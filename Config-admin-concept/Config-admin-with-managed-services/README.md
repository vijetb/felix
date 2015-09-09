* Configuration Admin

This concept is used for plug and play kind of services. 

** When to use this ?

If a bundle needs to be activated on runtime based on some configuration which other bundles update,
then this concept can be used.

** How it works?

To make this config Admin work, we should download the config-admin bundle that can be found at http://www.us.apache.org/dist//felix/org.apache.felix.configadmin-1.8.8.jar and should be activated

There are two bundles, Client and Service. The client bundle is interested in receiving the updates from the service Bundle.
The client creates a "key" for a particular "pid", defines a listener that needs to be updated upon receving the interested update.
and updates the config admin bundle. The config admin bundle stores this pid mapped to the set of listeners.

When the service when it wants to update the value, will refer the pid and the value, and update it. The Config admin bundle will invoke all the listener that are registered for that pid

** How to run the Example?
1. Install the configAdmin Bundle. (Make sure its active)
2. Run the client.
3. Run the service.



