package test;

import sal.lat.locallib.api.*;
import sal.lat.locallib.api.endpoints.*;


public class Test {

    static String key = "bd5565c659d234f456628fe914bcd238";
    static String secret = "076e710afe4868f82f3b9989cc1aaa746e9f815268a6fb338e0bdc5ddff9a1f7";
    public static void main(String[] args) throws Exception {
        AuthenticatedApiContext api = new AuthenticatedApiContext(key, secret);
        long id = 32338477;
        api.exec(new ContactMessagePost(id).setMsg("a"));

    }
}