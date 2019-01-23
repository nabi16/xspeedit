/**
 * 
 */
package com.vsct.xspeedit.models;

/**
 * @author sebarin
 *
 */
public class Item {
	
	/**
	 * item size
	 */
	private int size;
	
	/**
	 * added on the box ? true:false
	 */
	private boolean added = false;
	
	
	public Item(int size) {
		this.size = size;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(int size) {
		this.size = size;
	}

	/**
	 * @return the added
	 */
	public boolean isAdded() {
		return added;
	}

	/**
	 * @param added the added to set
	 */
	public void setAdded(boolean added) {
		this.added = added;
	}

}
