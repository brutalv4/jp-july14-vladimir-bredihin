package com.kademika.day10.frame29mocks_and_stubs;

import java.util.List;

/**
 * Created by Ricky on 20.07.14.
 */
public interface StorageService {

    <T> void store(T object);

    <T> T getById(Long id);

    <T> List<T> getAll(Class clazz);
}
