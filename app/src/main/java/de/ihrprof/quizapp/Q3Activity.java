package de.ihrprof.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;

public class Q3Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_q3);
	}

	
    public void btn_clicked(View v){
    	// Die erste und die letzte Checkbox m�ssen "gechecked" sein, alle anderen nicht
    	boolean correctAnswer = 
    			 ((CheckBox) findViewById(R.id.q3check1)).isChecked() &&
    			!((CheckBox) findViewById(R.id.q3check2)).isChecked() &&
    			!((CheckBox) findViewById(R.id.q3check3)).isChecked() &&
    			!((CheckBox) findViewById(R.id.q3check4)).isChecked() &&
    			 ((CheckBox) findViewById(R.id.q3check5)).isChecked();
    	Helper.feedback(correctAnswer,1,this);
    }	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.q3, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
