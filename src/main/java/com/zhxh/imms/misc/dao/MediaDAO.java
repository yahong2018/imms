package com.zhxh.imms.misc.dao;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.misc.entity.Media;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component("mediaDAO")
public class MediaDAO extends BaseDAOWithEntity<Media> {
    public List<Media> getCandidateMaterialMedia(Map listMap, String materialId) {
        this.convertWhere(listMap, materialId);
        return this.getList(listMap);
    }

    public int getCandidateMaterialMediaCount(Map listMap, String materialId) {
        this.convertWhere(listMap, materialId);
        return this.getPageListCount(listMap);
    }

    private void convertWhere(Map listMap, String materialId) {
        StringBuffer filter = new StringBuffer("media_id not in( \n")
                .append(" select material_media_media_id from material_media \n")
                .append("   where material_media_material_id='").append(materialId).append("'\n")
                .append(")");


        if (!StringUtils.isEmpty(listMap.get("where").toString())) {
            filter.insert(0, " and ").insert(0, listMap.get("where").toString());
        }
        listMap.put("where", filter.toString());

    }
}
