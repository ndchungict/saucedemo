package chungnd.demo.ability;

import chungnd.demo.exception.CannotAuthenticateException;
import io.cucumber.datatable.DataTable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.serenitybdd.screenplay.Ability;
import net.serenitybdd.screenplay.Actor;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
public class Authenticate implements Ability {
    private String username;
    private String password;

    public static Authenticate as(Actor actor) {
        if (actor.abilityTo(Authenticate.class)==null){
            throw new CannotAuthenticateException(actor.getName());
        }
        return actor.abilityTo(Authenticate.class);
    }

    public static Authenticate with(String username,String password){
        return new Authenticate(username, password);
    }

    public static Authenticate with(DataTable credentials){
        List<Map<String, String>> data = credentials.asMaps(String.class, String.class);
        String user = "";
        String pass = "";
        if (data.get(0).get("username")!= null){
            user = data.get(0).get("username");
        }
        if(data.get(0).get("password")!=null){
            pass = data.get(0).get("password");
        }
        return new Authenticate(user,pass);
    }
}
