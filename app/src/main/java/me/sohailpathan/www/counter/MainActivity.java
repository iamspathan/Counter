package me.sohailpathan.www.counter;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText e1 ,  e2;
    Button b1  ,   b2;
    Spinner spinner;
    ListView listView;
    String name[] = { "Apple" , "Ball" , "Cat"};
    int image[] = {R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background, };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1 = (EditText)findViewById(R.id.username);
        e2 = (EditText)findViewById(R.id.password);
        b1 = (Button)findViewById(R.id.submit);
        b2 = (Button)findViewById(R.id.dialogue);
        spinner = (Spinner)findViewById(R.id.spn);
        listView =(ListView)findViewById(R.id.customlist);

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


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder  builder= new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("Outer AlertBox").setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                                builder1.setMessage("Inner Alert Box").setPositiveButton("yes", new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                         AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this);
                                        ArrayList arrayList = new ArrayList();
                                        arrayList.add("14");
                                        arrayList.add("15");
                                        arrayList.add("4");
                                        arrayList.add("3");
                                        arrayList.add("2");
                                        View v = getLayoutInflater().inflate(R.layout.activity_drop_down_spinner,null);
                                        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(MainActivity.this , android.R.layout.simple_spinner_dropdown_item,arrayList);
                                        builder2.setView(v);
                                        spinner.setAdapter(arrayAdapter);
                                        builder.show();
                                    }
                                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                       Toast.makeText(MainActivity.this, "NO" , Toast.LENGTH_SHORT).show();
                                    }
                                }).setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        Toast.makeText(MainActivity.this, "Cancel" , Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });


            }
        });

        CustomAdapter customAdapter = new CustomAdapter(this,image,name);
        listView.setAdapter(customAdapter);

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