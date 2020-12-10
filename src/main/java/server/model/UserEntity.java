package server.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

@Entity(name = "common_user")
@Table(name = "common_user")
public class UserEntity implements Serializable, UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = false)
    private Long id;
    @Column(name = "USERNAME", nullable = false)
    private String username;
    @Column(name = "PASSWORD", nullable = false)
    private String password;
    @Column(name = "ACCOUNT", nullable = false)
    private Integer account;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = true)
    private StreetRacerEntity racer;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = true)
    private AdminEntity admin;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = true)
    private List<BetEntity> bets;

    public UserEntity() {
    }

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public void set(UserEntity user) {
        if (user.username != null) this.username = user.username;
        if (user.password != null) this.password = user.password;
        if (user.account != null) this.account = user.account;
        if (user.racer != null) this.racer = user.racer;
        if (user.admin != null) this.admin = user.admin;
        if (user.bets != null) this.bets = user.bets;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAccount() {
        return account;
    }

    public void setAccount(Integer account) {
        this.account = account;
    }

    public StreetRacerEntity getRacer() {
        return racer;
    }

    public void setRacer(StreetRacerEntity racer) {
        this.racer = racer;
    }

    public AdminEntity getAdmin() {
        return admin;
    }

    public void setAdmin(AdminEntity admin) {
        this.admin = admin;
    }

    public List<BetEntity> getBets() {
        return bets;
    }

    public void setBets(List<BetEntity> bets) {
        this.bets = bets;
    }

    public boolean isAdmin() {
        return admin != null;
    }

    public boolean isRacer() {
        return racer != null;
    }
    public boolean validate() {
        return !(username==null || password==null || account==null);
    }
    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", account=" + account +
                ", racer=" + racer +
                ", admin=" + admin +
                ", bets=" + bets +
                '}';
    }
}
