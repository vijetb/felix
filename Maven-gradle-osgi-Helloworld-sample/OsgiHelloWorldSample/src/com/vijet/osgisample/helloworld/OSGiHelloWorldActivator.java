package com.vijet.osgisample.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * The Sample Class to illustrates OSGi Bundle.
 * @author Vijet 
 */
public class OSGiHelloWorldActivator implements BundleActivator {

	@Override
	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("**** HELLO-WORLD ****");
	}

	@Override
	public void stop(BundleContext bundleContext) throws Exception {
		
	}

}
