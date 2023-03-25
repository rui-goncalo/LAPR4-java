package eapli.base.app.backoffice.console.presentation.warehouse.Printers;

import eapli.base.warehousemanagement.domain.WAisle;
import eapli.framework.visitor.Visitor;

public class WAislePrinter implements Visitor<WAisle> {

    @Override
    public void visit(WAisle obj) {
        System.out.printf("%d | %d | %s | %s | %s | %s",
                obj.getVersion(),
                obj.getId(),
                obj.getAccessibility(),
                obj.getBegin(),
                obj.getEnd(),
                obj.getDepth());
    }
}