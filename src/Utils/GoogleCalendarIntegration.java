package Utils;

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.DateTime;
import com.google.api.services.calendar.Calendar;
import com.google.api.services.calendar.model.Event;
import com.google.api.services.calendar.model.EventAttendee;
import com.google.api.services.calendar.model.EventDateTime;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GoogleCalendarIntegration {

    private static final String CREDENTIALS_FILE_PATH = "C:\\Users\\guilherme\\Documents\\GitHub\\ProvaA3PB\\src\\Tokens\\provaa3-37279a88a50f.json";

    public static void criarEvento(List<String> participantEmails, DateTime dataEvento, String nomeEvento) {

        try {
            HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();

            GoogleCredential credential = GoogleCredential.fromStream(
                    new FileInputStream(CREDENTIALS_FILE_PATH))
                    .createScoped(Collections.singleton("https://www.googleapis.com/auth/calendar"));

            Calendar service = new Calendar.Builder(httpTransport, jsonFactory, credential)
                    .setApplicationName("Ferramentas&&amigos")
                    .build();

            Event event = new Event();
            event.setSummary(nomeEvento);
            event.setStart(new EventDateTime().setDateTime(dataEvento));
            event.setEnd(new EventDateTime().setDateTime(dataEvento));

            EventAttendee attendee = new EventAttendee();
            List<EventAttendee> attendees = new ArrayList<>();
            for (String email : participantEmails) {
                attendee.setEmail(email);
                attendees.add(attendee);
            }
            event.setAttendees(attendees);           

            Event createdEvent = service.events().insert("primary", event).execute();
            createdEvent.getHtmlLink();
        } catch (IOException | GeneralSecurityException e) {
            e.printStackTrace();
        }
    }
}
