package sal.lat.locallib.api.endpoints;

import sal.lat.locallib.Ad;
import sal.lat.locallib.api.AuthenticatedRequest;

public class Ads extends GetAdsRequest implements AuthenticatedRequest<Ad[]> {
    public Ads(){
        super("/api/ads/");
    }

    public Ads setVisible(boolean isVisible){
        addParameter("visible", isVisible);
        return this;
    }

    public Ads setCurrency(String currency){
        addParameter("currency", currency);
        return this;
    }

    public Ads setTradeType(Ad.TradeType type){
        addParameter("trade_type", String.valueOf(type));
        return this;
    }

    public Ads setCountryCode(String countryCode){
        addParameter("countrycode", countryCode);
        return this;
    }
}
