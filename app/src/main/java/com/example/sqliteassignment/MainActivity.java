package com.example.sqliteassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText no, name, age;
    Button Register, login;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        no = findViewById(R.id.editNumber);
        name = findViewById(R.id.editTextName);
        age = findViewById(R.id.editAge);
        login = findViewById(R.id.btnLogin);
        Register = findViewById(R.id.btnRegister);

        DB = new DBHelper(getApplicationContext());
        SQLiteDatabase db = DB.getReadableDatabase();


        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (no.getText().toString().isEmpty() || name.getText().toString().isEmpty() || age.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Empty field not required ", Toast.LENGTH_SHORT).show();
                } else {
                    int numberCheck = Integer.parseInt(no.getText().toString());
                    String stname = name.getText().toString();
                    DB = new DBHelper(getApplicationContext());
                    Cursor c = DB.display(numberCheck);
                    if (c.getCount() == 0) {
                        Toast.makeText(MainActivity.this, "No record available", Toast.LENGTH_SHORT).show();
                    } else {
                        StringBuffer buffer = new StringBuffer();
                        c.moveToNext();
                        buffer.append("Number:" + c.getString(0) + "\n");
                        buffer.append("Name:" + c.getString(1) + "\n");
                        buffer.append("Age:" + c.getString(2) + "\n");
                        if (c.getInt(0) == numberCheck) {

                            Intent intent = new Intent(MainActivity.this, UpdateDelete.class);
                            startActivity(intent);

                        } else {
                            Toast.makeText(MainActivity.this, "Invalid inputs", Toast.LENGTH_SHORT).show();
                        }
                    }


                    Intent intent = new Intent(MainActivity.this, UpdateDelete.class);
                    startActivity(intent);
                }


            }
        });


        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Register.class);
                startActivity(intent);
            }
        });
    }
}