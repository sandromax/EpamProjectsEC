package org.sandromax.fastest.controller;

import org.sandromax.fastest.domain.test.Issue;
import org.sandromax.fastest.model.dao.imp.TestDao;
import org.sandromax.fastest.services.TestLoader;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet("/upload")
@MultipartConfig
public class UploadServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse resp) throws ServletException, IOException {
        String description = request.getParameter("description"); // Retrieves <input type="text" name="description">
        System.out.println("description: "+description);

        Part filePart = request.getPart("file"); // Retrieves <input type="file" name="file">
//        System.out.println("filePart: "+filePart.getName()+"\nsize: "+filePart.getSize()+"\ninputStream: "+filePart.getInputStream());

//        String fileName; // MSIE fix.
//        fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
//        System.out.println("fileNAme: "+fileName);

        InputStream fileContent = filePart.getInputStream();

        LinkedList<String> fileStrings = new LinkedList<>();

        // ... (do your job here)
        try(BufferedReader br = new BufferedReader(new InputStreamReader(fileContent))) {
//            String result = br.lines().collect(Collectors.joining("\n"));
//            System.out.println("Your file: \n"+result);

            String line = br.readLine();
            while (line != null) {
                fileStrings.add(line);
                line = br.readLine();
            }
        }
        System.out.println("number of strings: " + fileStrings.size());

        TestLoader testLoader = new TestLoader();
        HashSet<Issue> issues = testLoader.handle(fileStrings);
        System.out.println("number of issues: " + issues.size());

        TestDao testDao = new TestDao();
        testDao.addIssues(issues);


    }
}
