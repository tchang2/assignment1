package ca.ualberta.tchang2_notes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

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

import com.google.gson.Gson;
import com.google.gson.JsonParseException;

public class AddCounter extends Activity {
	private static final String LIST_OF_COUNTERS = "list.sav";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_counter);
		setupActionBar();
	}

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
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	public void addCounter (View view){

		EditText editText = (EditText) findViewById(R.id.new_counter_name);
		String counter_name = editText.getText().toString();									//Name of counter
		String Filename = editText.getText() + ".sav";											//File name of counter

		try{
			//Just in case there is no list.sav then we make a new one
			//Even if it exists, it will write nothing to it
			FileOutputStream check = openFileOutput(LIST_OF_COUNTERS,Context.MODE_APPEND);		//Open a file output stream, this should create a new save file for counter
			check.write("".getBytes());															//Write nothing
			check.close();																		//Close our output stream

			System.out.println("Check has completed!");
			
			//Attempt to read from old list of counters
			FileInputStream fis = openFileInput(LIST_OF_COUNTERS);								//Open a file input stream, load in our old list
			BufferedReader br = new BufferedReader(new InputStreamReader(fis));
			Gson jsontoobject = new Gson();
			ListOfCounters templist = jsontoobject.fromJson(br, ListOfCounters.class);			//Extract our new list of counters

			System.out.println("Read from old list success!");
			
			//Attempt to save the counter
			//Create a new .sav file for the counter
			ListOfTime emptylist = new ListOfTime();											//Create a new list of time
			emptylist.setName(counter_name);													//Set the name of this list as the counter name
			Gson empty = new Gson();
			FileOutputStream foscreate = openFileOutput(Filename,Context.MODE_PRIVATE);			//Open a file output stream, this should create a new save file for counter
			foscreate.write(empty.toJson(emptylist).getBytes());								//Convert the empty array into JSON format and write to file
			foscreate.close();																	//Close our output stream

			System.out.println("New save file for " + Filename + " created!");

			//Add it to the list of counters
			//Now write in a new list
			FileOutputStream foslist = openFileOutput(LIST_OF_COUNTERS,Context.MODE_PRIVATE);	//Open a file output stream, overwriting existing list
			templist.addList(counter_name);														//Add the counter to the list
			System.out.println("HEY WE ADDED!");
			Gson objecttojson = new Gson();														//Convert our list into JSON
			foslist.write(objecttojson.toJson(templist).getBytes());							//Write it into a file
			foslist.close();																	//Close our output stream

			System.out.println("Finished updating " + LIST_OF_COUNTERS);

		}catch (FileNotFoundException e) {
			//Should not get here
		} catch (IOException e) {
			// Should not get here
		} catch (JsonParseException e){
			System.out.println("Could not find old "+LIST_OF_COUNTERS+" will go ahead and create new one");
		}
		//We are done adding, go back to previous activity
		finish();
	}

}
