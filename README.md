Observer Pattern - Concept & Explanation
The Observer Pattern is a behavioral design pattern that allows an object (Subject) to notify multiple other objects (Observers) whenever its state changes.

How It Works?
Subject (Observable)

Maintains a list of observers.

Notifies all attached observers whenever its state changes.

Observer

Listens for updates from the Subject.

When the Subject's state changes, the Observer gets notified and reacts accordingly.

Real-Life Example 📌
Think of YouTube Subscriptions:

You (Observer) subscribe to a YouTube channel (Subject).

Whenever the channel uploads a new video (state change), you receive a notification (update).

If you unsubscribe (detach), you won’t get notified anymore.

How It Works in my Code?
Subject Class

Stores the list of Observers.

Calls notifyAllObservers() when the state changes.

Can attach (subscribe) and detach (unsubscribe) observers.

Observers (Binary, Octal, Hexa)

Convert and print the state in different formats when notified.

Main Class (ObserverPatternDemo)

Creates a Subject.

Attaches multiple Observers.

Changes the state and sees how only active observers are notified.

Why Use Observer Pattern?
✅ Loose Coupling: Subject doesn’t need to know observer details.
✅ Scalability: Can add/remove observers without modifying Subject.
✅ Automatic Updates: Observers always receive the latest changes.
question 2  
The above code demonstrates the Observer Pattern, which allows multiple objects (observers) to be notified when an event happens. Here’s how it works in simple terms:

EventManager:

This class manages different events (like "open" and "save").

It allows observers (listeners) to subscribe or unsubscribe from events.

When an event occurs, it notifies all subscribed observers.

EventListener (Interface):

This is the base structure for all observers. Any class that wants to listen for events must implement this.

EmailNotificationListener:

This class listens for an event and sends an email when notified.

SMSSupportListener:

This class listens for an event and sends an SMS when notified.

If the SMS message is longer than 160 characters, it shows a warning.

Editor (Application Example):

Simulates a simple editor where you can open and save a file.

It notifies observers when a file is opened or saved.

Main Class (Program Execution):

Creates an Editor object.

Subscribes an email listener to the "open" event.

Subscribes an SMS listener to the "save" event.

Opens a file (openFile), which triggers an email notification.

Saves the file (saveFile), which triggers an SMS notification.

Example Execution Flow:
The user opens "document.txt" → Email is sent.

The user saves the file → SMS is sent (and warns if the text is too long).

This approach allows us to easily add new listeners in the future without modifying existing code, following the Open-Closed Principle in software design. 
