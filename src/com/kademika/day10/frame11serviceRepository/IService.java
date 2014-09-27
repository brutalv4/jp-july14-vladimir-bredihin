package com.kademika.day10.frame11serviceRepository;

/**
 * Created by Ricky on 30.06.14.
 */
public interface IService {

    IService createSome();

    void resolveSome();

    void recordSome(IService IService);

    String getSome(IService IService);

    boolean isResolved();
}
