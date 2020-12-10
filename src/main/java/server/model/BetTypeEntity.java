package server.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "bet_type")
public class BetTypeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "BET_TYPE_ID", nullable = false)
    private Long id;
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "BET_TYPE_ID", nullable = true)
    private List<BetEntity> bets;

    public BetTypeEntity() {
    }

    public BetTypeEntity(String description) {
        this.description = description;
    }

    public void set(BetTypeEntity betType) {
        if (betType.description != null) this.description = betType.description;
        if (betType.bets != null) this.bets = betType.bets;
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BetEntity> getBets() {
        return bets;
    }

    public void setBets(List<BetEntity> bets) {
        this.bets = bets;
    }

    public boolean validate() {
        return !(description==null);
    }

    @Override
    public String toString() {
        return "BetTypeEntity{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", bets=" + bets +
                '}';
    }
}
