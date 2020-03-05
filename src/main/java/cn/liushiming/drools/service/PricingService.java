package cn.liushiming.drools.service;

import cn.liushiming.drools.model.Order;
import cn.liushiming.drools.model.Result;

/**
 * pricing service
 * @author shiming
 */
public interface PricingService {
    /**
     * based on the order(customer type, total price etc) to determine the discount, reduction and final price
     *
     * @param order order detail
     * @return result
     */
    Result getTheResult(Order order);
}
