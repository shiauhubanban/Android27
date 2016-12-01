package com.org.iii.shine27;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView mesg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mesg = (TextView)findViewById(R.id.mesg);
    }

    public void test1(View v){
        MyAsyncTask myTask = new MyAsyncTask();
        myTask.execute("Brad","Tony","Eric","Mary","Peter");
    }


    private class MyAsyncTask extends AsyncTask<String,Integer,Void>{
        //背景就做了
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Log.v("brad", "onPreExecute");
        }
        //丟資料進去
        @Override
        protected Void doInBackground(String... names) {
            int i = 0;
            for (String name : names) {
                Log.v("brad", "doInBackground:" + name);
                publishProgress(i, i+10, i+100);
                try {
                    Thread.sleep(500);
                }catch (Exception e){}
                i++;
            }
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            mesg.setText("onProgressUpdate:" + values[0] + ":" +
                    values[1] + ":" + values[2]);
        }

        @Override
        protected void onPostExecute(Void aNull) {
            super.onPostExecute(aNull);
            Log.v("brad", "onPostExecute");
        }


        @Override
        protected void onCancelled(Void aNull) {
            super.onCancelled(aNull);
            Log.v("brad", "onCancelled");
        }

    }
}