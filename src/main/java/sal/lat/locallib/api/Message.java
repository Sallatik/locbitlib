package sal.lat.locallib.api;

import java.util.Date;

public class Message {

    public class Sender{
        long id;
        String name;
        String username;
        int trade_count;

        public long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getUsername() {
            return username;
        }

        public int getTrade_count() {
            return trade_count;
        }

        public Date getLast_online() {
            return last_online;
        }

        Date last_online;
    }


    public String getMsg() {
        return msg;
    }

    public Sender getSender() {
        return sender;
    }

    public Date getCreatedAt() {
        return created_at;
    }

    public boolean isAdmin() {
        return is_admin;
    }

    private String msg;
    private Sender sender;
    private Date created_at;
    private boolean is_admin;
}
