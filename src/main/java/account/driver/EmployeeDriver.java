package account.driver;

import java.util.List;

import account.dao.EmployeeDao;
import account.dao.EmployeeDaoImpl;
import account.dto.Employee;
import account.service.EmployeeService;
import account.service.EmployeeServiceImpl;

public class EmployeeDriver {
	public static void main(String[] args) {
		EmployeeDao employeeDao=new EmployeeDaoImpl();
		EmployeeService employeeService =new EmployeeServiceImpl(employeeDao);
		List<Employee>emplist=employeeService.getEmployees();
		System.out.println("Back with Employee List - "+emplist.size());
		for(Employee employee:emplist)
		{
			System.out.println(employee);
		}
		
	}
}