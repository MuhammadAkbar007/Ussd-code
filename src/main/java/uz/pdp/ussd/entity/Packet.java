package uz.pdp.ussd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import uz.pdp.ussd.entity.enums.PacketType;
import uz.pdp.ussd.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
public class Packet extends AbsEntity {

    @Enumerated(EnumType.STRING)
    private PacketType packetType;

    @Column(nullable = false,unique = true)
    private String name;

    private int amount;

    private int cost;

    private int duration;

    private boolean isTariff;

    @OneToMany
    private List<Tariff> availableTariffs;
}
