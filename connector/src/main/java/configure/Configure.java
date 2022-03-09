package configure;

public class Configure {

    private static final String DATABASE_DELIMITER = "/";
    private static final String JDBC_URL_PREFIX = "jdbc:";

    private final String dbUrl;
    private final String database;
    private final String userName;
    private final String password;
    private final String driver;

    static {
        System.out.println("[INFO] Configuration File Initiation");
    }

    public Configure(String dbUrl, String database, String userName, String password, String driver) {
        hasContainUrlPrefix(dbUrl);
        this.dbUrl = dbUrl;
        this.database = database;
        this.userName = userName;
        this.password = password;
        this.driver = driver;
    }

    private void hasContainUrlPrefix(String dbUrl) {
        final String REQUIRED_PREFIX = JDBC_URL_PREFIX;

        if (!dbUrl.startsWith(REQUIRED_PREFIX)) {
            throw new IllegalArgumentException("Check missing 'jdbc://' prefix in your database url");
        }
    }

    public String getDbUrl() {
        return dbUrl + DATABASE_DELIMITER + database;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getDriver() {
        return driver;
    }

    @Override
    public String toString() {
        return "Connection Info {" +
                "dbUrl='" + dbUrl + '\'' +
                ", database='" + database + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
