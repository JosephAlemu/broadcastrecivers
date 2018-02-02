package com.notificationtutorial.broadcastreceivers;

import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.notificationtutorial.broadcastreceivers.receiver.MyRceiverOne;

public class MainActivity extends AppCompatActivity {
    MyRceiverOne myRceiverOne;

    Button btnsend;
    TextView textView;
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       

        Intent brIntent = new Intent("sendToOtherApp");
        brIntent.putExtra("data", etSendData.getText().toString());
        LocalBroadcastManager.getInstance(this).sendBroadcast(brIntent);
    }


    @Override
    protected void onStart() {
        super.onStart();

          myRceiverOne = new MyRceiverOne();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        registerReceiver(myRceiverOne,intentFilter);
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(myRceiverOne);
    }
}
