package trainig.profileInformation;

public class mainData {
    private final String lastName;
    private final String firstName;
    private final String nativeName;
    private final String number;

    public mainData(String lastName, String firstName, String nativeName, String number) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.nativeName = nativeName;
        this.number = number;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getNumber() {
        return number;
    }
}
