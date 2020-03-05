package cn.liushiming.drools.model;
import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * @author shiming
 */
@Data
@AllArgsConstructor
public class Product {
    private String name;
    private Float price;
}
