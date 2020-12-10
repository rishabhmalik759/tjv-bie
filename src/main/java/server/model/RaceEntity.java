package server.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity(name = "RACE")
@Table(name = "RACE")
public class RaceEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RACE_ID", nullable = false)
    private Long id;
    @Column(name = "DATE_R", nullable = false)
    @JsonFormat(pattern="dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "FROM_R", nullable = false)
    private String from;
    @Column(name = "TO_R", nullable = false)
    private String to;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "RACE_ID", nullable = true)
    private List<RegistrationEntity> registrations;

    public RaceEntity() {
    }

    public RaceEntity(Date date, String from, String to) {
        this.date = date;
        this.from = from;
        this.to = to;
    }

    public void set(RaceEntity race) {
        if (race.date != null) this.date = race.date;
        if (race.from != null) this.from = race.from;
        if (race.to != null) this.to = race.to;
        if (race.registrations != null) this.registrations = race.registrations;
    }

    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public List<RegistrationEntity> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<RegistrationEntity> registrations) {
        this.registrations = registrations;
    }

    public boolean validate() {
        return !(date==null || from==null || to==null );
    }

    @Override
    public String toString() {
        return "RaceEntity{" +
                "id=" + id +
                ", date=" + date +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", registrations=" + registrations +
                '}';
    }
}
