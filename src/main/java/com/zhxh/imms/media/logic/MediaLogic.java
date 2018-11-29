package com.zhxh.imms.media.logic;

import com.zhxh.imms.media.dao.MediaDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("mediaLogic")
public class MediaLogic {
    @Resource(name="mediaDAO")
    private MediaDAO mediaDAO;


}
