package ba.sum.fsre.elektronickoPoslovanje.dto;

import java.sql.Timestamp;

public class RezervacijaDto {
    private Long id;
    private Timestamp datumRezervacije;
    private Long korisnikUdomiteljId;
    private String imeUdomitelja;
    private Long korisnikSkrbnikId;
    private String imeSkrbnika;
    private Long zivotinjaId;
    private String imeZivotinje;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDatumRezervacije() {
        return datumRezervacije;
    }

    public void setDatumRezervacije(Timestamp datumRezervacije) {
        this.datumRezervacije = datumRezervacije;
    }

    public Long getKorisnikUdomiteljId() {
        return korisnikUdomiteljId;
    }

    public void setKorisnikUdomiteljId(Long korisnikUdomiteljId) {
        this.korisnikUdomiteljId = korisnikUdomiteljId;
    }

    public String getImeUdomitelja() {
        return imeUdomitelja;
    }

    public void setImeUdomitelja(String imeUdomitelja) {
        this.imeUdomitelja = imeUdomitelja;
    }

    public Long getKorisnikSkrbnikId() {
        return korisnikSkrbnikId;
    }

    public void setKorisnikSkrbnikId(Long korisnikSkrbnikId) {
        this.korisnikSkrbnikId = korisnikSkrbnikId;
    }

    public String getImeSkrbnika() {
        return imeSkrbnika;
    }

    public void setImeSkrbnika(String imeSkrbnika) {
        this.imeSkrbnika = imeSkrbnika;
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
