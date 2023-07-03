package com.example.hrms_msil.Home;

import java.util.List;

public class Data{
	private List<HolidaysItem> holidays;
	private List<WorkAnniversaryItem> workAnniversary;
	private List<AnnouncementsItem> announcements;

	public void setHolidays(List<HolidaysItem> holidays){
		this.holidays = holidays;
	}

	public List<HolidaysItem> getHolidays(){
		return holidays;
	}

	public void setWorkAnniversary(List<WorkAnniversaryItem> workAnniversary){
		this.workAnniversary = workAnniversary;
	}

	public List<WorkAnniversaryItem> getWorkAnniversary(){
		return workAnniversary;
	}

	public void setAnnouncements(List<AnnouncementsItem> announcements){
		this.announcements = announcements;
	}

	public List<AnnouncementsItem> getAnnouncements(){
		return announcements;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"holidays = '" + holidays + '\'' + 
			",workAnniversary = '" + workAnniversary + '\'' + 
			",announcements = '" + announcements + '\'' + 
			"}";
		}
}