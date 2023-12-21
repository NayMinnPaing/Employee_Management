package com.employeeManagement.employeeManagement.service;

import java.util.List;

import com.employeeManagement.employeeManagement.model.EmployeeModel;

public interface EmployeeService {

	public int insertData(EmployeeModel empmodel);
	public List<EmployeeModel> selectAllData();
	public int deleteData(int empId);
	public EmployeeModel selectById(int empId);
	public int updateData(EmployeeModel empmodel);
}
