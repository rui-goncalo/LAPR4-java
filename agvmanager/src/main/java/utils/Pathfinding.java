package utils;

import domain.Coordinates;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Pathfinding {

    private static class QueueItem {
        int row;
        int col;
        int dist;
        List<Coordinates> path;

        public QueueItem(int row, int col, int dist, List<Coordinates> path) {
            this.row = row;
            this.col = col;
            this.dist = dist;
            this.path = path;
        }
    }

    private boolean isValid(int x, int y, int[][] grid, boolean[][] visited) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 0 && !visited[x][y];
    }

    private void addToQueue(Queue<QueueItem> queue, boolean[][] visited, QueueItem p, int x, int y) {
        QueueItem newQueueItem = new QueueItem(p.row + x, p.col + y, p.dist + 1, new ArrayList<>(p.path));
        newQueueItem.path.add(new Coordinates(p.row + x, p.col + y));
        queue.add(newQueueItem);
        visited[p.row + x][p.col + y] = true;
    }

    public List<Coordinates> breadthFirstSearch(int[][] grid, int startX, int startY, int destX, int destY) {
        Queue<QueueItem> queue = new LinkedList<>();
        QueueItem firstItem = new QueueItem(startX, startY, 0, new ArrayList<>());
        firstItem.path.add(new Coordinates(startX, startY));
        queue.add(firstItem);

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            QueueItem p = queue.remove();

            // Check if destination was reached
            if (p.row == destX && p.col == destY) return p.path;

            // Go up
            if (isValid(p.row - 1, p.col, grid, visited)) addToQueue(queue, visited, p, -1, 0);

            // Go down
            if (isValid(p.row + 1, p.col, grid, visited)) addToQueue(queue, visited, p, 1, 0);

            // Go left
            if (isValid(p.row, p.col - 1, grid, visited)) addToQueue(queue, visited, p, 0, -1);

            // Go right
            if (isValid(p.row, p.col + 1, grid, visited)) addToQueue(queue, visited, p, 0, 1);
        }

        return new ArrayList<>();
    }
}