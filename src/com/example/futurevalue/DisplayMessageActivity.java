package com.example.futurevalue;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;

public class DisplayMessageActivity extends Activity {

    @SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_message);
		// Show the Up button in the action bar.
		setupActionBar();
		
		// Get the message from the intent
	    Intent intent = getIntent();
	    
	    String new_value = intent.getStringExtra(MainActivity.NEW_VALUE);
	    
	    String cur_value = intent.getStringExtra(MainActivity.CUR_VALUE);
	  
	    String cur_age = intent.getStringExtra(MainActivity.CURRENT_AGE);
	    String future_age = intent.getStringExtra(MainActivity.FUTURE_AGE);
	   
	    int new_val = Integer.parseInt(new_value);
	    int curr_val = Integer.parseInt(cur_value);
	    int curr_age = Integer.parseInt(cur_age);
	    int fut_age = Integer.parseInt(future_age);
	    System.out.println("new value"+ new_val + "curr"+ curr_val+"currage"+curr_age+"Fut"+fut_age);
	    

	    double rate = Math.log((double)curr_val / new_val)/5;
	    System.out.println("R :" + rate);
	    
	    double e = 2.71828182846;
	    double future_value =  Math.pow(e, rate* (fut_age+curr_age));
	    System.out.println(Math.E + "   "+ future_value); 
	    future_value *= new_val ;
	   
	     future_value = Math.round(future_value * 100.0) / 100.0;
	    
	    TextView v = (TextView)findViewById(R.id.future);
	    v.setText(""+future_value);
	    
	    
//	    // Create the text view
//	    TextView textView = new TextView(this);
//	    textView.setTextSize(40);
//	    textView.setText(""+future_value);
//
//	    // Set the text view as the activity layout
//	    setContentView(textView);
//		
		
	}

	/**
	 * Set up the {@link android.app.ActionBar}.
	 */
	private void setupActionBar() {

		getActionBar().setDisplayHomeAsUpEnabled(true);

	}



	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
