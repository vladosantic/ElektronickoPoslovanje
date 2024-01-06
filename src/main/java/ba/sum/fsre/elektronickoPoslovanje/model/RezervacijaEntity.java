package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rezervacija", schema = "public", catalog = "udomi")
public class RezervacijaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "datum_rezervacije", nullable = true)
    private Timestamp datumRezervacije;
    @ManyToOne
    @JoinColumn(name = "korisnik_udomitelj_id", referencedColumnName = "id", nullable = false)
    private UserEntity korisnik_udomitelj_id;
    @ManyToOne
    @JoinColumn(name = "korisnik_skrbnik_id", referencedColumnName = "id", nullable = false)
    private UserEntity korisnik_skrbnik_id;

    @ManyToOne
    @JoinColumn(name = "zivotinja_id", referencedColumnName = "id", nullable = false)
    private ZivotinjaEntity zivotinjaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Timestamp datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public UserEntity getKorisnik_udomitelj_id() {
        return korisnik_udomitelj_id;
    }

    public void setKorisnik_udomitelj_id(UserEntity korisnik_udomitelj_id) {
        this.korisnik_udomitelj_id = korisnik_udomitelj_id;
    }

    public UserEntity getKorisnik_skrbnik_id() {
        return korisnik_skrbnik_id;
    }

    public void setKorisnik_skrbnik_id(UserEntity korisnik_skrbnik_id) {
        this.korisnik_skrbnik_id = korisnik_skrbnik_id;
    }

    public ZivotinjaEntity getZivotinjaId() {
        return zivotinjaId;
    }

    public void setZivotinjaId(ZivotinjaEntity zivotinjaId) {
        this.zivotinjaId = zivotinjaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RezervacijaEntity that = (RezervacijaEntity) o;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(datumRezervacije, that.datumRezervacije))
            return false;
        if (!Objects.equals(korisnik_udomitelj_id, that.korisnik_udomitelj_id))
            return false;
        if (!Objects.equals(korisnik_skrbnik_id, that.korisnik_skrbnik_id))
            return false;
        return Objects.equals(zivotinjaId, that.zivotinjaId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (datumRezervacije != null ? datumRezervacije.hashCode() : 0);
        result = 31 * result + (korisnik_udomitelj_id != null ? korisnik_udomitelj_id.hashCode() : 0);
        result = 31 * result + (korisnik_skrbnik_id != null ? korisnik_skrbnik_id.hashCode() : 0);
        result = 31 * result + (zivotinjaId != null ? zivotinjaId.hashCode() : 0);
        return result;
    }
}
