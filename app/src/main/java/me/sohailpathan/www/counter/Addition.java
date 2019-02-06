package me.sohailpathan.www.counter;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Addition extends AppCompatActivity {

    EditText first, second,result;
    Button add;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addition);
        first=(EditText)findViewById(R.id.first);
        second=(EditText)findViewById(R.id.second);
        result=(EditText)findViewById(R.id.result);
        add=(Button)findViewById(R.id.add);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a1 = Integer.parseInt(first.getText().toString());
                int b1 = Integer.parseInt(second.getText().toString());
                result.setText(a1+b1);
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putString("2",result.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        String s= savedInstanceState.getString("2");
        result.setText(s);
    }
}
