package com.zizaitianyuan.javac2.lesson05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildPath {

	/*
	 * 
	 * 假设我们有一颗树，如下所示。
	 *        A
	 *      /   \
	 *     B     C
	 *    /       \
	 *   D        F
	 *  /        / \
	 * E        G   H
	 * 
	 * 他们数据是按每个节点保存的，节点保存自己的名字及父节点的名字
	 * 
	 * {name: A, parentName: null}
	 * {name: B, parentName: A}
	 * {name: C, parentName: A}
	 * {name: D, parentName: B}
	 * ...
	 * 
	 * 实现方法，传入的参数是所有节点的List,返回一个Map，他的Key是节点的名字，
	 * Value是从根到节点的路径
	 * 
	 * 例如： 
	 * {
	 * 		A: [A],
	 * 		B: [A, B],
	 * 		D: [A, B, D],
	 * 		C: [A, C],
	 *      ...
	 * }
	 * 
	 * 
	 */
	private static Map<String, List<String>> nodePath = new HashMap<>();
	private static Map<String, Node> nodes = new HashMap<>();
	public static Map<String, List<String>> buildPaths(List<Node> nodes) {
		
		for(Node node : nodes){
			nodes.add(node);
		}
		
		for(Node node : nodes){
			rootPath(node.getName());
		}
		
		return nodePath;
		
		
		
		
	}

    public static List<String> rootPath(String name){
    	List<String> path = new ArrayList<>();
    	if(name == null){
    		return new ArrayList<String>();
    	}
    	new ArrayList<String>();
    	if(nodePath.get(name) != null){
    		return path = nodePath.get(name);
    	}else if("A".equals(name)){
    		path.add(name);
    		nodePath.get(name).addAll(path);
    		return path;
    	}else{
    		path = rootPath(nodes.get(name).getParentName());
    		path = new ArrayList<>(path);
    		path.add(name);
    		nodePath.get(name).addAll(path);
    	}
		return path;
    }
   


}



class Node {
	private String name;
	
	private String parentName;
	
	public Node(String name, String parentName) {
		this.name = name;
		this.parentName = parentName;
	}

	// 我们说了，一般实例成员变量会定义成private的。
	// 这个时候，我们简单的他们生成getter和setter方法
	// 这些代码可以自动生成：
	// 菜单： source -> generate getters and setters
	// (注意我这次使用的注释的方式是使用//)
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}

// 因为这个例子有点难，我写了个实现在下面。可以 想想再看




























































class BuildPath2 {

	/*
	 * 
	 * 假设我们有一颗树，如下所示。
	 *        A
	 *      /   \
	 *     B     C
	 *    /       \
	 *   D        F
	 *  /        / \
	 * E        G   H
	 * 
	 * 他们数据是按每个节点保存的，节点保存自己的名字及父节点的名字
	 * 
	 * {name: A, parentName: null}
	 * {name: B, parentName: A}
	 * {name: C, parentName: A}
	 * {name: D, parentName: B}
	 * ...
	 * 
	 * 实现方法，传入的参数是所有节点的List,返回一个Map，他的Key是节点的名字，
	 * Value是从根到节点的路径
	 * 
	 * 例如： 
	 * {
	 * 		A: [A],
	 * 		B: [A, B],
	 * 		D: [A, B, D],
	 * 		C: [A, C],
	 *      ...
	 * }
	 * 
	 * 
	 */
//	public static Map<String, List<String>> buildPaths(List<Node> nodes) {
//		
//		// 生成一个map，可以通过name来去的对应的node
//		allNodes = new HashMap<>();
//		
//		// 返回的结果
//		allPaths = new HashMap<>();
//		
//		for(Node node: nodes) {
//			allNodes.put(node.getName(), node);
//		}
//		
//		for(Node node: nodes) {
//			generatePath(node.getName());
//		}
//		
//		return allPaths;
//	}
//	
//	
//	private static Map<String, List<String>> allPaths;
//	private static Map<String, Node> allNodes;
//	
//	private static List<String> generatePath(String name) {
//		// 递归的结束条件
//		if(name == null) {
//			return new ArrayList<>();
//		}
//		
//		List<String> path;
//		if ((path = allPaths.get(name)) == null) {
//			Node n = allNodes.get(name);
//			List<String> parentPaths = generatePath(n.getParentName());
//			// 拷贝一份父节点的path
//			path = new ArrayList<>(parentPaths);
//			path.add(name);
//			allPaths.put(name, path);
//		}
//		return path;
//	}
	
}

