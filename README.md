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
