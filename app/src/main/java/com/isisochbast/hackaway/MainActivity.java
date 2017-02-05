package com.isisochbast.hackaway;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import java.util.ArrayList;

import static android.provider.AlarmClock.EXTRA_MESSAGE;


public class MainActivity extends AppCompatActivity {

    private String[] names = {"Stockholm", "Göteborg", "Malmö"};
    ListView mListView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listView);

        mListView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, new ArrayList<String>()));

        MyTask myTask = new MyTask();
        myTask.execute();





        /*mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Open the browser here
            })*/

    }

    @Override
    protected void onStart(){
        super.onStart();
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
                Object listItem = mListView.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, City.class);
                String message = listItem.toString();
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });




    }



    class MyTask extends AsyncTask<Void, String, String> {

        ArrayAdapter<String> mAdapter;
        ProgressBar mProgressBar;
        int count;


        @Override
        protected void onPreExecute() {
            mAdapter = (ArrayAdapter<String>) mListView.getAdapter();

            count = 0;
        }

        @Override
        protected String doInBackground(Void... voids) {

            for(String Name : names){
                publishProgress(Name);

            }
            return "All the names were added";
        }

        @Override
        protected void onProgressUpdate(String... values) {
            mAdapter.add(values[0]);
            count++;
        }


    }
}
