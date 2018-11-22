package sal.lat.locallib.api;

import com.google.gson.JsonObject;

public class ArrayUnwrapper<T> implements ResponseDataHandler<T> {

    private DataFieldDeserializer<T[]> deserializer;

    public ArrayUnwrapper(Class<T[]> resultClass, String fieldName) {
        deserializer = new DataFieldDeserializer<>(resultClass, fieldName);
    }

    @Override
    public T unpack(JsonObject data){
        return deserializer.unpack(data)[0];
    }
}