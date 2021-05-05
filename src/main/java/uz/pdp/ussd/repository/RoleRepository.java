package uz.pdp.ussd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussd.entity.Role;
import uz.pdp.ussd.entity.enums.RoleName;

public interface RoleRepository extends JpaRepository<Role, Integer> {

    Role findByRoleName(RoleName roleName);
}
