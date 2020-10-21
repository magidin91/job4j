package ru.job4j.exeptions;

public class JdbcConfig2 {
    public static void load(String url) throws UserInputException {
        if (url == null) {
            throw new UserInputException("Url could not be null");
        }
        //load jdbc
    }

    public static void main(String[] args) {
        try {
            load(null);
        } catch (UserInputException e) {
            e.printStackTrace();
        }
    }
}