package sal.lat.locallib.api;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import sal.lat.locallib.api.ResponseDataHandler;

public class DataDeserializer<T> implements ResponseDataHandler<T> {

    public static Gson gson;

    static {
        gson = new Gson(); // to be extended
    }

    protected final Class<T> resultClass;

    public DataDeserializer(Class<T> resultClass){ this.resultClass = resultClass; }

    @Override
    public T unpack(JsonObject data){ return deser(data); }

    protected T deser(JsonElement data){ return gson.fromJson(data, resultClass); }
}