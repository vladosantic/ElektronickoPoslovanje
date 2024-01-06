package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "recenzija", schema = "public", catalog = "udomi")
public class RecenzijaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "tekst_recenzije", nullable = true, length = -1)
    private String tekstRecenzije;
    @Basic
    @Column(name = "ocjena", nullable = true)
    private Integer ocjena;
    @Basic
    @Column(name = "datum_recenzije", nullable = true)
    private Timestamp datumRecenzije;
    @ManyToOne
    @JoinColumn(name = "korisnik_recezent_id", referencedColumnName = "id", nullable = false)
    private UserEntity korisnik_recezent_id;
    @ManyToOne
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id", nullable = false)
    private UserEntity korisnik_id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTekstRecenzije() {
        return tekstRecenzije;
    }

    public void setTekstRecenzije(String tekstRecenzije) {
        this.tekstRecenzije = tekstRecenzije;
    }

    public Integer getOcjena() {
        return ocjena;
    }

    public void setOcjena(Integer ocjena) {
        this.ocjena = ocjena;
    }

    public Timestamp getDatumRecenzije() {
        return datumRecenzije;
    }

    public void setDatumRecenzije(Timestamp datumRecenzije) {
        this.datumRecenzije = datumRecenzije;
    }

    public UserEntity getKorisnik_recezent_id() {
        return korisnik_recezent_id;
    }

    public void setKorisnik_recezent_id(UserEntity korisnik_recezent_id) {
        this.korisnik_recezent_id = korisnik_recezent_id;
    }

    public UserEntity getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(UserEntity korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecenzijaEntity that = (RecenzijaEntity) o;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(tekstRecenzije, that.tekstRecenzije))
            return false;
        if (!Objects.equals(ocjena, that.ocjena)) return false;
        if (!Objects.equals(datumRecenzije, that.datumRecenzije))
            return false;
        if (!Objects.equals(korisnik_recezent_id, that.korisnik_recezent_id))
            return false;
        return Objects.equals(korisnik_id, that.korisnik_id);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (tekstRecenzije != null ? tekstRecenzije.hashCode() : 0);
        result = 31 * result + (ocjena != null ? ocjena.hashCode() : 0);
        result = 31 * result + (datumRecenzije != null ? datumRecenzije.hashCode() : 0);
        result = 31 * result + (korisnik_recezent_id != null ? korisnik_recezent_id.hashCode() : 0);
        result = 31 * result + (korisnik_id != null ? korisnik_id.hashCode() : 0);
        return result;
    }
}
