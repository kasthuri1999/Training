package account.service;

import java.util.List;
import account.dao.EmployeeDao;
import account.dto.Employee;

public class EmployeeServiceImpl implements EmployeeService {
	EmployeeDao empDao;
		public EmployeeServiceImpl(EmployeeDao empDao)
		{
			this.empDao=empDao;
		}
		public Employee getEmployeeById(int empId)
		{
			Employee emp=empDao.findEmloyeeById(empId);
			return emp;
		}
		public List<Employee> getEmployees(){
			System.out.println("Service -In getEmployees");
			List<Employee> empList=empDao.getEmployees();
			return empList;
		}
		public List<Employee> getEmployeeByDept(){
		return null;
		}

		@Override
		public void deleteEmployee(int empId) {
		// TODO Auto-generated method stub
			Employee emp = empDao.findEmloyeeById(empId);
			if(emp != null) {
				empDao.deleteEmployee(emp);
			}else {
				throw new IllegalArgumentException("Employee Id not found");
			}
		}
		
		@Override
			public void insertEmployeeWithValues() {
				empDao.insertEmployeeWithValues();
			}
			
}
