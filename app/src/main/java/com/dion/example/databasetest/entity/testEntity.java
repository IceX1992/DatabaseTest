package com.dion.example.databasetest.entity;

/**
 * Created by Dion on 3/11/2016.
 */
public class testEntity {

    private static String pw;
    private static String voornaam;
    private static String geboortejaar;
    private long id;
    private String usrnam;

    public testEntity(long id, String usrnam, String pw, String voornaam, String geboortejaar) {
        this.id = id;
        this.usrnam = usrnam;
        this.pw = pw;
        this.voornaam = voornaam;
        this.geboortejaar = geboortejaar;
    }

    public static String getPw() {
        return pw;
    }

    public static void setPw(String pw) {
        testEntity.pw = pw;
    }

    public static String getVoornaam() {
        return voornaam;
    }

    public static void setVoornaam(String voornaam) {
        testEntity.voornaam = voornaam;
    }

    public static String getGeboortejaar() {
        return geboortejaar;
    }

    public static void setGeboortejaar(String geboortejaar) {
        testEntity.geboortejaar = geboortejaar;
    }

    public boolean comparePw(String password) {
        if (pw.equals(password)) {
            return true;
        } else {
            return false;
        }
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsrnam() {
        return usrnam;
    }

    public void setUsrnam(String usrnam) {
        this.usrnam = usrnam;
    }
}
