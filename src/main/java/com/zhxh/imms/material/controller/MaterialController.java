package com.zhxh.imms.material.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.ListRequest;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.material.dao.MaterialDAO;
import com.zhxh.imms.material.entity.Material;
import com.zhxh.imms.material.entity.MaterialMedia;
import com.zhxh.imms.material.logic.MaterialLogic;
import com.zhxh.imms.material.vo.MaterialVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/imms/material/material")
public class MaterialController extends SimpleCRUDController<Material> {
    @Resource(name = "materialDAO")
    private MaterialDAO materialDAO;

    @Resource(name="materialLogic")
    private MaterialLogic materialLogic;

    @Override
    protected BaseDAOWithEntity<Material> getCrudDao() {
        return this.materialDAO;
    }

    @Override
    protected List internalGetByRequest(ListRequest listRequest) {
        Class clazz = MaterialVO.class;
        List result = this.materialDAO.getPageList(clazz,listRequest.toMap(),null);
        return result;
    }

    @Override
    protected int internalGetRequestListCount(ListRequest listRequest) {
        Class clazz = MaterialVO.class;
        return this.materialDAO.getPageListCount(clazz,listRequest.toMap(),null);
    }

    @RequestMapping("addMedias.handler")
    @ResponseBody
    public int addMedias(@RequestBody Map materialMediaMaps) throws Exception {
        String materialId = materialMediaMaps.get("materialId").toString();
        String[] mediaIds = (String[]) materialMediaMaps.get("medias");

        MaterialMedia[] materialMediaArray = new MaterialMedia[mediaIds.length];
        for(int i=0;i<materialMediaArray.length;i++){
            MaterialMedia media = new MaterialMedia();
            media.setMaterialMediaMaterialId(materialId);
            media.setMaterialMediaMediaId(mediaIds[i]);

            materialMediaArray[i] = media;
        }

        return materialLogic.addMedias(materialMediaArray);
    }
}
