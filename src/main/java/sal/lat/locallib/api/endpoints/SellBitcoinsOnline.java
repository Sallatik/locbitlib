package sal.lat.locallib.api.endpoints;

import sal.lat.locallib.Ad;
import sal.lat.locallib.api.AnonymousRequest;

public class SellBitcoinsOnline extends GetAdsRequest implements AnonymousRequest<Ad[]> {
    public SellBitcoinsOnline(String currency){
        super("/sell-bitcoins-online/" + currency + "/.json");
    }
}
