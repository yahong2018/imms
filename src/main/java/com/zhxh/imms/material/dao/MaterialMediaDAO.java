package com.zhxh.imms.material.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.utils.BeanUtils;
import com.zhxh.imms.material.entity.MaterialMedia;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component("materialMediaDAO")
public class MaterialMediaDAO extends BaseDAOWithEntity<MaterialMedia> {
    @Override
    public boolean exists(Object item) {
        if (super.exists(item)) {
            return true;
        }

        Map<String, String> whereMap = new HashMap<>();
        StringBuffer where = new StringBuffer("material_media_material_id=#{materialMediaMaterialId} \n")
                .append(" and material_media_media_id=#{materialMediaMediaId}");

        whereMap.put("where", where.toString());
        Map<String, Object> objectMap = BeanUtils.getValues(item);

        List list = super.getList(MaterialMedia.class, whereMap, objectMap);
        return list.size() > 0;
    }
}
