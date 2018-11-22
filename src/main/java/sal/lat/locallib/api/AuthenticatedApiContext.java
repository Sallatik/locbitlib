package sal.lat.locallib.api;

import com.mashape.unirest.request.HttpRequest;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import static com.mashape.unirest.http.HttpMethod.GET;
import static com.mashape.unirest.http.HttpMethod.POST;
import static java.nio.charset.StandardCharsets.UTF_8;

public class AuthenticatedApiContext extends ApiContext {

    public static final String ALGO = "HmacSHA256";

    private final String key;
    private Mac mac;

    public <T> T exec(AuthenticatedRequest<T> request) throws IOException, LocalBitcoinsException{
        return execute(request);
    }

    @Override
    protected HttpRequest http(Request<?> r, String url) throws IOException{
        HttpRequest http = super.http(r, url);
        return sign(http);
    }

    private String nonce(){ return String.valueOf(System.currentTimeMillis()); }

    private String query(HttpRequest request) throws IOException{
        if (request.getHttpMethod() == GET) {
            String query = new URL(request.getUrl()).getQuery();
            return query == null ? "" : query;
        } else if (request.getHttpMethod() == POST) {
            return new String(request
                    .getBody()
                    .getEntity()
                    .getContent().readAllBytes(), UTF_8);
        } else
            throw new RuntimeException("Impossible HTTP method: " + request.getHttpMethod());
    }

    private String path(String url) throws MalformedURLException{
        return new URL(url).getPath();
    }

    private HttpRequest sign(HttpRequest request) throws IOException{

        String nonce = nonce();
        String path = path(request.getUrl());
        String query = query(request);

        System.out.println(path + " " + query); //!!!

        return request
                .header("Apiauth-Key", key)
                .header("Apiauth-Nonce", nonce)
                .header("Apiauth-Signature", createSignature(nonce, path, query));

    }

    private String createSignature(String nonce, String url, String query) {
        mac.reset();
        byte[] message = (nonce + key + url + query).getBytes(UTF_8);
        return bytesToHex(mac.doFinal(message));
    }

    public AuthenticatedApiContext(String key, String secret) throws InvalidKeyException {
        this.key = key;
        try{
            mac = Mac.getInstance(ALGO);
            mac.init(new SecretKeySpec(secret.getBytes(UTF_8), ALGO));
        } catch (NoSuchAlgorithmException e){
            // this never happens
            throw new RuntimeException("AAAAAAAAAAAAAAAAAAAA");
        }
    }

    private static String bytesToHex ( byte[] bytes){
        char[] hexArray = "0123456789ABCDEF".toCharArray();
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars).toUpperCase();
    }

}
