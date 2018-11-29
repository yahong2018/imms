package com.zhxh.imms.media.controller;

import com.zhxh.imms.media.logic.MediaLogic;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class MediaController {

    @Resource(name="mediaLogic")
    private MediaLogic mediaLogic;

}
