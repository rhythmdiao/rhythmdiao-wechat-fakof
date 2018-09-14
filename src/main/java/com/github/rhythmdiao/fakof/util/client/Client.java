package com.github.rhythmdiao.fakof.util.client;

/**
 * @author rhyth
 */
public interface Client {
    String execute(String requestURI, HttpProperty httpProperty);
}
