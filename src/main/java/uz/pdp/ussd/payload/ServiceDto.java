package uz.pdp.ussd.payload;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.ussd.entity.template.AbsEntity;

import java.sql.Timestamp;

@Data
@EqualsAndHashCode(callSuper = true)
public class ServiceDto extends AbsEntity {

    private String name;

    private double price;

    private Integer serviceCategoryID;

    private Timestamp expiredDate;
    private String categoryName;
}
