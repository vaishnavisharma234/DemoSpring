package com.demo.sre.controller;

import java.util.List;
//test comment
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.sre.DemoModel.DemoModel;
import com.demo.sre.Service.DemoService;
import com.demo.sre.exception.DemoException;

@RestController
@Validated
public class DemoController {
	@Autowired
	private DemoService demoService;
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String homeMethod(){
		return "this is error ";
	}
	@RequestMapping(value="/User", method=RequestMethod.GET)
	public List<DemoModel> getUser() throws DemoException{
		
		return demoService.getUser();
	}
	
	@RequestMapping(value="/User", method=RequestMethod.POST)
	public String addUser(@RequestBody DemoModel user) throws DemoException{
		String result=demoService.addUser(user);
		
		return result;
	}
	
	@RequestMapping(value="/User", method=RequestMethod.PUT)
	public String modifyUser(@RequestBody DemoModel user) throws DemoException{
		return demoService.modifyUser(user);
	}
	@RequestMapping(value="/User/{id}", method=RequestMethod.DELETE)
	public String deleteUser( @PathVariable  int id) throws DemoException{	
		
		return demoService.deleteUser(id);
	}
}
