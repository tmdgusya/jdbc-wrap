package session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import configure.Configure;
import exception.NotExistConfigureException;

public abstract class SessionFactory {

    private static final Logger log = LoggerFactory.getLogger(SessionFactory.class);

    static {
        log.info("Init DBConnection");
    }

    public static Connection connect(Configure configure) {

        Connection conn = null;

        if (configure == null) {
            throw new NotExistConfigureException();
        }

        try {
            Class.forName(configure.getDriver());
            conn = DriverManager.getConnection(
                    configure.getDbUrl(),
                    configure.getUserName(),
                    configure.getPassword()
            );

            log.info("DB Access... DB INFO = {}", configure);
        } catch (SQLException e) {
            log.error("Connection Fail", e);
        } catch (ClassNotFoundException e) {
            log.error("Check Database Driver", e);
        }

        return conn;
    }
}
