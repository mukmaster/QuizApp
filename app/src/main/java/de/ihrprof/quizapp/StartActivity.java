package de.ihrprof.quizapp;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class StartActivity extends Activity {

	// Voreinstellung: Alle sechs Fragen sind am Anfang aktiv
	private static boolean[] questionActive = {true, true, true, true, true, true, true};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_activity);

		// Alle Buttons deaktivieren, deren Fragen bereits deaktiviert sind
		if (!questionActive[0]) findViewById(R.id.button1).setEnabled(false);
		if (!questionActive[1]) findViewById(R.id.button2).setEnabled(false);
		if (!questionActive[2]) findViewById(R.id.button3).setEnabled(false);
		if (!questionActive[3]) findViewById(R.id.button4).setEnabled(false);
		if (!questionActive[4]) findViewById(R.id.button5).setEnabled(false);
		if (!questionActive[5]) findViewById(R.id.button6).setEnabled(false);
		
		// Im Intent nachsehen, ob Punkte (von der Feedback-Activity)
		// mitgeliefert werden
		Intent intent = getIntent();
		int p = intent.getIntExtra("pts", -1);
		int points=0;
		if (p > 0) {			
			// Ja, da waren Punkte im Intent: Diese werden den bisher in Preferences gespeicherten hinzu addiert
			SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
			// Hole die Punkte aus den Preferences, key=0. Falls keine vorhanden: 0 Punkte als Default
			points = prefs.getInt("score", 0);
			points = points + p;
			// Speichere die Punkte gleich wieder ab. Daf�r ben�tigen wir ein "Editor-Objekt":
			Editor edit = prefs.edit();
			edit.putInt("score", points);
			edit.apply();
		}

		// Die Punktzahl ausgeben
		TextView scoreView = (TextView) findViewById(R.id.score);
		scoreView.setText("" + points);
	}

	// Die folgende Methode wird automatisch aufgerufen, wenn einer der
	// Frage-Buttons ausgelöst wird. Sie hat herauszufinden, welcher Button es
	// war und
	// dann über ein Intent-Objekt (Nachricht) die zugehörige Activity zu
	// starten
	@SuppressWarnings("rawtypes")
	public void btn_clicked(View v) {

		// Nachsehen, wie die Voreinstellung f�r die Wiederholung von Fragen ist
		SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
		boolean questionsRepeat = sharedPref.getBoolean("pref_questions_retry", true);

		Class activityClass = null;
		switch (v.getId()) {
		case R.id.button1:
			activityClass = Q1Activity.class;
			if (!questionsRepeat)questionActive[0]=false;
			break;
		case R.id.button2:
			activityClass = Q2Activity.class;
			if (!questionsRepeat)questionActive[1]=false;
			break;
		case R.id.button3:
			activityClass = Q3Activity.class;
			if (!questionsRepeat)questionActive[2]=false;
			break;
		case R.id.button4:
			activityClass = Q4Activity.class;
			if (!questionsRepeat)questionActive[3]=false;
			break;
		case R.id.button5:
			activityClass = Q5Activity.class;
			if (!questionsRepeat)questionActive[4]=false;
			break;
		case R.id.button6:
			activityClass = Q6Activity.class;
			if (!questionsRepeat)questionActive[5]=false;
			break;
		case R.id.button7:
			activityClass = UsageActivity.class;
			break;
		default:
		}
		Intent intent = new Intent(this, activityClass);
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		Intent i;
		switch (id) {
		case R.id.action_settings:
			i = new Intent(this, SettingsActivity.class);
		    startActivity(i);
			return true;
		case R.id.action_about:
			i = new Intent(this, AboutActivity.class);
		    startActivity(i);
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}
}
