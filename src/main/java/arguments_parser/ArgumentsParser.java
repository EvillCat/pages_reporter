package arguments_parser;

public class ArgumentsParser {

    private String[] arguments;

    public ArgumentsParser(String[] arguments) {
        this.arguments = arguments;
    }

    public String getSenderEmail() {
        return arguments[0];
    }

    public String getPassword() {
        return arguments[1];
    }

    public String getRecieverEmail() {
        return arguments[2];
    }
}
