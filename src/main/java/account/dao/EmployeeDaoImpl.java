package account.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import account.dto.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	List<Employee> empList=new ArrayList<Employee>();
	public List<Employee> getEmployees()
	{
		System.out.println("Dao - in getEmployees");
//		Employee employee=new Employee();
//		employee.setEmpNo(1);
//		employee.setEmpName("hemant");
//		employee.setHireDate(LocalDate.of(2016, 07, 02));
//		employee.setSalary(80000);
//		employee.setJob("Developer");
//		empList.add(employee);
//		employee=new Employee();
//		employee.setEmpNo(2);
//		employee.setEmpName("varsha");
//		employee.setHireDate(LocalDate.of(2016, 07, 02));
//		employee.setSalary(10000);
//		employee.setJob("Developer");
//		empList.add(employee);
		Connection conn=null; 
		try {
			conn=DBUtil.getDBConnection();
			Statement stmt=conn.createStatement();
			ResultSet rs=stmt.executeQuery("SELECT empno, ename, sal, deptno, job, \"Hiredate\", comm, mgr\r\n"
					+ "	FROM public.emp;");
			
			while(rs.next())
			{
				Employee employee = new Employee();
				employee.setEmpno(rs.getInt("empno"));
				employee.setEmpName(rs.getString("ename"));
				employee.setJob(rs.getString("job"));
				employee.setHireDate(rs.getDate("Hiredate").toLocalDate());
				employee.setSalary(rs.getDouble("sal"));
				empList.add(employee);
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return empList;
	}
	@Override
	public Employee findEmloyeeById(int empId) {
		// TODO Auto-generated method stub
		Connection conn=null; 
		try {
			conn=DBUtil.getDBConnection();
			PreparedStatement pstmt =conn.prepareStatement("select empno,ename,job,hiredate,sal,dept_name"+
			"from emp e,department_master d where empno=? and e.deptno=d.dept_code");
			pstmt.setInt(1, empId);
			ResultSet rs=pstmt.executeQuery();
			Employee employee = new Employee();
			while(rs.next())
			{
				employee.setEmpno(rs.getInt("empno"));
				employee.setEmpName(rs.getString("ename"));
				employee.setJob(rs.getString("job"));
				employee.setHireDate(rs.getDate("Hiredate").toLocalDate());
				employee.setSalary(rs.getDouble("sal"));
			}return employee;
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		
		return null;
	}
	@Override
	public List<Employee> findEmployeesByDept() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void deleteEmployee(Employee emp) {
		// TODO Auto-generated method stub
		empList.remove(emp);
	}
	@Override
	public void insertEmployeeWithValues(Employee emp) {
		// TODO Auto-generated method stub
		Connection conn= null;
		try {
			//conn= DBUtil.getDBConnection();
//			Statement stmt=conn.createStatement();
//			int count=stmt.executeUpdate("insert into public.emp(\r\n"
//					+ "	empno, ename, sal, deptno, job, \"Hiredate\", comm, mgr)\r\n"
//					+ "	VALUES (5, 'sachin', 12000, 2, 'sales', '2012-01-20', 2, 2)");
//			System.out.println("Records is inserted successfully");
			conn= DBUtil.getDBConnection();
			String sql="insert into emp values(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, emp.getEmpNo());
			pstmt.setString(2, emp.getEmpName());
			pstmt.setDouble(3, emp.getSalary());
			pstmt.setInt(4, emp.getDeptno());
			pstmt.setString(5, emp.getJob());
			pstmt.setDate(6,Date.valueOf(emp.getHireDate()));
			pstmt.setInt(7, emp.getComm());
			pstmt.setInt(8, emp.getMgr());
			
			int count=pstmt.executeUpdate();
			System.out.println("Record created successfully");
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}finally {
			if(conn!=null)
			{
				try {
					conn.close();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void insertEmployeeWithValues() {
	
		}

}