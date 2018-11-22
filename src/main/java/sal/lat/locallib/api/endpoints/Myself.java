package sal.lat.locallib.api.endpoints;

import com.mashape.unirest.http.HttpMethod;
import sal.lat.locallib.User;
import sal.lat.locallib.api.AbstractRequest;
import sal.lat.locallib.api.AuthenticatedRequest;
import sal.lat.locallib.api.DataDeserializer;

public class Myself extends AbstractRequest<User> implements AuthenticatedRequest<User> {
    public Myself(){
        super(
                "/api/myself/",
                HttpMethod.GET,
                new DataDeserializer<>(User.class)
        );
    }
}
