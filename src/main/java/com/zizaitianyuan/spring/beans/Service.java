package com.zizaitianyuan.spring.beans;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

@Component("service")
public class Service {

	private Dao dao;
	
	@Override
	public String toString() {
		return "serivce" + dao;
	}

	public Dao getDao() {
		return dao;
	}

	@Resource(name="dao")
	public void setDao(Dao dao) {
		this.dao = dao;
	}
}
