package sal.lat.locallib.api;

import com.google.gson.JsonObject;
import com.mashape.unirest.http.HttpMethod;

import java.util.Map;

interface Request<T> {

    String getUrl();

    HttpMethod getMethod();

    String getPath();

    Map<String, Object> getParams();

    boolean isPaginated();

    ResponseDataHandler<T> getDataHandler();
}
