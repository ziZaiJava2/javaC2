package com.djbc.mall;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductionDJBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner in = new Scanner(System.in);
		getDataSheet();
		System.out.println("表单字段：id   name   description   original_price   price");
		System.out.println("\n1:存储数据\t2:查找整个数据\t3:查找单个数据\t4:更改数据\t5:删除数据");
		System.out.println("请输入你要进行的操作序号：");
		int number = in.nextInt();
		getAddProduction(number);
			
		System.out.println("谢谢操作！");
		
		in.close();
	}
	
	
	//创建一个url和加载驱动的方法
	public static String getUrl() throws ClassNotFoundException {
		String url = "jdbc:mysql://127.0.0.1:3306/mall?user=root&password=root";
		Class.forName("com.mysql.jdbc.Driver");
		return url;
	}
	
	
	//创建一个数据表
	public static  void getDataSheet() throws ClassNotFoundException, SQLException{
		String url = getUrl();  // 调用url和与加载驱动的方法
		Connection conn = null;
		Statement stat = null;
		
		//生成一个mall库里的production表
		try {
			String sql = "create table production(" + "id int not null auto_increment," + "name varchar(50) not null,"
					+ "description text not null," + "original_price double not null," + "price double not null,"
					+ "primary key(id)" + ");";
			conn = DriverManager.getConnection(url);
			stat = conn.createStatement();
			
			conn.setAutoCommit(false);
			boolean A = stat.execute(sql);  //在数据库执行sql里的内容，返回一个boolean类型
			if(A){
				System.out.println("创建production数据表。。。成功！");
			}else{
				System.out.println("创建production数据表。。。失败！");
			}
			conn.commit();
			
		} catch (SQLException e) {
			e.printStackTrace();    // 显示出异常的路径
		}finally{
			stat.close();
			conn.close();
		}
		
	}
	
	public static void getAddProduction(int number){
		Scanner in = new Scanner(System.in);
		try {
			if(number == 1){       //存储数据的操作
				Production A = Production.getProduction();
				ProductionDAO.getProductionDAO().addProduction(A);	
				
			}else if(number == 2){     //查找整个数据表数据的操作
				ProductionDAO.getProductionDAO().getAllProduction();
				
			}else if(number == 3){		//查找单个数据的操作
				System.out.println("请输入要查找的数据的id：");
				Production B = ProductionDAO.getProductionDAO().getProduction(in.nextInt());
				System.out.println(B.toString());     //调用Production里的toString方法
				
			}else if(number == 4){      //更改数据的操作
				System.out.println("请输入要更改的数据的id：");
				ProductionDAO.getProductionDAO().updateProduction(in.nextInt());
				
			}else if(number == 5){      //删除数据的操作
				System.out.println("请输入要删除的数据的id：");
				ProductionDAO.getProductionDAO().deleteProduction(in.nextInt());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			in.close();
		}
	}


}
