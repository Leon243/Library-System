package system.domain.model;

// TODO: Auto-generated Javadoc
/**
 * The Class Article.
 */
public class Article extends Item {

	/** The magazine. */
	private String magazine;

	/**
	 * Instantiates a new article.
	 * 
	 * @param itemID
	 *            the item id
	 * @param author
	 *            the author
	 * @param title
	 *            the title
	 * @param magazine
	 *            the magazine
	 */
	public Article(int itemID, String author, String title, String magazine) {
		super(itemID, author, title);
		this.setMagazine(magazine);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see Item#toString()
	 */
	@Override
	public String toString() {
		return "Author : " + getAuthor() + ", Title: " + "\"" + getTitle()
				+ "\"," + " Magazine: " + "\"" + getMagazine() + "\","
				+ " ItemID: " + getItemID();
	}

	/**
	 * Gets the magazine.
	 * 
	 * @return the magazine
	 */
	public String getMagazine() {
		return magazine;
	}

	/**
	 * Sets the magazine.
	 * 
	 * @param magazine
	 *            the new magazine
	 */
	public void setMagazine(String magazine) {
		this.magazine = magazine;
	}

	/* (non-Javadoc)
	 * @see system.domain.model.Item#equalsTo(java.lang.Object)
	 */
	@Override
	public int equalsTo(Object obj) {
		if (!(obj instanceof Article))
			return -1;
		Article other = (Article) obj;
		if(this.getAuthor().equals(other.getAuthor())
				&& this.getTitle().equals(other.getTitle())
				&& this.getMagazine().equals(other.getMagazine())
				&& this.getItemID() == other.getItemID()==true)
			return 2;
		return 0;
		
	}

}
