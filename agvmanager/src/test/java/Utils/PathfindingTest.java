package Utils;

import domain.Coordinates;
import org.junit.Test;
import utils.Pathfinding;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class PathfindingTest {
    @Test
    public void pathfindingTest() {
        Pathfinding pathfinding = new Pathfinding();
        List<Coordinates> path;

        int[][] matrix1 = {
                {0, 0},
                {0, 0}
        };

        int[][] matrix2 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] matrix3 = {
                {0, 1, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

        int[][] matrix4 = {
                {0, 1, 0},
                {0, 0, 0},
                {0, 0, 0}
        };

        int[][] matrix5 = {
                {0, 1, 0, 0, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {0, 0, 0, 0, 0}
        };

        path = pathfinding.breadthFirstSearch(matrix1, 0, 0, 1, 1);
        assertEquals(3, path.size());

        path = pathfinding.breadthFirstSearch(matrix2, 0, 0, 2, 2);
        assertEquals(5, path.size());

        path = pathfinding.breadthFirstSearch(matrix3, 0, 0, 0, 2);
        assertEquals(7, path.size());

        path = pathfinding.breadthFirstSearch(matrix4, 0, 0, 0, 2);
        assertEquals(5, path.size());

        path = pathfinding.breadthFirstSearch(matrix5, 0, 0, 2, 2);
        assertEquals(17, path.size());
    }
}