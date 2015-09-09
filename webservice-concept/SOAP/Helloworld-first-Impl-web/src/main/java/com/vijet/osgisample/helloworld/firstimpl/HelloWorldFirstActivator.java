package com.vijet.osgisample.helloworld.firstimpl;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

import com.vijet.osgisample.helloworldapi.IHelloWorld;

/**
 * Class that starts the bundle. This class just registers the service to the 
 * OSGi sevice registry. This will deploy the HelloWroldFirstImpl as a web service.
 */
public class HelloWorldFirstActivator implements BundleActivator {
	/**
	 * Bundle Context associated with the OSGi container
	 */
	public void start(BundleContext bundleContext) throws Exception {
		Dictionary props = new Hashtable();
		 
        props.put("service.exported.interfaces", "*");
        props.put("service.exported.configs", "org.apache.cxf.ws");
        props.put("org.apache.cxf.ws.address", "http://localhost:9090/helloWorld");
         
        bundleContext.registerService(IHelloWorld.class.getName(), new HelloWorldImplFirst(), props);
	}

	public void stop(BundleContext bundleContext) throws Exception {

	}

}
