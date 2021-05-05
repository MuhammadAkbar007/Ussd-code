package uz.pdp.ussd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.ussd.entity.enums.ClientType;
import uz.pdp.ussd.entity.template.AbsEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Tariff extends AbsEntity {

    @Column(nullable = false, unique = true)
    private String name;

    private double price;

    private double switchPrice;

    private Timestamp expireDate;

    private int mb; // tarif rejasi doirasida beriladigan mb miqdori
    private int sms; // tarif rejasi doirasida beriladigan sms miqdori
    private int min; // tarif rejasi doirasida beriladigan min miqdori
    private int mbCost; // mb tugaganda 1mb narxi
    private int smsCost; // sms tugaganda 1sms narxi
    private int minCost; // min tugaganda 1min narxi

    @Enumerated(EnumType.STRING)
    private ClientType clientType;
}
