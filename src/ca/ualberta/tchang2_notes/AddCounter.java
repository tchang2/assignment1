package ca.ualberta.tchang2_notes;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class AddCounter extends Activity {
	private static final String LIST_OF_COUNTERS = "list.sav";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_counter);
		setupActionBar();
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_counter, menu);
		return true;
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
	public void addCounter (View view){
		EditText editText = (EditText) findViewById(R.id.new_counter_name);
		String Counter_Name = editText.getText().toString() + "\n";
		String Filename = Counter_Name + ".sav";
		
		//Attempt to save the counter
		try{
			//Create a new .sav file for the counter
			FileOutputStream foscreate = openFileOutput(Filename,Context.MODE_APPEND);
			foscreate.write("".getBytes());
			foscreate.close();
			
			//Add it to the list of counters
			FileOutputStream foslist = openFileOutput(LIST_OF_COUNTERS,Context.MODE_APPEND);
			foslist.write(Counter_Name.getBytes());
			foslist.close();
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finish();
	}

}
