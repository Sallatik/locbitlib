package sal.lat.locallib.api;

import com.google.gson.JsonObject;

public class DataFieldDeserializer<T> extends DataDeserializer<T> {

    private final String fieldName;
    public DataFieldDeserializer(Class<T> resultClass, String fieldName){
        super(resultClass);
        this.fieldName = fieldName;
    }

    @Override
    public T unpack(JsonObject data){ return deser(data.get(fieldName)); }
}
