package com.example.ganesh.rectransportmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Home2 extends AppCompatActivity {

    Button previous,car_number7,car_number8,car_number9,car_number10,
            car_number11,car_number12,car_number13,car_number14,car_number15,car_number16,car_number7_location,car_number8_location,
            car_number9_location,car_number10_location,car_number11_location,car_number12_location,car_number13_location,
            car_number14_location,car_number15_location,car_number16_location;
    ImageButton image,image2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        car_number7=(Button)findViewById(R.id.button16);
        car_number7_location = (Button) findViewById(R.id.button25);
        car_number8=(Button)findViewById(R.id.button17);
        car_number8_location = (Button) findViewById(R.id.button26);
        car_number9=(Button)findViewById(R.id.button18);
        car_number9_location = (Button) findViewById(R.id.button27);
        car_number10=(Button)findViewById(R.id.button19);
        car_number10_location = (Button) findViewById(R.id.button28);
        car_number11=(Button)findViewById(R.id.button20);
        car_number11_location = (Button) findViewById(R.id.button29);
        car_number12=(Button)findViewById(R.id.button21);
        car_number12_location = (Button) findViewById(R.id.button30);
        car_number13=(Button)findViewById(R.id.button22);
        car_number13_location = (Button) findViewById(R.id.button31);
        car_number14=(Button)findViewById(R.id.button23);
        car_number14_location = (Button) findViewById(R.id.button32);
        car_number15=(Button)findViewById(R.id.button24);
        car_number15_location = (Button) findViewById(R.id.button33);
        image= (ImageButton)findViewById(R.id.imageButton4);
        image2= (ImageButton)findViewById(R.id.imageButton5);
        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MenuPage.class);
                startActivity(i);
            }
        });
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Home.class);
                startActivity(i);
            }
        });
        car_number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Prasanth P. ");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Verito");
                i.putExtra("Value4", "Guest purpose & Parthiban (Pickup & drop)");
                i.putExtra("Value5", "");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Vinoth M.");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Maruti wagon R");
                i.putExtra("Value4", "Guest purpose");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Balaji A.");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Maruti ertica");
                i.putExtra("Value4", "Guest purpose");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Parthiban K.");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Maruti eco");
                i.putExtra("Value4", "Guest purpose & college purpose");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Vaasu V.");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Maximo");
                i.putExtra("Value4", "Transport department to RAPL for maintenance and breakdown attend");
                i.putExtra("Value5", "");
                // Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Hari K.");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Maruti swift dzire");
                i.putExtra("Value4", "Mrs.Anitha & Mrs.Lavanya");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Nandhakumar P.");
                i.putExtra("Value2", "RIT");
                i.putExtra("Value3", "Maruti swift dzire");
                i.putExtra("Value4", "Mr.Velan (RIT Principal)");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Manikandan C.");
                i.putExtra("Value2", "RSB");
                i.putExtra("Value3", "Swift");
                i.putExtra("Value4", "Mr.Subendhu(RIT)");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Prasanth I.");
                i.putExtra("Value2", "RMCH");
                i.putExtra("Value3", "Maruti eco");
                i.putExtra("Value4", "Mr.Yogesh,Mrs.Johana Mrs.Kalaiselvi");
                i.putExtra("Value5", "");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number7_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1", "8624");
                startActivity(i);
            }
        });
        car_number8_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1", "3790");
                startActivity(i);
            }
        });
        car_number9_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1", "6504");
                startActivity(i);
            }
        });
        car_number10_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1", "8568");
                startActivity(i);
            }
        });
        car_number11_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1", "4566");
                startActivity(i);
            }
        });
        car_number12_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1", "2728");
                startActivity(i);
            }
        });
        car_number13_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1", "0187");
                startActivity(i);
            }
        });
        car_number14_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1", "7321");
                startActivity(i);
            }
        });
        car_number15_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1", "7441");
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home2, menu);
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
