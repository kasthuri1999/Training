package account.service;

import java.util.List;

import account.dto.Employee;

public interface EmployeeService {

	public Employee getEmployeeById(int empId);
	public List<Employee> getEmployees();
	public  List<Employee>getEmployeeByDept();
	public void deleteEmployee(int empId);
	public void insertEmployeeWithValues();
	

}