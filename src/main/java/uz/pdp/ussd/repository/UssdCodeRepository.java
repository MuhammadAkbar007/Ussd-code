package uz.pdp.ussd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussd.entity.UssdCode;

public interface UssdCodeRepository extends JpaRepository<UssdCode, Integer> {

    boolean existsByCode(String code);
}
