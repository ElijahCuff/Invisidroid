package venomo.invisible;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.app.Application;

public class home extends Activity 
{
	SharedPreferences preferences;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/** 
		   im not here, im in the prefs screen - this activity is really the main activity, 
		   add a setContentView(R.layout.you_id); here for more design ability
		**/
		startActivity(new Intent(this, Preferences.class));
	 }

  }
