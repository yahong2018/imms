package com.zhxh.admin.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zhxh.admin.entity.ProgramPrivilege;
import com.zhxh.admin.logic.ProgramPrivilegeLogic;
import com.zhxh.core.web.ExtJsResult;
import com.zhxh.core.web.ListRequest;
import com.zhxh.core.web.ListRequestBaseHandler;
import com.zhxh.core.web.ListRequestProcessHandler;

@Controller
@RequestMapping("/admin/programPrivilege")
public class ProgramPrivilegeController {
    @Resource(name = "programPrivilegeLogic")
    private ProgramPrivilegeLogic programPrivilegeLogic;

    private final ListRequestProcessHandler listRequestProcessHandler = new ListRequestProcessHandler();

    @RequestMapping("getProgramPrivilegeByProgramId.handler")
    @ResponseBody
    public ExtJsResult getProgramPrivilegeByProgramId(HttpServletRequest request, HttpServletResponse response) {
	   Map parameters = new HashMap();
   	    parameters.put("programId",request.getParameter("programId"));
        return listRequestProcessHandler.getListFromHttpRequest(request, new ListRequestBaseHandler() {
            @Override
            public List getByRequest(ListRequest listRequest) {
                return programPrivilegeLogic.getPageListByProgramId(listRequest.toMap(), parameters);
            }

            @Override
            public int getRequestListCount(ListRequest listRequest) {
                return programPrivilegeLogic.getPageListCountByProgramId(listRequest.toMap(), parameters);
            }
        });
    }
    
    @RequestMapping("update.handler")
    @ResponseBody
    public ProgramPrivilege update(ProgramPrivilege item) throws Exception {
    	programPrivilegeLogic.update(item);
        return item;
    }

    @RequestMapping("delete.handler")
    @ResponseBody
    public int delete(@RequestBody String[] id) throws Exception {    	
        return programPrivilegeLogic.delete(id);
    }
}
