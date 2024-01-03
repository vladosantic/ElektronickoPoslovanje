package ba.sum.fsre.elektronickoPoslovanje.model;

import jakarta.persistence.*;

@Entity
@Table(name = "lokacija", schema = "public", catalog = "udomi")
public class LokacijaEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "naziv", nullable = true, length = -1)
    private String naziv;
    @Basic
    @Column(name = "adresa", nullable = true, length = -1)
    private String adresa;
    @Basic
    @Column(name = "grad", nullable = true, length = -1)
    private String grad;
    @Basic
    @Column(name = "drzava", nullable = true, length = -1)
    private String drzava;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public String getAdresa() {
        return adresa;
    }

    public void setAdresa(String adresa) {
        this.adresa = adresa;
    }

    public String getGrad() {
        return grad;
    }

    public void setGrad(String grad) {
        this.grad = grad;
    }

    public String getDrzava() {
        return drzava;
    }

    public void setDrzava(String drzava) {
        this.drzava = drzava;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LokacijaEntity that = (LokacijaEntity) o;

        if (id != that.id) return false;
        if (naziv != null ? !naziv.equals(that.naziv) : that.naziv != null) return false;
        if (adresa != null ? !adresa.equals(that.adresa) : that.adresa != null) return false;
        if (grad != null ? !grad.equals(that.grad) : that.grad != null) return false;
        if (drzava != null ? !drzava.equals(that.drzava) : that.drzava != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (naziv != null ? naziv.hashCode() : 0);
        result = 31 * result + (adresa != null ? adresa.hashCode() : 0);
        result = 31 * result + (grad != null ? grad.hashCode() : 0);
        result = 31 * result + (drzava != null ? drzava.hashCode() : 0);
        return result;
    }
}
