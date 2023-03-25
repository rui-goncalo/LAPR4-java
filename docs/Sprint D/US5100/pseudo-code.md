# US5100
=======================================

# 1. Requirements

**Title -** As Project Manager, I want that the team to develop and integrate the others components/parts of the AGV digital twin (e.g.: movement, obstacle sensors, control unit).

**Acceptance criteria -** In conformity with SCOMP guidelines.

# Algorithms:

### Breadth first search
Given a matrix, a current position and a desired position, the method creates a boolean matrix to store all the visited
locations, and starts by marking the current location as visited. Then, from the starting position, it attempts to go
up, down, right and left, adding to a queue, if any of those positions are valid. When a new position is added to the queue,
it is marked as visited on the boolean matrix. Every queue item contains the path taken until said item was reached.