package com.example.shyro.universityupdates;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSend;
    EditText username,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void Login(View view){

        username=(EditText) findViewById(R.id.empId);
        password=(EditText) findViewById(R.id.empPassword);

        if(username.getText().toString().equals("admin") && password.getText().toString().equals("admin"))
        {
            Toast.makeText(getApplicationContext(),"Redirecting..",Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,SendMessageAll.class));
        }
        else
        {
            Toast.makeText(getApplicationContext(),"Enter correct Username and Password!!",Toast.LENGTH_SHORT).show();
        }

    }
}
