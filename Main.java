public class Main {
	public static void main(String[] args) {

		SectionB();
		SectionC();
	}

	private static void SectionB() {
		System.out.println("====================== סעיף ב של הממן שימוש במחרוזות =====================\n");

		// Create a priority queue with 5 levels (1 = highest, 5 = lowest)
		GenericPriorityQueue<String> queue = new GenericPriorityQueue<>(5);

		// Add multiple elements with a mix of priorities
		System.out.println("\n[1] Inserting elements with different priorities:");
		queue.add("A1", 1); // high
		queue.add("A2", 1);

		queue.add("E1", 5); // low
		queue.add("E2", 5);
		queue.add("E3", 5);

		queue.add("B1", 2); // medium-high
		queue.add("B2", 2);

		queue.add("C1", 3); // medium
		queue.add("C2", 3);

		queue.add("D1", 4); // medium-low
		queue.add("D2", 4);

		// Print full queue using iterator
		System.out.println("\n[2] Full queue contents (by priority order):");
		for (String item : queue) {
			System.out.println(item);
		}

		System.out.println("\nQueue size: " + queue.size());

		// Perform multiple polls
		System.out.println("\n[3] Polling elements (expected order: A1, A2, B1):");
		System.out.println("Polled: " + queue.poll()); // A1
		System.out.println("Polled: " + queue.poll()); // A2
		System.out.println("Polled: " + queue.poll()); // B1

		System.out.println("\nQueue after polling 3 elements:");
		for (String item : queue) {
			System.out.println(item);
		}

		System.out.println("Queue size: " + queue.size());

		// Contains checks
		System.out.println("\n[4] Checking if specific elements exist:");
		System.out.println("Contains 'C1'? " + queue.contains("C1")); // true
		System.out.println("Contains 'B1'? " + queue.contains("B1")); // false (was polled)
		System.out.println("Contains 'E3'? " + queue.contains("E3")); // true
		System.out.println("Contains 'Z9'? " + queue.contains("Z9")); // false

		// Remove some elements
		System.out.println("\n[5] Removing specific elements:");
		System.out.println("Remove 'D2': " + queue.remove("D2")); // true
		System.out.println("Remove 'Z9': " + queue.remove("Z9")); // false
		System.out.println("Remove 'E3': " + queue.remove("E3")); // true

		System.out.println("\nQueue after removals:");
		for (String item : queue) {
			System.out.println(item);
		}

		System.out.println("Queue size: " + queue.size());

		// Poll everything until empty
		System.out.println("\n[6] Polling all remaining elements:");
		String polled;
		while ((polled = queue.poll()) != null) {
			System.out.println("Polled: " + polled);
		}

		System.out.println("\nQueue should now be empty.");
		System.out.println("Queue size: " + queue.size());

		// Try polling and removing from empty queue
		System.out.println("\n[7] Behavior on empty queue:");
		System.out.println("Poll returns: " + queue.poll());
		System.out.println("Remove 'A1' (already removed): " + queue.remove("A1"));
		System.out.println("Contains 'C2': " + queue.contains("C2"));

		// Final check: use iterator on empty queue
		System.out.println("\n[8] Iterating over empty queue:");
		for (String item : queue) {
			System.out.println("Should not print: " + item);
		}

	}

	private static void SectionC() {
		System.out.println("\n=============================== סעיף ג: בדיקות עם פניות לקוחות ==================================");

	    // Create a priority queue with 4 levels (1 = highest, 4 = lowest)
	    GenericPriorityQueue<ClientInquiry> queue = new GenericPriorityQueue<>(4);

	    // Create different client inquiries
	    ClientInquiry a = new ClientInquiry("Or Saban", "050-1111111", "123456789");
	    ClientInquiry b = new ClientInquiry("Maya Malkis", "050-2222222", "234567890");
	    ClientInquiry c = new ClientInquiry("Lior Castel", "050-3333333", "345678901");
	    ClientInquiry d = new ClientInquiry("Or Saban", "050-1111111", "123456789"); // Duplicate of 'a'
	    ClientInquiry e = new ClientInquiry("Chen Ulmer", "050-4444444", "456789012");
	    ClientInquiry f = new ClientInquiry("Tom Levi", "050-5555555", "567890123");

	    // Add inquiries with different priorities
	    System.out.println("\n[1] Adding inquiries with different priorities:");
	    queue.add(a, 1); // Highest priority
	    queue.add(b, 2);
	    queue.add(c, 3);
	    queue.add(e, 4); // Lowest priority

	    // Print current queue contents
	    System.out.println("\n[2] Current queue (by priority):");
	    for (ClientInquiry inquiry : queue) {
	        System.out.println(inquiry);
	    }

	    // Check if the queue contains specific inquiries
	    System.out.println("\n[3] Contains checks:");
	    System.out.println("Contains Maya? " + queue.contains(b)); // true
	    System.out.println("Contains duplicate of Or? " + queue.contains(d)); // true
	    System.out.println("Contains Tom? " + queue.contains(f)); // false

	    // Remove inquiries
	    System.out.println("\n[4] Removing inquiries:");
	    System.out.println("Remove Lior? " + queue.remove(c)); // true
	    System.out.println("Remove Tom (not in queue)? " + queue.remove(f)); // false

	    // Print queue after removals
	    System.out.println("\n[5] Queue after removals:");
	    for (ClientInquiry inquiry : queue) {
	        System.out.println(inquiry);
	    }

	    // Poll the highest-priority element
	    System.out.println("\n[6] Polling the top-priority element:");
	    ClientInquiry polled = queue.poll();
	    System.out.println("Polled: " + (polled != null ? polled : "None"));

	    // Print queue after poll
	    System.out.println("\n[7] Queue after polling:");
	    for (ClientInquiry inquiry : queue) {
	        System.out.println(inquiry);
	    }

	    // Check the size of the queue
	    System.out.println("\n[8] Current queue size: " + queue.size());

	    // Poll all remaining elements until the queue is empty
	    System.out.println("\n[9] Polling all remaining inquiries:");
	    while ((polled = queue.poll()) != null) {
	        System.out.println("Polled: " + polled);
	    }

	    // Final size check
	    System.out.println("\n[10] Final queue size (should be 0): " + queue.size());
	}


}
