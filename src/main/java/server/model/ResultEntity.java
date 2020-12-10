package server.model;


import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "result")
@Table(name = "result")
public class ResultEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RESULT_ID", nullable = false)
    private Long id;
    @Column(name = "PLACE", nullable = false)
    private Integer place;
    @OneToOne
    @JoinColumn(name = "REGISTRATION_ID", nullable = false)
    private RegistrationEntity registration;

    public ResultEntity() {
    }

    public ResultEntity(Integer place, RegistrationEntity registration) {
        this.place = place;
        this.registration = registration;
    }

    public void set(ResultEntity result) {
        if (result.place != null) this.place = result.place;
        if (result.place != null) this.registration = result.registration;
    }

    public Long getId() {
        return id;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public RegistrationEntity getRegistration() {
        return registration;
    }

    public void setRegistration(RegistrationEntity registration) {
        this.registration = registration;
    }

    public boolean validate() {
        return !(place==null || registration==null);
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "id=" + id +
                ", place=" + place +
                ", registration=" + registration +
                '}';
    }
}
