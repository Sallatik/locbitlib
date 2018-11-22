package sal.lat.locallib.api.endpoints;

import com.mashape.unirest.http.HttpMethod;
import sal.lat.locallib.api.AbstractRequest;
import sal.lat.locallib.api.AuthenticatedRequest;
import sal.lat.locallib.api.VoidHandler;

public class ContactMessagePost extends AbstractRequest<Void> implements AuthenticatedRequest<Void> {

    public ContactMessagePost(long contactId){
        super(
                "/api/contact_message_post/" + contactId + "/",
                HttpMethod.POST,
                new VoidHandler()
        );
    }

    public ContactMessagePost setMsg(String msg){
        addParameter("msg", msg);
        return this;
    }
}
