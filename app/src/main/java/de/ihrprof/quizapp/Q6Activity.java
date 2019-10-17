package de.ihrprof.quizapp;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Q6Activity extends Activity {
	
	final String loesung = "Honeycomb";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_q6);

		ListView listview = (ListView) findViewById(R.id.q6_listview);
		
		final ArrayList<String> list = new ArrayList<String>();
		for (int i=0; i<namen.length; i++) {
			list.add(namen[i]);
		}
		
		final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, list);
		listview.setAdapter(adapter);
	
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
		      public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
		        final String clickedItem = (String) parent.getItemAtPosition(position);
		        if (clickedItem.equals(loesung))
		        	Helper.feedback(true,1,view.getContext());
		        else
		        	Helper.feedback(false,0,view.getContext());
		      }
			}
		);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.q6, menu);
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
	
	private final String[] namen =
		{"Adolf","Alfred","Almut","Alrun","Amalia","Ansgar","Arbogast","Archibald","Ariovist","Armin",
		"Arne","Arnfried","Arnulf","Arved","Astrid","Aswin","Baldur","Balko","Baltrun","Benno","Bert",
		"Bj�rn","Bodo","Borghilde","Brandolf","Bruno","Burghard","Dagmar","Dagny","Dagobert","Dankmanr",
		"Degenhard","Deike","Detlef","Dietbald","Eberhard","Eckbert","Edda","Edelgard","Edigna","Eduard",
		"Eike","Eila","Einar","Elfgard","Elmar","Elvira","Emma","Engelbert","Erik","Erlgard","Ernst",
		"Erwin","Ewald","Falko","Fara","Farold","Fehild","Ferdinand","Ferun","Finja","Folkward","Frank",
		"Frauke","Freya","Friederike","Fritz","Frigga","Gaidemar","Gandolf","Gefion","Gelsa","Gerald",
		"Gerda","Gerda","Gerlinde","Gertrud","Gerwin","Gisela","Gilbert","Gisbert","Gismara","Godelief",
		"Godwin","Goswin","Gotmar","Gotthilf","Gudrun","Gunhild","G�nther","Gustav","Hedda","Hagarun",
		"Hagen","Hallgard","Harald","Hartmut","Hartwig","Hedwig","Heidrun","Heike","Heiner","Helga",
		"Helgard","Helmar","Helmut","Herbert","Herline","Hermann","Hermine","Herta","Hildegard","Hilke",
		"Holger","Honeycomb","Horst","Hubert","Iduna","Igor","Inga","Ingrid","Ingrun","Inka","Irmbert",
		"Irmela","Irmgard","Irmina","Irminar","Irvin","Isbert","Isolde","Iwo","Karl","Knut","Konrad",
		"Kriemhild","Kunheide","Kunna","Kunolf","Kunrada","Kurt","Landerun","Lando","Leif","Leonhard",
		"Leopold","Liebgard","Lioba","Lothar","Ludwig","Luitberga","Luithilde","Malte","Malvin",
		"Manfred","Marbod","Margund","Markward","Mathilde","Merlinde","Minna","Minnegard","Mutbrecht",
		"Nanna","Neidhart","Norbert","Nordger","Nordwin","Norman","Northild","Nortrud","Nortrun",
		"Norwiga","Notker","Oda","Odin","Olaf","Ortlind","Ortrun","Ortwin","Osgard","Oskar",
		"Osrun","Ostara","Oswald","Oswin","Othilde","Otmar","Otthein","Ottokar","Raban","Radolf",
		"Raimund","Rambert","Randolf","Rango","Ranmar","Rasso","Richard","Rigmor","Rinelda","Robert",
		"Rochbert","Roland","Romilda","Roswin","Roswitha","Rudgar","Runhild","Salgard","Sarhild",
		"Sarolf","Saskia","Schwanhilde","Sebald","Siegfried","Siegmund","Sif","Sigga","Siglinde",
		"Sigmar","Sigrid","Sigrun","Sindolf","Sisgards","Solveig","Sonnwinn","Stilla","Sunhild",
		"Sven","Swidger","Tankred","Tassilo","Teuderun","Thilo","Thor","Thorbrand","Thorleif","Thorsten",
		"Throals","Thusnelda","Tilrun","Traute","Trautwin","Trudildis","Tyra","Uland","Ulbert",
		"Ulf","Ulrike","Ute","Uwe","Vanadis","Volker","Volkmar","Volkwin","Volkward","Walburga",
		"Walda","Waldemar","Walter","Waltraud","Werner","Wibke","Wiborg","Widogard","Widukind",
		"Wigberg","Wilberta","Wilfriede","Wilgard","Wilhelm","Willibald","Wiltraud","Winimar",
		"Wisgard","Wolfgang","Wolfram","Wunna"};
}
