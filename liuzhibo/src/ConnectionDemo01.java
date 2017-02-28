public class ConnectionDemo01{
	// 定义MySQL的数据库驱动程序
	public static final String DBDRIVER = "org.gjt.mm.mysql.Driver" ;
	public static void main(String args[]){
		try{
			Class.forName(DBDRIVER) ;	// 加载驱动程序
		}catch(ClassNotFoundException e){
			e.printStackTrace() ;
		}
	}
};