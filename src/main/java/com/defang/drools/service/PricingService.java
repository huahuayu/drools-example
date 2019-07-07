package com.defang.drools.service;

import com.defang.drools.model.Order;
import com.defang.drools.model.Result;

/**
 * 定价服务
 */
public interface PricingService {
    Result getTheResult(Order order);
}
