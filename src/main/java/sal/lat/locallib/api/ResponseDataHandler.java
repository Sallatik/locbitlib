package sal.lat.locallib.api;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@FunctionalInterface
public interface ResponseDataHandler<T> {
    T unpack(JsonObject data);
}
