import java.util.ArrayList;
import java.util.Iterator;

/**
 * A generic priority queue implementation that stores elements based on
 * priority levels.
 * 
 * Each element is associated with a priority from 1 (highest) to n (lowest).
 * Internally, elements are grouped into buckets based on their priority.
 * 
 * @param <T> the type of elements stored in the queue
 */
public class GenericPriorityQueue<T> implements Iterable<T> {

	// The main data structure: each index represents a different priority level (0
	// = highest priority)
	private ArrayList<ArrayList<T>> priorityQueue; // (השתמשתי ברעיון המוצע במטלה)
	private int n; // Number of priority levels (from 1 to n)

	/**
	 * Constructs a priority queue with the given number of priority levels.
	 *
	 * @param priority the number of priority levels (must be between 1 and 10)
	 * @throws IllegalArgumentException if priority is not in the range [1, 10]
	 */
	public GenericPriorityQueue(int priority) {

		if (priority < 1 || priority > 10) {
			throw new IllegalArgumentException("Invalid n: must be between 1 and 10");
		}
		this.n = priority;

		priorityQueue = new ArrayList<ArrayList<T>>(n);

		// Initialize each bucket (ArrayList) for each priority level
		for (int i = 0; i < n; i++) {
			priorityQueue.add(new ArrayList<>());
		}
	}

	/**
	 * Validates that the priority value is within the allowed range.
	 *
	 * @param priority the priority to validate
	 * @throws IllegalArgumentException if priority is invalid
	 */
	private void validatePriority(int priority) {
		if (priority < 1 || priority > this.n) {
			throw new IllegalArgumentException("Invalid priority: must be between 1 and " + this.n);
		}
	}

	/**
	 * Adds a new element to the queue with the specified priority.
	 *
	 * @param newElement the element to add
	 * @param priority   the priority level (1 is highest)
	 */
	public void add(T newElement, int priority) {
		validatePriority(priority);
		// Subtract 1 to map logical priority (1..n) to index (0..n-1)
		priorityQueue.get(priority - 1).add(newElement);
	}

	/**
	 * Removes and returns the highest-priority element in the queue.
	 *
	 * @return the element removed, or null if the queue is empty
	 */
	public T poll() {
		// Scan from highest to lowest priority
		for (int i = 0; i < this.n; i++) {
			ArrayList<T> list = priorityQueue.get(i);
			if (!list.isEmpty()) {
				return list.remove(0);// Remove and return the first inserted element (FIFO per priority)
			}
		}

		return null; // Queue is empty

	}

	/**
	 * Checks if the specified element exists in the queue.
	 *
	 * @param element the element to search for
	 * @return true if found, false otherwise
	 */
	public boolean contains(T element) {
		for (ArrayList<T> list : priorityQueue) {
			if (list.contains(element)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Removes the specified element from the queue, if it exists.
	 *
	 * @param element the element to remove
	 * @return true if the element was found and removed, false otherwise
	 */
	public boolean remove(T element) {
		for (ArrayList<T> list : priorityQueue) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).equals(element)) {
					list.remove(i);
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Returns the total number of elements currently in the queue.
	 *
	 * @return the size of the queue
	 */
	public int size() {
		int sum = 0;
		for (ArrayList<T> list : priorityQueue) {
			sum += list.size();
		}

		return sum;
	}

	/**
	 * Returns an iterator over the elements in the queue, iterating from highest to
	 * lowest priority and in insertion order within each priority.
	 *
	 * @return an iterator over the elements in the queue
	 */
	public Iterator<T> iterator() {

		Iterator<T> iterator = new Iterator<T>() {
			private int bucketIndex = 0; // Tracks the current priority level
			private int elementIndex = 0;// Tracks the position within the current priority level

			@Override
			public boolean hasNext() {
				// Skip over empty priority buckets
				while (bucketIndex < n) {
					ArrayList<T> priorityList = priorityQueue.get(bucketIndex);
					if (elementIndex < priorityList.size()) {
						return true;
					} else {
						bucketIndex++;
						elementIndex = 0;
					}

				}
				return false;
			}

			@Override
			public T next() {
				// Return the next element and advance elementIndex
				T item = priorityQueue.get(bucketIndex).get(elementIndex);
				elementIndex++;
				return item;
			}

		};

		return iterator;

	}

}
