package account.dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBUtil {

	public static Connection getDBConnection() throws SQLException {
		// TODO Auto-generated method stub
		Connection connection = null;
		try {
			DriverManager.deregisterDriver(new org.postgresql.Driver());
			connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/sqlproject", "postgres", "Pkasthuri");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}

}
