package sal.lat.locallib.api.endpoints;

import com.mashape.unirest.http.HttpMethod;
import sal.lat.locallib.Contact;
import sal.lat.locallib.api.AbstractRequest;
import sal.lat.locallib.api.AuthenticatedRequest;
import sal.lat.locallib.api.Depaginator;

public class Dashboard extends AbstractRequest<Contact[]> implements AuthenticatedRequest<Contact[]> {

    public Dashboard(){
        this("");
    }

    protected Dashboard(String subEndpoint) { // constructor for sub endpoints ( /canceled, /released, etc.)
        super(
                "/api/dashboard/" + subEndpoint,
                HttpMethod.GET,
                new Depaginator<>(Contact[].class, "contact_list")
        );
    }
}
