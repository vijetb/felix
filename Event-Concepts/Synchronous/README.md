#Synchronous Events
Events are in the form of key-value pairs. If an object needs be communicated between the bundles then it can be represented as String either by using XML or JSON, serializing and deserializing on either side.

#### How it works ?
* For the event communication, Event-Admin bundle should be downloaded from http://www.us.apache.org/dist//felix/org.apache.felix.eventadmin-1.4.4.jar and should be installed onto the container.This bundle should be in active state.
* The bundle that needs to receive the event should register to the event topic. These event topics will be kept in registry under Event-Admin bundle.
* When some bundle sends an event with this topic, then the event admin bundle retrives all the listeners that are registered for this event and invoke the listeners.


#### How to Run the bundles?
1. Install the event-admin bundle and verify that its active.
2. Run the Osgi-sample-Event-Consumer
3. Run the Osgi-sample-Event-Producer-Async
