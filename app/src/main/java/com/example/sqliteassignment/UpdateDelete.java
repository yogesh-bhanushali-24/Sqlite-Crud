package com.example.sqliteassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateDelete extends AppCompatActivity {

    private EditText uNumber, uName, uAge;
    private Button update, delete, logout;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_delete);

        uNumber = findViewById(R.id.etNumber);
        uName = findViewById(R.id.etName);
        uAge = findViewById(R.id.etAge);
        update = findViewById(R.id.btnUpdate);
        delete = findViewById(R.id.btnDelete);
        logout = findViewById(R.id.btnLogout);
        DB = new DBHelper(this);


        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (uNumber.getText().toString().isEmpty() || uNumber.getText().toString().isEmpty() || uAge.getText().toString().isEmpty()) {
                    Toast.makeText(UpdateDelete.this, "All Field Required", Toast.LENGTH_SHORT).show();
                } else {
                    int d1 = Integer.parseInt(uNumber.getText().toString());
                    int d3 = Integer.parseInt(uAge.getText().toString());
                    String d2 = uName.getText().toString();

                    Boolean checkupdatedata = DB.updateuserdata(d1, d2, d3);
                    if (checkupdatedata == true) {
                        Toast.makeText(UpdateDelete.this, " Entry Updated", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateDelete.this, Viewpage.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(UpdateDelete.this, " Entry Not Updated", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });


        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (uNumber.getText().toString().isEmpty() || uNumber.getText().toString().isEmpty() || uAge.getText().toString().isEmpty()) {
                    Toast.makeText(UpdateDelete.this, "All Field Required", Toast.LENGTH_SHORT).show();
                } else {
                    int d1 = Integer.parseInt(uNumber.getText().toString());
                    Boolean checkdeletedata = DB.deletedata(d1);
                    if (checkdeletedata == true) {
                        Toast.makeText(UpdateDelete.this, " Data Deleted", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(UpdateDelete.this, Viewpage.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(UpdateDelete.this, " Entry Not Deleted", Toast.LENGTH_SHORT).show();
                    }

                }


            }
        });


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(UpdateDelete.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}