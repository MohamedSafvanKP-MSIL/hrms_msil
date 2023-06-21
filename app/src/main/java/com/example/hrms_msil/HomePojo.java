package com.example.hrms_msil;


import java.util.ArrayList;
import java.util.List;

//public class HomePojo {
//
//        private String status;
//        private String error;
//        private Data data;
//        public String getStatus() {
//            return status;
//        }
//        public void setStatus(String status) {
//            this.status = status;
//        }
//        public String getError() {
//            return error;
//        }
//        public void setError(String error) {
//            this.error = error;
//        }
//        public Data getData() {
//            return data;
//        }
//        public void setData(Data data) {
//            this.data = data;
//        }
//    public class Data {
//        private List<WorkAnniversary> workAnniversary = new ArrayList<WorkAnniversary>();
//        private List<Holidays> holidays = new ArrayList<Holidays>();
//        private List<Announcements> announcements = new ArrayList<Announcements>();
//        public List<WorkAnniversary> getWorkAnniversary() {
//            return workAnniversary;
//        }
//        public void setWorkAnniversary(List<WorkAnniversary> workAnniversary) {
//            this.workAnniversary = workAnniversary;
//        }
//        public List<Holidays> getHolidays() {
//            return holidays;
//        }
//        public void setHolidays(List<Holidays> holidays) {
//            this.holidays = holidays;
//        }
//        public List<Announcements> getAnnouncements() {
//            return announcements;
//        }
//        public void setAnnouncements(List<Announcements> announcements) {
//            this.announcements = announcements;
//        }
//    }
//    public class WorkAnniversary {
//        private String name;
//        private String empId;
//        private Integer yrs;
//        public String getName() {
//            return name;
//        }
//        public void setName(String name) {
//            this.name = name;
//        }
//        public String getEmpId() {
//            return empId;
//        }
//        public void setEmpId(String empId) {
//            this.empId = empId;
//        }
//        public Integer getYrs() {
//            return yrs;
//        }
//        public void setYrs(Integer yrs) {
//            this.yrs = yrs;
//        }
//    }
//    public class Holidays {
//        private String date;
//        private String occasion;
//        public String getDate() {
//            return date;
//        }
//        public void setDate(String date) {
//            this.date = date;
//        }
//        public String getOccasion() {
//            return occasion;
//        }
//        public void setOccasion(String occasion) {
//            this.occasion = occasion;
//        }
//    }
//    public class Announcements {
//        private String date;
//        private String title;
//        private String message;
//        private String priority;
//        public String getDate() {
//            return date;
//        }
//        public void setDate(String date) {
//            this.date = date;
//        }
//        public String getTitle() {
//            return title;
//        }
//        public void setTitle(String title) {
//            this.title = title;
//        }
//        public String getMessage() {
//            return message;
//        }
//        public void setMessage(String message) {
//            this.message = message;
//        }
//        public String getPriority() {
//            return priority;
//        }
//        public void setPriority(String priority) {
//            this.priority = priority;
//        }
//    }
//}
//public class HomePojo {
//    ArrayList<WorkAnniversary> workAnniversary;
//
//    public ArrayList<WorkAnniversary> getWorkAnniversary() {
//        return workAnniversary;
//    }
//
//    public void setWorkAnniversary(ArrayList<WorkAnniversary> workAnniversary) {
//        this.workAnniversary = workAnniversary;
//    }
//
//    ArrayList<Holidays> holidays;
//
//    public ArrayList<Holidays> getHolidays() {
//        return holidays;
//    }
//
//    public void setHolidays(ArrayList<Holidays> holidays) {
//        this.holidays = holidays;
//    }
//
//    ArrayList<Announcements> announcements;
//
//    public ArrayList<Announcements> getAnnouncements() {
//        return announcements;
//    }
//
//    public void setAnnouncements(ArrayList<Announcements> announcements) {
//        this.announcements = announcements;
//    }
//
//    public class WorkAnniversary{
//            String name;
//            String empId;
//            String yrs;
//
//            public String getName() {
//                return name;
//            }
//
//            public void setName(String name) {
//                this.name = name;
//            }
//
//            public String getEmpId() {
//                return empId;
//            }
//
//            public void setEmpId(String empId) {
//                this.empId = empId;
//            }
//
//            public String getYrs() {
//                return yrs;
//            }
//
//            public void setYrs(String yrs) {
//                this.yrs = yrs;
//            }
//        }
//
//        public class Announcements{
//            String date;
//            String title;
//            String message;
//            String priority;
//
//            public String getDate() {
//                return date;
//            }
//
//            public void setDate(String date) {
//                this.date = date;
//            }
//
//            public String getTitle() {
//                return title;
//            }
//
//            public void setTitle(String title) {
//                this.title = title;
//            }
//
//            public String getMessage() {
//                return message;
//            }
//
//            public void setMessage(String message) {
//                this.message = message;
//            }
//
//            public String getPriority() {
//                return priority;
//            }
//
//            public void setPriority(String priority) {
//                this.priority = priority;
//            }
//        }
//
//        public class Holidays{
//            String date2;
//            String occasion;
//
//            public String getDate() {
//                return date2;
//            }
//
//            public void setDate(String date) {
//                this.date2 = date;
//            }
//
//            public String getOccasion() {
//                return occasion;
//            }
//
//            public void setOccasion(String occasion) {
//                this.occasion = occasion;
//            }
//    }
//}
//
//
public class HomePojo {
    private ArrayList<WorkAnniversary> workAnniversary;
    private ArrayList<Holidays> holidays;
    private ArrayList<Announcements> announcements;

    public ArrayList<WorkAnniversary> getWorkAnniversary() {
        return workAnniversary;
    }

    public void setWorkAnniversary(ArrayList<WorkAnniversary> workAnniversary) {
        this.workAnniversary = workAnniversary;
    }

    public ArrayList<Holidays> getHolidays() {
        return holidays;
    }

    public void setHolidays(ArrayList<Holidays> holidays) {
        this.holidays = holidays;
    }

    public ArrayList<Announcements> getAnnouncements() {
        return announcements;
    }

    public void setAnnouncements(ArrayList<Announcements> announcements) {
        this.announcements = announcements;
    }

    public static class WorkAnniversary {
        private String name;
        private String empId;
        private int yrs;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
            this.empId = empId;
        }

        public int getYrs() {
            return yrs;
        }

        public void setYrs(int yrs) {
            this.yrs = yrs;
        }
    }

    public static class Announcements {
        private String date;
        private String title;
        private String message;
        private String priority;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getPriority() {
            return priority;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }
    }

    public static class Holidays {
        private String date;
        private String occasion;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getOccasion() {
            return occasion;
        }

        public void setOccasion(String occasion) {
            this.occasion = occasion;
        }
    }
}