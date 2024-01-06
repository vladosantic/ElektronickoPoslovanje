package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "komentar", schema = "public", catalog = "udomi")
public class KomentarEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Basic
    @Column(name = "tekst_komentara", nullable = true, length = -1)
    private String tekstKomentara;
    @Basic
    @Column(name = "datum_komentara", nullable = true)
    private Timestamp datumKomentara;

    @ManyToOne
    @JoinColumn(name = "korisnik_id")
    private UserEntity korisnikId;

    @ManyToOne
    @JoinColumn(name = "objava_id")
    private ObjavaEntity objavaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public UserEntity getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(UserEntity korisnikId) {
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

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(tekstKomentara, that.tekstKomentara))
            return false;
        if (!Objects.equals(datumKomentara, that.datumKomentara))
            return false;
        if (!Objects.equals(korisnikId, that.korisnikId)) return false;
        return Objects.equals(objavaId, that.objavaId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (tekstKomentara != null ? tekstKomentara.hashCode() : 0);
        result = 31 * result + (datumKomentara != null ? datumKomentara.hashCode() : 0);
        result = 31 * result + (korisnikId != null ? korisnikId.hashCode() : 0);
        result = 31 * result + (objavaId != null ? objavaId.hashCode() : 0);
        return result;
    }
}
