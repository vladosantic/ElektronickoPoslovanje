package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Collection;

@Entity
@Table(name = "korisnik", schema = "public", catalog = "udomi")
public class KorisnikEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "ime", nullable = true, length = -1)
    private String ime;
    @Basic
    @Column(name = "prezime", nullable = true, length = -1)
    private String prezime;
    @Basic
    @Column(name = "email", nullable = true, length = -1)
    private String email;
    @Basic
    @Column(name = "telefon", nullable = true, length = -1)
    private String telefon;
    @Basic
    @Column(name = "lokacija", nullable = true, length = -1)
    private String lokacija;
    @Basic
    @Column(name = "korisnicko_ime", nullable = true, length = -1)
    private String korisnickoIme;
    @Basic
    @Column(name = "lozinka", nullable = true, length = -1)
    private String lozinka;
    @Basic
    @Column(name = "datum_registracije", nullable = true)
    private Timestamp datumRegistracije;
    @OneToMany(mappedBy = "korisnikId")
    private Collection<KomentarEntity> komentarId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public Timestamp getDatumRegistracije() {
        return datumRegistracije;
    }

    public void setDatumRegistracije(Timestamp datumRegistracije) {
        this.datumRegistracije = datumRegistracije;
    }

    public Collection<KomentarEntity> getKomentarId() {
        return komentarId;
    }

    public void setKomentarId(Collection<KomentarEntity> komentarId) {
        this.komentarId = komentarId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KorisnikEntity that = (KorisnikEntity) o;

        if (id != that.id) return false;
        if (!ime.equals(that.ime)) return false;
        if (!prezime.equals(that.prezime)) return false;
        if (!email.equals(that.email)) return false;
        if (!telefon.equals(that.telefon)) return false;
        if (!lokacija.equals(that.lokacija)) return false;
        if (!korisnickoIme.equals(that.korisnickoIme)) return false;
        if (!lozinka.equals(that.lozinka)) return false;
        if (!datumRegistracije.equals(that.datumRegistracije)) return false;
        return komentarId.equals(that.komentarId);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + ime.hashCode();
        result = 31 * result + prezime.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + telefon.hashCode();
        result = 31 * result + lokacija.hashCode();
        result = 31 * result + korisnickoIme.hashCode();
        result = 31 * result + lozinka.hashCode();
        result = 31 * result + datumRegistracije.hashCode();
        result = 31 * result + komentarId.hashCode();
        return result;
    }
}
