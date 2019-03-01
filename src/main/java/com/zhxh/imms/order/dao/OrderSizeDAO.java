package com.zhxh.imms.order.dao;

import com.zhxh.admin.service.AuthenticateService;
import com.zhxh.core.data.BaseDAOWithEntity;
import com.zhxh.imms.GlobalConstants;
import com.zhxh.imms.order.entity.OrderSize;
import com.zhxh.imms.order.entity.ProductionOrder;
import com.zhxh.imms.order.entity.ScheduleOrder;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component("productionOrderSizeDAO")
public class OrderSizeDAO extends BaseDAOWithEntity<OrderSize> {

}
