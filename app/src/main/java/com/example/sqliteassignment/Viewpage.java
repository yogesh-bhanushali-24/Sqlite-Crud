package com.example.sqliteassignment;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Viewpage extends AppCompatActivity {

    //    private TextView number,name,age;
    TextView textView;
    private Button MainButton;
    DBHelper DB;

//    List<Integer> NumberDB = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpage);

//        number=findViewById(R.id.vNumber);
//        name=findViewById(R.id.vName);
//        age=findViewById(R.id.vAge);
        textView = findViewById(R.id.textView);
        MainButton = findViewById(R.id.btnMain);
        DB = new DBHelper(this);
        //data view
        Cursor res = DB.getdata();

        if (res.getCount() == 0) {
            Toast.makeText(this, "No data Available", Toast.LENGTH_SHORT).show();
            return;
        }

        StringBuffer buffer = new StringBuffer();
        while (res.moveToNext()) {
            buffer.append("Number:" + res.getString(0) + "\n");
            buffer.append("Name:" + res.getString(1) + "\n");
            buffer.append("Age:" + res.getString(2) + "\n");
//            NumberDB.add(Integer.valueOf(res.getString(0)));
        }

//        Toast.makeText(this, NumberDB.toString(), Toast.LENGTH_LONG).show();

//        AlertDialog.Builder builder=new AlertDialog.Builder(Viewpage.this);
//        builder.setCancelable(true);
//        builder.setTitle("User Data");
//        builder.setMessage(buffer.toString());
//        builder.show();
        textView.setText(buffer);
//       StringBuffer v=buffer.append("Number:"+res.getString(0)+"\n");
//        textView.setText(buffer.append("Number"+res.getString(0)+"\n"));
//        textView.setText(res.getString(0));

        MainButton.setOnClickListener(new android.view.View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Intent intent = new Intent(Viewpage.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}