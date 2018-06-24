package com.example.afihisam.connecttomysqljsp;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListAdapter adapter;
    ProgressDialog progressDialog;
    ConnectionClass connectionClass;
    ArrayList<Data> dataList = new ArrayList<Data>();
    Statement stmt;
    ResultSet rs;
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        connectionClass = new ConnectionClass();
        progressDialog = new ProgressDialog(this);

        ViewStudents viewstudents = new ViewStudents();
        viewstudents.execute("");

        adapter = new CustomAdapter(MainActivity.this, dataList);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(adapter);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public class ViewStudents extends AsyncTask<String, String, String> {

        String z = "";
        boolean isSuccess = false;

        @Override
        protected void onPreExecute() {
            progressDialog.setMessage("Loading...");
            progressDialog.show();
        }


        @Override
        protected String doInBackground(String... params) {

            try {
                Connection con = connectionClass.CONN();
                if (con == null) {
                    z = "Please check your internet connection";
                } else {

                 String query = "select * from student";

                    stmt = con.createStatement();
                    rs = stmt.executeQuery(query);

                    z = "query successfully";


                    while (rs.next()) {
                        isSuccess = true;
                        dataList.add(new Data(rs.getString("name"), rs.getString("age"), rs.getString("picture")));

                    }
                   // progressDialog.hide();


                }
            } catch (Exception ex) {
                isSuccess = false;
                z = "Exceptions" + ex;
            }
            return z;
        }

        @Override
        protected void onPostExecute(String s) {

            if (isSuccess) {

                 ((BaseAdapter)adapter).notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "Ok!",
                        Toast.LENGTH_LONG).show();

            }
            else{
                Toast.makeText(MainActivity.this, "Fail, "+z,
                        Toast.LENGTH_LONG).show();
            }
            progressDialog.hide();

        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
