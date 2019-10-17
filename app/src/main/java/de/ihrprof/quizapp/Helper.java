package de.ihrprof.quizapp;

import android.content.Context;
import android.content.Intent;

public class Helper {

	/**
	 * Wird von den Frage-Activities aufgerufen, um ein Feedback f�r den User zu
	 * erzeugen. Wenn die Antwort korrekt war, wird ein zuf�llig ausgew�hltes
	 * positives Feedback erstellt. Die erworbene Punktzahl wird in den
	 * Punktetext an die Stelle der Raute eingesetzt: z.B. in
	 * "Sie haben # Punkte gewonnen".
	 * 
	 * @param isAnswerCorrect
	 *            true, wenn die Antwort richtig war, sonst false
	 * @param points
	 *            die erworbene Punktzahl
	 * @param activity
	 *            von welcher (Frage-)Activity kommen wir?
	 */
	public static void feedback(boolean isAnswerCorrect, int points, Context activity) {
		/*
		 * Achtung: Die Methode ist eine reine Hilfsmethode (eine
		 * "Zusammenfassung" von mehrfach gebrauchten Befehlen. Die Klasse
		 * besitzt keine Datenfelder und die Methode kann unabh�ngig von einer
		 * Instanz dieser Klasse verwendet werden. Daher wurde sie "static" definiert.
		 */
		String feedback, pointstr;
		if (isAnswerCorrect) {
			// Die positiven Antworten werden durch den Zufallsgenerator
			// variiert
			if (Math.random() < 0.5)
				/*
				 * Auf die Activity-Methoden kann nur im Kontext der Activity
				 * zugegriffen werden. Daher haben wir diese der
				 * feedback-Methode als Parameter "activity" mitgegegeben.
				 */
				feedback = activity.getString(R.string.positive_feedback1);
			else
				feedback = activity.getString(R.string.positive_feedback2);
			pointstr = activity.getString(R.string.positive_score).replace("#",
					points + "");
		} else {
			if (Math.random() < 0.5)
				feedback = activity.getString(R.string.negative_feedback1);
			else
				feedback = activity.getString(R.string.negative_feedback2);
			pointstr = activity.getString(R.string.negative_score);
			points = 0;
		}
		/*
		 * Der Intent zum Aufruf der FeedbackActivity wird erzeugt
		 */
		Intent intent = new Intent(activity, FeedbackActivity.class);
		/*
		 * Als Extra-Information bekommt der Intent noch die Feedback-Texte und
		 * die Punkte mit
		 */
		intent.putExtra("fb", feedback);
		intent.putExtra("pstr", pointstr);
		intent.putExtra("pts", points);
		activity.startActivity(intent);
	}
}
