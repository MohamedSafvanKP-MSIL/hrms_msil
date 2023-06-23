package com.example.hrms_msil;

import java.util.ArrayList;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

public class InboxPojo {

    ArrayList<data> data;

    public ArrayList<data> getData() {
        return data;
    }

    public void setData(ArrayList<data> data) {
        this.data = data;
    }

    public class data {
        private String date;

        private String title;
        private String message;
        private String priority;
        private String url;

        public data(String date, String title, String message, String priority, String url) {
            this.date = date;
            this.title = title;
            this.message = message;
            this.priority = priority;
            this.url = url;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String  date) {
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

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }


    }
}
