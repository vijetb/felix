# Events in OSGi

Events are the mechanisms through which Bundles communicate with other bundles. There are two types of eventing mechanisms:
1. Asynchronous 
2. Synchronous

### Asynchronous Events
* Two bundles can communicate asynchronously. In this mechanism, the event sender sends the event and continueous his 
exectution without bothering if the receiver (if there are any) receives and processes it or no.

### Synchronous Events
* In this mechanism, the event sender waits after sending the event to relese the execution from the receiver, and then 
resumes execution.
