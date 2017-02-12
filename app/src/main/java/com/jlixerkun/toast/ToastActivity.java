package com.jlixerkun.toast;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

public class ToastActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        //First, instantiate a Toast object with one of the makeText() methods.
        //https://developer.android.com/guide/topics/ui/notifiers/toasts.html

        Context context = getApplicationContext();
        CharSequence toast_text = "Hello toast!";
        int duration = Toast.LENGTH_LONG;

        Toast toast = Toast.makeText(context, toast_text, duration);
        toast.setGravity(Gravity.CENTER,0,0); // Center toast message on screen
        toast.show();
        // Method chaining to avoid holding on to the toast object
        // Equivalent to the 2 lines above
        // Toast.makeText(context, toast_text, duration).show();


    }

    public void showToast(View v){
        LayoutInflater inflater = getLayoutInflater();
        View layout = inflater.inflate(R.layout.custom_toast_layout,
                (ViewGroup) findViewById(R.id.custom_toast_container));

        TextView text = (TextView) layout.findViewById(R.id.toast_text);
        text.setText(R.string.custom_toast_message);

        Toast toast = new Toast(getApplicationContext());
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}
