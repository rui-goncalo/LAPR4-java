package eapli.base.app.backoffice.console.presentation.warehouse.Printers;

import eapli.base.warehousemanagement.domain.AGVDock;
import eapli.framework.visitor.Visitor;

public class AGVDockPrinter implements Visitor<AGVDock> {
    @Override
    public void visit(AGVDock obj) {
        System.out.printf("%d | %s | %s | %s | %s | %s",
                obj.getVersion(),
                obj.getId(),
                obj.getAccessibility(),
                obj.getBegin(),
                obj.getEnd(),
                obj.getDepth());
    }
}