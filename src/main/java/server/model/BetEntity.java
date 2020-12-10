package server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "bet")
@Table(name = "bet")
public class BetEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BET_ID", nullable = false)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "USER_ID", nullable = false)
    private UserEntity user;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "REGISTRATION_ID", nullable = false)
    private RegistrationEntity registration;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonBackReference
    @JoinColumn(name = "BET_TYPE_ID", nullable = false)
    private BetTypeEntity betType;

    @Column(name = "DATE", nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "AMOUNT", nullable = false)
    private Integer amount;
    @Column(name = "RATE", nullable = false)
    private Double rate;

    public BetEntity() {
    }

    public BetEntity(UserEntity user, RegistrationEntity registration, Date date, Integer amount, Double rate) {
        this.user = user;
        this.registration = registration;
        this.date = date;
        this.amount = amount;
        this.rate = rate;
    }

    public BetEntity(UserEntity user, RegistrationEntity registration, BetTypeEntity betType, Date date, Integer amount, Double rate) {
        this.user = user;
        this.registration = registration;
        this.betType = betType;
        this.date = date;
        this.amount = amount;
        this.rate = rate;
    }

    public void set(BetEntity bet) {
        if (bet.user != null) this.user = bet.user;
        if (bet.registration != null) this.registration = bet.registration;
        if (bet.betType != null) this.betType = bet.betType;
        if (bet.date != null) this.date = bet.date;
        if (bet.amount != null) this.amount = bet.amount;
        if (bet.rate != null) this.rate = bet.rate;
    }


    public Long getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public RegistrationEntity getRegistration() {
        return registration;
    }

    public void setRegistration(RegistrationEntity registration) {
        this.registration = registration;
    }

    public BetTypeEntity getBetType() {
        return betType;
    }

    public void setBetType(BetTypeEntity betType) {
        this.betType = betType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public boolean validate() {
        return !(user==null || registration==null || betType==null || date==null || amount==null || rate==null);
    }

    @Override
    public String toString() {
        return "BetEntity{" +
                "id=" + id +
                ", user=" + user +
                ", registration=" + registration +
                ", betType=" + betType +
                ", date=" + date +
                ", amount=" + amount +
                ", rate=" + rate +
                '}';
    }
}
