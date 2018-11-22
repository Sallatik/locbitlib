package sal.lat.locallib.api.endpoints;


import sal.lat.locallib.Ad;
import sal.lat.locallib.api.AbstractRequest;
import sal.lat.locallib.api.Depaginator;

import static com.mashape.unirest.http.HttpMethod.GET;

public abstract class GetAdsRequest extends AbstractRequest<Ad[]> {

    protected GetAdsRequest(String path){
        super(path,
                GET,
                new Depaginator<>( Ad[].class, "ad_list")
        );
    }
}