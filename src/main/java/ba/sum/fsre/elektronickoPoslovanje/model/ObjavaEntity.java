package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "objava", schema = "public", catalog = "udomi")
public class ObjavaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "tekst_objave", nullable = true, length = -1)
    private String tekstObjave;
    @Basic
    @Column(name = "datum_objave", nullable = true)
    private Timestamp datumObjave;

    @ManyToOne
    @JoinColumn(name = "korisnik_id", nullable = false)
    private UserEntity korisnikId;

    @ManyToOne
    @JoinColumn(name = "lokacija_id", referencedColumnName = "id", nullable = false)
    private LokacijaEntity lokacijaId;
    @ManyToOne
    @JoinColumn(name = "zivotinja_id", referencedColumnName = "id", nullable = false)
    private ZivotinjaEntity zivotinjaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTekstObjave() {
        return tekstObjave;
    }

    public void setTekstObjave(String tekstObjave) {
        this.tekstObjave = tekstObjave;
    }

    public Timestamp getDatumObjave() {
        return datumObjave;
    }

    public void setDatumObjave(Timestamp datumObjave) {
        this.datumObjave = datumObjave;
    }

    public UserEntity getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(UserEntity korisnikId) {
        this.korisnikId = korisnikId;
    }

    public LokacijaEntity getLokacijaId() {
        return lokacijaId;
    }

    public void setLokacijaId(LokacijaEntity lokacijaId) {
        this.lokacijaId = lokacijaId;
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

        ObjavaEntity that = (ObjavaEntity) o;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(tekstObjave, that.tekstObjave)) return false;
        if (!Objects.equals(datumObjave, that.datumObjave)) return false;
        if (!Objects.equals(korisnikId, that.korisnikId)) return false;
        if (!Objects.equals(lokacijaId, that.lokacijaId)) return false;
        return Objects.equals(zivotinjaId, that.zivotinjaId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (tekstObjave != null ? tekstObjave.hashCode() : 0);
        result = 31 * result + (datumObjave != null ? datumObjave.hashCode() : 0);
        result = 31 * result + (korisnikId != null ? korisnikId.hashCode() : 0);
        result = 31 * result + (lokacijaId != null ? lokacijaId.hashCode() : 0);
        result = 31 * result + (zivotinjaId != null ? zivotinjaId.hashCode() : 0);
        return result;
    }
}
