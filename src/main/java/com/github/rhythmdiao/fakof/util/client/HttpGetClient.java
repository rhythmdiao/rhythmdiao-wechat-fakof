package com.github.rhythmdiao.fakof.util.client;

import org.apache.http.client.methods.HttpGet;

/**
 * @author rhyth
 */
public class HttpGetClient extends HttpBaseClient {

    public HttpGetClient(String context) {
        super(context);
    }

    public HttpGetClient(String scheme, String context) {
        super(scheme, context);
    }

    @Override
    public String execute(String path, HttpProperty httpProperty) {
        HttpGet httpGet = new HttpGet();
        setURI(httpGet, path);
        addHeader(httpGet, httpProperty);
        return execute(httpGet);
    }
}
