package com.huahuayu.drools.service;

import com.huahuayu.drools.model.Order;
import com.huahuayu.drools.model.Result;

/**
 * pricing service
 */
public interface PricingService {
    /**
     * based on the order(customer type, total price etc) to determine the discount, reduction and final price
     *
     * @param order
     * @return result
     */
    Result getTheResult(Order order);
}
