package xuandac.com.vn.cordova;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

public class AppName extends CordovaPlugin {
	@Override
        public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
		PackageManager packageManager = this.cordova.getActivity().getPackageManager();
		 ApplicationInfo ai;
	     CharSequence al;
		try {	
			if (action.equals("getAppName")) {
				ai = packageManager.getApplicationInfo(this.cordova.getActivity().getPackageName(), 0);
            	al = packageManager.getApplicationLabel(ai);
                callbackContext.sendPluginResult(new PluginResult(PluginResult.Status.OK, (String) al));
			return true;
			}
			return false;
		} catch (NameNotFoundException e) {
			callbackContext.success("N/A");
			return true;
		}
	}

}
