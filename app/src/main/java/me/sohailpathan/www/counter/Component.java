package me.sohailpathan.www.counter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;

public class Component extends AppCompatActivity implements View.OnClickListener {

    RadioButton rb1 ,rb2 , rb3;
    ListView lv1;
    Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_component);
        rb1=findViewById(R.id.rb1);
        rb2=findViewById(R.id.rb2);
        rb3=findViewById(R.id.rb3);
        b1=(Button)findViewById(R.id.spin);
        rb1.setOnClickListener(this);
        lv1=findViewById(R.id.lv1);
        //First Type List View
        String arr[] ={ "Apple", "Ball" , "Cat"};
        /*Third Type List View(Access static XML)
        String arr[] = getResources().getStringArray(R.array.arr);
         */
        ArrayAdapter<String> adapterobject = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arr );
        lv1.setAdapter(adapterobject);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Intent intent = new Intent(Component.this , DropDownSpinner.class);
                startActivity(intent);
            }
        });

    }
    @Override
    public  void onClick(View v)
    {
        switch(v.getId())
        {
            case R.id.rb1:
                Toast.makeText(this, "Male Selected" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb2:
                Toast.makeText(this, "Female Selected" , Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb3:
                Toast.makeText(this, "Other Selected" , Toast.LENGTH_SHORT).show();


        }

    }

}
