package com.maksymenko.epam.external.projects.second.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Class can read text from the file and write text to the file
 *
 * @version 1.01 2017-12-11
 * @author Maksymenko Oleksandr
 */
public class FileWorker {
    private List<String> content = new LinkedList<>();

    public FileWorker() {

    }

    public List<String> read(String path) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String read = "";

            while ((read = bufferedReader.readLine()) != null) {
                content.add(read);
            }

            if(content.size() != 0)
                return content;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String readLikeOneString(String path) {
        List<String> list = new LinkedList<>();

        list = read(path);

        StringBuilder builder = new StringBuilder();

        for(String string : list) {
            builder.append(string);
        }

        return builder.toString();

    }
}
