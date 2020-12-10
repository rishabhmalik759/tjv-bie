package server.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "admin")
@Table(name = "admin")
public class AdminEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID", nullable = false)
    private Long id;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @PrimaryKeyJoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private UserEntity user;

    public AdminEntity() {
    }

    public AdminEntity(UserEntity user) {
        this.user = user;
    }

    public void set(AdminEntity admin) {
        if (admin.user != null) this.user = admin.user;
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

    public boolean validate() {
        return !(user==null);
    }

    @Override
    public String toString() {
        return "AdminEntity{" +
                "id=" + id +
                ", user=" + user +
                '}';
    }
}
