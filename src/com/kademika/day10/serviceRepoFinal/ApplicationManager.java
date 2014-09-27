package com.kademika.day10.serviceRepoFinal;

import com.kademika.day10.serviceRepoFinal.annotations.InitService;
import com.kademika.day10.serviceRepoFinal.annotations.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Created by Ricky on 20.07.14.
 */
public class ApplicationManager<T> {

    private List<T> services;

    public ApplicationManager() {
        this.services = new ArrayList<T>();
    }

    public static <T> T initClass(Class aClass, Map<String, Object> data)
            throws Exception {
        Constructor ctor = null;

        for (Constructor constructor : aClass.getConstructors()) {
            ctor = constructor;
            if (ctor.getGenericParameterTypes().length == 0) {
                break;
            }
        }

        T obj = (T) ctor.newInstance();

        for (Map.Entry entry : data.entrySet()) {
            String methodName = entry.getKey().toString();
            methodName = "set" + methodName.substring(0, 1).toUpperCase() + methodName.substring(1,
                    methodName.length()).toLowerCase();

            Class[] clazzez = new Class[]{entry.getValue().getClass()};

            Method method = obj.getClass().getMethod(methodName, clazzez);
            method.invoke(obj, entry.getValue());
        }

        return obj;
    }

    public static <T> T initClass(Class aClass, List<Object> data) throws Exception {

        Constructor ctor = null;
        Class[] initArgs = new Class[data.size()];
        Object[] objects = data.toArray();

        for (int i = 0; i <= objects.length - 1; i++) {
            initArgs[i] = objects[i].getClass();
        }

        for (Constructor constructor : aClass.getConstructors()) {
            ctor = constructor;
            if (Arrays.equals(ctor.getGenericParameterTypes(), initArgs)) {
                break;
            }
        }

        T obj = (T) ctor.newInstance(objects);

        return obj;
    }

    public static void setPrivates(Object o, Map<String, Object> data) {

        for (Map.Entry entry : data.entrySet()) {
            try {
                Field field = o.getClass().getDeclaredField((String) entry.getKey());
                field.setAccessible(true);
                field.set(o, entry.getValue());
            } catch (NoSuchFieldException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

    }

    public static void printClassInfo(Class aClass) {
        Class tmp = aClass;
        // name, simplename
        do {
            System.out.println("Name: " + tmp.getName());
            System.out.println("Simple name: " + tmp.getSimpleName());
            tmp = tmp.getSuperclass();
            System.out.println();
        } while (tmp != null);
    }

    public static void printClassMethods(Class aClass) {
        Class tmp = aClass;
        // name, simplename
        do {
            System.out.println("Constructors:");
            for (Constructor constructor : tmp.getConstructors()) {
                System.out.println(constructor.toGenericString());
            }
            System.out.println();

            System.out.println("Methods:");
            for (Method method : tmp.getMethods()) {
                System.out.println(method.toGenericString());
            }
            System.out.println();

            tmp = tmp.getSuperclass();
        } while (tmp != null);
    }

    public static void printClassFields(Class aClass) {
        Class tmp = aClass;
        do {
            System.out.println("All fields of " + tmp.getSimpleName() + ".class");
            for (Field field : tmp.getDeclaredFields()) {
                System.out.println(field.getName());
            }
            System.out.println();

            tmp = tmp.getSuperclass();
        } while (tmp != null);
    }

    public List<T> getServices() {
        return new ArrayList<>(services);
    }

    public void addLastService(Class aClass) throws Exception {

    }

    public T getLastService() {
        return services.get(services.size() - 1);
    }

    public T getService(Class aClass) throws Exception {
        T service;
        if (aClass.isAnnotationPresent(Service.class)) {
            service = (T) aClass.newInstance();
        } else {
            throw new IllegalArgumentException();
        }

        runInitServiceMethod(service);

        return service;
    }

    public void doSomething(T service) {
        System.out.println("something =)");
    }

    /**
     * run methods with InitService mark
     */
    public void runInitServiceMethod(T service) {
        for (Method method : service.getClass().getMethods()) {
            if (method.isAnnotationPresent(InitService.class)) {
                try {
                    method.invoke(service, new Class[0]);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
