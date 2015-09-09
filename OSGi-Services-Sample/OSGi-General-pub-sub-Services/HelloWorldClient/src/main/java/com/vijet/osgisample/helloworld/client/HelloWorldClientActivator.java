package com.vijet.osgisample.helloworld.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import com.vijet.osgisample.helloworldapi.IHelloWorld;

/**
 * Client class that access this the HelloWorldService
 */
public class HelloWorldClientActivator  implements BundleActivator
{
	private ServiceReference serviceRef = null;
	private IHelloWorld helloWorld = null;
	
	public void start(BundleContext context) throws Exception {
		serviceRef = context.getServiceReference(IHelloWorld.class.getName());
		helloWorld = (IHelloWorld) context.getService(serviceRef);
		if(null != helloWorld){
			helloWorld.sayHello();
		}else{
			System.out.println("No-Service-found");
		}
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
