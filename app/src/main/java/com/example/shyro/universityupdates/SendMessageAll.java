package com.example.shyro.universityupdates;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendMessageAll extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Button btnSend, btnStaff;
    private DrawerLayout allDrawerLayout;
    private ActionBarDrawerToggle allToggle;
    private NavigationView mNavigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message_all);

        mNavigationView = (NavigationView) findViewById(R.id.nav_view_all);


        if (mNavigationView != null) {
            mNavigationView.setNavigationItemSelectedListener(this);
        }


        allDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout_send_message_all);
        allToggle = new ActionBarDrawerToggle(this, allDrawerLayout, R.string.open, R.string.close);

        allDrawerLayout.addDrawerListener(allToggle);
        allToggle.syncState();


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //setNavigationViewListener();


        btnSend = (Button) findViewById(R.id.btnSendAll);
        btnStaff = (Button) findViewById(R.id.btnSendStaff);
        final EditText textSendAll = (EditText) findViewById(R.id.text_to_sendAll);

        btnSend.setOnClickListener(new View.OnClickListener() {
                                       @Override
        public void onClick(View view) {




              int empty = textSendAll.getText().length();

                  if (empty > 0){
                      String message = textSendAll.getText().toString();
                      sendSMS( message);


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
        public boolean onOptionsItemSelected (MenuItem item){
            if (allToggle.onOptionsItemSelected(item)) {
                return true;
            }
            return super.onOptionsItemSelected(item);
        }

    /**
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            case R.id.nav_all: {
                startActivity(new Intent(this, SendMessageAll.class));
                break;
            }
            case R.id.nav_staff: {
                startActivity(new Intent(this, SendMessageStaff.class));
                break;
            }
            case R.id.nav_student: {
                startActivity(new Intent(this, SendMessageStudents.class));
                break;
            }
            case R.id.nav_logout: {
                startActivity(new Intent(this, MainActivity.class));
                break;
            }
            default:
                startActivity(new Intent(this, SendMessageAll.class));

        }
                //close navigation drawer
                allDrawerLayout.closeDrawer(GravityCompat.START);
                return true;

        }


    private void setNavigationViewListener() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_all);
        navigationView.setNavigationItemSelectedListener(this);
    }**/

    public void sendSMS(String msg) {
        String[] phoneNumbers = {"0713427968", "0701869953","0773177972","0716591181","0727716382", "0723816895","0726849197"};

        for (int i = 0; i < phoneNumbers.length; i++) {


            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(phoneNumbers[i], null, msg, null, null);
        }
    }

    


/**
 *         btnSend.setOnClickListener(new View.OnClickListener() {
@Override
public void onClick(View view) {
String msg= textSend.getText().toString();
sendMessage(msg);




}





});

 }

 public void sendMessage(String msg){
 String [] phoneNumbers = {"0713427968","0701869953"};

 for(int i=0;i<=phoneNumbers.length;i++){


 SmsManager sms = SmsManager.getDefault();
 sms.sendTextMessage(phoneNumbers[i], null, msg, null, null);


 **/
    }







