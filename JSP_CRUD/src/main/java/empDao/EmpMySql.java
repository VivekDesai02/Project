package empDao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import pojo.EmpPojo;


public class EmpMySql {
	
	public List<EmpPojo> ViawData(){
		List<EmpPojo> Ist = new ArrayList<>();
		
		try {
			Connection conn = empConnection.dbConnection.connect();
			String q ="SELECT * FROM `emp_info`";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(q);
			
			while(rs.next()) {
				EmpPojo ep = new EmpPojo();
				
				ep.setId(rs.getInt("id"));
				ep.setName(rs.getString("name"));
				ep.setCity(rs.getString("city"));
				ep.setSalary(rs.getInt("salary"));
				Ist.add(ep);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return Ist;
		
	}
	
	public int add(EmpPojo ep) {
		try {
			Connection conn = empConnection.dbConnection.connect();
			String q = "INSERT INTO `emp_info`(`name`, `city`, `salary`) VALUES (?,?,?)";
			PreparedStatement pst = conn.prepareStatement(q);
			
			pst.setString(1, ep.getName());
			pst.setString(2, ep.getCity());
			pst.setInt(3, ep.getSalary());
			
			int Status = pst.executeUpdate();
			
			if(Status == 1) {
				return 1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public int delete(EmpPojo ep) {
		try {
			
			Connection conn = empConnection.dbConnection.connect();
			String q ="DELETE FROM `emp_info` WHERE id =?";
			PreparedStatement pst = conn.prepareStatement(q);
			
			pst.setInt(1, ep.getId());
			
			int Status = pst.executeUpdate();
			if(Status == 1) {
				return 1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
	public EmpPojo IdView(int id) {
		
		EmpPojo ep = null;
		try {
			Connection conn = empConnection.dbConnection.connect();
			String q = "SELECT * FROM `emp_info` WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setInt(1, id);
			
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				ep = new EmpPojo();
				ep.setId(rs.getInt("id"));
				ep.setName(rs.getString("name"));
				ep.setCity(rs.getString("city"));
				ep.setSalary(rs.getInt("salary"));
			}
			
		}catch(Exception e) {
			
		}
		
		return ep;
		
	}
	
	public int Update(EmpPojo ep) {
		try {
			Connection conn = empConnection.dbConnection.connect();
			String q = "UPDATE `emp_info` SET `name`=?,`city`=?,`salary`=? WHERE id=?";
			PreparedStatement pst = conn.prepareStatement(q);
			pst.setString(1, ep.getName());
			pst.setString(2, ep.getCity());
			pst.setInt(3, ep.getSalary());
			pst.setInt(4, ep.getId());
			
			int Status = pst.executeUpdate();
			
			if(Status == 1) {
				return 1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return 0;
	}

}


