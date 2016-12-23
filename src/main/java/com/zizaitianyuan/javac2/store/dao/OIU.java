package com.zizaitianyuan.javac2.store.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import com.zizaitianyuan.javac2.store.dto.*;

public class OIU {
	
	private static Production production = new Production();
	
	private static Users users = new Users();
	
	private static Orders orders = new Orders();
	
	private static Category category = new Category();
	
	private static ProductionDAO PD = new ProductionDAO();
	
	private static UsersDAO UD = new UsersDAO();
	
	private static OrdersDAO OD = new OrdersDAO();
	
	private static CategoryDAO CD = new CategoryDAO();
	
	private static String input = null;
	
	private static boolean a = true;
	
	private static Scanner sc = new Scanner(System.in);
	
	private static List<String> tableList = new ArrayList<>(Arrays.asList("production", "orders", "category", "users"));

	public static void main(String[] args) throws Exception {
	
		speak();
		
		boolean flag = true;
		
		while (flag) {
		
			input = sc.nextLine();
			
			switch (input.toUpperCase()) {
			
			case "DELETE": {
			
			}
			
			case "D": {
			
				System.out.println("请输入要删除的表的名称:\n");
				
				input = sc.nextLine();
				
				if (tableList.contains(input.toLowerCase())) {
				
					switch (input) {
					
					case "production": {
					
						System.out.println("请输入要删除的商品名");
						
						String name = sc.nextLine();
						
						PD.deleteProduction(name);
						
						break;
					
					}
					
					case "users": {
					
						System.out.println("请输入要删除的用户名");
						
						String name = sc.nextLine();
						
						UD.deleteUsers(name);
						
						break;
					
					}
					
					case "orders": {
					
						System.out.println("请输入要删除的订单用户名");
						
						String name = sc.nextLine();
						
						OD.deleteOrders(name);
						
						break;
					
					}
					
					case "category": {
					
						System.out.println("请输入要删除的类名");
						
						String name = sc.nextLine();
						
						CD.deleteCategory(name);
						
						break;
					
					}
					
					}
					
					System.out.println("删除成功\n");
					
					tell();
				
				} else {
				
					System.out.println("数据表不存在\n");
					
					tell();
				
				}
				
				break;
			
			}
			
			case "ADD": {
			
			}
			
			case "A": {
			
				System.out.println("请输入要插入数据的的表\n");
				
				String tableName = sc.nextLine();
				
				if (tableList.contains(tableName.toLowerCase())) {
				
					switch (tableName) {
					
					case "production": {
					
						addDataToProduction();
						
						break;
					
					}
					
					case "users": {
					
						addDataToUsers();
						
						break;
					
					}
					
					case "orders": {
					
						addDataToOrders();
						
						break;
					
					}
					
					case "category": {
					
						addDataToCategory();
						
						break;
					
					}
					
					}
					
					tell();
				
				}
				
				break;
			
			}
			
			case "QUERY": {
			
			}
			
			case "Q": {
			
				System.out.println("请输入要查询的表名\n");
				
				String tableName = sc.nextLine();
				
				while (tableList.contains(tableName) && a) {
				
					System.out.println("请选择查询模式:获取明细内容,输入:Y/获得所有名称,输入:N");
					
					input = sc.nextLine();
					
					if ("Y".equals(input.toUpperCase())) {
					
						switch (tableName) {
						
						case "production": {
						
							System.out.println("请输入要查询的商品名\n");
							
							String productionName = sc.nextLine();
							
							Production pro = PD.getProduction(productionName);
							
							System.out.println("商品名:" + pro.getName() + "\n商品描述:" + pro.getDescription() + "\n商品原价"
									+ pro.getOriginal_price() + "\n商品现价" + pro.getPrice());
							
							break;
						
						}
						
						case "orders": {
						
							System.out.println("请输入要查询的订单ID\n");
							
							int ordersId = sc.nextInt();
							
							Orders ord = OD.getOrders(ordersId);
							
							System.out.println("\n创建日期:" + ord.getCreate_Date() + "\n送货地址:" + ord.getAddress()
									+ "\n用户昵称:" + ord.getUser_name() + "\n是否付款:" + ord.getIsPay());
							
							break;
						
						}
						
						case "users": {
						
							System.out.println("请输入要查询的用户名\n");
							
							String usersName = sc.nextLine();
							
							Users use = UD.getUsers(usersName);
							
							System.out.println("\n用户姓名:：" + use.getName() + "\n用户地址:" + use.getAddress() + "\n用户余额"
									+ use.getBalance() + "\n用户邮箱:" + use.getMailbox() + "\n用户昵称:" + use.getNickName());
							
							break;
						}
						
						case "category": {
						
							System.out.println("请输入要查询的分类ID\n");
							
							int categoryId = sc.nextInt();
							
							Category cate = CD.getCategory(categoryId);
							
							System.out.println("\n分类:" + cate.getName());
							
							break;
						
						}
						
						}
						
						judge();
					
					} else if ("N".equals(input.toUpperCase())) {
					
						switch (tableName) {
						
						case "production": {
						
							List<String> proList = PD.getAllProduction();
							
							System.out.println("所有的商品名:\n" + proList.toString() + "\n");
							
							break;
						
						}
						
						case "users": {
						
							List<String> usersList = UD.getAllUsers();
							
							System.out.println("所有的用户名:\n" + usersList.toString() + "\n");
							
							break;
						
						}
						
						case "orders": {
						
							List<String> ordersList = OD.getAllOrders();
							
							System.out.println("订单用户:\n" + ordersList.toString() + "\n");
							
							break;
						
						}
						
						case "category": {
						
							List<String> cateList = CD.getAllCategory();
							
							System.out.println("分类名:\n" + cateList.toString() + "\n");
							
							break;
						
						}
						
						}
						
						judge();
					
					} else {
					
						System.out.println("输入错误");
					
					}
				
				}
				
				break;
			
			}
			
			case "UPDATE": {
			
			}
			
			case "U": {
			
				System.out.println("请输入想更新的数据表名称:");
				
				String tableName = sc.nextLine();
				
				switch (tableName) {
				
				case "production": {
				
					System.out.println("请输入您想在商品表中更新的商品描述和商品名");
					
					updateStr(PD);
					
					break;
				
				}
				
				case "users": {
				
					System.out.println("请输入您想在用户表中更新的用户昵称和用户名");
					
					updateStr(UD);
					
					break;
				
				}
				
				case "category": {
				
					System.out.println("请输入您想在分类表中更新的数据和类名");
					
					updateStr(CD);
					
					break;
				
				}
				
				case "orders": {
				
					System.out.println("请输入您想在订单表中更新的付款状态和订单用户名");
					
					updateStr(OD);
					
					break;
				
				}
				
				}
				
				tell();
				
				break;
			
			}
			
			case "BYE": {
			
			}
			
			case "B": {
			
				flag = false;
				
				System.out.println("您已成功退出，感谢使用青青数据库系统");
				
				break;
			
			}
			
			}

		
		}
	
	}

