package ba.sum.fsre.elektronickoPoslovanje.dto;

import java.math.BigInteger;

public class ZivotinjaDto {
    private Long id;
    private String ime;
    private Integer godine;
    private String velicina;
    private BigInteger tezina;
    private Long vrstaId;
    private String nazivVrste;

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

    public Long getVrstaId() {
        return vrstaId;
    }

    public void setVrstaId(Long vrstaId) {
        this.vrstaId = vrstaId;
    }

    public String getNazivVrste() {
        return nazivVrste;
    }

    public void setNazivVrste(String nazivVrste) {
        this.nazivVrste = nazivVrste;
    }
}
