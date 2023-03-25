package eapli.base.warehousemanagement.application;

import eapli.base.infrastructure.persistence.PersistenceContext;
import eapli.base.warehousemanagement.domain.*;
import eapli.base.warehousemanagement.repositories.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;

public class ParserJSON {
    private static final WarehouseRepository warehouseRepository = PersistenceContext.repositories().warehouses();
    private static final WAisleRepository wAisleRepository = PersistenceContext.repositories().waisles();
    private static final WRowRepository wRowRepository = PersistenceContext.repositories().wrows();
    private static final AGVDocksRepository agvDocksRepository = PersistenceContext.repositories().agvdocks();
    private static final CoordinatesRepository coordinatesRepository = PersistenceContext.repositories().coordinates();

    public static Warehouse parseWarehouse() {
        JSONParser parser = new JSONParser();

        try (Reader reader = new FileReader("data/warehouse.json")) {

            JSONObject warehouse = (JSONObject) parser.parse(reader);

            Warehouse newWarehouse = new Warehouse(
                    (String) warehouse.get("Warehouse"),
                    (Long) warehouse.get("Length"),
                    (Long) warehouse.get("Width"),
                    (Long) warehouse.get("Square"),
                    (String) warehouse.get("Unit"));

            JSONArray aisles = (JSONArray) warehouse.get("Aisles");

            for (Object oAisle : aisles) {
                JSONObject aisle = (JSONObject) oAisle;

                JSONObject beginAisle = (JSONObject) aisle.get("begin");
                JSONObject endAisle = (JSONObject) aisle.get("end");
                JSONObject depthAisle = (JSONObject) aisle.get("depth");

                WAisle newAisle = new WAisle(
                        (String) aisle.get("accessibility"),
                        coordinatesRepository.save(new Coordinates(((Long) beginAisle.get("lsquare")).intValue(), ((Long) beginAisle.get("wsquare")).intValue())),
                        coordinatesRepository.save(new Coordinates(((Long) endAisle.get("lsquare")).intValue(), ((Long) endAisle.get("wsquare")).intValue())),
                        coordinatesRepository.save(new Coordinates(((Long) depthAisle.get("lsquare")).intValue(), ((Long) depthAisle.get("wsquare")).intValue())));

                newWarehouse.getwAisles().add(wAisleRepository.save(newAisle));

                JSONArray rows = (JSONArray) aisle.get("rows");

                for (Object oRow : rows) {
                    JSONObject row = (JSONObject) oRow;

                    JSONObject beginRow = (JSONObject) row.get("begin");
                    JSONObject endRow = (JSONObject) row.get("end");

                    WRow newRow = new WRow(
                            ((Long) row.get("shelves")).intValue(),
                            coordinatesRepository.save(new Coordinates(((Long) beginRow.get("lsquare")).intValue(), ((Long) beginRow.get("wsquare")).intValue())),
                            coordinatesRepository.save(new Coordinates(((Long) endRow.get("lsquare")).intValue(), ((Long) endRow.get("wsquare")).intValue())));

                    newAisle.getwRows().add(wRowRepository.save(newRow));
                }
            }

            JSONArray agvDocks = (JSONArray) warehouse.get("AGVDocks");

            for (Object oAGVDocks : agvDocks) {
                JSONObject agvDock = (JSONObject) oAGVDocks;

                JSONObject beginAGVDock = (JSONObject) agvDock.get("begin");
                JSONObject endAGVDock = (JSONObject) agvDock.get("end");
                JSONObject depthAGVDock = (JSONObject) agvDock.get("depth");
                JSONObject baseLocationAGVDock = (JSONObject) agvDock.get("baseLocation");

                AGVDock newAGVDock = new AGVDock(
                        (String) agvDock.get("Id"),
                        (String) agvDock.get("accessibility"),
                        coordinatesRepository.save(new Coordinates(((Long) beginAGVDock.get("lsquare")).intValue(), ((Long) beginAGVDock.get("wsquare")).intValue())),
                        coordinatesRepository.save(new Coordinates(((Long) endAGVDock.get("lsquare")).intValue(), ((Long) endAGVDock.get("wsquare")).intValue())),
                        coordinatesRepository.save(new Coordinates(((Long) depthAGVDock.get("lsquare")).intValue(), ((Long) depthAGVDock.get("wsquare")).intValue())),
                        (String) agvDock.get("description"),
                        (String) agvDock.get("model"),
                        BigDecimal.valueOf(((Long) agvDock.get("carryWeight"))).floatValue(),
                        BigDecimal.valueOf(((Long) agvDock.get("carryWeight"))).floatValue(),
                        coordinatesRepository.save(new Coordinates(((Long) baseLocationAGVDock.get("lsquare")).intValue(), ((Long) baseLocationAGVDock.get("wsquare")).intValue())),
                        (String) agvDock.get("state"),
                        ((Long) agvDock.get("currentPosX")).intValue(),
                        ((Long) agvDock.get("currentPosY")).intValue());

                newWarehouse.getAgvDocks().add(agvDocksRepository.save(newAGVDock));
            }

            return warehouseRepository.save(newWarehouse);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}