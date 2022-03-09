package configure;

public class Configure {

    private final String DEFAULT_USERNAME = "root";

    private final String dbUrl;
    private final String database;
    private final String userName;
    private String password;

    static {
        System.out.println("[INFO] Configuration File Initiation");
    }

    public Configure(String dbUrl, String database, String userName, String password) {
        hasContainUrlPrefix(dbUrl);
        this.dbUrl = dbUrl;
        this.database = database;
        this.userName = userName;
        this.password = password;
    }

    private void hasContainUrlPrefix(String dbUrl) {
        final String REQUIRED_PREFIX = "jdbc://";

        if (!dbUrl.startsWith(REQUIRED_PREFIX)) {
            throw new IllegalArgumentException("Check missing 'jdbc://' prefix in your database url");
        }
    }


}
