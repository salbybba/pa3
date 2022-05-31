/* Class to implement a Maze solver */

public abstract class MazeSolver {
	
	public static Square solve(Maze maze, SearchWorklist wl) {
		/* Complete this method */
		wl.add(maze.start);
		maze.start.visit();
		while(!wl.isEmpty()) {
			Square current = wl.remove();
			if(current == maze.finish) {
				return current;
			} else {
				goToNextSquare(maze.contents, current, -1, 0, wl);
				goToNextSquare(maze.contents, current, 1, 0, wl);
				goToNextSquare(maze.contents, current, 0, 1, wl);
				goToNextSquare(maze.contents, current, 0, -1, wl);
			}
		}
		return null;
	}

	// Return true if the location of s, offset by rowOffset and colOffset, is in
	// bounds and not a wall, false otherwise
	private static boolean availableNeighbor(Square[][] contents, Square s, int rowOffset, int colOffset) {
		Square neighbor = getNeighbor(contents, s, rowOffset, colOffset);
		return neighbor != null && !neighbor.getIsWall() && !neighbor.isVisited();
	}

	private static Square getNeighbor(Square[][] contents, Square current, int rowOffset, int colOffset) {
		if(current.getRow() + rowOffset >= 0 && current.getRow() + rowOffset < contents.length
		&& current.getCol() + colOffset >= 0 && current.getCol() + colOffset < contents.length) {
				return contents[current.getRow() + rowOffset][current.getCol() + colOffset];
		} else {
			return null;
		}
	}

	private static void goToNextSquare(Square[][] contents, Square current, int rowOffset, int colOffset, SearchWorklist wl) {
		if(availableNeighbor(contents, current, rowOffset, colOffset)) {
			Square neighbor = getNeighbor(contents, current, rowOffset, colOffset);
			neighbor.visit();
			neighbor.setPrevious(current);
			wl.add(neighbor);
		}
	}
}
