package ca.ualberta.tchang2_notes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	private static final String LIST_OF_COUNTERS = "list.sav";
	//private static final String FILE_EXT = ".sav";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//Read in the list
		try {
			FileInputStream fis = openFileInput(LIST_OF_COUNTERS);
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));
			String line = in.readLine();
			while (line != null) {
				System.out.println(line + "next");
				line = in.readLine();
			}
			System.out.println("FILE FOUND!");

		} catch (FileNotFoundException e) {
			System.out.println("FILE NOT FOUND");
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
