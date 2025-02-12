package starter.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class EnterUserCredentials {
    public static Performable userName(String username) {
        return Task.where("{0} enter username '" + username + "'",
                Enter.theValue(username)
                        .into(LoginForm.USER_FIELD)
        );
    }

    public static Performable userPass(String pass) {
        return Task.where("{0} enter pass '" + pass + "'",
                Enter.theValue(pass)
                        .into(LoginForm.PASS_FIELD)
        );
    }
}
