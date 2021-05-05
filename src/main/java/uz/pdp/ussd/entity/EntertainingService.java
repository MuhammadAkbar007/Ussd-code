package uz.pdp.ussd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.ussd.entity.template.AbsEntity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class EntertainingService extends AbsEntity {

    private String name;

    private double price;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ServiceCategory serviceCategory;

    private Timestamp expiredDate;

    @ManyToOne
    private SimCard simCard;

    private Integer count;
}
