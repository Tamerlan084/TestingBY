package model;

public class eduData {
    public final String facultet;
    public final String dpt;

    public eduData(String facultet, String dpt) {
        this.facultet = facultet;
        this.dpt = dpt;
    }

    public String getFacultet() {
        return facultet;
    }

    public String getDpt() {
        return dpt;
    }
}
