package uz.pdp.ussd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussd.entity.EntertainingService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ServiceRepository extends JpaRepository<EntertainingService, UUID> {

    Optional<EntertainingService> findByName(String name);

    boolean existsByName(String name);

    List<EntertainingService> findAllByOrderByCountAsc();
}
