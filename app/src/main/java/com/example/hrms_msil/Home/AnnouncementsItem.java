package com.example.hrms_msil.Home;

public class AnnouncementsItem{
	private String date;
	private String title;
	private String message;
	private String priority;

	public void setDate(String date){
		this.date = date;
	}

	public String getDate(){
		return date;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setPriority(String priority){
		this.priority = priority;
	}

	public String getPriority(){
		return priority;
	}

	@Override
 	public String toString(){
		return 
			"AnnouncementsItem{" + 
			"date = '" + date + '\'' + 
			",title = '" + title + '\'' + 
			",message = '" + message + '\'' + 
			",priority = '" + priority + '\'' + 
			"}";
		}
}
