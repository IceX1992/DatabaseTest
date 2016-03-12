package com.dion.example.databasetest.entity;

/**
 * Created by Dion on 3/12/2016.
 */
public class ziekteEntity {


    /*    public static final String REAL_ID = "id";
    public static final String REAL_NAAM = "naam";
    public static final String REAL_ONTDEKT= "ontdekt door";
    public static final String REAL_JAARVANONTDEKKING = "ontdekt in";
    */

    private static String naam;
    private static String ontdekt_door;
    private static String ontdekt_in;
    private static long id;

    public ziekteEntity(long id, String naam, String ontdekt_door, String ontdekt_in) {
        this.id = id;
        this.naam = naam;
        this.ontdekt_door = ontdekt_door;
        this.ontdekt_in = ontdekt_in;
    }


    public static String getNaam() {
        return naam;
    }

    public static void setNaam(String naam) {
        ziekteEntity.naam = naam;
    }

    public static String getOntdekt_door() {
        return ontdekt_door;
    }

    public static void setOntdekt_door(String ontdekt_door) {
        ziekteEntity.ontdekt_door = ontdekt_door;
    }

    public static String getOntdekt_in() {
        return ontdekt_in;
    }

    public static void setOntdekt_in(String ontdekt_in) {
        ziekteEntity.ontdekt_in = ontdekt_in;
    }

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        ziekteEntity.id = id;
    }
}
