
/**
 * Represents a client inquiry with identifying and contact information. Used in
 * the priority queue for sorting and comparison based on ID and contact
 * details.
 */
public class ClientInquiry {
	private String name; // Full name of the client
	private String contactDetails; // Contact details (e.g., phone number, email, etc.)
	private String idNumber; // National ID number (used for identity and uniqueness)

	/**
	 * Constructs a new ClientInquiry object with the given details.
	 *
	 * @param newName    the name of the client
	 * @param newDetails the contact details of the client
	 * @param newId      the national ID number of the client
	 */
	public ClientInquiry(String newName, String newDetails, String newId) {
		setName(newName);
		setContactDetails(newDetails);
		setIdNumber(newId);
	}

	// Getter and Setter for name
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	// Getter and Setter for contact details
	public String getContactDetails() {
		return contactDetails;
	}

	public void setContactDetails(String contactDetails) {
		this.contactDetails = contactDetails;
	}

	public String getIdNumber() {
		return idNumber;
	}

	// Getter and Setter for ID number
	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	/**
	 * Returns a string representation of the client inquiry.
	 */
	@Override
	public String toString() {
		return "Name: " + name + ", ID: " + idNumber + ", Contact: " + contactDetails;
	}

	/**
	 * Checks if two inquiries are equal based on ID number and contact details.
	 *
	 * @param other the object to compare with
	 * @return true if both ID and contact are equal, false otherwise
	 */
	@Override
	public boolean equals(Object other) {
		// Same object reference
		if (this == other) {
			return true;
		}

		// Not the same class
		if (!(other instanceof ClientInquiry)) {
			return false;
		}

		// Cast and compare id number and contact details fields
		ClientInquiry otherInquiry = (ClientInquiry) other;

		return (otherInquiry.idNumber.equals(this.idNumber))
				&& (otherInquiry.contactDetails.equals(this.contactDetails));

	}
}
