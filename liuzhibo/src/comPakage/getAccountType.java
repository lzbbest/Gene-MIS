package comPakage;

import java.sql.ResultSet;
import java.sql.SQLException;

import dbManage.JDBCFile;

public class getAccountType {

	String selectsql=null;
    JDBCFile jdbccon=null;
	public getAccountType(){}
	public getAccountType(String selectsql,JDBCFile jdbccon){
		this.selectsql=selectsql;
		this.jdbccon=jdbccon;
	}
	public String getAccountTypeValue(){
		String AccountTypeValue="";
		ResultSet rs=null;
		rs=jdbccon.query(selectsql);
		try {
			boolean hasRecord=rs.next();
			if(hasRecord=false){
				return AccountTypeValue;
			}
			AccountTypeValue=rs.getString(1);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return AccountTypeValue;
	}
}
