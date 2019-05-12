package arguments_parser;

public class ArgumentsParser {

    private String[] arguments;

    public ArgumentsParser(String[] arguments) throws NotEnoughArgumentsException, IncorrectArgumentsException {
        this.arguments = arguments;
        checkArguments(arguments);
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

    private void checkArguments(String[] args) throws NotEnoughArgumentsException, IncorrectArgumentsException {
        if (!checkOnArgumentsLength(args)) {
            throw new NotEnoughArgumentsException();
        } else if (!checkOnCorrectArguments(args)){
            throw new IncorrectArgumentsException();
        }
    }

    private boolean checkOnCorrectArguments(String[] args) {
        return (args[0].contains("@") && args[2].contains("@"));
    }

    private boolean checkOnArgumentsLength(String[] args) {
        return args.length == 3;
    }


    public class IncorrectArgumentsException extends Exception {

    }

    public class NotEnoughArgumentsException extends Exception {

    }
}
