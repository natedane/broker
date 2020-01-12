package broker;

import java.sql.*;
import java.util.*;

import javax.sql.DataSource;

public class connection {

	public List<StockInfo> GetStocks(DataSource d) throws SQLException {
		Connection c;
		Statement s;
		ResultSet rs;
		StockInfo p;
	
		c = d.getConnection();
		s = c.createStatement();
		rs = s.executeQuery("select * from people");
	
		List<StockInfo> pl = new ArrayList<StockInfo>();

		while (rs.next())
		{
			p = new StockInfo(rs.getString("stockName"), rs.getDouble("buyPrice"), rs.getInt("quantity"));
		    pl.add(p);
		}
	
		return pl;
	}
}
