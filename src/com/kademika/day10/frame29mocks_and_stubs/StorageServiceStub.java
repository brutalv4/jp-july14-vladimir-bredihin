package com.kademika.day10.frame29mocks_and_stubs;

import java.util.List;

/**
 * Created by Ricky on 20.07.14.
 */
public class StorageServiceStub implements StorageService {

    @Override
    public <T> void store(T object) {

    }

    @Override
    public <T> T getById(Long id) {
        return null;
    }

    @Override
    public <T> List<T> getAll(Class clazz) {
        return null;
    }
}
