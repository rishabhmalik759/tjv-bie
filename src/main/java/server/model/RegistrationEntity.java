package server.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "registration")
@Table(name = "registration")
public class RegistrationEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "REGISTRATION_ID", nullable = false)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "RACE_ID", nullable = false)
    private RaceEntity race;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "USER_ID", nullable = false)
    private StreetRacerEntity racer;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_ID", nullable = true)
    private CarEntity car;
    @OneToOne
    @JoinColumn(name = "REGISTRATION_ID", nullable = true)
    private ResultEntity result;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "REGISTRATION_ID", nullable = true)
    private List<BetEntity> bets;

    public RegistrationEntity() {
    }

    public RegistrationEntity(RaceEntity race, StreetRacerEntity racer, CarEntity car) {
        this.race = race;
        this.racer = racer;
        this.car = car;
    }

    public RegistrationEntity(RaceEntity race, StreetRacerEntity racer) {
        this.race = race;
        this.racer = racer;
    }

    public void set(RegistrationEntity registration) {
        if (registration.race != null) this.race = registration.race;
        if (registration.racer != null) this.racer = registration.racer;
        if (registration.car != null) this.car = registration.car;
        if (registration.result != null) this.result = registration.result;
        if (registration.bets != null) this.bets = registration.bets;
    }

    public Long getId() {
        return id;
    }

    public RaceEntity getRace() {
        return race;
    }

    public void setRace(RaceEntity race) {
        this.race = race;
    }

    public StreetRacerEntity getRacer() {
        return racer;
    }

    public void setRacer(StreetRacerEntity racer) {
        this.racer = racer;
    }

    public CarEntity getCar() {
        return car == null ? new CarEntity("", "", 0) : car;
    }

    public void setCar(CarEntity car) {
        this.car = car;
    }

    public ResultEntity getResult() {
        return result;
    }

    public void setResult(ResultEntity result) {
        this.result = result;
    }

    public void addBet(BetEntity bet) {
        bets.add(bet);
    }

    public List<BetEntity> getBets() {
        return bets;
    }

    public void setBets(List<BetEntity> bets) {
        this.bets = bets;
    }

    public boolean validate() {
        return !(race==null || racer==null);
    }

    @Override
    public String toString() {
        return "RegistrationEntity{" +
                "id=" + id +
                ", race=" + race +
                ", racer=" + racer +
                ", car=" + car +
                ", result=" + result +
                ", bets=" + bets +
                '}';
    }
}
