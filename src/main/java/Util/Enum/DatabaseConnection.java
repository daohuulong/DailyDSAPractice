package src.main.java.Util.Enum;

public enum DatabaseConnection {
    CONNECTION("abc"),
    ;

    private final String connectionString;

    private DatabaseConnection(String connectionString) {
        this.connectionString = connectionString;
    }
}
