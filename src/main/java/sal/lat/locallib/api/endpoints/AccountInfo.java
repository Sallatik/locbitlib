package sal.lat.locallib.api.endpoints;

import com.mashape.unirest.http.HttpMethod;
import sal.lat.locallib.User;
import sal.lat.locallib.api.AbstractRequest;
import sal.lat.locallib.api.AnonymousRequest;
import sal.lat.locallib.api.DataDeserializer;

public class AccountInfo extends AbstractRequest<User> implements AnonymousRequest<User> {
    public AccountInfo(String username){
        super(
                "/api/account_info/" + username + "/",
                HttpMethod.GET,
                new DataDeserializer<>(User.class)
        );
    }
}
