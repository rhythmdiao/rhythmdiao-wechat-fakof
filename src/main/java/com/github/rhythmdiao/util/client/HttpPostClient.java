package com.github.rhythmdiao.util.client;

import org.apache.http.client.methods.HttpPost;

/**
 * @author rhyth
 */
public class HttpPostClient extends HttpBaseClient {

    public HttpPostClient(String context) {
        super(context);
    }

    public HttpPostClient(String scheme, String context) {
        super(scheme, context);
    }

    @Override
    public String execute(String path, HttpProperty httpProperty) {
        HttpPost httpPost = new HttpPost();
        setURI(httpPost, path);
        addHeader(httpPost, httpProperty);
        addParameter(httpPost, httpProperty);
        return execute(httpPost);
    }
}
