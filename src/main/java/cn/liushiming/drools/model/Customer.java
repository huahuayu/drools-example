package cn.liushiming.drools.model;
import cn.liushiming.drools.common.type.CustomerType;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author shiming
 */
@Data
@AllArgsConstructor
public class Customer {
    private String name;
    private CustomerType type;
}
