package com.zhxh.imms.order.service;

import com.zhxh.core.data.DataCode.BCode;
import com.zhxh.core.exception.ErrorCode;
import com.zhxh.imms.code.dao.SizeDAO;
import com.zhxh.imms.code.entity.Size;
import com.zhxh.imms.factory.dao.PlantDAO;
import com.zhxh.imms.factory.dao.WorkCenterDAO;
import com.zhxh.imms.factory.entity.Plant;
import com.zhxh.imms.factory.entity.WorkCenter;
import com.zhxh.imms.material.dao.BomDAO;
import com.zhxh.imms.material.dao.MaterialDAO;
import com.zhxh.imms.material.entity.BomOrder;
import com.zhxh.imms.material.entity.Material;
import com.zhxh.imms.material.service.BomOrderService;
import com.zhxh.imms.material.service.BomService;
import com.zhxh.imms.material.vo.BomVO;
import com.zhxh.imms.order.dao.OrderMeasureDAO;
import com.zhxh.imms.order.dao.OrderSizeDAO;
import com.zhxh.imms.order.dao.ScheduleOrderDAO;
import com.zhxh.imms.order.dto.ScheduleOrderDTO;
import com.zhxh.imms.order.entity.OrderMeasure;
import com.zhxh.imms.order.entity.OrderSize;
import com.zhxh.imms.order.entity.ScheduleOrder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component("scheduleOrderService")
public class ScheduleOrderService {

    @Transactional(rollbackFor = RuntimeException.class)
    public void receiveScheduleFromAps(ScheduleOrderDTO scheduleOrder) {
        //1.校验scheduleOrder单头
        this.verifyHeader(scheduleOrder);
        //2.保存BOM
        this.saveBom(scheduleOrder);
        //3.保存生产排期
        this.scheduleOrderDAO.insert(scheduleOrder);
        //4.保存订单尺码
        this.saveOrderSize(scheduleOrder);
        //5.保存量体信息
        this.saveMeasureData(scheduleOrder);
    }

    private void verifyHeader(ScheduleOrderDTO dto) {
        //物料校验
        if (dto.getFgMaterialId() <= 0) {
            Material material = materialDAO.getOneByField("material_no", "materialNo", dto.getFgMaterialNo());
            if (material == null) {
                com.zhxh.core.exception.ExceptionHelper.throwException(ErrorCode.ERROR_DATA_NOT_EXISTS, "主面料编号错误！");
            }
            dto.setFgMaterialId(material.getRecordId());
        }

        //工作中心校验
        if (dto.getWorkCenterId() <= 0) {
            WorkCenter workCenter = workCenterDAO.getOneByField("work_center_no", "workCenterNo", dto.getWorkCenterNo());
            if (workCenter == null) {
                com.zhxh.core.exception.ExceptionHelper.throwException(ErrorCode.ERROR_DATA_NOT_EXISTS, "工作中心编号错误！");
            }
            dto.setWorkCenterId(workCenter.getRecordId());
        }

        //工厂校验
        if (dto.getPlantId() <= 0) {
            Plant plant = plantDAO.getByPlantNo(dto.getPlantNo());
            if (plant == null) {
                com.zhxh.core.exception.ExceptionHelper.throwException(ErrorCode.ERROR_DATA_NOT_EXISTS, "工厂编号错误！");
            }
            dto.setPlantId(plant.getRecordId());
        }
    }

    private void saveMeasureData(ScheduleOrderDTO dto){
        for (OrderMeasure measure : dto.getMeasures()) {
            measure.setOrderId(dto.getRecordId());
            measure.setRefRecordType(BCode.RECORD_TYPE_SCHEDULE_ORDER);
            orderMeasureDAO.insert(measure);
        }
    }

    private void saveOrderSize(ScheduleOrderDTO dto) {
        //订单尺码校验
        for (OrderSize orderSize : dto.getOrderSizes()) {
            Size size = sizeDAO.getOneByField("size_code", "sizeCode", orderSize.getSizeCode());
            if (size == null) {
                com.zhxh.core.exception.ExceptionHelper.throwException(ErrorCode.ERROR_DATA_NOT_EXISTS, "尺码编码错误！");
            }
            orderSize.setSizeId(size.getRecordId());

            orderSize.setOrderId(dto.getRecordId());
            orderSize.setRefRecordType(BCode.RECORD_TYPE_SCHEDULE_ORDER);
            orderSizeDAO.insert(orderSize);
        }
    }

    private void saveBom(ScheduleOrderDTO dto){
        //BOM校验
        for (BomVO bomVO : dto.getBoms()) {
            bomService.fillFromVo(bomVO);
        }
        //保存Bom
        BomOrder bomOrder = bomOrderService.createBomOrder(BCode.BOM_TYPE_ORDER);
        for (BomVO bom : dto.getBoms()) {
            bom.setBomOrderId(bomOrder.getRecordId());
            bomDAO.insert(bom);
        }
        dto.setBomOrderId(bomOrder.getRecordId());
    }

    @Resource(name = "scheduleOrderDAO")
    private ScheduleOrderDAO scheduleOrderDAO;

    @Resource(name = "productionOrderService")
    private ProductionOrderService productionOrderService;

    @Resource(name = "materialDAO")
    private MaterialDAO materialDAO;

    @Resource(name = "workCenterDAO")
    private WorkCenterDAO workCenterDAO;

    @Resource(name = "plantDAO")
    private PlantDAO plantDAO;

    @Resource(name = "bomService")
    private BomService bomService;

    @Resource(name = "sizeDAO")
    private SizeDAO sizeDAO;

    @Resource(name = "orderSizeDAO")
    private OrderSizeDAO orderSizeDAO;

    @Resource(name = "bomDAO")
    private BomDAO bomDAO;

    @Resource(name = "bomOrderService")
    private BomOrderService bomOrderService;

    @Resource(name = "orderMeasureDAO")
    private OrderMeasureDAO orderMeasureDAO;

    public ScheduleOrderService() {
    }
}
