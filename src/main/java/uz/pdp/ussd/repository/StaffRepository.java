package uz.pdp.ussd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussd.entity.Staff;

import java.util.Optional;
import java.util.UUID;

public interface StaffRepository extends JpaRepository<Staff, UUID> {

    Optional<Staff> findByUserName(String userName);
    boolean existsByUserName(String userName);
}
