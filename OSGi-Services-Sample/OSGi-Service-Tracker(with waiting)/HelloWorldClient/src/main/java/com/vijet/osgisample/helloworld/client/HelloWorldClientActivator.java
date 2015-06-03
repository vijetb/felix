package com.vijet.osgisample.helloworld.client;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.util.tracker.ServiceTracker;

import com.vijet.osgisample.helloworldapi.IHelloWorld;

/**
 * Client class that access this the HelloWorldService
 */
public class HelloWorldClientActivator  implements BundleActivator
{
	private ServiceTracker serviceTracker = null;
	private IHelloWorld appService = null;
	
	public void start(BundleContext context) throws Exception {
		serviceTracker = new ServiceTracker(context, IHelloWorld.class.getName(), null);
		serviceTracker.open();
		
		new Thread(new Runnable() {
			
			public void run() {
				try {
					appService = (IHelloWorld) serviceTracker.waitForService(0);
					if(null == appService){
						System.out.println("No - Service is subscribed");
					}else{
						appService.sayHello();
					}
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
		}).start();
		
	}

	public void stop(BundleContext context) throws Exception {
	
		
	}

	

}
