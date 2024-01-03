package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.util.Collection;

@Entity
@Table(name = "uloga", schema = "public", catalog = "udomi")
public class UlogaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "naziv", nullable = true, length = -1)
    private String naziv;
    @OneToMany(mappedBy = "ulogaId")
    private Collection<KorisnikUlogaEntity> korisnikId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public Collection<KorisnikUlogaEntity> getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Collection<KorisnikUlogaEntity> korisnikId) {
        this.korisnikId = korisnikId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UlogaEntity that = (UlogaEntity) o;

        if (id != that.id) return false;
        if (!naziv.equals(that.naziv)) return false;
        return korisnikId.equals(that.korisnikId);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + naziv.hashCode();
        result = 31 * result + korisnikId.hashCode();
        return result;
    }
}
