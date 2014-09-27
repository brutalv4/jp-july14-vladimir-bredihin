package com.kademika.day10.serviceRepoFinal;

import com.kademika.day10.serviceRepoFinal.annotations.InitService;
import com.kademika.day10.serviceRepoFinal.annotations.Service;

/**
 * Created by Ricky on 20.07.14.
 */
@Service
public class SomeService {

    @InitService
    public void init() {
        System.out.println("done!");
    }
}
