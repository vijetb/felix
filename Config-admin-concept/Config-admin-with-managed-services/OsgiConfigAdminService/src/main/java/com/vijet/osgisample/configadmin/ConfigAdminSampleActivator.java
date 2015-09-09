package com.vijet.osgisample.configadmin;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.cm.Configuration;
import org.osgi.service.cm.ConfigurationAdmin;

/**
 * Class that updates the configuration parameters. The client will be registering and will be waiting for these
 * Properties to update!
 */
public class ConfigAdminSampleActivator implements BundleActivator{
	/**
	 * Reference to get hold of ConfigAdmin Service
	 */
	private ServiceReference serviceRef = null;
	/**
	 * ConfigAdmin Service to update the config properties
	 */
	private ConfigurationAdmin configAdmin = null;
	
	public void start(BundleContext context) throws Exception {
		serviceRef = context.getServiceReference(ConfigurationAdmin.class.getName());
		configAdmin = (ConfigurationAdmin) context.getService(serviceRef);
		if(null != configAdmin){
			Configuration config = configAdmin.getConfiguration("vijet.sample.configservice",null);
				Dictionary<String,Object> props = config.getProperties();
				if (props == null) {
				    props = new Hashtable<String,Object>();
				}
				props.put("key", "updated-sample-value");
				config.update(props);
				System.out.println("**** CONFIG VALUES UPDATED *****");
		}else{
			System.out.println("Config Admin is null, Check the bundles..");
		}
	}

	public void stop(BundleContext context) throws Exception {
		
	}

}
