package trainig.profileInformation;

public class eduData {
    private final String facultet;
    private final String dpt;

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
