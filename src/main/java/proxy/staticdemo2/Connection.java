package proxy.staticdemo2;

import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Wrapper;

public interface Connection extends Wrapper, AutoCloseable{

	Statement createStatment() throws SQLException;
	void close() throws SQLException;
}
