package sal.lat.locallib.api.endpoints;

import sal.lat.locallib.Ad;
import sal.lat.locallib.api.AnonymousRequest;

public class BuyBitcoinsOnline extends GetAdsRequest implements AnonymousRequest<Ad[]> {

    public BuyBitcoinsOnline(String currency){
        super("/buy-bitcoins-online/" + currency + "/.json");
    }
}
