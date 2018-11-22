package sal.lat.locallib.api.endpoints;

import com.mashape.unirest.http.HttpMethod;
import sal.lat.locallib.Ad;
import sal.lat.locallib.api.AbstractRequest;
import sal.lat.locallib.api.ArrayUnwrapper;
import sal.lat.locallib.api.AuthenticatedRequest;

public class AdGet extends AbstractRequest<Ad> implements AuthenticatedRequest<Ad> {

    public AdGet(long adId) {
        super(
                "/api/ad-get/" + adId + "/",
                HttpMethod.GET,
                new ArrayUnwrapper<>(Ad[].class, "ad_list")
        );
    }
}