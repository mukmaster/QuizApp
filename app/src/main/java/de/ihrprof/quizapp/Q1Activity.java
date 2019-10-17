package de.ihrprof.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;

public class Q1Activity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_q1);
	}

	/* 
	 * Die Event-Handling-Methode btn_clicked wird aufgerufen, wenn der Benutzer seine
	 * Antwort eingegeben hat. Sie findet heraus, ob die Antwort korrekt ist und
	 * gibt diese Information zusammen mit Feedback-Texten weiter an die Feedback-Activity
	 */
    public void btn_clicked(View v){
    	// mit findViewById bekommen wir das RadioButton-Objekt der korrekten Antwort
    	RadioButton rb = (RadioButton) findViewById(R.id.radio3);
    	/* Die Methode feedback (aus der Klasse Helper) erledigt den Rest:
    	 * Erzeugen der Feedbacktexte, der Punkte und Aufrufen der Feedback-Activity
    	 */
        Helper.feedback(rb.isChecked(),1,this);
    }
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.q1, menu);
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
