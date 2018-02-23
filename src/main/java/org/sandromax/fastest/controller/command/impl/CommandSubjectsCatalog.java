package org.sandromax.fastest.controller.command.impl;

import org.sandromax.fastest.controller.command.Command;
import org.sandromax.fastest.controller.command.CommandList;
//import org.sandromax.fastest.controller.command.Receiver;
import org.sandromax.fastest.domain.test.Subject;
import org.sandromax.fastest.model.dao.imp.TestDao;

import static org.sandromax.fastest.controller.until.constants.Pages.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CommandSubjectsCatalog implements Command {

    @Override
    public String execute(HttpServletRequest request) {
        String page = SUBJECTS_CATALOG;

        TestDao testDao = new TestDao();
        List<Subject> subjects = testDao.getAllSubjects();

        System.out.println("CommandSubjectCatalpg");
        for(Subject s : subjects) {
            System.out.println("(id)" + s.getId() + " (name)" + s.getName() + " (lang)" +s.getLang());
        }

        request.setAttribute("list", subjects);

        return page;
    }

}
