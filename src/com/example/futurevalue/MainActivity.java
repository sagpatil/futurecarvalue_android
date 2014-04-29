package com.example.futurevalue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {

	public final static String NEW_VALUE = "com.example.myfirstapp.new_value";
	public final static String CUR_VALUE = "com.example.myfirstapp.cur_value";
	public final static String CURRENT_AGE= "com.example.myfirstapp.cur_age";
	public final static String FUTURE_AGE = "com.example.myfirstapp.future_age";
	static String new_value = "";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
		Intent intent = new Intent(this, DisplayMessageActivity.class);
		EditText editText = (EditText) findViewById(R.id.new_value);
		new_value = editText.getText().toString();

		
		editText = (EditText) findViewById(R.id.current_value);
		String cur_value = editText.getText().toString();
		
		editText = (EditText) findViewById(R.id.current_age);
		String cur_age = editText.getText().toString();
		
		
		editText = (EditText) findViewById(R.id.future_age);
		String fut_age = editText.getText().toString();

		
		intent.putExtra(NEW_VALUE, new_value);
		intent.putExtra(CUR_VALUE, cur_value);
		intent.putExtra(CURRENT_AGE, cur_age);
		intent.putExtra(FUTURE_AGE, fut_age);
		EditText view1 = (EditText) findViewById(R.id.new_value);
		startActivity(intent);
	}

}
