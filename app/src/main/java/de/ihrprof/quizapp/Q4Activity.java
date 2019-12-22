package de.ihrprof.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

import static java.lang.Math.round;

public class Q4Activity extends Activity implements View.OnTouchListener {

    private final String APP = "QuizApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);

        ImageView imageView = findViewById(R.id.q4imageView);
        imageView.setBackgroundColor(0xff0000);
        imageView.setOnTouchListener(this);
    }

    public boolean onTouch(View view, MotionEvent evt) {
        // Für Debugzwecke den folgenden Methodenaufruf auskommentieren:
        // debugImageView(view, evt);

        // Zunächst besorgen wir uns die Breite und Höhe des angeklickten Views (in Pixeln)
        float viewWidth = view.getWidth();
        float viewHeight = view.getHeight();

        // Und dann die Koordinaten des Touchevents (ebenfalls Pixel)
        float x = evt.getX();
        float y = evt.getY();

        // Die Touch-Koordinaten umrechnen in relative Koordinaten (die absoluten Koordinaten hängen von der Displayauflösung ab):
        float xRel = x/viewWidth;
        float yRel = y/viewHeight;

		/*  Den Koordinatenbereich für einen Treffen haben wir vorab mit Hilfe der Methode debugImageView herausgefunden.
		    Bitte beachten: Bilder können von Android skaliert werden, damit sie in den ImageView passen. In unserem
		    Beispiel wurde im Layout von activity_q4.xml festgelegt, dass das Bild in den ImageView eingepasst wird (scaleType="fitXY")
		    und außerdem mit adjustViewBounds = "true" verhindert, dass von Android noch Padding-Space um das Bild gelegt wird.
		*/

        boolean treffer = (xRel>=0.85 && yRel>=0.04 && yRel<=0.13);
        if (treffer)
            Helper.feedback(true, 1, this);
        else
            Helper.feedback(false, 0, this);
        return false;
    }

    private void debugImageView(View v, MotionEvent evt) {
        // Die folgende Methode hat mir geholfen, die Größe und die Skalierung des Bildes zu analysieren
        // Sie muss in onTouch aktiviert werden (Kommentar weg). Sie protokolliert mit Hilfe von Log.i(),
        // also die Ergebnisse im Logcat nachsehen!
        ImageView iv = (ImageView) v;
        float viewWidth = round(iv.getWidth());
        float viewHeight = round(iv.getHeight());
        float imgWidth = round(iv.getDrawable().getIntrinsicWidth());
        float imgHeight = round(iv.getDrawable().getIntrinsicHeight());
        float x = round(evt.getX());
        float y = round(evt.getY());
        float xRel = x/viewWidth;
        float yRel = y/viewHeight;

        boolean treffer = (xRel>=0.85 && yRel>=0.04 && yRel<=0.13);
        // boolean treffer = (x >= 585 && x <= 656 && y >= 45 && y <= 120);

        Log.i(APP, "ImageView.getWidth/-Height:" + viewWidth + ", " + viewHeight);
        Log.i(APP, "Drawable.getMinimumWidth/-Height:" + imgWidth + ", " + imgHeight);
        Log.i(APP, "TouchEvent.getX-/Y:" + x + ", " + y);
        Log.i(APP, "Relativ: " + xRel + ", " + yRel);
        Log.i(APP, "Treffer: " + treffer);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.q4, menu);
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
