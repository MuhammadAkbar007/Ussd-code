package uz.pdp.ussd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussd.entity.SimCard;

import java.util.Optional;
import java.util.UUID;

public interface SimCardRepository extends JpaRepository<SimCard, UUID> {

    Optional<SimCard> findBySimCardNumber(String simCardNumber);

    Optional<SimCard> findByCodeAndNumber(String code, String number);

    boolean existsByNumberAndCode(String number, String code);
}
