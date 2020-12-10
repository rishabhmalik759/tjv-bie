package server.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity(name = "car")
@Table(name = "car")
public class CarEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CAR_ID", nullable = false)
    private Long id;
    @Column(name = "BRAND", nullable = false)
    private String brand;
    @Column(name = "MODEL", nullable = false)
    private String model;

    @Column(name = "HORSEPOWER", nullable = false)
    private Integer horsepower;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "CAR_ID", nullable = true)
    private List<RegistrationEntity> registrations;

    public CarEntity() {
    }

    public CarEntity(String brand, String model, Integer horsepower) {
        this.brand = brand;
        this.model = model;
        this.horsepower = horsepower;
    }

    public void set(CarEntity car) {
        if (car.brand != null) this.brand = car.brand;
        if (car.model != null) this.model = car.model;
        if (car.horsepower != null) this.horsepower = car.horsepower;
        if (car.registrations != null) this.registrations = car.registrations;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getHorsepower() {
        return horsepower;
    }

    public void setHorsepower(Integer horsepower) {
        this.horsepower = horsepower;
    }

    public List<RegistrationEntity> getRegistrations() {
        return registrations;
    }

    public void setRegistrations(List<RegistrationEntity> registrations) {
        this.registrations = registrations;
    }

    public boolean validate() {
        return !(brand==null || model==null || horsepower==null);
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", horsepower=" + horsepower +
                ", registrations=" + registrations +
                '}';
    }
}
