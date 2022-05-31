import java.util.ArrayList;

/*
 * Write your JUnit tests here
 * Use the formatMaze() method to get nicer JUnit output
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class TestSolvers {

	/* Helper method to compare two mazes */
	public void checkMaze(SearchWorklist wl, Maze startMaze, String[] expected) {
		Square s = MazeSolver.solve(startMaze, wl);
		if(expected == null) { assertNull(s); }
		else {
			ArrayList<Square> sp = startMaze.storePath();
			String actualStr = formatMaze(startMaze.showSolution(sp));
			String expectedStr = formatMaze(expected);
			assertEquals(expectedStr, actualStr);
		}
	}	

	/* Helper method to format String[] output as String */
	public String formatMaze(String[] arr) {
		String result = "";
		for (String s: arr)
			result += "\n"+s;
		return (result+"\n");
	}

	/* Add your own Worklist tests below */

	/* ************** HINT ******************** 
	 * Use the helper methods to create simple
	 * tests that are easier to debug. 
	 */

	@Test
	public void testStackSolve() {
		StackWorklist swl = new StackWorklist();
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
		Square answer = new Square(1, 2, false);
		answer.visit();
		Square s_finish = MazeSolver.solve(m, swl);
		assertEquals(answer.toString(), s_finish.toString());
	}

	@Test
	public void testQueueSolve() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
		Square answer = new Square(1, 2, false);
		Square q_finish = MazeSolver.solve(m, qwl);
		answer.visit();
		assertEquals(answer.toString(), q_finish.toString());
	}

	@Test
	public void testStackStorePath() {
		StackWorklist swl = new StackWorklist();
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
		String[] stack_answer = new String[] {
			"#___",
            "__F*",
            "S##*",
            "****"
		};
		
		MazeSolver.solve(m, swl);
		ArrayList<Square> path = m.storePath();
	
		assertArrayEquals(stack_answer, m.showSolution(path));
	}

	@Test
	public void testQueueStorePath() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "S##_",
            "____"
        });
		String[] queue_answer = new String[] {
			"#___",
            "**F_",
            "S##_",
            "____"
		};
		
		MazeSolver.solve(m, qwl);
		ArrayList<Square> path = m.storePath();
	
		assertArrayEquals(queue_answer, m.showSolution(path));
	}
	
	@Test
	public void testStackSolveNoSolution() {
		StackWorklist swl = new StackWorklist();
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "####",
            "S___"
        });
		Square s_finish = MazeSolver.solve(m, swl);
		assertEquals(null, s_finish);
	}

	@Test
	public void testQueueSolveNoSolution() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "####",
            "S___"
        });
		Square q_finish = MazeSolver.solve(m, qwl);
		assertEquals(null, q_finish);
	}

	@Test
	public void testStackStorePathNoSolution() {
		StackWorklist swl = new StackWorklist();
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "####",
            "S___"
        });
		MazeSolver.solve(m, swl);
		ArrayList<Square> path = m.storePath();
	
		assertEquals(new ArrayList<>(), path);
	}

	@Test
	public void testQueueStorePathNoSolution() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
            "#___",
            "__F_",
            "####",
            "S___"
        });
		MazeSolver.solve(m, qwl);
		ArrayList<Square> path = m.storePath();
	
		assertEquals(new ArrayList<>(), path);
	}

	@Test
	public void testStackOneStep() {
		StackWorklist swl = new StackWorklist();
		Maze m = new Maze(new String[] {
            "#___",
            "____",
            "_##_",
            "__FS"
        });
		String[] stack_answer = new String[] {
			"#___",
            "____",
            "_##_",
            "__FS"
		};
		
		MazeSolver.solve(m, swl);
		ArrayList<Square> path = m.storePath();
	
		assertArrayEquals(stack_answer, m.showSolution(path));
	}

	@Test
	public void testQueueOneStep() {
		QueueWorklist qwl = new QueueWorklist();
		Maze m = new Maze(new String[] {
            "#___",
            "____",
            "_##_",
            "__FS"
        });
		String[] queue_answer = new String[] {
			"#___",
            "____",
            "_##_",
            "__FS"
		};
		
		MazeSolver.solve(m, qwl);
		ArrayList<Square> path = m.storePath();
	
		assertArrayEquals(queue_answer, m.showSolution(path));
	}
}



