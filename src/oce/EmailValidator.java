package oce;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailValidator {

    private static Matcher M;
    private static Pattern P;
    private static final String EmailPattern =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public EmailValidator() {
        P = Pattern.compile(EmailPattern);
    }

    public static boolean validate(final String hex) {

        M = P.matcher(hex);
        return M.matches();

    }
}