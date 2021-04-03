package com.example.sqliteassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    private EditText Number, Name, Age;
    private Button reg;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Number = findViewById(R.id.rNumber);
        Name = findViewById(R.id.rName);
        Age = findViewById(R.id.rAge);
        reg = findViewById(R.id.btRegister);
        DB = new DBHelper(this);


        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (Number.getText().toString().isEmpty() || Name.getText().toString().isEmpty() || Age.getText().toString().isEmpty()) {
                    Toast.makeText(Register.this, "All Field Required", Toast.LENGTH_SHORT).show();

                } else {
                    int d1 = Integer.parseInt(Number.getText().toString());
                    int d3 = Integer.parseInt(Age.getText().toString());
                    String d2 = Name.getText().toString();
                    Boolean checkinsertdata = DB.insertuserdata(d1, d2, d3);
                    if (checkinsertdata == true) {
                        Toast.makeText(Register.this, "New Entry Inserted", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(Register.this, Viewpage.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Register.this, "New Entry Not Inserted", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
}