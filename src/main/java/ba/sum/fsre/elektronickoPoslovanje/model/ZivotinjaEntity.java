package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "zivotinja", schema = "public", catalog = "udomi")
public class ZivotinjaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic
    @Column(name = "ime", nullable = true, length = -1)
    private String ime;
    @Basic
    @Column(name = "godine", nullable = true)
    private Integer godine;
    @Basic
    @Column(name = "velicina", nullable = true, length = -1)
    private String velicina;
    @Basic
    @Column(name = "tezina", nullable = true, precision = 0)
    private BigInteger tezina;
    @Basic
    @Column(name = "slika", nullable = true, length = -1)
    private String slika;
    @OneToMany(mappedBy = "zivotinjaId")
    private Collection<ObjavaEntity> objavaId;
    @OneToMany(mappedBy = "zivotinjaId")
    private Collection<RezervacijaEntity> rezervacijaId;
    @ManyToOne
    @JoinColumn(name = "vrsta_id", referencedColumnName = "id")
    private VrstaEntity vrstaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public Integer getGodine() {
        return godine;
    }

    public void setGodine(Integer godine) {
        this.godine = godine;
    }

    public String getVelicina() {
        return velicina;
    }

    public void setVelicina(String velicina) {
        this.velicina = velicina;
    }

    public BigInteger getTezina() {
        return tezina;
    }

    public void setTezina(BigInteger tezina) {
        this.tezina = tezina;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public Collection<ObjavaEntity> getObjavaId() {
        return objavaId;
    }

    public void setObjavaId(Collection<ObjavaEntity> objavaId) {
        this.objavaId = objavaId;
    }

    public Collection<RezervacijaEntity> getRezervacijaId() {
        return rezervacijaId;
    }

    public void setRezervacijaId(Collection<RezervacijaEntity> rezervacijaId) {
        this.rezervacijaId = rezervacijaId;
    }

    public VrstaEntity getVrstaId() {
        return vrstaId;
    }

    public void setVrstaId(VrstaEntity vrstaId) {
        this.vrstaId = vrstaId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZivotinjaEntity that = (ZivotinjaEntity) o;

        if (!id.equals(that.id)) return false;
        if (!Objects.equals(ime, that.ime)) return false;
        if (!Objects.equals(godine, that.godine)) return false;
        if (!Objects.equals(velicina, that.velicina)) return false;
        if (!Objects.equals(tezina, that.tezina)) return false;
        if (!Objects.equals(slika, that.slika)) return false;
        if (!Objects.equals(objavaId, that.objavaId)) return false;
        if (!Objects.equals(rezervacijaId, that.rezervacijaId))
            return false;
        return Objects.equals(vrstaId, that.vrstaId);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (ime != null ? ime.hashCode() : 0);
        result = 31 * result + (godine != null ? godine.hashCode() : 0);
        result = 31 * result + (velicina != null ? velicina.hashCode() : 0);
        result = 31 * result + (tezina != null ? tezina.hashCode() : 0);
        result = 31 * result + (slika != null ? slika.hashCode() : 0);
        result = 31 * result + (objavaId != null ? objavaId.hashCode() : 0);
        result = 31 * result + (rezervacijaId != null ? rezervacijaId.hashCode() : 0);
        result = 31 * result + (vrstaId != null ? vrstaId.hashCode() : 0);
        return result;
    }
}
