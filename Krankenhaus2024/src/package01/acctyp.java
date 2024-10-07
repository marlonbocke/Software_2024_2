package package01;
import java.time.LocalDate;

public class acctyp {
    private String name;
    private LocalDate startDate;
    private String position;
    private boolean marker;
    private String permission;

    public acctyp(String name, LocalDate startDate, String position, boolean marker, String permission) {
        this.name = name;
        this.startDate = startDate;
        this.position = position;
        this.marker = marker;
        this.permission = permission;
    }

    // Getters and Setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isMarker() {
        return marker;
    }

    public void setMarker(boolean marker) {
        this.marker = marker;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}

class Kunde extends acctyp {
    public Kunde(String name, LocalDate startDate, String position, boolean marker, String permission) {
        super(name, startDate, position, marker, permission);
    }
}

class Mitarbeiter extends acctyp {
    public Mitarbeiter(String name, LocalDate startDate, String position, boolean marker, String permission) {
        super(name, startDate, position, marker, permission);
    }
}

class Administrator extends acctyp {
    public Administrator(String name, LocalDate startDate, String position, boolean marker, String permission) {
        super(name, startDate, position, marker, permission);
    }
}
