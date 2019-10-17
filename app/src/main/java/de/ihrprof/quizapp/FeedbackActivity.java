package de.ihrprof.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class FeedbackActivity extends Activity {

	private int points;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_feedback);
		
		// Wir ben�tigen Zugriff auf den Intent, der diese Activity gestartet hat,
		// denn dieser enth�lt noch weitere Informationen, die wir gleich auslesen werden
		Intent intent =getIntent();
		String feedback = intent.getStringExtra("fb");
		String pointstr = intent.getStringExtra("pstr");
		points = intent.getIntExtra("pts",0);
		
		// Die erhaltenen Werte tragen wir in die entsprechenden Views ein
		TextView feedbackView = (TextView) findViewById(R.id.textViewFeedback);
		feedbackView.setText(feedback);
		
		TextView pointsView = (TextView) findViewById(R.id.textViewPoints);
		pointsView.setText(pointstr);
		
	}

    public void back_button_clicked(View v){
    	Intent intent = new Intent(this, StartActivity.class);
    	    	
    	intent.putExtra("pts", points);
    	startActivity(intent);	
    	
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.feedback, menu);
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
