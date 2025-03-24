// Single Java file with Observer Pattern and SMS Support

import java.util.*;

// EventManager - Manages event listeners
class EventManager {
    private Map<String, List<EventListener>> listeners = new HashMap<>();

    public EventManager(String... operations) {
        for (String operation : operations) {
            listeners.put(operation, new ArrayList<>());
        }
    }

    public void subscribe(String eventType, EventListener listener) {
        listeners.get(eventType).add(listener);
    }

    public void unsubscribe(String eventType, EventListener listener) {
        listeners.get(eventType).remove(listener);
    }

    public void notify(String eventType, String message) {
        for (EventListener listener : listeners.get(eventType)) {
            listener.update(eventType, message);
        }
    }
}

// EventListener - Interface for observers
interface EventListener {
    void update(String eventType, String message);
}

// EmailNotificationListener - Sends email notifications
class EmailNotificationListener implements EventListener {
    private String email;

    public EmailNotificationListener(String email) {
        this.email = email;
    }

    @Override
    public void update(String eventType, String message) {
        System.out.println("Email sent to " + email + ": " + message);
    }
}

// SMSSupportListener - Checks SMS length and sends SMS
class SMSSupportListener implements EventListener {
    private String phoneNumber;

    public SMSSupportListener(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update(String eventType, String message) {
        if (message.length() > 160) {
            System.out.println("Warning: SMS length exceeds 160 characters!");
        } else {
            System.out.println("SMS sent to " + phoneNumber + ": " + message);
        }
    }
}

// Editor - Simulates an application generating events
class Editor {
    public EventManager events;
    private String content;

    public Editor() {
        this.events = new EventManager("open", "save");
    }

    public void openFile(String filePath) {
        this.content = "Opened file: " + filePath;
        events.notify("open", content);
    }

    public void saveFile() {
        events.notify("save", "File has been saved.");
    }
}

// Main class - Runs the program
public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();

        EmailNotificationListener emailListener = new EmailNotificationListener("user@example.com");
        SMSSupportListener smsListener = new SMSSupportListener("+1234567890");

        editor.events.subscribe("open", emailListener);
        editor.events.subscribe("save", smsListener);

        editor.openFile("document.txt");
        editor.saveFile();
    }
}
