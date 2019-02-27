package com.zhxh.imms.order.service;

import com.zhxh.core.exception.ErrorCode;
import com.zhxh.imms.GlobalConstants;
import com.zhxh.imms.code.dao.SizeDAO;
import com.zhxh.imms.code.entity.Size;
import com.zhxh.imms.factory.dao.PlantDAO;
import com.zhxh.imms.factory.dao.WorkCenterDAO;
import com.zhxh.imms.factory.entity.Plant;
import com.zhxh.imms.factory.entity.WorkCenter;
import com.zhxh.imms.kanban.EventType;
import com.zhxh.imms.material.dao.MaterialDAO;
import com.zhxh.imms.material.entity.Material;
import com.zhxh.imms.material.service.BomService;
import com.zhxh.imms.material.vo.BomVO;
import com.zhxh.imms.order.dao.ScheduleOrderDAO;
import com.zhxh.imms.order.dto.ScheduleOrderDTO;
import com.zhxh.imms.order.entity.OrderMeasure;
import com.zhxh.imms.order.entity.OrderSize;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Component("scheduleOrderService")
public class ScheduleOrderService {
    @Transactional(rollbackFor = RuntimeException.class)
    public void receiveScheduleFromAps(ScheduleOrderDTO scheduleOrder) {
        //1.保存生产排期
        this.scheduleOrderDAO.insert(scheduleOrder);
        //2.数据验证与转换
        this.vo2Entity(scheduleOrder);
        //3.保存订单尺码

        //4.保存定制信息

        //5.保存量体信息
    }

    private void vo2Entity(ScheduleOrderDTO dto) {
        //物料校验
        if (dto.getFgMaterialId() == 0) {
            Material material = materialDAO.getByMaterialNo(dto.getFgMaterialNo());
            if (material == null) {
                com.zhxh.core.exception.ExceptionHelper.throwException(ErrorCode.ERROR_DATA_NOT_EXISTS, "主面料编号错误！");
            }
            dto.setFgMaterialId(material.getRecordId());
        }

        //工作中心校验
        if (dto.getWorkCenterId() == 0) {
            WorkCenter workCenter = workCenterDAO.getByWorkCenterNo(dto.getWorkCenterNo());
            if (workCenter == null) {
                com.zhxh.core.exception.ExceptionHelper.throwException(ErrorCode.ERROR_DATA_NOT_EXISTS, "工作中心编号错误！");
            }
            dto.setWorkCenterId(workCenter.getRecordId());
        }

        //工厂校验
        if (dto.getPlantId() == 0) {
            Plant plant = plantDAO.getByPlantNo(dto.getPlantNo());
            if (plant == null) {
                com.zhxh.core.exception.ExceptionHelper.throwException(ErrorCode.ERROR_DATA_NOT_EXISTS, "工厂编号错误！");
            }
            dto.setPlantId(plant.getRecordId());
        }

        //订单尺码校验
        for (OrderSize orderSize : dto.getOrderSizes()) {
            orderSize.setOrderId(dto.getRecordId());
            orderSize.setRefRecordType(GlobalConstants.RECORD_TYPE_SCHEDULE_ORDER);
            Map parameters = new HashMap<String, Object>();
            parameters.put("sizeCode", orderSize.getSizeCode());
            Size size = sizeDAO.getOne("size_code=#{sizeCode}", parameters);
            if (size == null) {
                com.zhxh.core.exception.ExceptionHelper.throwException(ErrorCode.ERROR_DATA_NOT_EXISTS, "尺码编码错误！");
            }
            orderSize.setSizeId(size.getRecordId());
        }

        //BOM校验
        for (BomVO bomVO : dto.getBoms()) {
            bomService.fillFromVo(bomVO);
        }

        //转换量体数据
        for (OrderMeasure measure : dto.getMeasures()) {
            measure.setOrderId(dto.getRecordId());
            measure.setRefRecordType(GlobalConstants.RECORD_TYPE_SCHEDULE_ORDER);
        }
    }

    public void publishEvent(String eventId, Object data) {
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

    public ScheduleOrderService() {
    }
}
