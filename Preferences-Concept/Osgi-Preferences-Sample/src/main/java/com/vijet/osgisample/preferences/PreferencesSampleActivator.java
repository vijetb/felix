package com.vijet.osgisample.preferences;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.prefs.Preferences;
import org.osgi.service.prefs.PreferencesService;

/**
 * This bundle demonstrates the Preferences API in OSGi. This feature enables the bundle to 
 * store some information persistently. This data will be persisted even after the bundle is stopped.
 * It can fetch this data, when it comes up later.
 * 
 * Also, Install the bundle- "Preferences" in the Felix container from http://felix.apache.org/downloads.cgi
 */
public class PreferencesSampleActivator implements BundleActivator{

	public void start(BundleContext context) throws Exception {
		ServiceReference sRef = context.getServiceReference(PreferencesService.class.getName());
		if(null != sRef){
			PreferencesService preferenceService = (PreferencesService)context.getService(sRef);
			if(null != preferenceService){
				Preferences pref = preferenceService.getUserPreferences("user-1");
				String name = pref.get("name", "default-name");
				if(name.equals("default-name")){
					pref.put("name", "Alice");
					pref.putBoolean("booleanKey", false);
					pref.putInt("intKey", 11);
					pref.flush();// this will save the data
					System.out.println("New Preferences created and Updated");
				}else{
					pref.sync(); // this will retreive the data
					System.out.println("Retrived Preferences:\n " + pref.get("name", "default-name") +"\n" +
					pref.getBoolean("booleanKey", true) + "\n" + pref.getInt("intKey", 0));
					System.out.println("Preferences has been restored...");
				}
				
			}else{
				System.out.println("Error in connecting to preference Service");
			}
		}else{
			System.out.println("Preference Service is not available, Download the Preference Service bundle and deploy it");
		}
	}

	public void stop(BundleContext context) throws Exception {
		
	}

}
