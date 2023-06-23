package com.example.hrms_msil.pojo;

public class WorkAnniversaryItem{
	private String empId;
	private String name;
	private int yrs;

	public void setEmpId(String empId){
		this.empId = empId;
	}

	public String getEmpId(){
		return empId;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setYrs(int yrs){
		this.yrs = yrs;
	}

	public int getYrs(){
		return yrs;
	}

	@Override
 	public String toString(){
		return 
			"WorkAnniversaryItem{" + 
			"empId = '" + empId + '\'' + 
			",name = '" + name + '\'' + 
			",yrs = '" + yrs + '\'' + 
			"}";
		}
}
