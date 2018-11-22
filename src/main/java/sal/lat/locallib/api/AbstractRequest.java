package sal.lat.locallib.api;

import com.google.gson.JsonObject;
import com.mashape.unirest.http.HttpMethod;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractRequest<T> implements Request<T>{

    public static final String HOST = "https://localbitcoins.com";

    public String getUrl() { return HOST + path; }

    public HttpMethod getMethod() { return method; }

    public String getPath() { return path; }

    public Map<String, Object> getParams() { return params; }

    public ResponseDataHandler<T> getDataHandler() { return dataHandler; }

    public boolean isPaginated(){
        return dataHandler instanceof Depaginator;
    }

    private final String path;
    private final HttpMethod method;
    private final ResponseDataHandler<T> dataHandler;
    private Map<String, Object> params = new HashMap<>();

    protected void addParameter(String name, Object value){
        params.put(name, value);
    }

    protected AbstractRequest(String path, HttpMethod method, ResponseDataHandler<T> dataHandler){
        this.path = path;
        this.method = method;
        this.dataHandler = dataHandler;
    }
}