package com.android.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.android.camera.app.CameraApp;

public class StorageEnvironment {

	public static String getStorage() {

		String path = "";
		SharedPreferences shared = CameraApp.getAppContext().getSharedPreferences(CameraApp.getAppContext().getPackageName() +"_preferences_0",0);

                // set our new pref default value !
                shared.edit().putString(CameraSettings.KEY_PHOTOVIDEO_STORAGE, shared.getString(CameraSettings.KEY_PHOTOVIDEO_STORAGE,"internal")).apply();
                // set "continuos-picture" as default, till it´s fixed
                shared.edit().putString(CameraSettings.KEY_FOCUS_TIME, shared.getString(CameraSettings.KEY_FOCUS_TIME,"continuous-picture")).apply();

		if  (shared.getString(CameraSettings.KEY_PHOTOVIDEO_STORAGE, "").equals("internal")) {
			path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).toString();
                        
		} else {
                        // we hardcode path here!
                        // getting sdcard path, can be a pain on various devices and would need more code
                        // change path here directly for your device :-) 
                        // "/mnt/extSdCard/DCIM" = Samsung Galaxy S III
                        path = "/mnt/extSdCard/DCIM";
                       
		}
		
		return path;
	}
}
