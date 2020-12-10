package server.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "street_racer")
@Table(name = "street_racer")
public class StreetRacerEntity implements Serializable {
    @Id
    @Column(name = "USER_ID", nullable = false)
    private Long id;

    @Column(name = "win_counter", nullable = false)
    private Long winCounter;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private UserEntity user;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "USER_ID", nullable = true)
    private List<RegistrationEntity> registrations;

    public StreetRacerEntity() {
        winCounter = 0L;
    }

    public StreetRacerEntity(UserEntity user) {
        this.user = user;
        winCounter = 0L;
    }

    public void set(StreetRacerEntity racer) {
        if (racer.id != null) this.id = racer.id;
        if (racer.winCounter != null) this.winCounter = racer.winCounter;
        if (racer.user != null) this.user = racer.user;
        if (racer.registrations != null) this.registrations = racer.registrations;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
        id = user.getId();
    }

    public Long getId() {
        return id;
    }

    public List<RegistrationEntity> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<RegistrationEntity> registrations) {
        this.registrations = registrations;
    }

    public Long getWinCounter() {
        return winCounter;
    }

    public void setWinCounter(Long winCounter) {
        this.winCounter = winCounter;
    }

    public boolean validate() {
        return !(user==null || winCounter==null);
    }

    @Override
    public String toString() {
        return "StreetRacerEntity{" +
                "id=" + id +
                ", winCounter=" + winCounter +
                ", user=" + user +
                ", registrations=" + registrations +
                '}';
    }
}
