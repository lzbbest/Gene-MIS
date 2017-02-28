package dbManage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCFile {
	String url="jdbc:mysql://localhost:3306/gomissystem";
	Connection con=null;
	Statement stmt=null;
	ResultSet rs=null;
	public JDBCFile(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection(url,"root","root");
			stmt=con.createStatement();
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
	public ResultSet query(String selectsql){
		ResultSet rs=null;
		try {
			rs=stmt.executeQuery(selectsql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}		
		return rs;
	}
	public int insert(String insertsql){
		int result=0;
		try {
			result=stmt.executeUpdate(insertsql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}		
		return result;
	}
	public int delete(String deletesql){
		int result=0;
		try {
			result=stmt.executeUpdate(deletesql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}		
		return result;
	}
	
	public int update(String updatesql){
		int result=0;
		try {
			result=stmt.executeUpdate(updatesql);
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}		
		return result;
	}

}
