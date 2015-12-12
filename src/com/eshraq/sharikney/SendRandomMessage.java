package com.eshraq.sharikney;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by hazem on 12/10/15.
 */
public class SendRandomMessage extends Activity {
    AsyncTask<Void, Void, Void> mRegisterTask;
    Button sendMsg;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.send_random_msg);
        sendMsg = (Button) findViewById(R.id.sendMsg);
        sendMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMsg();
            }
        });
    }

    public void sendMsg() {
        mRegisterTask = new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                // Register on our server
                // On server creates a new user
                ServerUtilities.sendRandom(getApplicationContext(), "APA91bGzkK7GEr1edKF8KBvZcmGIts6pxyHUf-fCL9h-jt5_5rV9IYr8FcpgQGZHJeYVOk5SRia_IKxbVr9UUmShemIhX7l67-oR_Rg1SwBzAKWgQtw-yDQmW-jQtd0YyDEqDX5H91o6RnGFvhI0kYSaShnrkDLJag", "test");
                return null;
            }

            @Override
            protected void onPostExecute(Void result) {
                mRegisterTask = null;
            }
        };
        mRegisterTask.execute(null, null, null);
    }
}
