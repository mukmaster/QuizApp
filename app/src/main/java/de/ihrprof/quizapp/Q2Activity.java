package de.ihrprof.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class Q2Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_q2);
	}

	public void btn_clicked(View v) {
		// mit findViewById bekommen wir Zugriff auf das Eingabefeld (EditText-Objekt)
		EditText answerField = (EditText) findViewById(R.id.q2answerView);
		String answerText = answerField.getText().toString();
		String rightAnswer = getString(R.string.q2_right_answer);
		boolean correct = answerText.trim().toLowerCase().equals(rightAnswer.trim().toLowerCase());
		Helper.feedback(correct, 1, this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.q2, menu);
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
