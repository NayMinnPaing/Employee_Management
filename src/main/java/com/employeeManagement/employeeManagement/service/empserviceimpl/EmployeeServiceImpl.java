package com.employeeManagement.employeeManagement.service.empserviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeManagement.employeeManagement.model.EmployeeModel;
import com.employeeManagement.employeeManagement.repository.EmployeeRepository;
import com.employeeManagement.employeeManagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepositoy;
	
	@Override
	public int insertData(EmployeeModel empmodel) {
		// TODO Auto-generated method stub
		return employeeRepositoy.insertData(empmodel);
	}

	@Override
	public List<EmployeeModel> selectAllData() {
		
		return employeeRepositoy.selectAllData();
	}

	@Override
	public int deleteData(int empId) {
		// TODO Auto-generated method stub
		return employeeRepositoy.deleteData(empId);
	}

	@Override
	public EmployeeModel selectById(int empId) {
		// TODO Auto-generated method stub
		return employeeRepositoy.selectById(empId);
	}

	@Override
	public int updateData(EmployeeModel empmodel) {
		// TODO Auto-generated method stub
		return employeeRepositoy.updateData(empmodel);
	}

	

}
