package uz.pdp.ussd.payload;

import lombok.Data;

@Data
public class SimcardEntertainingDto {

    private String EntertainingName;

    private boolean isActive;
}
