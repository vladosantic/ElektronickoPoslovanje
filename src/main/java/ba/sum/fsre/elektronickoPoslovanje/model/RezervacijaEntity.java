package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "rezervacija", schema = "public", catalog = "udomi")
public class RezervacijaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "datum_rezervacije", nullable = true)
    private Timestamp datumRezervacije;
    @ManyToOne
    @JoinColumn(name = "korisnik_udomitelj_id", referencedColumnName = "id", nullable = false)
    private KorisnikEntity korisnik_udomitelj_id;
    @ManyToOne
    @JoinColumn(name = "korisnik_skrbnik_id", referencedColumnName = "id", nullable = false)
    private KorisnikEntity korisnik_skrbnik_id;

    @ManyToOne
    @JoinColumn(name = "zivotinja_id", referencedColumnName = "id", nullable = false)
    private ZivotinjaEntity zivotinjaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Timestamp datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public KorisnikEntity getKorisnik_udomitelj_id() {
        return korisnik_udomitelj_id;
    }

    public void setKorisnik_udomitelj_id(KorisnikEntity korisnik_udomitelj_id) {
        this.korisnik_udomitelj_id = korisnik_udomitelj_id;
    }

    public KorisnikEntity getKorisnik_skrbnik_id() {
        return korisnik_skrbnik_id;
    }

    public void setKorisnik_skrbnik_id(KorisnikEntity korisnik_skrbnik_id) {
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

        if (id != that.id) return false;
        if (!datumRezervacije.equals(that.datumRezervacije)) return false;
        if (!korisnik_udomitelj_id.equals(that.korisnik_udomitelj_id)) return false;
        if (!korisnik_skrbnik_id.equals(that.korisnik_skrbnik_id)) return false;
        return zivotinjaId.equals(that.zivotinjaId);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + datumRezervacije.hashCode();
        result = 31 * result + korisnik_udomitelj_id.hashCode();
        result = 31 * result + korisnik_skrbnik_id.hashCode();
        result = 31 * result + zivotinjaId.hashCode();
        return result;
    }
}
