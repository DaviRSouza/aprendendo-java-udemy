package composition3.model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Client {
    private String name;
    private String email;
    private LocalDate birthDate;
    private static final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Client(String name, String email, String birthDate) {
        this.name = name;
        this.email = email;
        this.birthDate = LocalDate.parse(birthDate, dtf);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBirthDate() {
        return birthDate.format(dtf);
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return getName() +
                " (" +
                getBirthDate() +
                ") - " +
                getEmail();
    }
}
