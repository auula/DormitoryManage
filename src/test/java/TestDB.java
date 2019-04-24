import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import me.codegc.manage.dao.AdminDao;
import me.codegc.manage.dao.impl.AdminDaoimplement;
import me.codegc.manage.model.Admin;
import me.codegc.manage.utils.JDBCUtil;

public class TestDB {
	
	@Test
	public void test1() {
		
		String configFile = "src/main/resources/jdbc.properties";
		
		
		Connection connection = JDBCUtil.init(configFile).getConnection();
		if (connection != null) {
			System.out.append("SQLConnection获取正常:" + connection);
		} else {
			System.out.append("SQLConnection获取异常！！！");
		}
		JDBCUtil.closeConnection(connection);
	}
	
	@Test
	public void test2() {
		AdminDao ad = new AdminDaoimplement();
		Admin admin =  ad.findByAccountAndPassword("admin", "admin");
		System.out.println(admin.toString());
	}
}
