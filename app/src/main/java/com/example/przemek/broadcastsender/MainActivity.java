package com.example.przemek.broadcastsender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText et_message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_message = (EditText) findViewById(R.id.et_message);
    }

    public void sendOutBroadcast(View view) {
        Intent intent = new Intent();
        intent.setAction("com.example.przemek.broadcastsender.MY_INTENT");
        intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
        String message = et_message.getText().toString();
        intent.putExtra("message", message);
        sendBroadcast(intent, "com.example.przemek.broadcastsender.PERMISSION");
    }
}
