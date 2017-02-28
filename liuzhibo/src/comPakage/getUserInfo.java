package comPakage;

import java.sql.ResultSet;
import java.sql.SQLException;

import dbManage.JDBCFile;

public class getUserInfo {

	String selectsql=null;
    JDBCFile jdbccon=null;
    int recordNum=0;
    String account_type=null;
	public getUserInfo(){}
	public getUserInfo(String selectsql,JDBCFile jdbccon){
		this.selectsql=selectsql;
		this.jdbccon=jdbccon;
	}
	
	public void queryUserInfo(){
		ResultSet rs=null;
		rs=jdbccon.query(selectsql);
		try {
			boolean hasRecord=rs.next();
			if(hasRecord=false){
				recordNum=0;
				account_type=null;
			}
			else{
				recordNum=rs.getInt(1);
				account_type=rs.getString(2);
			}
			
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	
	}
	public String getAccountType(){
		return account_type;
	}
	public int getRecordNum(){
		return recordNum;
	}
}
