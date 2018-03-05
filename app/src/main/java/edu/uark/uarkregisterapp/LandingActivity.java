package edu.uark.uarkregisterapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;

import edu.uark.uarkregisterapp.models.transition.ProductTransition;


public class LandingActivity extends AppCompatActivity {

	private static EditText username;
	private static EditText password;
	private static Button login_button;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_landing);
	}

	/*public void displayAllProductsButtonOnClick(View view) {
		this.startActivity(new Intent(getApplicationContext(), ProductsListingActivity.class));
	}*/

	public void createLoginButtonOnClick(View view) {
		username = (EditText)findViewById(R.id.Employee_ID);
		password = (EditText)findViewById(R.id.Password);
		login_button = (Button)findViewById(R.id.button_create_Employee);

		login_button.setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View v) {
						if(username.getText().toString().equals("user") &
									password.getText().toString().equals("pass")){
								Toast.makeText(LandingActivity.this,"Employee Exists", Toast.LENGTH_SHORT).show();
						}
						else{
							Toast.makeText(LandingActivity.this,"No Employee Exists \n Please create your firsst Employee", Toast.LENGTH_SHORT).show();
						}
					}
				}
        );

		Intent intent = new Intent(getApplicationContext(), ProductViewActivity.class);

		intent.putExtra(
			getString(R.string.intent_extra_product),
			new ProductTransition()
		);

		this.startActivity(intent);
	}
}
//hellow world