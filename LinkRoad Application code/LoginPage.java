package com.example.ganesh.rectransportmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    TextView tv;
    EditText username,pwd;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        tv= (TextView)findViewById(R.id.textView85);
        tv.setSelected(true);
        username = (EditText)findViewById(R.id.editText);
        pwd = (EditText)findViewById(R.id.editText2);
        login = (Button)findViewById(R.id.button14);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("admin") && pwd.getText().toString().equals("admin@rec")) {
                    Intent i = new Intent(getApplicationContext(), MenuPage.class);
                    startActivity(i);
                } else
                    Toast.makeText(getApplicationContext(),"Invalid Login credentials",Toast.LENGTH_LONG).show();
            }
        });

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
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login_page, menu);
        return true;
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
