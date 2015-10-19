package utils;

import java.io.IOException;
import java.sql.*;
import java.util.Properties;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import framework.PropertiesLoader;

public class DatabaseManager {
    static Session session;
    static Connection connection;
    static PreparedStatement stmt;
    static ResultSet rs;

    private static void doSshTunnel(String strSshUser, String strSshPassword, String strSshHost, int nSshPort,
                                    String strRemoteHost, int nLocalPort, int nRemotePort) throws JSchException {
        final JSch jsch = new JSch();
        session = jsch.getSession(strSshUser, strSshHost, nSshPort);
        session.setPassword(strSshPassword);

        final Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        session.setConfig(config);

        session.connect();
        session.setPortForwardingL(nLocalPort, strRemoteHost, nRemotePort);
    }

    private static String executeQuery(String query, String column){
        String result = "";
        try {
            stmt = connection.prepareStatement(query);
            if (!column.equals("")) {
                rs = stmt.executeQuery();
                if (rs.next()) {
                    if (column.equals("1")) {
                        result = rs.getString(Integer.parseInt(column));
                    } else {
                        result = rs.getString(column);
                    }
                }
            } else {
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * Method deletes all records, which match the predefined player name, from the following tables:
     * accounts, persons, persons, transactions, audit_events.
     *
     * @throws Exception
     */

    public static void deletePlayers() throws Exception {
        String id = executeQuery("SELECT * FROM players WHERE us_login LIKE '" + "PLogin" + "%';", "us_person_id");
        while (!id.equals("")) {

            executeQuery("DELETE FROM transactions WHERE debit_account_id in (select account_id FROM accounts WHERE person_id ="
                    + id + " )" + "OR credit_account_id in (select account_id from accounts where person_id =" + id + " );", "");

            executeQuery("DELETE FROM accounts WHERE person_id = " + id + ";", "");

            executeQuery("DELETE FROM persons WHERE person_id = " + id + ";", "");
            executeQuery("DELETE FROM players WHERE us_person_id = " + id + ";", "");

            id = executeQuery("SELECT * FROM players WHERE us_login LIKE '" + "PLogin" + "%';", "us_person_id");
        }
        executeQuery("DELETE FROM audit_events WHERE object_name LIKE '" + "PLogin" + "%';", "");
    }

    /**
     * Method returns the first existing player email from the DB.
     *
     * @return first available e-mail address
     */

    public static String getExistingEmail() throws Exception {
        return executeQuery("SELECT * FROM players;", "us_email");
    }

    /**
     * Method returns the first existing player login from the DB.
     *
     * @return first available player name
     */

    public static String getExistingLogin() throws Exception {
        return executeQuery("SELECT * FROM players;", "us_login");
    }

    public static void deleteTickets() throws Exception {
        executeQuery("DELETE FROM tickets WHERE name like '%auto%';", "");
    }

    public static void deleteLiveEvents() throws Exception {
        executeQuery("DELETE FROM events WHERE name like '%auto%';", "");
    }

    public static void deleteTables() throws Exception {
        executeQuery("DELETE FROM desks WHERE d_name like '%auto%';", "");
        executeQuery("DELETE FROM audit_events WHERE object_name LIKE '%auto%';", "");
    }

    public static void deleteFastFolds() throws Exception {
        executeQuery("DELETE FROM fast_folds WHERE name like '%AUTO%';", "");
        executeQuery("DELETE FROM audit_events WHERE object_name LIKE '%AUTO%';", "");
    }

    public static String getLastTableId() throws Exception {
        return executeQuery("SELECT currval FROM _sequence;", "currval");
    }

    public static void deleteBonusProgram() throws Exception {
        String id = executeQuery("SELECT * FROM bonus_programs WHERE code LIKE 'bonuscode%';", "id");
        while (!id.equals("")) {
            executeQuery("DELETE FROM bonus_programs_awards WHERE  program_id =" + id + ";", "");
            executeQuery("DELETE FROM bonus_programs WHERE id = " + id + ";", "");
            id = executeQuery("SELECT * FROM bonus_programs WHERE code LIKE 'bonuscode%';", "id");
        }
    }

    public static void deleteCollusionList() throws Exception {
        executeQuery("Delete FROM blankbots.collusion_list where cheater1_player_id between '10035' and '10042' "
                + "AND cheater2_player_id  between '10035' and '10042';", "");
    }

    public static void deleteTournaments() throws Exception {
        String id = executeQuery("SELECT * FROM tournaments WHERE tour_name LIKE 'auto%';", "tour_id");
        while (!id.equals("")) {
            executeQuery("DELETE FROM tournaments WHERE tour_id = '" + id + "';", "");
            executeQuery("DELETE FROM tournament_registration_types WHERE tournament_id = '" + id + "';", "");
            id = executeQuery("SELECT * FROM tournaments WHERE tour_name LIKE 'Auto%';", "tour_id");
        }
    }

    /**
     * Establish an ssh tunnel to the SQL server.
     *
     * @throws NullPointerException, SQLException, JSchException, IOException
     */

    public static void establishConnection() {
        try {
            PropertiesLoader loader = new PropertiesLoader();
            String sshUser = loader.loadProperty().getProperty("sshUser");
            String sshPassword = loader.loadProperty().getProperty("sshPassword");
            String sshHost = loader.loadProperty().getProperty("sshHost");
            int sshPort = Integer.parseInt(loader.loadProperty().getProperty("sshPort"));
            String remoteHost = loader.loadProperty().getProperty("remoteHost");
            int localPort = Integer.parseInt(loader.loadProperty().getProperty("localPort"));
            int remotePort = Integer.parseInt(loader.loadProperty().getProperty("remotePort"));

            String dbUrl = loader.loadProperty().getProperty("dbUrl");
            String dbUser = loader.loadProperty().getProperty("dbUser");
            String dbPassword = loader.loadProperty().getProperty("dbPassword");

            DatabaseManager.doSshTunnel(sshUser, sshPassword, sshHost, sshPort, remoteHost, localPort, remotePort);
            connection = DriverManager.getConnection(dbUrl, dbUser, dbPassword);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Method closes the ssh connection to the SQL server.
     *
     * @throws SQLException, IOException, JSchException
     */

    public static void closeConnection() throws SQLException, IOException, JSchException {
        PropertiesLoader loader = new PropertiesLoader();
        int localPort = Integer.parseInt(loader.loadProperty().getProperty("localPort"));
        if (connection != null) {
            connection.close();
        }
        if (session != null) {
            session.delPortForwardingL(localPort);
            session.disconnect();
        }
    }
}
