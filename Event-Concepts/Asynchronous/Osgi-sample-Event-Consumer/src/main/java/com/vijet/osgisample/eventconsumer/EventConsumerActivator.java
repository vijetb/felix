package com.vijet.osgisample.eventconsumer;

import java.util.Dictionary;
import java.util.Hashtable;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.service.event.Event;
import org.osgi.service.event.EventConstants;
import org.osgi.service.event.EventHandler;

/**
 * This Bundle Consumers the event Event. The producer of the event will send the events.
 */
public class EventConsumerActivator implements BundleActivator,EventHandler{

	private String[] topics = new String[] {"com/vijet/sample/event"};

	public void start(BundleContext context) throws Exception {
	        Dictionary props = new Hashtable();
	        props.put(EventConstants.EVENT_TOPIC, topics);
	        context.registerService(EventHandler.class.getName(), this , props);
	        System.out.println("CONSUMER SERVICE REDAY TO CONSUME SERVICES..");
	}

	public void stop(BundleContext context) throws Exception {
		
	}

	public void handleEvent(Event event) {
		if(event.getTopic().equals("com/vijet/sample/event")){
			System.out.println("*** EVENT RECEIVED ***");
			System.out.println("*** PAYLOAD ***");
			System.out.println("NAME->" + event.getProperty("name"));
			System.out.println("NUMBER->" + event.getProperty("number"));
			System.out.println("ADDRESS->" + event.getProperty("address"));

		}
	}

}
