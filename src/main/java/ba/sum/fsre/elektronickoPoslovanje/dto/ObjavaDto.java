package ba.sum.fsre.elektronickoPoslovanje.dto;

import java.sql.Timestamp;

public class ObjavaDto {
    private Long id;
    private String tekstObjave;
    private Timestamp datumObjave;
    private Long korisnikId;
    private String imePrezime;
    private Long lokacijaId;
    private String imeLokacije;
    private Long zivotinjaId;
    private String imeZivotinje;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTekstObjave() {
        return tekstObjave;
    }

    public void setTekstObjave(String tekstObjave) {
        this.tekstObjave = tekstObjave;
    }

    public Timestamp getDatumObjave() {
        return datumObjave;
    }

    public void setDatumObjave(Timestamp datumObjave) {
        this.datumObjave = datumObjave;
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

    public Long getLokacijaId() {
        return lokacijaId;
    }

    public void setLokacijaId(Long lokacijaId) {
        this.lokacijaId = lokacijaId;
    }

    public String getImeLokacije() {
        return imeLokacije;
    }

    public void setImeLokacije(String imeLokacije) {
        this.imeLokacije = imeLokacije;
    }

    public Long getZivotinjaId() {
        return zivotinjaId;
    }

    public void setZivotinjaId(Long zivotinjaId) {
        this.zivotinjaId = zivotinjaId;
    }

    public String getImeZivotinje() {
        return imeZivotinje;
    }

    public void setImeZivotinje(String imeZivotinje) {
        this.imeZivotinje = imeZivotinje;
    }
}
