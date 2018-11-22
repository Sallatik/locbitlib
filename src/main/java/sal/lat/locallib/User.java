package sal.lat.locallib;

import java.util.Date;

public class User {

    public String getUsername() {
        return username;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public int getTradingPartnersCount() {
        return trading_partners_count;
    }

    public int getFeedbacksUnconfirmedCount() {
        return feedbacks_unconfirmed_count;
    }

    public String getTradeVolumeText() {
        return trade_volume_text;
    }

    public boolean isHasCommonTrades() {
        return has_common_trades;
    }

    public String getConfirmedTradeCountText() {
        return confirmed_trade_count_text;
    }

    public int getBlockedCount() {
        return blocked_count;
    }

    public int getFeedbackScore() {
        return feedback_score;
    }

    public int getFeedbackCount() {
        return feedback_count;
    }

    public String getUrl() {
        return url;
    }

    public int getTrustedCount() {
        return trusted_count;
    }

    public Date getIdentityVerifiedAt() {
        return identity_verified_at;
    }

    public int getRealNameVerificationsTrusted() {
        return real_name_verifications_trusted;
    }

    public int getRealNameVerificationsUntrusted() {
        return real_name_verifications_untrusted;
    }

    public int getRealNameVerificationsRejected() {
        return real_name_verifications_rejected;
    }


        private String username;
        private Date created_at;
        private int trading_partners_count;
        private int feedbacks_unconfirmed_count;
        private String trade_volume_text;
        private boolean has_common_trades;
        private String confirmed_trade_count_text;
        private int blocked_count;
        private int feedback_score;
        private int feedback_count;
        private String url;
        private int trusted_count;
        private Date identity_verified_at;
        private int real_name_verifications_trusted;
        private int real_name_verifications_untrusted;
        private int real_name_verifications_rejected;

}
