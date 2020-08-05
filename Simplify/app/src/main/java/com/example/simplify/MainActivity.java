package com.example.simplify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;

public class MainActivity extends AppCompatActivity {

    private Button login_btn;
    private static final String DB_URL = "";
    private static final String USER = "";
    private static final String PASS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView signup_btn = findViewById(R.id.signup_tv);

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignup();
            }
        });
    }

    /*private class Send extends AsyncTask<String, String, String> {

        String msg = "";

        protected String doInBackground(String... strings) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

                if (conn == null) {

                } else {
                    String que
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }*/

    public void openSignup(){
        Intent intent = new Intent(this, SignUp.class);
        startActivity(intent);
    }
}
