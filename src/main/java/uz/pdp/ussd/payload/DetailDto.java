package uz.pdp.ussd.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uz.pdp.ussd.entity.SimCard;
import uz.pdp.ussd.entity.enums.ActionType;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DetailDto {

    @Enumerated(EnumType.STRING)
    private ActionType actionType;
    private SimCard simCard; //o'zgarishi mumkin
    private Float amount;
}
