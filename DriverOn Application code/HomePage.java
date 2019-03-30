package com.example.ganesh.driver;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View.*;
import android.view.*;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    EditText busno;
    ImageButton start;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        tv = (TextView)findViewById(R.id.textView2);
        tv.setSelected(true);
        busno = (EditText)findViewById(R.id.editText);
        start = (ImageButton)findViewById(R.id.imageButton);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bus_number = busno.getText().toString();
                if (bus_number.equals("8629") || bus_number.equals("8665") || bus_number.equals("8556") || bus_number.equals("0821") || bus_number.equals("3756") ||
                        bus_number.equals("6183") || bus_number.equals("8624") || bus_number.equals("3790") || bus_number.equals("6504") ||
                        bus_number.equals("8568") || bus_number.equals("4566") || bus_number.equals("2728") || bus_number.equals("0187") ||
                        bus_number.equals("7321") || bus_number.equals("7441") || bus_number.equals("0782") || bus_number.equals("5303")) {
                    Intent i = new Intent(getApplicationContext(), LocationTracker.class);
                    i.putExtra("Value1", bus_number);
                    startActivity(i);
                } else
                    Toast.makeText(getApplicationContext(), "Car number does not exist", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
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
            Toast.makeText(getApplicationContext(),"Press back one more time to exit",Toast.LENGTH_LONG).show();
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
