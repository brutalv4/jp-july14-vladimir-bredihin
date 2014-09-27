package com.kademika.day10.frame29mocks_and_stubs;

import java.util.Map;

/**
 * Created by Ricky on 20.07.14.
 */
public class ServiceClass {

    private StorageService storageService;

    public ServiceClass() {
    }

    public void storeUserData(Map<String, Object> data) {
        storageService.store(new Object());
    }

    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }
}
