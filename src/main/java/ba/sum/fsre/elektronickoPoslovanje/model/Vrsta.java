package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Vrsta")
public class Vrsta {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "nazivVrste")
    private String nazivVrste;

    public Vrsta() {

    }

    public Vrsta(int id, String nazivVrste) {
        this.id = id;
        this.nazivVrste = nazivVrste;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazivVrste() {
        return nazivVrste;
    }

    public void setNazivVrste(String nazivVrste) {
        this.nazivVrste = nazivVrste;
    }

    @Override
    public String toString() {
        return "Vrsta{" +
                "id=" + id +
                ", nazivVrste='" + nazivVrste + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vrsta vrsta = (Vrsta) o;

        return id == vrsta.id;
    }

    @Override
    public int hashCode() {
        return id;
    }
}
