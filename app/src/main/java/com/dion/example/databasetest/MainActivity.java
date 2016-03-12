package com.dion.example.databasetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.dion.example.databasetest.database.Test2DAO;
import com.dion.example.databasetest.entity.testEntity;

public class MainActivity extends AppCompatActivity {

    private Test2DAO db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        db = new Test2DAO(this);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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



    public void findPw(View view) {
        EditText username = (EditText) findViewById(R.id.editText);
        String usernamevalue = String.valueOf(username.getText());

        EditText password = (EditText) findViewById(R.id.editText2);
        String passwordValue = String.valueOf(password.getText());

        testEntity test = null;
        String notification = null;
        test = db.login(usernamevalue, passwordValue);

        if (test != null) {
            boolean isPwValid = test.comparePw(passwordValue);

            if (isPwValid) {
                //notification = "ingelogd";
                Intent intent = new Intent(this, Dashboard.class);
                intent.putExtra("voornaam", test.getVoornaam());
                intent.putExtra("username", test.getUsrnam());
                startActivity(intent);
            } else {
                notification = "opnieuw";
            }
        } else {
            notification = "opnieuw";
        }
        Toast.makeText(this, notification, Toast.LENGTH_LONG).show();
      /*
        if (passwordValue == String.valueOf(test.getPw())){
            Intent intent = new Intent(this, Dashboard.class);
            startActivity(intent);
        }else{
            notification= " probeer opnieuw";
            Toast.makeText(this,notification,Toast.LENGTH_LONG).show();
        }

*/


        //   db.findpw(usernamevalue);


        //  outputText = String.format("pw = %s \nvoornaam = %s \ngeboortedatum = %s ", test.getPw(), test.getVoornaam(), test.getGeboortejaar());
        //   output.setText(outputText);

    }


}
