package uz.pdp.ussd.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.pdp.ussd.entity.Packet;
import uz.pdp.ussd.entity.enums.PacketType;

import java.util.Optional;
import java.util.UUID;

public interface PacketRepository extends JpaRepository<Packet, UUID> {

    boolean existsByName(String name);

    Packet findByName(String name);

    Optional<Packet> findByPacketTypeAndAmount(PacketType packetType, int amount);
}
