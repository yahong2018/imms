package com.zhxh.core.web;

import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.core.utils.Logger;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public abstract class SimpleCRUDController<T> {
    private final ListRequestProcessHandler listRequestProcessHandler = new ListRequestProcessHandler();

    @RequestMapping("getAll.handler")
    @ResponseBody
    public final List<T> getAll() {
       return this.internalGetAll();
    }

    @RequestMapping("getAllByPage.handler")
    @ResponseBody
    public final ExtJsResult getAllByPage(HttpServletRequest request, HttpServletResponse response) {
        return listRequestProcessHandler.getListFromHttpRequest(request, new ListRequestBaseHandler() {
            @Override
            public List getByRequest(ListRequest listRequest) {
                return internalGetByRequest(listRequest);
            }

            @Override
            public int getRequestListCount(ListRequest listRequest) {
                return internalGetRequestListCount(listRequest);
            }
        });
    }

    @RequestMapping("create.handler")
    @ResponseBody
    public final T create(T item) {
        return this.internalCreate(item);
    }

    @RequestMapping("update.handler")
    public final T update(T item) {
        return this.internalUpdate(item);
    }

    @RequestMapping("delete.handler")
    @ResponseBody
    public final int delete(@RequestBody Object[] ids) {
        return this.internalDelete(ids);
    }

    protected List<T> internalGetAll(){
        return this.getCrudDao().getAll();
    }

    protected int internalDelete(Object[] ids) {
        int result = 0;
        try {
            for (Object id : ids) {
                this.getCrudDao().deleteById(id);
                result += 1;
            }
        } catch (Exception e) {
            Logger.error(e);
        }

        return result;
    }


    protected T internalUpdate(T item) {
        try {
            this.getCrudDao().update(item);
        } catch (Exception e) {
            Logger.error(e);
        }
        return item;
    }

    protected T internalCreate(T item) {
        try {
            this.getCrudDao().insert(item);
        } catch (Exception e) {
            Logger.error(e);
        }
        return item;
    }

    protected List internalGetByRequest(ListRequest listRequest) {
        return this.getCrudDao().getPageList(listRequest.toMap(), null);
    }

    protected int internalGetRequestListCount(ListRequest listRequest) {
        return this.getCrudDao().getPageListCount(listRequest.toMap(), null);
    }

    protected abstract BaseDAOWithEntity<T> getCrudDao();
}
