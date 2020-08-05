package com.example.simplify;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class SignUp extends AppCompatActivity {
    TextView Status;
    EditText firstName, lastName, eMail, pass, passconf;
    private static final String DB_URL = "";
    private static final String USER = "";
    private static final String PASS = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);

        firstName = findViewById(R.id.FirstName);
        lastName = findViewById(R.id.LastName);
        eMail = findViewById(R.id.mail);
        pass = findViewById(R.id.passwd);
        passconf = findViewById(R.id.conf_passwd);
        Status = findViewById(R.id.Status);
        TextView returnToLogin = findViewById(R.id.return_login);
        returnToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OpenLogin();
            }
        });
        Button registerMe = findViewById(R.id.registerBtn);
        registerMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnConn();
            }
        });
    }

    public void btnConn(){
        String msg = "";
        String FirstName = firstName.getText().toString();
        String LastName = lastName.getText().toString();
        String email = eMail.getText().toString();
        String Pass = pass.getText().toString();
        //String passConf = passconf.getText().toString();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);

            if (conn == null) {
                msg = "Connection was wrong";
            } else {
                String query = " INSERT INTO UserData (EMAIL, Password, First Name, Second Name, Tasks)"
                        + " VALUES (?, ?, ?, ?, ?)";
                PreparedStatement preparedStmt = conn.prepareStatement(query);
                preparedStmt.setString(1, email);
                preparedStmt.setString(2, Pass);
                preparedStmt.setString(3, FirstName);
                preparedStmt.setString(4, LastName);
                preparedStmt.setString(5, "");
                preparedStmt.execute();
                msg = "Inserted Succesfully";
                conn.close();
            }
        } catch (Exception e) {
            msg = "Connection was wrong!";
            e.printStackTrace();
        }
        Status.setText(msg);
    }

    public void OpenLogin(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}