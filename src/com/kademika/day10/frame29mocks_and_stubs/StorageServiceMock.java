package com.kademika.day10.frame29mocks_and_stubs;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky on 20.07.14.
 */
public class StorageServiceMock implements StorageService {

    private List<Object> objects;
    private int storeCounter;

    public StorageServiceMock() {
        this.objects = new ArrayList<>();
        storeCounter = 0;
    }

    @Override

    public <T> void store(T object) {
        objects.add(object);
        storeCounter++;
    }

    @Override
    public <T> T getById(Long id) {
        return null;
    }

    @Override
    public <T> List<T> getAll(Class clazz) {
        return (List<T>) new ArrayList<>(objects);
    }

    public int getStoreCounter() {
        return storeCounter;
    }
}
