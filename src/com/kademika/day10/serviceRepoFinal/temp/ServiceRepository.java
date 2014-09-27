package com.kademika.day10.serviceRepoFinal.temp;

import com.kademika.day10.serviceRepoFinal.annotations.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky on 30.06.14.
 */
public class ServiceRepository<T extends Service> {

    private List<T> services;

    public ServiceRepository() {
        services = new ArrayList<T>();
    }

    public void addLast(T service) {
        services.add(service);
    }

    public T getLast() {
        return services.get(services.size() - 1);
    }

    public void removeLast() {
        services.remove(services.size() - 1);
    }

    public int getSize() {
        return services.size();
    }
}

