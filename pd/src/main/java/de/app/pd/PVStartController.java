/**
 * 
 */
package de.app.pd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author pd
 * 
 */

@Controller
public class PVStartController {

	@Autowired
	DataSource dataSource;

	@RequestMapping(value = "/pv/{function}", method = { RequestMethod.GET })
	public ModelAndView getStartpage(@PathVariable String function) {

		// ApplicationContext ctx = new ClassPathXmlApplicationContext();
		// DataSource ds = (DataSource) ctx.getBean("dataSource");
		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			connection = dataSource.getConnection();
			ps = connection.prepareStatement("select * from tagesertrag");
			rs = ps.executeQuery();
			while (rs.next()){
				System.out.println(rs.getString("ertrag"));
			}
			System.out.println("test");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			try{
				rs.close();
			} catch(Exception e){}
			try{
				ps.close();
			} catch(Exception e){}
			try{
				connection.close();
			} catch(Exception e){}
		}
		String viewname = "";
		if (function.equals("uebersicht")) {
			viewname = "uebersicht";
		}
		return new ModelAndView(viewname);
	}

}
