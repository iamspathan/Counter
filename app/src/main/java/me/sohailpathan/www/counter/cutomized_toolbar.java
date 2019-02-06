package me.sohailpathan.www.counter;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


public class cutomized_toolbar extends AppCompatActivity {


    Toolbar toolbar;
    ActionBar actionBar;
    Button progressButton;
    private ProgressBar progressBar,progressBar2;
    private int ProgressStatus = 0;
    private TextView textView;
    private Handler handler =new Handler();
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cutomized_toolbar);
        toolbar=findViewById(R.id.toolbar);
        progressButton = (Button)findViewById(R.id.progressDialogueButton);
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
        progressBar=(ProgressBar)findViewById(R.id.progress2);
        textView=(TextView)findViewById(R.id.text1);

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(ProgressStatus < 100)
                {
                    ProgressStatus+=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(ProgressStatus);
                            textView.setText(ProgressStatus + "/" + progressBar.getMax());
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        });
        t.start();
    }


    public  void push2(View v)
    {
        progressDialog = new ProgressDialog(v.getContext());
        progressDialog.setMax(100);
        progressDialog.setIcon(R.drawable.ic_launcher_background);
        progressDialog.setCancelable(true);
        progressDialog.setProgressStyle(progressDialog.STYLE_HORIZONTAL);
        setProgress(0);
        progressDialog.show();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(ProgressStatus < 100)
                {
                    ProgressStatus+=1;
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(ProgressStatus);
                            textView.setText(ProgressStatus + "/" + progressBar.getMax());
                        }
                    });
                    try {
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }

                }
            }
        });
        t.start();

    }



    public void push(View v)
    {
        LayoutInflater inflater = getLayoutInflater();
        View layout =inflater.inflate(R.layout.activity_custom_toast,null);
        //TextView textView = (TextView)layout.findViewById(R.id.text1);
        Toast toast = new Toast((getApplicationContext()));
        toast.setGravity(Gravity.CENTER_VERTICAL, 0 ,0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.my_menu,menu);
        MenuItem search = menu.findItem(R.id.search);
         SearchView searchView = (SearchView) search.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(cutomized_toolbar.this, query , Toast.LENGTH_SHORT).show();
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                Toast.makeText(cutomized_toolbar.this, newText , Toast.LENGTH_SHORT).show();
                return true;
            }
        });
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
