package sal.lat.locallib.api;

import com.google.gson.JsonObject;

import java.lang.reflect.Array;
import java.util.List;
import java.util.stream.Stream;

public class Depaginator<T> extends DataFieldDeserializer<T[]> {

    public Depaginator(Class<T[]> resultClass, String fieldName){ super(resultClass, fieldName); }

    T[] depaginate(List<JsonObject> dataPages){
        Class<T> c = (Class<T>) resultClass.getComponentType();

        return dataPages.stream()
                .map(super::unpack)
                .flatMap(Stream::of)
                .toArray(i -> (T[]) Array.newInstance(c, i));
    }
}
