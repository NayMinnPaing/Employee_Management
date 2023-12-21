package com.employeeManagement.employeeManagement.controller;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.employeeManagement.employeeManagement.model.EmployeeModel;
import com.employeeManagement.employeeManagement.service.empserviceimpl.EmployeeServiceImpl;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	EmployeeModel empValidObj=new EmployeeModel();
	
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public ModelAndView addform() {
		
		ModelAndView modelview= new ModelAndView();
		modelview.setViewName("addform");
		
		modelview.addObject("empValidObj", empValidObj);
		return modelview;
	}
	
	@RequestMapping(value = "/empdata" ,method = RequestMethod.GET)
	public ModelAndView addData(@ModelAttribute  EmployeeModel empmodel) {
		
		int result=employeeServiceImpl.insertData(empmodel);
		List<EmployeeModel> emplist=employeeServiceImpl.selectAllData();

		ModelAndView modelview= new ModelAndView();
		modelview.setViewName("index");
		modelview.addObject("emplist", emplist);

		modelview.addObject("resultinsert", result);
		return modelview;
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteData(@PathVariable (name="id") String empId) {
		int id=Integer.parseInt(empId);
		int result=employeeServiceImpl.deleteData(id);
		
		ModelAndView modelview=new ModelAndView();
		modelview.setViewName("redirect:/index");
		modelview.addObject("resultdelete", result);
		return modelview;
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public ModelAndView selecttoupdate(@PathVariable (name="id") String empId) {
		int id=Integer.parseInt(empId);
		EmployeeModel empmodel=employeeServiceImpl.selectById(id);
		
		ModelAndView modelview=new ModelAndView();
		modelview.setViewName("showupdate");
		modelview.addObject("empmodel", empmodel);
		return modelview;
	}
	
	@RequestMapping(value = "/updatedata", method = RequestMethod.POST)
	public ModelAndView updatedata(@ModelAttribute EmployeeModel empmodel) {
		int result=employeeServiceImpl.updateData(empmodel);
		ModelAndView modelview=new ModelAndView();
		modelview.setViewName("redirect:/index");
		modelview.addObject("resultupdate", result);
		return modelview;
	}
}
