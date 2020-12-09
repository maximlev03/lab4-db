package ua.lviv.iot.lab_4.model;

import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class Zone extends RepresentationModel<Zone> implements IWithId {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    private Role role;

    @Override
    public String toString() {
        return "Zone{" +
                "id=" + id +
                ", role id=" + role.getId() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Zone)) return false;
        Zone zone = (Zone) o;
        return id == zone.id &&
                Objects.equals(role, zone.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, role);
    }

}
