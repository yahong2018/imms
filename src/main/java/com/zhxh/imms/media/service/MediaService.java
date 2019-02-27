package com.zhxh.imms.media.service;

import com.zhxh.imms.media.dao.MediaDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("mediaService")
public class MediaService {
    @Resource(name="mediaDAO")
    private MediaDAO mediaDAO;


}
