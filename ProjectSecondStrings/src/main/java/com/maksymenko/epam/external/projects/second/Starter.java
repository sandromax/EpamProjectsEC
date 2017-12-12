package com.maksymenko.epam.external.projects.second;

import com.maksymenko.epam.external.projects.second.controller.FileWorker;

import java.util.LinkedList;
import java.util.List;

public class Starter {
    public static void main(String[] args) {

        List<String> list = new LinkedList<>();

        FileWorker fw = new FileWorker();

        list = fw.read("src/main/resources/30.txt");

//        System.out.println(list);
//        System.out.println("Strings in list " + list.size());

        System.out.println(fw.readLikeOneString("src/main/resources/30.txt"));
    }
}
