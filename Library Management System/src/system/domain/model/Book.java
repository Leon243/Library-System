package system.domain.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Book.
 */
public class Book extends Item {

	/** The isbn. */
	private int ISBN;

	/**
	 * Instantiates a new book.
	 * 
	 * @param itemID
	 *            the item id
	 * @param author
	 *            the author
	 * @param title
	 *            the title
	 * @param ISBN
	 *            the isbn
	 */
	public Book(int itemID, String author, String title, int ISBN) {
		super(itemID, author, title);
		this.setISBN(ISBN);
	}

	/**
	 * Gets the isbn.
	 * 
	 * @return the isbn
	 */
	@Override
	public int getISBN() {
		return ISBN;
	}

	/**
	 * Sets the isbn.
	 * 
	 * @param iSBN
	 *            the new isbn
	 */
	public void setISBN(int iSBN) {
		ISBN = iSBN;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Item#toString()
	 */
	@Override
	public String toString() {

		return "Author: " + getAuthor() + ", Title: " + "\"" + getTitle()
				+ "\"," + " ISBN: " + getISBN() + ", ItemID: " + getItemID();
	}

	/* (non-Javadoc)
	 * @see system.domain.model.Item#equalsTo(java.lang.Object)
	 */
	@Override
	public int equalsTo(Object obj) {
		if(!(obj instanceof Book))
			return -1;
		Book other = (Book) obj;
		if(this.getAuthor().equals(other.getAuthor())
				&& this.getTitle().equals(other.getTitle())
				&& this.getISBN() == other.getISBN()
				&& this.getItemID() == other.getItemID()==true)
			return 1;
		return 0;
		
	}
}
