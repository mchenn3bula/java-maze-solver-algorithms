package project3;

public class PossibleLocationsQueue implements PossibleLocations {

	private Location [] q;
	private int capacity, head, tail;
	//constructors
	public PossibleLocationsQueue () {
		this.capacity = 6;
		this.q = new Location[capacity];
		this.head = 0;
		this.tail = 0;
	}
	public PossibleLocationsQueue (int capacity) {
		this.capacity = capacity;
		this.q = new Location[capacity];
		this.head = 0;
		this.tail = 0;
	}
	
    /**
    * Add a Location object to this collection.
    * @param s object to be added
    * @throws IllegalArgumentException if the given location is a wall
    * @throws NullPointerException if the given location is null
    */
    public void add( Location s ) {
    	try {
    		// case when the array is full
    		if (tail == capacity - 1) { 
    			capacity = capacity + 6;
    			Location [] temp = new Location[capacity];
    			for (int i = 0; i < q.length; i++) {
    				 temp[i] = q[i];
    			}
    			q = temp;
    		}
    		q[tail] = s;
    		tail++;
    	} catch (IllegalArgumentException ex) {
    	}
	}

    /**
     * Remove the next object from this collection. The specific
     * item returned is determined by the underlying structure
     * by which this collection is represented.
     * @return the next object, or null if set is empty
     */
    public Location remove() {
    	if (isEmpty())
    		return null;
    	capacity --;
    	tail--;
    	Location temp = q[head];
    	Location [] templist = new Location[capacity];
    	for (int i = 1; i <= tail; i++) {
    		templist[i-1] = q[i];
    	}
    	q = templist;
		return temp;
	}

    /**
     * Determines if this collection is empty or not.
     * @return  true, if set is empty, false, otherwise.
     */
    public boolean isEmpty() {
		return q.length == 0 || q[0] == null;
	}
}
