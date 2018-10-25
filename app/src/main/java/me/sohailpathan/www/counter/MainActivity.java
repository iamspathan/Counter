package me.sohailpathan.www.counter;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1 , e2;
    Button b1  ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.username);
        e2 = (EditText)findViewById(R.id.password);
        b1 = (Button)findViewById(R.id.submit);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = e1.getText().toString();
                String b = e2.getText().toString();
                if(a.equalsIgnoreCase("") ||  b.equalsIgnoreCase("") )
                {
                    Toast.makeText(MainActivity.this , "Please Enter Credential" , Toast.LENGTH_SHORT ).show();
                }
               else if(a.equalsIgnoreCase(b))
                {

                    Toast.makeText(MainActivity.this , "Credential Match" , Toast.LENGTH_SHORT ).show();
                    Intent intent = new Intent(MainActivity.this , CalculateActivity.class);
                    intent.putExtra("username" , a);
                    intent.putExtra("password" , b);
                    startActivityForResult(intent,1);

                }

                else
                {
                    Toast.makeText(MainActivity.this , " Wrong Credential ! Please Try Again " , Toast.LENGTH_SHORT  ).show();
                }
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1)
        {
            String s = data.getStringExtra("k");
            Toast.makeText(this,s,Toast.LENGTH_SHORT).show();
        }
    }
}


