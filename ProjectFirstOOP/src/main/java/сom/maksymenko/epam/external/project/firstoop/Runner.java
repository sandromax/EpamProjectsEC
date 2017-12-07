package сom.maksymenko.epam.external.project.firstoop;

import сom.maksymenko.epam.external.project.firstoop.controller.Controller;
import сom.maksymenko.epam.external.project.firstoop.model.Model;
import сom.maksymenko.epam.external.project.firstoop.model.entities.Plan;
import сom.maksymenko.epam.external.project.firstoop.model.plans.Business;
import сom.maksymenko.epam.external.project.firstoop.view.View;

public class Runner {
    public static void main(String[] args) {
        Controller program = new Controller();
        program.launch();
    }

}
