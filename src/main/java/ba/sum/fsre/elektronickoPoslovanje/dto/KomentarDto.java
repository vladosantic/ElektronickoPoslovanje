package ba.sum.fsre.elektronickoPoslovanje.dto;

import java.sql.Timestamp;

public class KomentarDto {
    private int id;
    private String tekstKomentara;
    private Timestamp datumKomentara;
    private int korisnikId;
    private int objavaId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getKorisnikId() {
        return korisnikId;
    }

    public void setKorisnikId(int korisnikId) {
        this.korisnikId = korisnikId;
    }

    public int getObjavaId() {
        return objavaId;
    }

    public void setObjavaId(int objavaId) {
        this.objavaId = objavaId;
    }
}
