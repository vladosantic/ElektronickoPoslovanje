package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

@Entity
@Table(name = "korisnik_uloga", schema = "public", catalog = "udomi")
public class KorisnikUlogaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;

    @ManyToOne
    @JoinColumn(name = "korisnik_id", referencedColumnName = "id", nullable = false)
    private KorisnikEntity korisnikId;

    @ManyToOne
    @JoinColumn(name = "uloga_id")
    private UlogaEntity ulogaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public KorisnikEntity getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(KorisnikEntity korisnikId) {
        this.korisnikId = korisnikId;
    }

    public UlogaEntity getUlogaId() {
        return ulogaId;
    }

    public void setUlogaId(UlogaEntity ulogaId) {
        this.ulogaId = ulogaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KorisnikUlogaEntity that = (KorisnikUlogaEntity) o;

        if (id != that.id) return false;
        if (!korisnikId.equals(that.korisnikId)) return false;
        return ulogaId.equals(that.ulogaId);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + korisnikId.hashCode();
        result = 31 * result + ulogaId.hashCode();
        return result;
    }
}
