package com.example.jesve.reto1_hackspace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private Button help, logIn;
    private TextView terms;
    private EditText fullName, email, password;
    private CheckBox box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //Enlace con CheckBox
        box = (CheckBox)findViewById(R.id.Checkbox_agree);

        //Enlace EditText
        fullName = (EditText)findViewById(R.id.edt_name);
        email = (EditText)findViewById(R.id.edt_email2);
        password = (EditText)findViewById(R.id.edt_password2);

        //Enlace Botones
        help = (Button)findViewById(R.id.btn_help2);
        logIn = (Button)findViewById(R.id.btn_loginIn2);

        help.setOnClickListener(this);
        logIn.setOnClickListener(this);

        //Mandando mensaje al presionar el texto "Terms of services"
        TextView terms = (TextView)findViewById(R.id.txt_terms);
        terms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Terminos de Servicios",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_help2:
                Toast.makeText(getApplicationContext(), "Created By JvegaG",Toast.LENGTH_SHORT).show();
                break;

            case R.id.btn_loginIn2:
                String verName = fullName.getText().toString();
                String verEmail = email.getText().toString();
                String verPassword = password.getText().toString();

                if(verName.isEmpty() == false && verEmail.isEmpty() == false && verPassword.isEmpty() == false && box.isChecked() == true){
                    Toast.makeText(getApplicationContext(),"Congratulations!!",Toast.LENGTH_SHORT).show();
                }
                else{
                    if (verName.isEmpty()){
                        fullName.setError("Please enter your full Name");
                    }
                    if (verEmail.isEmpty()){
                        email.setError("Please enter an e-mail");
                    }
                    if (verPassword.isEmpty()){
                        password.setError("Please enter a Password");
                    }
                    if(box.isChecked() == false){
                        Toast.makeText(getApplicationContext(),"You need to agree with all statements",Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}