	private static void addDataToProduction() {
	
		System.out.println("请输入要插入的数据:(name/description/original_price/price)\n");
		
		createProduction();
		
		PD.addProduction(production);
		
		System.out.println("插入数据成功\n");
	}

	private static void createProduction() {
		
		String name = sc.nextLine();
		
		String description = sc.nextLine();
		
		int original_price = sc.nextInt();
		
		int price = sc.nextInt();
		
		production.setName(name);
		
		production.setDescription(description);
		
		production.setOriginal_price(original_price);
		
		production.setPrice(price);
	}

	private static void addDataToCategory() {
		
		System.out.println("请输入要插入的数据:(name)\n");
		
		createCategory();
		
		CD.addCategory(category);
		
		System.out.println("插入数据成功\n");
	}

	private static void createCategory() {
		
		String name = sc.nextLine();
		
		category.setName(name);
	}

	private static void addDataToOrders() throws ParseException {
		
		System.out.println("请输入要插入的数据:(date(yyyy-MM-dd)/address/user_name/ispay)\n");
		
		createOrders();
		
		OD.addOrders(orders);
		
		System.out.println("插入数据成功\n");
	}

	private static void createOrders() throws ParseException {
		
		String dateStr = sc.nextLine();
		
		String address = sc.nextLine();
		
		String user_name = sc.nextLine();
		
		String ispay = sc.nextLine();
		
		Date dateTemp = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
		
		java.sql.Date date = new java.sql.Date(dateTemp.getTime());
		
		orders.setCreate_Date(date);
		
		orders.setAddress(address);
		
		orders.setUser_name(user_name);
		
		orders.setIsPay(ispay);
	}

	private static void addDataToUsers() {
		
		System.out.println("请输入要插入的数据:(name/nickName/mailbox/address/balance)\n");
		
		createUsers();
		
		UD.addUsers(users);
		
		System.out.println("插入数据成功\n");
	}

	private static void createUsers() {
		
		String name = sc.nextLine();
		
		String nickName = sc.nextLine();
		
		String mailbox = sc.nextLine();
		
		String address = sc.nextLine();
		
		int balance = sc.nextInt();
		
		users.setName(name);
		
		users.setNickName(nickName);
		
		users.setMailbox(mailbox);
		
		users.setAddress(address);
		
		users.setBalance(balance);
	}

	private static void updateStr(TAG tag) {
		
		String change = sc.nextLine();
		
		String name = sc.nextLine();
		
		tag.update(change, name);
		
		System.out.println("更新成功");
	}

	private static void speak() {
		
		System.out.println("******************************");
		
		System.out.println("---> 请选择想进行的操作:(不区分大小写)" + "\n" + "---> 删除指定数据表(D/DELETE)\n" + "---> 添加数据(A/ADD)\n"
				+ "---> 查找数据(Q/QUERY)\n" + "---> 更新数据(U/UPDATE)\n" + "---> 退出系统(B/BYE)\n");
		
		System.out.println("******************************");
	}

	private static void tell() {

		System.out.println("请指示下一步操作:\n");
	
	}

	private static void judge() {
	
		System.out.println("是否继续查询？(Y/N)");
		
		String choice = sc.nextLine();
		
		if ("N".equals(choice.toUpperCase())) {
		
			a = false;
			
			tell();
		
		}
	
	}

}
