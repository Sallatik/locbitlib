package sal.lat.locallib.api.endpoints;

import com.mashape.unirest.http.HttpMethod;
import sal.lat.locallib.api.AbstractRequest;
import sal.lat.locallib.api.AuthenticatedRequest;
import sal.lat.locallib.api.Depaginator;
import sal.lat.locallib.api.Message;

public class ContactMessages extends AbstractRequest<Message[]> implements AuthenticatedRequest<Message[]> {

    public ContactMessages(long contactId){
        super(
                "/api/contact_messages/" + contactId + "/",
                HttpMethod.GET,
                new Depaginator<>(Message[].class, "message_list")
        );
    }
}
