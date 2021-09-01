package account.dto;

import java.time.LocalDate;

public class Employee {
	private int empNo;
	private String empName;
	private String job;
	private LocalDate hireDate;
	private double salary;
	private String deptName;
	
	private int Deptno;
	private int Comm;
	private int Mgr;
	
	
	public int getComm() {
		return Comm;
	}
	public void setComm(int comm) {
		Comm = comm;
	}
	public int getMgr() {
		return Mgr;
	}
	public void setMgr(int mgr) {
		Mgr = mgr;
	}
	
	public int getDeptno() {
		return Deptno;
	}
	public void setDeptno(int deptno) {
		Deptno = deptno;
	}
	public int getEmpNo() {
		return empNo;
	}
	public void setEmpno(int empno) {
		this.empNo = empno;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public LocalDate getHireDate() {
		return hireDate;
	}
	public void setHireDate(LocalDate hireDate) {
		this.hireDate = hireDate;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String toString(){
		return getEmpNo()+"\t"+getEmpName()+"\t"+  getJob()+"\t"
		+getHireDate()+"\t"+getSalary();
	}
}