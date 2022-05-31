
import java.util.ArrayList;
/*
 * Class to implement SearchWorklist as a Stack and a Queue.
 * You can use any built-in Java collections for this class.
 */

class StackWorklist implements SearchWorklist {

	class Node {
        Square value;
        Node next;

        public Node(Square value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

	public StackWorklist() {
		this.size = 0;
		this.front = null;
	}

	public void add(Square c) {
		this.front = new Node(c, this.front);
	}

	public Square remove() {
		Square oldFront = null;
		if(this.front != null) {
			oldFront = this.front.value;
			this.front = this.front.next;
		}
		return oldFront;
	}

	public boolean isEmpty() {
		return this.front == null;
	}
}

class QueueWorklist implements SearchWorklist {

	ArrayList<Square> contents;

	public QueueWorklist() {
		this.contents = new ArrayList<Square>();
	}

	public void add(Square c) {
		this.contents.add(this.contents.size(), c);
	}

	public Square remove() {
		return this.contents.remove(0);
	}

	public boolean isEmpty() {
		return this.contents.size() == 0;
	}
}

public interface SearchWorklist {
	void add(Square c);
	Square remove();
	boolean isEmpty();
}
