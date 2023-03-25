package eapli.base.app.backoffice.console.presentation.warehouse.Printers;

import eapli.base.warehousemanagement.domain.WRow;
import eapli.framework.visitor.Visitor;

public class WRowPrinter implements Visitor<WRow> {
    @Override
    public void visit(WRow obj) {
        System.out.printf("%d | %d | %d | %s | %s",
                obj.getVersion(),
                obj.getId(),
                obj.getShelves(),
                obj.getBegin(),
                obj.getEnd());
    }
}