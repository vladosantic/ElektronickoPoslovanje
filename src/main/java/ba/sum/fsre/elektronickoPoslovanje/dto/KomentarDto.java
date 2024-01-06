package ba.sum.fsre.elektronickoPoslovanje.dto;

import java.sql.Timestamp;

public class KomentarDto {
    private Long id;
    private String imePrezime;
    private String tekstKomentara;
    private Timestamp datumKomentara;
    private Long korisnikId;
    private Long objavaId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImePrezime() {
        return imePrezime;
    }

    public void setImePrezime(String imePrezime) {
        this.imePrezime = imePrezime;
    }

    public String getTekstKomentara() {
        return tekstKomentara;
    }

    public void setTekstKomentara(String tekstKomentara) {
        this.tekstKomentara = tekstKomentara;
    }

    public Timestamp getDatumKomentara() {
        return datumKomentara;
    }

    public void setDatumKomentara(Timestamp datumKomentara) {
        this.datumKomentara = datumKomentara;
    }

    public Long getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(Long korisnikId) {
        this.korisnikId = korisnikId;
    }

    public Long getObjavaId() {
        return objavaId;
    }

    public void setObjavaId(Long objavaId) {
        this.objavaId = objavaId;
    }
}
