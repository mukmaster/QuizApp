package de.ihrprof.quizapp;

import android.os.Bundle;
import android.preference.PreferenceActivity;


public class SettingsActivity extends PreferenceActivity {

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

}

/* Die Nutzung von PreferenceActivity (s. oben) ist sehr einfach und praktisch.  
 * Allerdings ist diese Klasse "deprecated" und wird evtl. irgendwann nicht mehr unterst�tzt. 
 * Die folgende (auskommentierte) Klasse zeigt die derzeit empfohlene Methode, wie man Preferences 
 * mit Hilfe von PreferenceFragment realisieren kann.
 
public class SettingsActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Display the fragment as the main content.
        getFragmentManager().beginTransaction()
                .replace(android.R.id.content, new SettingsFragment())
                .commit();
    }
    
    public static class SettingsFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.preferences);
        }
    }
}
*/
