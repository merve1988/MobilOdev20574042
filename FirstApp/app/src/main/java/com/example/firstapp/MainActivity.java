package com.example.firstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.EditText;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {

    Button button,button2;
    EditText editTextTextPersonName,editTextTextPassword;
    Integer counter;
    String user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        defineVariable();
        defineListeners();
    }

    private void cleanText(){
        editTextTextPersonName.setText("");
        editTextTextPassword.setText("");
    }

    private boolean checkPerson(){
        if(editTextTextPersonName.getText().toString().equals(user) && editTextTextPassword.getText().toString().equals(pass)){
            return true;
        }
        return false;
    }

    public void defineVariable(){
        counter=0;
        user="admin";
        pass="admin";
        editTextTextPersonName=(EditText) findViewById(R.id.editTextTextPersonName);
        editTextTextPassword=(EditText) findViewById(R.id.editTextTextPassword);
        button=(Button) findViewById(R.id.button);
        button2=(Button) findViewById(R.id.button2);

    }

    public void defineListeners(){
        button.setOnClickListener((v) -> {

            if(checkPerson()){
                Toast.makeText(MainActivity.this,"Username and Password are correct!", Toast.LENGTH_SHORT).show();
            }

            else{

                cleanText();
                counter+=1;
                Toast.makeText(MainActivity.this,"Username and/or Password is incorrect!", Toast.LENGTH_SHORT).show();

                if (counter>=3){

                    Toast.makeText(MainActivity.this,"Login button disabled!", Toast.LENGTH_SHORT).show();
                    button.setBackgroundColor(Color.RED);
                    button.setEnabled(false);

                }
            }
        });


        button2.setOnClickListener((v) -> {
            Toast.makeText(MainActivity.this, "Coming soon :)", Toast.LENGTH_SHORT).show();
        });

    }
}
