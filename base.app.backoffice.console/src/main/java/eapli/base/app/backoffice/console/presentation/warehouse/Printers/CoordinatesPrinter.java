package eapli.base.app.backoffice.console.presentation.warehouse.Printers;

import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.framework.visitor.Visitor;

public class CoordinatesPrinter implements Visitor<Coordinates> {
    @Override
    public void visit(Coordinates obj) {
        System.out.printf("%d | %d | %d | %d",
                obj.getVersion(),
                obj.getId(),
                obj.getlSquare(),
                obj.getwSquare());
    }
}