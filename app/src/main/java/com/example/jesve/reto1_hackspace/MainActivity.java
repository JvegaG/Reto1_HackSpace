package com.example.jesve.reto1_hackspace;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button help, singUp, logIn;
    private EditText email, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Enlace Textos Eeditables
        email = (EditText)findViewById(R.id.edt_email);
        password = (EditText)findViewById(R.id.edt_password);

        // Enlace Botones
        help = (Button)findViewById(R.id.btn_help);
        singUp = (Button)findViewById(R.id.btn_singUp);
        logIn = (Button)findViewById(R.id.btn_loginIn);

        help.setOnClickListener(this);
        singUp.setOnClickListener(this);
        logIn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_help:
                Toast.makeText(getApplicationContext(),"Created By JvegaG",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_singUp:
                Intent intent = new Intent (MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;

            case R.id.btn_loginIn:
                String verEmail = email.getText().toString();
                String verPassword = password.getText().toString();

                if (verEmail.isEmpty()){
                    email.setError("Please enter your e-mail o Username");
                }
                else if (verPassword.isEmpty()){
                    password.setError("Please enter your Password");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Congratulations!!",Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
}
