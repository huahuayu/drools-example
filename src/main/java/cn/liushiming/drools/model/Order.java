package cn.liushiming.drools.model;

import cn.liushiming.drools.common.type.PaymentMethod;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author shiming
 */
@Data
@AllArgsConstructor
public class Order {
    private Integer orderId;
    private Customer customer;
    private Product product;
    private PaymentMethod paymentMethod;
}
