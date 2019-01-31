package com.zhxh.imms.misc.service;

import com.zhxh.imms.misc.dao.MediaDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("mediaService")
public class MediaService {
    @Resource(name="mediaDAO")
    private MediaDAO mediaDAO;


}
