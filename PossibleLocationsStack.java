package project3;

public class PossibleLocationsStack implements PossibleLocations{
	
	// create a nested list for the stack
	private class Node {
        Location data;
        Node next;
    }
	
	//create reference
	Node top;
	
	//constructor
	PossibleLocationsStack() {
		this.top = null;
	}
	
    /**
    * Add a Location object to this collection.
    * @param s object to be added
    * @throws IllegalArgumentException if the given location is a wall
    */
	@Override
	public void add(Location s) {
		try {
			Node temp = new Node();
			temp.data = s;
			temp.next = top;
			top = temp;
		} catch (IllegalArgumentException ex) {
		}
	}

    /**
     * Remove the next object from this collection. The specific
     * item returned is determined by the underlying structure
     * by which this collection is represented.
     * @return the next object, or null if set is empty
     */
	@Override
	public Location remove() {
		if (isEmpty()) 
			return null;
		Location temp = top.data;
		top = (top).next;
		return temp;
	}

    /**
     * Determines if this collection is empty or not.
     * @return  true, if set is empty, false, otherwise.
     */
	@Override
	public boolean isEmpty() {
		return top == null || top.data == null;
	}

}
