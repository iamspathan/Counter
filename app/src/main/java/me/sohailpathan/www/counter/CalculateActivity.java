package me.sohailpathan.www.counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CalculateActivity extends AppCompatActivity {

    EditText number ,username , password;
    Button b1 , b2 , b3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_calculate);
        b1 = (Button)findViewById(R.id.increment);
        b2 = (Button)findViewById(R.id.decrement);
        number = (EditText)findViewById(R.id.number);
        username = (EditText)findViewById(R.id.username);
        password = (EditText)findViewById(R.id.password);
        b3 = (Button)findViewById((R.id.next));


        Intent i = getIntent();
        String us = i.getStringExtra("username");
        String ps = i.getStringExtra("password");
        username.setText(us);
        password.setText(ps);

        Intent j =new Intent();
        j.putExtra("k" , us);
        setResult(RESULT_OK,j);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(number.getText().toString()) + 1;
                number.setText(String.valueOf(a));
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int b = Integer.parseInt(number.getText().toString()) - 1 ;
                number.setText(String.valueOf(b));

            }
        });
        b3 .setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(CalculateActivity.this , Component.class);
                startActivity(intent);
            }
        });

    }

    public void add(View v)
    {
        Toast.makeText(CalculateActivity.this,"PLEASE ENTER THE VALUE" , Toast.LENGTH_SHORT).show();
    }



}
