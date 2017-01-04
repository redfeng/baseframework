package com.zqxx.system.dao;

import org.springframework.stereotype.Repository;

import com.zqxx.dao.BaseDao;
import com.zqxx.system.po.User;

@Repository
public class UserDao extends BaseDao<User>{
	//根据登陆名查找用户
	public User findByName(String loginName){
		String hql="from User where username=?";
		return this.findOne(hql, loginName);
	}
}
