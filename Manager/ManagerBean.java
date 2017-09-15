package com.inautix.Manager;

public class ManagerBean {
	private String emp_id;
	private String mgr_id;
	public String getMgr_id() {
		return mgr_id;
	}
	public void setMgr_id(String mgr_id) {
		this.mgr_id = mgr_id;
	}
	public String getEmp_cpwd() {
		return emp_cpwd;
	}
	public void setEmp_cpwd(String emp_cpwd) {
		this.emp_cpwd = emp_cpwd;
	}
	private String emp_cpwd;
	private String emp_pwd;
	public String getEmp_pwd() {
		return emp_pwd;
	}
	public void setEmp_pwd(String emp_pwd) {
		this.emp_pwd = emp_pwd;
	}
	private String admin_id;
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getEmp_id() {
		return emp_id;
	}
	public void setEmp_id(String emp_id) {
		this.emp_id = emp_id;
	}
	public String getEmp_name() {
		return emp_name;
	}
	public void setEmp_name(String emp_name) {
		this.emp_name = emp_name;
	}
	public String getEmp_designation() {
		return emp_designation;
	}
	public void setEmp_designation(String emp_designation) {
		this.emp_designation = emp_designation;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	private String emp_name;
	private String emp_designation;
	private int salary;
	
}
