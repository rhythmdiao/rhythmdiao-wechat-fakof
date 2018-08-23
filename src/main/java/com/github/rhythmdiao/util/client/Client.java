package com.github.rhythmdiao.util.client;

/**
 * @author rhyth
 */
public interface Client {
    String execute(String requestURI, HttpProperty httpProperty);
}
