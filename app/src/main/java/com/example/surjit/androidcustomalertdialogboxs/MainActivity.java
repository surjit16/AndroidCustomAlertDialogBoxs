package com.example.surjit.androidcustomalertdialogboxs;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    AlertDialog.Builder builder;
    AlertDialog alertDialog;
    EditText name;
    EditText email;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void customAlertDialogBox01(View view) {

        builder = new AlertDialog.Builder(this);
        View myAlertDailogView = getLayoutInflater().inflate(R.layout.custom_alert_dialog_box_01, null);

        builder.setView(myAlertDailogView);
        builder.setTitle("Custom View");
        builder.setCancelable(false);

        alertDialog = builder.create();
        alertDialog.show();

        name = myAlertDailogView.findViewById(R.id.name);
        email = myAlertDailogView.findViewById(R.id.email);
        Button submit = myAlertDailogView.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = name.getText().toString();
                String e = email.getText().toString();

                if (n.isEmpty() || e.isEmpty()) {
                    if (n.isEmpty()) name.setError("enter name");
                    if (e.isEmpty()) email.setError("enter email");
                } else {
                    // To dismiss the alert dialog box
                    alertDialog.dismiss();
                    // To show the tost that display the data you entered
                    toast = Toast.makeText(MainActivity.this, "Name is " + n + "\nEmail is " + e, Toast.LENGTH_LONG);
                    toast.show();
                }

            }
        });

    }
}
