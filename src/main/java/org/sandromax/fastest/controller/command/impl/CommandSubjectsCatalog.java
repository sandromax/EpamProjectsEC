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
//    private Receiver receiver;
//    public CommandSubjectsCatalog(Receiver receiver) {
//        this.receiver = receiver;
//    }
    @Override
    public String execute(HttpServletRequest request) {
        String page = SUBJECTS_CATALOG;

        TestDao testDao = new TestDao();
        List<Subject> subjects = testDao.getAllSubjects();

        for(Subject s : subjects) {
            System.out.println("(id)" + s.getId() + " (name)" + s.getName() + " (lang)" +s.getLang());
        }

        request.setAttribute("list", subjects);

        return page;

//        System.out.println("Going to catalog of the subjects");
//        receiver.action(CommandList.SUBJECTS_CATALOG);
    }

}
