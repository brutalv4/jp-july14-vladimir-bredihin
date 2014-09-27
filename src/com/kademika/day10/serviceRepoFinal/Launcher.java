package com.kademika.day10.serviceRepoFinal;

/**
 * Created by Ricky on 20.07.14.
 */
public class Launcher {

    public static void main(String[] args) throws Exception{

        ApplicationManager manager = new ApplicationManager();
        manager.getService(SomeService.class);

    }
}
