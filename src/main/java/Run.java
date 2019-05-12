import arguments_parser.ArgumentsParser;
import operator.Operator;

import java.util.HashMap;
import java.util.Map;


public class Run {


    /**
     * @param args senderEmail, password, reciverEmail
     */
    public static void main(String[] args) {
        ArgumentsParser parser = null;
        try {
            parser = new ArgumentsParser(args);
        } catch (ArgumentsParser.NotEnoughArgumentsException e) {
            System.out.println("Не хватает аргументов запуска. Необходимо 3 параметра: \n" +
                    "1) Логин почты отправителя; \n" +
                    "2) Пароль от почты отправителя; \n" +
                    "3) Адрес почты получателя.");
        } catch (ArgumentsParser.IncorrectArgumentsException e) {
            System.out.println("Некорректные аргументы запуска. Необходимо 3 параметра: \n" +
                    "1) Логин почты отправителя; \n" +
                    "2) Пароль от почты отправителя; \n" +
                    "3) Адрес почты получателя.");
        }

        //Мапы нужны были для того, чтобы протестировать всю программу. Были заполнены значениями.
        Map<String, String> yesterdayPages = new HashMap<>();
        Map<String, String> todayPages = new HashMap<>();

        Operator operator = new Operator(parser.getSenderEmail(), parser.getPassword(), parser.getRecieverEmail(),
                todayPages, yesterdayPages);
        operator.sendReport();
    }
}
