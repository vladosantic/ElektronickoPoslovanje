package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "komentar", schema = "public", catalog = "udomi")
public class KomentarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @Basic
    @Column(name = "tekst_komentara", nullable = true, length = -1)
    private String tekstKomentara;
    @Basic
    @Column(name = "datum_komentara", nullable = true)
    private Timestamp datumKomentara;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private KorisnikEntity korisnikId;

    @ManyToOne
    @JoinColumn(name = "objava_id")
    private ObjavaEntity objavaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTekstKomentara() {
        return tekstKomentara;
    }

    public void setTekstKomentara(String tekstKomentara) {
        this.tekstKomentara = tekstKomentara;
    }

    public Timestamp getDatumKomentara() {
        return datumKomentara;
    }

    public void setDatumKomentara(Timestamp datumKomentara) {
        this.datumKomentara = datumKomentara;
    }

    public KorisnikEntity getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(KorisnikEntity korisnikId) {
        this.korisnikId = korisnikId;
    }

    public ObjavaEntity getObjavaId() {
        return objavaId;
    }

    public void setObjavaId(ObjavaEntity objavaId) {
        this.objavaId = objavaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KomentarEntity that = (KomentarEntity) o;

        if (id != that.id) return false;
        if (!tekstKomentara.equals(that.tekstKomentara)) return false;
        if (!datumKomentara.equals(that.datumKomentara)) return false;
        if (!korisnikId.equals(that.korisnikId)) return false;
        return objavaId.equals(that.objavaId);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + tekstKomentara.hashCode();
        result = 31 * result + datumKomentara.hashCode();
        result = 31 * result + korisnikId.hashCode();
        result = 31 * result + objavaId.hashCode();
        return result;
    }
}
