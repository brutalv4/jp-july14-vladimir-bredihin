package com.kademika.day10.frame05;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ricky on 30.06.14.
 */
public class TrickyLists {

    public static void main(String[] args) {
        List data = new ArrayList();
        List<String> strList = new ArrayList<>();

        data = strList;
        data.add(10);

        String s = strList.get(0);
    }
}
