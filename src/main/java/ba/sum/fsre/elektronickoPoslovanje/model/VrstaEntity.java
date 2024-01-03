package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vrsta", schema = "public", catalog = "udomi")
public class VrstaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "naziv_vrste", nullable = true, length = -1)
    private String nazivVrste;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VrstaEntity that = (VrstaEntity) o;

        if (id != that.id) return false;
        if (nazivVrste != null ? !nazivVrste.equals(that.nazivVrste) : that.nazivVrste != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (nazivVrste != null ? nazivVrste.hashCode() : 0);
        return result;
    }
}
