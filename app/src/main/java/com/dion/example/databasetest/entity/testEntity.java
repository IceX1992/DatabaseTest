package com.dion.example.databasetest.entity;

/**
 * Created by Dion on 3/11/2016.
 */
public class testEntity {

    private long id;
    private String usrnam;
    private static String pw;

    public testEntity(long id, String usrnam, String pw){
        this.id = id;
        this.usrnam = usrnam;
        this.pw = pw;
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

    public static String getPw() {
        return pw;
    }

    public static void setPw(String pw) {
        testEntity.pw = pw;
    }
}