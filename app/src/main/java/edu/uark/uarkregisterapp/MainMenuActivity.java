package edu.uark.mainmenuscreen;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.DialogInterface;
import android.view.View.OnClickListener;
import android.support.design.widget.Snackbar;
import android.widget.EditText;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button start_transaction = (Button) findViewById(R.id.start_transaction);
        start_transaction.setOnClickListener(this);  //calls onClick method

        Button create_employee = (Button) findViewById(R.id.create_employee);
        create_employee.setOnClickListener(this);

        Button sales_report_product = (Button) findViewById(R.id.sales_report_product);
        sales_report_product.setOnClickListener(this);

        Button sales_report_cashier = (Button) findViewById(R.id.sales_report_cashier);
        sales_report_cashier.setOnClickListener(this);

    }

    private void OnClick(View v) {
        /* do button stuff */

        switch (v.getId()) {

            case R.id.start_transaction:
                //Start Transaction goes here
                alertOneButton();
                break;

            case R.id.create_employee:
                //Create Employee goes here
                break;

            case R.id.sales_report_product:
                //Sales Report: Product goes here
                break;

            case R.id.sales_report_cashier:
                //Sales Report:Cashier goes here
                break;
        }

    }

    public void alertOneButton() {
        new AlertDialog.Builder(MainMenuActivity.this)
                .setTitle("Woah!")
                .setMessage("Functionallity not implemented yet")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                }).show();
    }


    @Override
    public void onClick(View view) {

    }
}
