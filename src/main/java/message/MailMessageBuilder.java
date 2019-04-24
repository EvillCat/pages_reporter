package message;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MailMessageBuilder {

    private StringBuilder messageBuilder;


    public MailMessageBuilder() {
        messageBuilder = new StringBuilder();
    }

    public String getSubject() {
        Date date = new Date();
        SimpleDateFormat formatDate = new SimpleDateFormat("E MM.dd.yyyy");
        return "Изменения в сайтах " + formatDate.format(date);
    }

    private void writeListToBuilder(List<String> pages) {
        if (pages == null) {
            messageBuilder.append("Нет изменений \n");
        } else {
            for (String page : pages) {
                messageBuilder.append(page + "\n");
            }
        }
    }

    public String getMessage(List<String> deletedPages, List<String> createdPages, List<String> updatedPages) {

        messageBuilder.append("Здравствуйте, дорогая и.о. секретаря \n");
        messageBuilder.append("За последние сутки во вверенных Вам сайтах произошли следующие изменения: \n");
        messageBuilder.append("1. Исчезли следующие страницы: \n");

        writeListToBuilder(deletedPages);

        messageBuilder.append("2. Появились следующие новые страницы: \n");

        writeListToBuilder(createdPages);

        messageBuilder.append("3. Изменились следующие страницы: \n");

        writeListToBuilder(updatedPages);

        messageBuilder.append("\n" + "\n" + "\n");
        messageBuilder.append("С уважением, \n");
        messageBuilder.append("автоматизированная система мониторинга");

        return new String((messageBuilder));
    }


}
