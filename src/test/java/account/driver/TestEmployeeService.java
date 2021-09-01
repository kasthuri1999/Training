package account.driver;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import account.dao.EmployeeDao;
import account.dto.Employee;
import account.service.EmployeeService;
import account.service.EmployeeServiceImpl;

class TestEmployeeService {
	static EmployeeService employeeService = null;
	static EmployeeDao mockEmployeeDao =null;
	private static Employee emp1;
	private static Employee emp2;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		mockEmployeeDao = Mockito.mock(EmployeeDao.class);
		employeeService = new EmployeeServiceImpl(mockEmployeeDao);
		emp1=new Employee();
		emp1.setEmpno(1);
		emp1.setEmpName("Hemant");
		emp1.setHireDate(LocalDate.of(2018,11,22));
		emp1.setSalary(8000);
		emp1.setJob("Developer");
		emp2=new Employee();
		emp2.setEmpno(2);
		emp2.setEmpName("Varsha");
		emp2.setHireDate(LocalDate.of(2018,12,02));
		emp2.setSalary(9000);
		emp2.setJob("Tester");
		Mockito.when(mockEmployeeDao.getEmployees()).thenReturn(Arrays.asList(emp1,emp2));
		
	}
    @Test
	void getAllEmployeetest() {
		List<Employee> allEmployee=employeeService.getEmployees();
		assertNotNull(allEmployee);
		assertEquals(2,allEmployee.size());
		assertNotEquals(3, allEmployee.size());
		
	}
}