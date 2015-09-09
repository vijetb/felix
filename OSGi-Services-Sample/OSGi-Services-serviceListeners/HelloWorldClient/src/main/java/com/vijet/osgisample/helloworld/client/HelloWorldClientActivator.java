package com.vijet.osgisample.helloworld.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceEvent;
import org.osgi.framework.ServiceListener;
import org.osgi.framework.ServiceReference;

import com.vijet.osgisample.helloworldapi.IHelloWorld;

/**
 * Client class that access this the HelloWorldService
 */
public class HelloWorldClientActivator  implements BundleActivator,ServiceListener
{
	private IHelloWorld helloWorld = null;
	private BundleContext bundleContext = null;
	
	public void start(BundleContext context) throws Exception {
		bundleContext = context;
		bundleContext.addServiceListener(this);
	}

	public void stop(BundleContext context) throws Exception {
		// TODO Auto-generated method stub
		
	}

	public void serviceChanged(ServiceEvent event) {
		if(event.getType() == ServiceEvent.REGISTERED){
			helloWorld = (IHelloWorld) bundleContext.getService(event.getServiceReference());
			if(null != helloWorld){
				helloWorld.sayHello();
			}else{
				System.out.println("No-Service-found, Not Proper Service");
			}
		}
	}

}
