package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

import java.math.BigInteger;
import java.util.Collection;

@Entity
@Table(name = "zivotinja", schema = "public", catalog = "udomi")
public class ZivotinjaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
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

        if (id != that.id) return false;
        if (!ime.equals(that.ime)) return false;
        if (!godine.equals(that.godine)) return false;
        if (!velicina.equals(that.velicina)) return false;
        if (!tezina.equals(that.tezina)) return false;
        if (!slika.equals(that.slika)) return false;
        if (!objavaId.equals(that.objavaId)) return false;
        if (!rezervacijaId.equals(that.rezervacijaId)) return false;
        return vrstaId.equals(that.vrstaId);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + ime.hashCode();
        result = 31 * result + godine.hashCode();
        result = 31 * result + velicina.hashCode();
        result = 31 * result + tezina.hashCode();
        result = 31 * result + slika.hashCode();
        result = 31 * result + objavaId.hashCode();
        result = 31 * result + rezervacijaId.hashCode();
        result = 31 * result + vrstaId.hashCode();
        return result;
    }
}
