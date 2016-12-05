package com.shop.database;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainDatabase {
	public static void main(String[] args) {
		UseDatabase UD = new UseDatabase();
		Scanner sc = new Scanner(System.in);
		speak();
		String input = null;
		boolean flag = true;
		String createName = null;
		List<String> tableNameList = new ArrayList<String>();
		while (flag) {
			input = sc.nextLine();
			switch (input.toUpperCase()) {
			case "CREATE": {
			}
			case "C": {
				System.out.println("请输入想创建的商品表的名称:\n");
				createName = sc.nextLine();
				tableNameList.add(createName);
				UD.createTable(createName);
				System.out.println("创建成功!");
				tell();
				break;
			}
			case "DELETE": {
			}
			case "D": {
				System.out.println("请输入要删除的表的名称:\n");
				String name = sc.nextLine();
				if (tableNameList.contains(name)) {
					UD.deleteTable(name);
					tableNameList.remove(name);
					System.out.println("删除成功!");
					tell();
				} else {
					System.out.println("数据表不存在");
					tell();
				}
				break;
			}
			case "ADD": {
			}
			case "A": {
				System.out.println("请输入要插入的表及其数据:(表名/商品名/商品描述/原价/现价)\n");
				String tableName = sc.nextLine();
				String name = sc.nextLine();
				String description = sc.nextLine();
				int original_price = sc.nextInt();
				int price = sc.nextInt();
				if (tableNameList.contains(tableName)) {
					UD.insert(tableName, name, description, original_price, price);
					System.out.println("操作成功!");
					tell();
				} else {
					System.out.println("数据表不存在");
					tell();
				}
				break;
			}
			case "QUERY": {
			}
			case "Q": {
				System.out.println("请输入要查找的项:(列名/表名)\n");
				String column = sc.nextLine();
				String tableName = sc.nextLine();
				if (tableNameList.contains(tableName)) {
					System.out.println("查找结果如下:\n");
					UD.queryTable(column, tableName);
					tell();
				} else {
					System.out.println("不存在该表");
					tell();
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
		System.out.println("您已退出数据库系统");
		sc.close();
	}

	private static void speak() {
		System.out.println("请选择想进行的操作:(不区分大小写)" + "\n" + "创建数据库表(C/CREATE)\n" + "删除指定数据表(D/DELETE)\n" + "添加数据(A/ADD)\n"
				+ "查找数据(Q/QUERY)\n" + "退出系统(B/BYE)\n");
	}

	private static void tell() {
		System.out.println("请指示下一步操作:\n");
	}
}
