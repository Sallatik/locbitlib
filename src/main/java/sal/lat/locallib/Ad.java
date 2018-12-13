package sal.lat.locallib;

import javax.naming.directory.InvalidAttributeValueException;
import java.util.Date;

public class Ad {

    public enum TradeType{
        LOCAL_SELL, LOCAL_BUY, ONLINE_SELL, ONLINE_BUY;
    }

    public boolean isVisible() {
        return data.visible;
    }

    public boolean isHiddenByOpeningHours() {
        return data.hidden_by_opening_hours;
    }

    public String getLocationString() {
        return data.location_string;
    }

    public double getTempPriceAsDouble() { return Double.parseDouble(this.getTempPrice()); }
    public String getCountrycode() {
        return data.countrycode;
    }

    public String getCity() {
        return data.city;
    }

    public TradeType getTradeType() {
        return data.trade_type;
    }

    public String getOnlineProvider() {
        return data.online_provider;
    }

    public String getFirstTimeLimitBtc() {
        return data.first_time_limit_btc;
    }

    public String getVolumeCoefficientBtc() {
        return data.volume_coefficient_btc;
    }

    public boolean isSmsVerificationRequired() {
        return data.sms_verification_required;
    }

    public String getReferenceType() {
        return data.reference_type;
    }

    public String getDisplayReference() {
        return data.display_reference;
    }

    public String getCurrency() {
        return data.currency;
    }

    public double getLat() {
        return data.lat;
    }

    public double getLon() {
        return data.lon;
    }

    public String getMinAmount() {
        return data.min_amount;
    }

    public String getMaxAmount() {
        return data.max_amount;
    }

    public String getMaxAmountAvailable() {
        return data.max_amount_available;
    }

    public String getLimitToFiatAmounts() {
        return data.limit_to_fiat_amounts;
    }

    public long getAdId() {
        return data.ad_id;
    }

    public String getTempPrice() {
        return data.temp_price;
    }

    public String getTempPriceUsd() {
        return data.temp_price_usd;
    }

    public boolean isFloating() {
        return data.floating;
    }

    public Profile getProfile() {
        return data.profile;
    }

    public int getRequireFeedbackScore() {
        return data.require_feedback_score;
    }

    public int getRequireTradeVolume() {
        return data.require_trade_volume;
    }

    public boolean isRequireTrustedByAdvertiser() {
        return data.require_trusted_by_advertiser;
    }

    public int getPaymentWindowMinutes() {
        return data.payment_window_minutes;
    }

    public String getBankName() {
        return data.bank_name;
    }

    public boolean isTrackMaxAmount() {
        return data.track_max_amount;
    }

    public String getAtmModel() {
        return data.atm_model;
    }

    public String getPriceEquation() {
        return data.price_equation;
    }

    public String getOpeningHours() {
        return data.opening_hours;
    }

    public String getAccountInfo() {
        return data.account_info;
    }

    public class Profile{
        public String getUsername() {
            return username;
        }

        public String getName() {
            return name;
        }

        public Date getLastOnline() {
            return last_online;
        }

        public String getTradeCount() {
            return trade_count;
        }

        public int getFeedbackScore() {
            return feedback_score;
        }

        private String username;
        private String name;
        private Date last_online;
        private String trade_count;
        private int feedback_score;
    }

    private Data data;
    private Actions actions;

    private static class Data {
        private boolean visible;
        private boolean hidden_by_opening_hours;
        private String location_string;
        private String countrycode;
        private String city;
        private TradeType trade_type;
        private String online_provider;
        private String first_time_limit_btc;
        private String volume_coefficient_btc;
        private boolean sms_verification_required;
        private String reference_type;
        private String display_reference;
        private String currency;
        private double lat;
        private double lon;
        private String min_amount;
        private String max_amount;
        private String max_amount_available;
        private String limit_to_fiat_amounts;
        private long ad_id;
        private String temp_price;
        private String temp_price_usd;
        private boolean floating;
        private Profile profile;
        private int require_feedback_score;
        private int require_trade_volume;
        private boolean require_trusted_by_advertiser;
        private int payment_window_minutes;
        private String bank_name;
        private boolean track_max_amount;
        private String atm_model;
        private String price_equation;
        private String opening_hours;
        private String account_info;
    }

    public String getPublicView() {
        return actions.public_view;
    }

    public String getChangeForm() {
        return actions.change_form;
    }

    public String getHtmlEdit() {
        return actions.html_edit;
    }

    private static class Actions{
        private String public_view;
        private String change_form;
        private String html_edit;
    }
}
