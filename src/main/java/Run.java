import operator.Operator;

import java.util.HashMap;
import java.util.Map;

public class Run {

    //В параметрах запуска необходимо передавать: адрес отправителя, пароль от ящика отправителя, адрес получателя.
    public static void main(String[] args) {

        //Мапы нужны были для того, чтобы протестировать всю программу. Были заполнены значениями.
        Map<String, String> yesterdayPages = new HashMap<>();
        Map<String, String> todayPages = new HashMap<>();

        Operator operator = new Operator(args, todayPages, yesterdayPages);
        operator.sendReport();
    }
}
