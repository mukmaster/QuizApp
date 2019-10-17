package de.ihrprof.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.NumberPicker;

public class Q5Activity extends Activity {

private NumberPicker nb;	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);		
		setContentView(R.layout.activity_q5);
		nb = (NumberPicker) findViewById(R.id.q5numberpicker);
		nb.setMinValue(1);
		nb.setMaxValue(50);
		nb.setValue(1);
	}
	
	public void btn_clicked(View v){
		nb = (NumberPicker) findViewById(R.id.q5numberpicker);
		Helper.feedback(nb.getValue()==21, 1, this);
    }	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.q5, menu);
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
