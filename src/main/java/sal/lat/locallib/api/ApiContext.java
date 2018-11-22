package sal.lat.locallib.api;

import com.google.gson.JsonObject;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.mashape.unirest.http.HttpMethod.GET;
import static com.mashape.unirest.http.HttpMethod.POST;
import static sal.lat.locallib.api.DataDeserializer.gson;

public class ApiContext {

    public <T> T exec(AnonymousRequest<T> request) throws IOException, LocalBitcoinsException {
        return execute(request);
    }

    protected <T> T execute(Request<T> request) throws IOException, LocalBitcoinsException {

        if (request.isPaginated())
            return executePaginated(request,
                    (Depaginator) request.getDataHandler());
        else {

            Response response = getResponse(request, request.getUrl());
            return request.getDataHandler()
                    .unpack(response.getData());
        }
    }

    private <T> T executePaginated(Request<T> request, Depaginator depaginator) throws LocalBitcoinsException, IOException{
        List<JsonObject> dataPages = new ArrayList<>();
        String url = request.getUrl();
        Response response;

        do {
            response = getResponse(request, url);
            dataPages.add(response.getData());
            if (response.hasNextPage())
                url = response.getNextPage();
        } while(response.hasNextPage());

        return (T) depaginator.depaginate(dataPages);
    }

    protected HttpRequest http(Request<?> r, String url) throws IOException{
        HttpRequestWithBody http = new HttpRequestWithBody(r.getMethod(), url);
        if(http.getHttpMethod() == GET)
            http.queryString(r.getParams());
        else if(http.getHttpMethod() == POST)
            http.fields(r.getParams());
        return http;
    }

    private Response getResponse(Request<?> r, String url) throws IOException {
        try {

            String json = http(r, url)
                    .asString()
                    .getBody();

            System.out.println(json); //!!!
            return gson.fromJson(json, Response.class);

        } catch (UnirestException e){
            throw new IOException("Connection error", e);
        }
    }
}
