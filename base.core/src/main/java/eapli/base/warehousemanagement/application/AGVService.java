package eapli.base.warehousemanagement.application;

import eapli.base.ordermanagement.domain.NewOrder;
import eapli.base.warehousemanagement.domain.AGVDock;
import eapli.framework.application.ApplicationService;

import java.util.List;

@ApplicationService
public class AGVService {
    public void printListAGVs (List<AGVDock> agvDockList) {
        for (AGVDock a : agvDockList) {
            System.out.println("AGV ID: " + a.getId() +
                    "\nDescription: " + a.getDescription() +
                    "\nState: " + a.getState() + "\n");
        }
    }
}
