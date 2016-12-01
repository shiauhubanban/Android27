package com.org.iii.shine27;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void test1(View v){
        MyAsyncTask myTask = new MyAsyncTask();
        myTask.execute("Brad","Tony","Eric","Mary","Peter");
    }

    
    private class MyAsyncTask extends AsyncTask<String,Void,Void>{
        //背景就做了
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.v("brad", "onPreExecute");
        }

        //丟資料進去
        @Override
        protected Void doInBackground(String... names) {
            for (String name : names) {
                Log.v("brad", "doInBackground:" + name);
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aNull) {
            super.onPostExecute(aNull);
            Log.v("brad", "onPostExecute");
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
            Log.v("brad", "onProgressUpdate");
        }

        @Override
        protected void onCancelled(Void aNull) {
            super.onCancelled(aNull);
            Log.v("brad", "onCancelled");
        }

    }
}