package com.example.hrms_msil.Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.example.hrms_msil.ContactAdapter;
import com.example.hrms_msil.R;
import com.example.hrms_msil.User;
import com.example.hrms_msil.UserDao;
import com.example.hrms_msil.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private EditText contactEditText;
    private ContactAdapter contactAdapter;
    private List<User> contactList;
    private UserDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        recyclerView = findViewById(R.id.recyclerview);
       contactEditText=findViewById(R.id.contact_editText);


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        contactList = new ArrayList<>();
        contactAdapter = new ContactAdapter(contactList);
        recyclerView.setAdapter(contactAdapter);

        UserDatabase contactDatabase = UserDatabase.getDB(this);
        contactDao=contactDatabase.userDao();

        loadContacts();

    }

    private void loadContacts() {
        new AsyncTask<Void, Void, List<User>>() {
            @Override
            protected List<User> doInBackground(Void... voids) {
                return contactDao.getAllUser();
            }

            @Override
            protected void onPostExecute(List<User> contacts) {
                super.onPostExecute(contacts);
                contactList.clear();
                contactList.addAll(contacts);
                contactAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}