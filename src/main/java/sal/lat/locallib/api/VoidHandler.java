package sal.lat.locallib.api;

import com.google.gson.JsonObject;

public class VoidHandler implements ResponseDataHandler<Void> {

    public Void unpack(JsonObject data){ return null; }
}
