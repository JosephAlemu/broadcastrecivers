package com.notificationtutorial.broadcastreceivers.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Admin on 1/31/2018.
 */

public class MyRceiverOne extends BroadcastReceiver {
    private static final String TAG = "MyRceiverOne";
    EditText editTex;
    TextView textView;
    public MyRceiverOne(EditText editText) {
        this.editTex = editText;
    }

    @Override
    public void onReceive(Context context, Intent intent) {


        String receivedData = intent.getStringExtra("data");
        Log.d(TAG, "onReceive: " + receivedData);

        textView.setText(receivedData);
    }
}
