package com.example.hrms_msil.Fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hrms_msil.ContactAdapter;
import com.example.hrms_msil.DetailActivity;
import com.example.hrms_msil.R;
import com.example.hrms_msil.User;
import com.example.hrms_msil.UserDao;
import com.example.hrms_msil.UserDatabase;

import java.util.ArrayList;
import java.util.List;

public class ContactActivity extends AppCompatActivity implements ContactAdapter.OnItemClickListener {


    @Override
    public void onItemClick(User contact) {
        Intent intent=new Intent(ContactActivity.this, DetailActivity.class);
        intent.putExtra("email",contact.getEmail());
        intent.putExtra("contact No",contact.getContact());
        startActivity(intent);
    }


    private RecyclerView recyclerView;
    private EditText contactEditText;
    private String currentQuery;
    private ContactAdapter contactAdapter;
    private List<User> contactList;
    private UserDao contactDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        recyclerView = findViewById(R.id.recyclerview);
        contactEditText = findViewById(R.id.contact_editText);
        contactEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                currentQuery=s.toString().trim();
                loadContacts(currentQuery);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        contactList = new ArrayList<>();
        contactAdapter = new ContactAdapter(contactList, this);
        recyclerView.setAdapter(contactAdapter);

        UserDatabase contactDatabase = UserDatabase.getDB(this);
        contactDao = contactDatabase.userDao();


        loadContacts("");

    }


    private void loadContacts(String query) {
        new AsyncTask<String, Void, List<User>>() {
            @Override
            protected List<User> doInBackground(String... params) {
                String searchQuery = params[0];
                return contactDao.searchUser("%" + searchQuery + "%");
            }

            @Override
            protected void onPostExecute(List<User> contacts) {
                super.onPostExecute(contacts);
                contactList.clear();
                contactList.addAll(contacts);
                contactAdapter.notifyDataSetChanged();
            }
        }.execute(query);
    }
}