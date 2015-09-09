package com.vijet.osgisample.helloworld.firstimpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import com.vijet.osgisample.helloworldapi.IHelloWorld;

/**
 * Class that starts the bundle. This class just registers the service to the 
 * OSGi sevice registry. This is way how the services will be registered to the
 * registry
 */
public class HelloWorldFirstActivator implements BundleActivator {
	/**
	 * Bundle Context associated with the OSGi container
	 */
	private BundleContext mBundleContext;
	public void start(BundleContext bundleContext) throws Exception {
		mBundleContext = bundleContext;
		ServiceRegistration serviceReg =  mBundleContext.registerService(IHelloWorld.class.getName(), new HelloWorldImplFirst(), null);
		if(null != serviceReg){
			System.out.println("Service Registerd!! Service Started...");
		}else{
			System.out.println("Service Registration Failed!!!");
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {

	}

}
