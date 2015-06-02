package com.vijet.osgisample.configadminclient;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.ConfigurationException;
import org.osgi.service.cm.ManagedService;

/**
 * Sample class that acts a client, inorder to receive the Updated values and react accordingly
 */
public class CofigAdminClientActivator implements BundleActivator, ManagedService {

	public void start(BundleContext context) throws Exception {
		//Register the PID
		Dictionary<String,String> props = new Hashtable<String,String>();
		props.put("service.pid", "vijet.sample.configservice");
		context.registerService(ManagedService.class.getName(), this, props);
		System.out.println("Config-Client-Registered");
	}

	public void stop(BundleContext context) throws Exception {

	}

	public void updated(Dictionary<String, ?> properties)
			throws ConfigurationException {
		if(null != properties){
			System.out.println("*** UPDATE RECEIVED ***");
			System.out.println("KEY: " + properties.get("key"));
		}else{
			System.out.println("Null properties received, ignored");
		}
	}

}
