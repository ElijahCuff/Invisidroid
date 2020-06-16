package venomo.invisible;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class receiver extends BroadcastReceiver {
    @Override
	public void onReceive(Context context, final Intent intent) {
		// stop any other apps with the same secret code
		abortBroadcast();

		// continue to load settings for desired secret code
		Settings settings = Settings.get(context);
		String number = settings.getNumber(context);

		/**
		 HANDLE INTENT ACTIONS HERE 
		**/
		// launch a new intent to the homepage activity for calls
		if (intent.getAction().equals(android.content.Intent.ACTION_NEW_OUTGOING_CALL)) {
			String phoneNumber = intent.getExtras().getString(android.content.Intent.EXTRA_PHONE_NUMBER);
			if (phoneNumber.equals(number)) { 
				Intent home = new Intent(context , home.class);
				home.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
				context.startActivity(home);
			  } else if (phoneNumber.equals(context.getString(R.string.emergencySecret))) {
				if (settings.useEmergency()) {
					Intent home = new Intent(context , home.class);
					home.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
					context.startActivity(home);
				  }
			  }
		  }
		  // HANDLE ON BOOT COMPLETED
		  else if (intent.getAction().equals(android.content.Intent.ACTION_BOOT_COMPLETED)) {
			// to do, add a background worker
			Intent home = new Intent(context , home.class);
			home.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			context.startActivity(home);
		  }
		

	  }
  }
