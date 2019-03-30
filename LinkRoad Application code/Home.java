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

public class Home extends AppCompatActivity {

    Button next, car_number1, car_number1_location, car_number2, car_number3, car_number4, car_number5, car_number7,car_number6,car_number2_location,
            car_number3_location,car_number4_location,car_number5_location,car_number6_location,car_number7_location,car_numbernew,car_numbernew_location,aboutus;
    ImageButton image,image2;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        tv= (TextView)findViewById(R.id.textView74);
        tv.setSelected(true);
        car_number1 = (Button) findViewById(R.id.button);
        car_number1_location = (Button) findViewById(R.id.button2);
        car_number2 = (Button) findViewById(R.id.button3);
        car_number2_location = (Button) findViewById(R.id.button4);
        car_number3 = (Button) findViewById(R.id.button5);
        car_number3_location = (Button) findViewById(R.id.button6);
        car_number4 = (Button) findViewById(R.id.button7);
        car_number4_location = (Button) findViewById(R.id.button8);
        car_number5 = (Button) findViewById(R.id.button9);
        car_number5_location = (Button) findViewById(R.id.button10);
        car_number6 = (Button) findViewById(R.id.button11);
        car_number6_location = (Button) findViewById(R.id.button12);
        car_number7 = (Button) findViewById(R.id.button35);
        car_number7_location = (Button) findViewById(R.id.button36);
        car_numbernew = (Button)findViewById(R.id.button37);
        car_numbernew_location = (Button)findViewById(R.id.button38);
        image= (ImageButton)findViewById(R.id.imageButton);
        image2= (ImageButton)findViewById(R.id.imageButton2);


        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Home2.class);
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
        car_number1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Venkatesan N.");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Verito");
                i.putExtra("Value4", "CRM sir");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Ajith P.");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Bolero");
                i.putExtra("Value4", "Balasubramanian");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Ashokan D.");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Maruti CIAZ");
                i.putExtra("Value4", "Murugesan S.,Subbaiha,Selavaraj");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        String values = "Murugesan S." +
                "Subbaiha" +
                "Selavaraj";
        System.out.println(values.length());
        car_number4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Karthi M.");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Maruti Eco");
                i.putExtra("Value4", "Nandhini(pickup & drop)");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Vinoth K.");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Maruti Omni");
                i.putExtra("Value4", "Emergency van for boys hostel");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Venkatesan S.");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Omni ambulance");
                i.putExtra("Value4", "Emergency van for girls hostel");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "Poonguzhali.S");
                i.putExtra("Value2", "REC");
                i.putExtra("Value3", "Honda Amaze");
                i.putExtra("Value4", "HOD Department of IT");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_numbernew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Details.class);
                i.putExtra("Value1", "NA");
                i.putExtra("Value2", "RAPL");
                i.putExtra("Value3", "Maximo plus");
                i.putExtra("Value4", "Vehicle in REC under service");// Set the request code to any code you like, you can identify the  // callback via this code
                startActivity(i);
            }
        });
        car_number1_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1","8629");
                startActivity(i);
            }
        });
        car_number2_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1","8665");
                startActivity(i);
            }
        });
        car_number3_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1","8556");
                startActivity(i);
            }
        });
        car_number4_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1","3756");
                startActivity(i);
            }
        });
        car_number5_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1","0821");
                startActivity(i);
            }
        });
        car_number6_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1","6183");
                startActivity(i);
            }
        });
        car_number7_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1","5303");
                startActivity(i);
            }
        });
        car_numbernew_location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),LocationTracker.class);
                i.putExtra("Value1", "0782");
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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
