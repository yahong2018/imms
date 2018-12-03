package com.zhxh.imms.material.logic;

import com.zhxh.imms.material.dao.MaterialDAO;
import com.zhxh.imms.material.dao.MaterialMediaDAO;
import com.zhxh.imms.material.entity.MaterialMedia;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Component("materialLogic")
public class MaterialLogic {
    @Resource(name = "materialDAO")
    private MaterialDAO materialDAO;

    @Resource(name = "materialMediaDAO")
    private MaterialMediaDAO materialMediaDAO;

    @Transactional(rollbackFor = RuntimeException.class)
    public int  addMedias(MaterialMedia[] materialMediaArray) throws Exception {
        for(MaterialMedia media:materialMediaArray){
            materialMediaDAO.insert(media);
        }

        return materialMediaArray.length;
    }
}
