package com.zizaitianyuan.spring;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GenerateInstance {

	private static Logger logger = LoggerFactory.getLogger(GenerateInstance.class);

	public static void main(String[] args) throws Exception {

		// 1. 解析xml
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();

		Document doc = builder.parse(GenerateInstance.class.getClassLoader().getResourceAsStream("daos.xml"));
		logger.debug(doc.getDocumentElement().getNodeName());
		
		Element dao = (Element) doc.getElementsByTagName("bean").item(0);
		String className = dao.getAttribute("class");
		
		Element prop = (Element) dao.getElementsByTagName("property").item(0);
		String str = prop.getAttribute("name");
		String method = "set" + str.substring(0, 1).toUpperCase() + str.substring(1);
		String value = prop.getAttribute("value");
		
		logger.debug(className);
		// 2. 实例化对象
		Class<?> clazz = Class.forName(className);
		
		Constructor<?> c = clazz.getDeclaredConstructor(new Class[]{});
		Object o = c.newInstance(new Object[]{});
		
		Method setMethod = clazz.getDeclaredMethod(method, new Class[] {String.class});
		setMethod.invoke(o, value);
		
		logger.debug(o.toString());
		
//		// 3. 装配对象
	}
}
