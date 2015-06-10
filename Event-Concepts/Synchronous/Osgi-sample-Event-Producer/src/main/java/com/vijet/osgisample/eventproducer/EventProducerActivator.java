package com.vijet.osgisample.eventproducer;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventAdmin;

/**
 * This Bundle Sends a Producer Event to the EventAdmin.The consumer of these events who have registered,
 * will receive it.
 */
public class EventProducerActivator implements BundleActivator{
	private static final String TOPIC = "com/vijet/sample/event";

	public void start(BundleContext context) throws Exception {
		ServiceReference ref = context.getServiceReference(EventAdmin.class.getName());
        if (ref != null)
        {
            EventAdmin eventAdmin = (EventAdmin) context.getService(ref);

            Dictionary<String,String> properties = new Hashtable<String,String>();
            properties.put("name", "TED");
            properties.put("number" , "1-2-1");
            properties.put("address" , "East carson Street");


            Event reportGeneratedEvent = new Event(TOPIC, properties);
            eventAdmin.sendEvent(reportGeneratedEvent);
            System.out.println("***EVENT SENT***");
        }else{
        	System.out.println("ERROR in getting Service Reference");
        }
	}

	public void stop(BundleContext context) throws Exception {
		
	}

}
