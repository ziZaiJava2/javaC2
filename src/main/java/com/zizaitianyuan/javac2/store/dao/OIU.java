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
	private static ProductionDAO PD;
	private static UsersDAO UD;
	private static OrdersDAO OD;
	private static CategoryDAO CD;
	private static String input = null;
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
						PD.deleteProduction();
						break;
					}
					case "users": {
						UD.deleteUsers();
						break;
					}
					case "orders": {
						OD.deleteOrders();
						break;
					}
					case "category": {
						CD.deleteCategory();
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
				boolean a = true;
				while (tableList.contains(tableName) && a) {
					System.out.println("请选择查询模式:获取明细内容,输入:Y/获得所有名称,输入:N");
					input = sc.nextLine();
					if ("Y".equals(input.toUpperCase())) {
						switch (tableName) {
						case "producton": {
							System.out.println("请输入要查询的商品ID\n");
							int productionId = sc.nextInt();
							Production pro = PD.getProduction(productionId);
							System.out.println("商品名:" + pro.getName() + "商品描述:" + pro.getDescription() + "商品原价"
									+ pro.getOriginal_price() + "商品现价" + pro.getPrice());
							break;
						}
						case "orders": {
							System.out.println("请输入要查询的订单ID\n");
							int ordersId = sc.nextInt();
							Orders ord = OD.getOrders(ordersId);
							System.out.println("创建日期:" + ord.getCreate_Date() + "送货地址:" + ord.getAddress() + "用户昵称:"
									+ ord.getUser_name() + "是否付款:" + ord.getIsPay());
							break;
						}
						case "users": {
							System.out.println("请输入要查询的用户ID\n");
							int usersId = sc.nextInt();
							Users use = UD.getUsers(usersId);
							System.out.println("用户姓名:：" + use.getName() + "用户地址:" + use.getAddress() + "用户余额"
									+ use.getBalance() + "用户邮箱:" + use.getMailbox() + "用户昵称:" + use.getNickName());
							break;
						}
						case "category": {
							System.out.println("请输入要查询的分类ID\n");
							int categoryId = sc.nextInt();
							Category cate = CD.getCategory(categoryId);
							System.out.println("分类:" + cate.getName());
							break;
						}
						}
						judge(a);
					} else if ("N".equals(input.toUpperCase())) {
						switch (tableName) {
						case "production": {
							List<String> proList = PD.getAllProduction();
							System.out.println("所有的商品名:" + proList.toString() + "\n");
							break;
						}
						case "users": {
							List<String> usersList = UD.getAllUsers();
							System.out.println("所有的用户名:" + usersList.toString() + "\n");
							break;
						}
						case "orders": {
							List<String> ordersList = OD.getAllOrders();
							System.out.println("订单用户:" + ordersList.toString() + "\n");
							break;
						}
						case "category": {
							List<String> cateList = CD.getAllCategory();
							System.out.println("分类名:" + cateList.toString() + "\n");
							break;
						}
						}
						judge(a);
					} else {
						System.out.println("输入错误");
					}
				}
				break;
			}
			case "BYE": {
			}
			case "B": {
				flag = false;
				break;
			}
			default: {
				System.out.println("您输入了不符合格式的指令!!");
				tell();
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

	private static void speak() {
		System.out.println("请选择想进行的操作:(不区分大小写)" + "\n" + "删除指定数据表(D/DELETE)\n" + "添加数据(A/ADD)\n" + "查找数据(Q/QUERY)\n"
				+ "退出系统(B/BYE)\n");
	}

	private static void tell() {
		System.out.println("请指示下一步操作:\n");
	}

	private static void judge(boolean a) {
		System.out.println("是否继续查询？(Y/N)\n");
		String choice = sc.nextLine();
		if ("N".equals(choice.toUpperCase())) {
			a = false;
			tell();
		}
	}
}
