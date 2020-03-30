package com.example.databases;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DBAdapter db = new DBAdapter(this);
//---add a contact---
        db.open();
        long id = db.insertContact("Hana Kirana", "hanakiran36@gmail.com");
        id = db.insertContact("Oscar Diggs", "oscar@oscardiggs.com");
        db.close();
        db.open();
        Cursor c = db.getAllContacts();
        if (c.moveToFirst())
        {
            do {
                DisplayContact(c);
            } while (c.moveToNext());
        }
        db.close();
    }
    public void DisplayContact(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Name: " + c.getString(1) + "\n" +
                        "Email: " + c.getString(2),
                Toast.LENGTH_LONG).show();
    }
}