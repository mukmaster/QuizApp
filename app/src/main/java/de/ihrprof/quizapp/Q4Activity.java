package de.ihrprof.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

public class Q4Activity extends Activity implements OnTouchListener {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_q4);
		
		ImageView img = (ImageView) findViewById(R.id.q4imageView);
		img.setOnTouchListener(this);		
	}
	
	public boolean onTouch(View view, MotionEvent evt){
		// Zun�chst besorgen wir uns die Breite und H�he des angeklickten Bilds (in Pixeln)
		float imgWidth = view.getWidth();
		float imgHeight = view.getHeight();
		// Und dann die Koordinaten des Touchevents (ebenfalls Pixel)
		float x = evt.getX();
		float y = evt.getY();
		// Die Koordinaten werden von absolut in relativ umgerechnet
		x = x/imgWidth;
		y = y/imgHeight;
		// Dank Photoshop wissen wir, dass der gesuchte Bildbereich bei x>=85% und 4%<=y<=13% liegt
		boolean treffer = (x>=0.85) && (y>=0.04) && (y<=0.13); 
		if (treffer)
			Helper.feedback(true,1,this);
		else
			Helper.feedback(false,0,this);
		return true;
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
