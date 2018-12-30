package com.zhxh.imms.misc.controller;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.web.*;
import com.zhxh.imms.misc.dao.MediaDAO;
import com.zhxh.imms.misc.entity.Media;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("imms/media/media")
public class MediaController extends SimpleCRUDController<com.zhxh.imms.misc.entity.Media> {
    @Resource(name="mediaDAO")
    private MediaDAO mediaDAO;

    private ListRequestProcessHandler listRequestProcessHandler = new ListRequestProcessHandler();

    @Override
    protected BaseDAOWithEntity<Media> getCrudDao() {
        return this.mediaDAO;
    }


}
