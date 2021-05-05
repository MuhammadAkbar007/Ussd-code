package uz.pdp.ussd.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.pdp.ussd.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EqualsAndHashCode(callSuper = true)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"code", "number"})})
public class SimCard extends AbsEntity implements UserDetails {

    private String name;

    private String code;

    private String number;

    @Column(unique = true)
    private String simCardNumber;

    @OneToMany(mappedBy = "simCard", cascade = CascadeType.ALL)
    private List<DebtSimCard> debtSimCards;

    @ManyToOne
    private Client client;

    private boolean active = false;

    private double balance;

    private String pinCode;

    @ManyToMany
    private Set<EntertainingService> entertainingServices;

    private double amountMb;
    private double amountMinute;
    private double amountSms;

    @ManyToOne
    private Tariff tariff;

    private boolean tariffIsActive = false;

    private boolean isCredit = false;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.pinCode;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
