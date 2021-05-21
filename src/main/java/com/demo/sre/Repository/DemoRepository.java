package com.demo.sre.Repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.demo.sre.DemoModel.DemoModel;

@Repository
public class DemoRepository {
	private List<DemoModel> userList;

	public DemoRepository() {
	userList= new ArrayList<DemoModel>();
	DemoModel user1=new DemoModel("John",23,121);
	DemoModel user2=new DemoModel("Milany",26,126);
	DemoModel user3=new DemoModel("Abhimanyu",22,127);
	DemoModel user4=new DemoModel("Peter",28,129);
	userList.add(user1);
	userList.add(user2);
	userList.add(user3);
	userList.add(user4);}

	public DemoModel getById(Integer searchId) {
	 for(DemoModel users:userList) {
		 if(users.getId()==searchId)
		return users;
	 }
	 return null;
	}
	
	public List<DemoModel> getUsers() {
		
		return userList;
	}
	
	public String addUsers(DemoModel user) {
		
		userList.add(user);
		return user.getName();
	}
	
	public DemoModel modifyUser(DemoModel user) {
		for(DemoModel u:userList) {
			if(u.getId()==user.getId()) {
				u.setName(user.getName());
				u.setAge(user.getAge());}
	}
		return user;
		}
	
	public DemoModel deleteUser(DemoModel user) {
				userList.remove(user);
		   return user;
	}
	
}
