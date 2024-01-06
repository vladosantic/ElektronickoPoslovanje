package ba.sum.fsre.elektronickoPoslovanje.dto;

import java.sql.Timestamp;

public class RecenzijaDto {
    private Long id;
    private String tekstRecenzije;
    private Integer ocjena;
    private Timestamp datumRecenzije;
    private Long korisnikRecezentId;
    private String imePrezimeRecezenta;
    private Long korisnikId;
    private String imePrezime;

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

    public Long getKorisnikRecezentId() {
        return korisnikRecezentId;
    }

    public void setKorisnikRecezentId(Long korisnikRecezentId) {
        this.korisnikRecezentId = korisnikRecezentId;
    }

    public String getImePrezimeRecezenta() {
        return imePrezimeRecezenta;
    }

    public void setImePrezimeRecezenta(String imePrezimeRecezenta) {
        this.imePrezimeRecezenta = imePrezimeRecezenta;
    }

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }
}
