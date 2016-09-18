package com.learning.service;

/**
 * Created by amits on 18/09/16.
 */
public interface AddonService {
    void cancel(String eventUrl);

    void order(String eventUrl);

    void change(String eventUrl);

    void bind(String eventUrl);

    void unbind(String eventUrl);
}
