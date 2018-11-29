package com.zhxh.imms.media.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.SimpleCRUDController;
import com.zhxh.imms.media.dao.MediaDAO;
import com.zhxh.imms.media.entity.Media;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("imms/media/media")
public class MediaController extends SimpleCRUDController<com.zhxh.imms.media.entity.Media> {

    @Resource(name="mediaDAO")
    private MediaDAO mediaDAO;

    @Override
    protected BaseDAOWithEntity<Media> getCrudDao() {
        return this.mediaDAO;
    }
}
