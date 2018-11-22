package sal.lat.locallib;

import java.util.Date;

public class Contact {

    private Data data;

    public class Profile {
        private String username;
        public String getUsername(){ return username; }
    }

    private class Data {
        private Profile buyer;
        private Profile seller;
        private boolean is_buying;
        private boolean is_selling;
        private long contact_id;
        private Date canceled_at;
        private Date escrowed_at;
        private Date funded_at;
        private Date payment_completed_at;
        private Date disputed_at;
        private Date closed_at;

    }

    public Profile getBuyer() {
        return data.buyer;
    }

    public Profile getSeller() {
        return data.seller;
    }

    public boolean isBuying() {
        return data.is_buying;
    }

    public boolean isSelling() {
        return data.is_selling;
    }

    public long getContactId() {
        return data.contact_id;
    }

    public Date getCanceledAt() {
        return data.canceled_at;
    }

    public Date getEscrowedAt() {
        return data.escrowed_at;
    }

    public Date getFundedAt() {
        return data.funded_at;
    }

    public Date getPaymentCompletedAt() {
        return data.payment_completed_at;
    }

    public Date getDisputedAt() {
        return data.disputed_at;
    }

    public Date getClosedAt() {
        return data.closed_at;
    }

}
