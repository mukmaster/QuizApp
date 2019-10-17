package de.ihrprof.quizapp;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ListViewActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	        ArrayAdapter adapter = new ArrayAdapter (this, android.R.layout.simple_list_item_2) {

	    	    final String[] description = new String[] { "Author", "Year", "Build"};
	    	    final String[] value = new String[] { "Roderus", "2014", "V0.2.3a"};
	    		@Override
	    		public View getView(int position, View convertView, android.view.ViewGroup parent) {
	    		View view = super.getView(position, convertView, parent);

	    		TextView text1 = (TextView) view.findViewById(android.R.id.text1);
	    		TextView text2 = (TextView) view.findViewById(android.R.id.text2);

	    		text1.setText(description[position]);
	    		text2.setText(value[position]);
	    		return view;
	    		}
	    		};
	        setListAdapter(adapter);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.about, menu);
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
