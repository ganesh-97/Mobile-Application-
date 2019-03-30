package com.example.ganesh.rectransportmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Details extends AppCompatActivity {

    Button back;
    TextView car_user1,car_users, drivers_name, institution,type;
    ImageButton image,image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Bundle extras = getIntent().getExtras();
        String drivers_name_1 = extras.getString("Value1");
        String institution_1 = extras.getString("Value2");
        String type_1 = extras.getString("Value3");
        String car_users_1 = extras.getString("Value4");
        String extra = extras.getString("Value5");
        drivers_name= (TextView)findViewById(R.id.textView47);
        institution = (TextView)findViewById(R.id.textView48);
        type = (TextView)findViewById(R.id.textView49);
        car_users = (TextView)findViewById(R.id.textView52);
        car_user1 = (TextView)findViewById(R.id.textView64);
        image = (ImageButton)findViewById(R.id.imageButton6);
        image2 = (ImageButton)findViewById(R.id.imageButton7);
        drivers_name.setText(drivers_name_1);
        institution.setText(institution_1);
        type.setText(type_1);
        car_users.setText(car_users_1);
        car_user1.setText(extra);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuPage.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }
    int backButtonCount;
    @Override
    public void onBackPressed(){

        if(backButtonCount >=1){
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
        }
        else{
            Toast.makeText(getApplicationContext(), "Press back one more time to exit", Toast.LENGTH_LONG).show();
            backButtonCount++;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
