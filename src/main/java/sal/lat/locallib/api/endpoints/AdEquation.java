package sal.lat.locallib.api.endpoints;

import com.mashape.unirest.http.HttpMethod;
import sal.lat.locallib.api.AbstractRequest;
import sal.lat.locallib.api.AuthenticatedRequest;
import sal.lat.locallib.api.VoidHandler;

public class AdEquation extends AbstractRequest<Void> implements AuthenticatedRequest<Void> {
    public AdEquation(long adId){
        super(
                "/api/ad-equation/"+ adId +"/",
                HttpMethod.POST,
                new VoidHandler()
        );
    }

    public AdEquation setPriceEquation(String priceEquation){
        addParameter("price_equation", priceEquation);
        return this;
    }
}
