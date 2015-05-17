package com.vijet.osgisample.helloworld;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

/**
 * The Sample Class to illustrates OSGi Bundle using GRADLE.
 * @author Vijet 
 */
public class OSGiHelloWorldActivator implements BundleActivator {

	public void start(BundleContext bundleContext) throws Exception {
		System.out.println("**** HELLO-WORLD ****");
	}

	public void stop(BundleContext bundleContext) throws Exception {
		
	}

}
