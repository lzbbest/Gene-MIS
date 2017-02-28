package comPakage;

import java.sql.ResultSet;
import java.sql.SQLException;

import dbManage.JDBCFile;

public class recordNumStat {

	String selectsql=null;
    JDBCFile jdbccon=null;
	public recordNumStat(){}
	public recordNumStat(String selectsql,JDBCFile jdbccon){
		this.selectsql=selectsql;
		this.jdbccon=jdbccon;
	}
	public int getRecordNum(){
		int recordNum=0;
		ResultSet rs=null;
		rs=jdbccon.query(selectsql);
		try {
			boolean hasRecord=rs.next();
			if(hasRecord=false){
				return recordNum;
			}
			recordNum=rs.getInt(1);
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return recordNum;
	}
}
