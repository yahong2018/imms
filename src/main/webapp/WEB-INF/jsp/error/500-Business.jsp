<%@ page import="com.zhxh.core.exception.BusinessException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
   // Object businessException =  request.getAttribute("javax.servlet.error.message");
    BusinessException businessException = (BusinessException) request.getAttribute("javax.servlet.error.exception");
    if(businessException !=null) {
        response.getWriter().write(businessException.getMessage());
    }
    response.getWriter().flush();
%>
