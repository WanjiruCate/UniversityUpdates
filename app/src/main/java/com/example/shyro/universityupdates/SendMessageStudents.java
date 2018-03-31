package com.example.shyro.universityupdates;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessageStudents extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout studentDrawerLayout;
    private ActionBarDrawerToggle studentToggle;

    private NavigationView lNavigationView;



    Button btnStudent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message_students);

        lNavigationView = (NavigationView) findViewById(R.id.nav_view_student);


        if (lNavigationView != null) {
            lNavigationView.setNavigationItemSelectedListener(this);
        }


        studentDrawerLayout =(DrawerLayout)findViewById(R.id.drawerLayout_send_message_students);
        studentToggle=new ActionBarDrawerToggle(this,studentDrawerLayout,R.string.open,R.string.close);

        studentDrawerLayout.addDrawerListener(studentToggle);
        studentToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        btnStudent = (Button) findViewById(R.id.btnSendStudent);
        final EditText textSendAll = (EditText) findViewById(R.id.text_to_sendStudent);

        btnStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {





                int empty = textSendAll.getText().length();

                if (empty > 0){
                    String message = textSendAll.getText().toString();
                    sendSMS(message);

                    Toast.makeText(getApplicationContext(), "Message sent", Toast.LENGTH_LONG).show();}

                else{
                    Toast.makeText(getApplicationContext(), "Please insert a message!!", Toast.LENGTH_SHORT).show();}


            }
        }
        );

    }

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_all) {//DO your stuff }
            startActivity(new Intent(this, SendMessageAll.class));
        } else if (id == R.id.nav_staff) {//DO your stuff }
            startActivity(new Intent(this, SendMessageStaff.class));
        } else if (id == R.id.nav_student) {//DO your stuff }
            startActivity(new Intent(this, SendMessageStudents.class));
        } else if (id == R.id.nav_logout) {
            startActivity(new Intent(this, MainActivity.class));

        }
        return true;
    }

        @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(studentToggle.onOptionsItemSelected(item) ){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void sendSMS(String msg) {
        String[] phoneNumbers = {"0713427968", "0701869953","0704946070","0716591181"};

        for (int i = 0; i < phoneNumbers.length; i++) {


            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumbers[i], null, msg, null, null);


        }
    }

}

