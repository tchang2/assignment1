package ca.ualberta.tchang2_notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	//private static final String LIST_OF_COUNTERS = "list.sav";
	//private static final String FILE_EXT = ".sav";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
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
