package com.demo.sre.Service;


import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.demo.sre.DemoModel.DemoModel;
import com.demo.sre.Repository.DemoRepository;
import com.demo.sre.exception.DemoException;

public class DemoService {

	//private List<DemoModel> userList;
	@Autowired
	private DemoRepository demoRepository;
	
	public List<DemoModel> getUser() throws DemoException{
		try{ 
			List<DemoModel> result=demoRepository.getUsers();
		if(result==null|| result.isEmpty()) throw new DemoException("User Not Found!");
		return result;
		}
		catch(DemoException exception) {
			Logger LOGGER = LoggerFactory.getLogger(this.getClass()); 
			LOGGER.error(exception.getMessage(),exception);
			throw exception;
		}
	
	}
	
	public String addUser(DemoModel user) throws DemoException {
		//userList.add(user);
         demoRepository.addUsers(user);
		return "User added successfully";}
			

	
	public String modifyUser(DemoModel user) throws DemoException {
	try {
		DemoModel result=demoRepository.getById(user.getId());
		if(result == null)	{	throw new DemoException("User Not Found!");}
         demoRepository.modifyUser(user);
		return "User updated successfully";	
	}
		catch(DemoException exception) {
			Logger LOGGER = LoggerFactory.getLogger(this.getClass()); 
			LOGGER.error(exception.getMessage(),exception);
			throw exception;
		}
		}
	
	public String deleteUser(int searchId) throws DemoException {
		try{
			DemoModel result=demoRepository.getById(searchId);
	     if(result!=null) {
	    	demoRepository.deleteUser(result);
	       return  "User deleted successfully";  }
	     else { throw new DemoException("User Not Found!");} 
		}
	       catch(DemoException exception) {
				Logger LOGGER = LoggerFactory.getLogger(this.getClass()); 
				LOGGER.error(exception.getMessage(),exception);
				throw exception;
			}
	
	
}}
