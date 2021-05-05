package uz.pdp.ussd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussd.entity.Tariff;

import java.util.UUID;

public interface TariffRepository extends JpaRepository<Tariff, UUID> {

    boolean existsByName(String name);

    Tariff findByName(String name);
}
