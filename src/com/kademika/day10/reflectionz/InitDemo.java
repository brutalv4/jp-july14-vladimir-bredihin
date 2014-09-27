package com.kademika.day10.reflectionz;

import com.kademika.day10.domain.Dog;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ricky on 07.07.14.
 */
public class InitDemo {

    public static void main(String[] args) throws Exception {

        Map<String, Object> data = new HashMap();
        data.put("name", "Spike");
        data.put("age", 5);
        data.put("id", 31L);
        data.put("price", 100D);

        Dog dog1 = ServiceClazz.initClass(Dog.class, data);

        ArrayList<Object> objects = new ArrayList<>();
        objects.add("Spike");
        objects.add(5);

        Dog dog2 = ServiceClazz.initClass(Dog.class, objects);

        Dog dog3 = new Dog();
        Map<String, Object> data1 = new HashMap();
        data1.put("age", 7);

        ServiceClazz.setPrivates(dog3, data1);

        System.out.println(dog3 + " of age " + dog3.getAge());
    }
}
