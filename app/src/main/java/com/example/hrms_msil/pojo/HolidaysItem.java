package com.example.hrms_msil.pojo;

public class HolidaysItem{
	private String date;
	private String occasion;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setOccasion(String occasion){
		this.occasion = occasion;
	}

	public String getOccasion(){
		return occasion;
	}

	@Override
 	public String toString(){
		return 
			"HolidaysItem{" + 
			"date = '" + date + '\'' + 
			",occasion = '" + occasion + '\'' + 
			"}";
		}
}
