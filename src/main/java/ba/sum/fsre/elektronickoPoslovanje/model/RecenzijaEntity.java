package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "recenzija", schema = "public", catalog = "udomi")
public class RecenzijaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
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
    private KorisnikEntity korisnik_recezent_id;
    @ManyToOne
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id", nullable = false)
    private KorisnikEntity korisnik_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public KorisnikEntity getKorisnik_recezent_id() {
        return korisnik_recezent_id;
    }

    public void setKorisnik_recezent_id(KorisnikEntity korisnik_recezent_id) {
        this.korisnik_recezent_id = korisnik_recezent_id;
    }

    public KorisnikEntity getKorisnik_id() {
        return korisnik_id;
    }

    public void setKorisnik_id(KorisnikEntity korisnik_id) {
        this.korisnik_id = korisnik_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        RecenzijaEntity that = (RecenzijaEntity) o;

        if (id != that.id) return false;
        if (!tekstRecenzije.equals(that.tekstRecenzije)) return false;
        if (!ocjena.equals(that.ocjena)) return false;
        if (!datumRecenzije.equals(that.datumRecenzije)) return false;
        if (!korisnik_recezent_id.equals(that.korisnik_recezent_id)) return false;
        return korisnik_id.equals(that.korisnik_id);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + tekstRecenzije.hashCode();
        result = 31 * result + ocjena.hashCode();
        result = 31 * result + datumRecenzije.hashCode();
        result = 31 * result + korisnik_recezent_id.hashCode();
        result = 31 * result + korisnik_id.hashCode();
        return result;
    }
}
