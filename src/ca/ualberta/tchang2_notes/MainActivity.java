package ca.ualberta.tchang2_notes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;

import com.google.gson.Gson;

public class MainActivity extends Activity {
	private static final String LIST_OF_COUNTERS = "list.sav";
	//private static final String FILE_EXT = ".sav";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//Read in the list for DEBUG
		try {
			FileInputStream fis = openFileInput(LIST_OF_COUNTERS);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			System.out.println("FILE FOUND!");
			String line = in.readLine();
			while (line != null) {
				System.out.println(line + "next");
				line = in.readLine();
			}

		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND CREATING ONE");									//If we got here that means there is no list.sav, here we will make one
			ListOfCounters emptylist = new ListOfCounters();									//Initialize a file for the list of counters
			Gson gson = new Gson();
			try{
				FileOutputStream fos = openFileOutput(LIST_OF_COUNTERS,Context.MODE_PRIVATE);	//Create a list.sav file
				fos.write(gson.toJson(emptylist).getBytes());									//Convert the empty array into JSON format and write to file
				fos.close();
			}catch (IOException ioe){}
		} catch (IOException e) {}
		//String[] names = new String[] { "Alice","Bob","Eve" };
		//ArrayAdapter <String> adapter = new ArrayAdapter < String > (this,android.R.layout,list_item, names);
        
		
	}

	/*@Override
	protected void onStart(){
		//Refresh the list?
	}

	@Override
	protected void onResume(){
		//Do nothing for now
	}

	@Override
	protected void onPause(){
		//Save to json?
	}*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void addCounter (View view){
		Intent intent = new Intent(this, AddCounter.class);
		startActivity(intent);
	}

}
