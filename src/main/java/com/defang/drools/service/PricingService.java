package com.defang.drools.service;

import com.defang.drools.model.Order;
import com.defang.drools.model.Result;

/**
 * pricing service
 */
public interface PricingService {
    Result getTheResult(Order order);
}
