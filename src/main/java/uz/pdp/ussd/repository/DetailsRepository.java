package uz.pdp.ussd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussd.entity.Details;
import uz.pdp.ussd.entity.SimCard;
import uz.pdp.ussd.entity.enums.ActionType;

import java.util.List;
import java.util.UUID;

public interface DetailsRepository extends JpaRepository<Details, UUID> {

    List<Details> findAllByActionTypeAndSimCard(ActionType actionType, SimCard simCard);

    List<Details> findAllBySimCard(SimCard simCard);
}
