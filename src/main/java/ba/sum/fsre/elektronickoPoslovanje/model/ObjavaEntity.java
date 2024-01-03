package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "objava", schema = "public", catalog = "udomi")
public class ObjavaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "tekst_objave", nullable = true, length = -1)
    private String tekstObjave;
    @Basic
    @Column(name = "datum_objave", nullable = true)
    private Timestamp datumObjave;
    @OneToMany(mappedBy = "objavaId")
    private Collection<KomentarEntity> komentarId;

    @ManyToOne
    @JoinColumn(name = "korisnik_id", nullable = false)
    private KorisnikEntity korisnikId;

    @ManyToOne
    @JoinColumn(name = "lokacija_id", referencedColumnName = "id", nullable = false)
    private LokacijaEntity lokacijaId;
    @ManyToOne
    @JoinColumn(name = "zivotinja_id", referencedColumnName = "id", nullable = false)
    private ZivotinjaEntity zivotinjaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Collection<KomentarEntity> getKomentarId() {
        return komentarId;
    }

    public void setKomentarId(Collection<KomentarEntity> komentarId) {
        this.komentarId = komentarId;
    }

    public KorisnikEntity getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(KorisnikEntity korisnikId) {
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

        if (id != that.id) return false;
        if (!tekstObjave.equals(that.tekstObjave)) return false;
        if (!datumObjave.equals(that.datumObjave)) return false;
        if (!komentarId.equals(that.komentarId)) return false;
        if (!korisnikId.equals(that.korisnikId)) return false;
        if (!lokacijaId.equals(that.lokacijaId)) return false;
        return zivotinjaId.equals(that.zivotinjaId);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + tekstObjave.hashCode();
        result = 31 * result + datumObjave.hashCode();
        result = 31 * result + komentarId.hashCode();
        result = 31 * result + korisnikId.hashCode();
        result = 31 * result + lokacijaId.hashCode();
        result = 31 * result + zivotinjaId.hashCode();
        return result;
    }
}
