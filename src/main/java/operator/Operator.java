package operator;

import arguments_parser.ArgumentsParser;
import handler.StatePagesHandler;
import message.MailMessageBuilder;
import sender.Sender;
import source.MemorySourcePages;

import java.util.Map;

public class Operator {

    private ArgumentsParser parser;
    private MemorySourcePages sourcePages;
    private StatePagesHandler handler;
    private MailMessageBuilder messageBuilder;
    private Sender sender;

    public Operator(String[] args, Map<String, String> todayPages, Map<String, String> yesterdayPages) {
        parser = new ArgumentsParser(args);
        sourcePages = new MemorySourcePages(todayPages, yesterdayPages);
        handler = new StatePagesHandler(sourcePages);
        messageBuilder = new MailMessageBuilder();
        sender = new Sender(parser.getSenderEmail(), parser.getPassword());
    }

    public void sendReport() {
        String message = messageBuilder.getMessage
                (handler.getDeletedUrls(), handler.getCreatedUrls(), handler.getUpdatedUrls());
        sender.send(messageBuilder.getSubject(), message, parser.getRecieverEmail());
    }
}
