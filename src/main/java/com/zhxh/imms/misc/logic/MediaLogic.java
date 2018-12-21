package com.zhxh.imms.misc.logic;

import com.zhxh.imms.misc.dao.MediaDAO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component("mediaLogic")
public class MediaLogic {
    @Resource(name="mediaDAO")
    private MediaDAO mediaDAO;


}
