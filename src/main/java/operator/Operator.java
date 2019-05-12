package operator;

import handler.StatePagesHandler;
import message.MailMessageBuilder;
import sender.Sender;
import source.MemorySourcePagesImlementation;

import java.util.Map;

public class Operator {

    private MemorySourcePagesImlementation sourcePages;
    private StatePagesHandler handler;
    private MailMessageBuilder messageBuilder;
    private Sender sender;
    private String recieverEmail;

    public Operator(String senderEmail, String password, String recieverEmail,
                    Map<String, String> todayPages, Map<String, String> yesterdayPages) {
        sourcePages = new MemorySourcePagesImlementation(todayPages, yesterdayPages);
        handler = new StatePagesHandler(sourcePages);
        messageBuilder = new MailMessageBuilder();
        sender = new Sender(senderEmail, password);
        this.recieverEmail = recieverEmail;
    }

    public void sendReport() {
        String message =
                messageBuilder.getMessage(handler.getDeletedUrls(), handler.getCreatedUrls(), handler.getUpdatedUrls());
        sender.send(messageBuilder.getSubject(), message,recieverEmail);
    }
}
