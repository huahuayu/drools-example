package com.defang.drools.service;

import com.defang.drools.model.Order;
import com.defang.drools.model.Result;

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
