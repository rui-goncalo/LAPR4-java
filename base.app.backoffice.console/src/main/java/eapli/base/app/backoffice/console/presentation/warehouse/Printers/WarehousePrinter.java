package eapli.base.app.backoffice.console.presentation.warehouse.Printers;

import eapli.base.warehousemanagement.domain.Warehouse;
import eapli.framework.visitor.Visitor;

public class WarehousePrinter implements Visitor<Warehouse> {

    @Override
    public void visit(Warehouse visit) {
        System.out.printf("%d | %d | %s | %.1f | %.1f | %.1f | %s",
                visit.getVersion(),
                visit.getId(),
                visit.getName(),
                visit.getLength(),
                visit.getWidth(),
                visit.getSquare(),
                visit.getUnit());
    }
}