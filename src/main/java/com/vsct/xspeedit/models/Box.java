/**
 * 
 */
package com.vsct.xspeedit.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * @author sebarin
 *
 */
@Component
public class Box {

	/**
	 * items list
	 */
	private List<Item> items;

	/**
	 * Global var to calculate the current size
	 */
	private int currentSize;
	
	/**
	 * Capacity
	 */
	private int capacity;


	public Box () {
		this.items = new ArrayList<Item>();
		this.currentSize = 0;
		this.capacity = 0;
	}
	
	public Box(int capacity) {
		this.items = new ArrayList<Item>();
		this.currentSize = 0;
		this.capacity = capacity;
	}

	/**
	 * creates box with an item
	 * 
	 * @param item
	 */

	public Box(Item item) {
		this.items = new ArrayList<Item>();
		this.items.add(item);
	}

	/**
	 * @return the products
	 */
	public List<Item> getItems() {
		return items;
	}

	/**
	 * @param products
	 *            the products to set
	 */
	public void setItems(List<Item> items) {
		this.items = items;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		items.stream().forEach(it -> builder.append(it.getSize()));
		return builder.toString();
	}

	/**
	 * Add an item to the box
	 * @param item
	 *            : the item to add
	 * @return boolean
	 */
	public boolean add(Item item) {
		boolean itemAdded = false;
		if (item.getSize() + this.currentSize <= this.capacity) {
			item.setAdded(true);
			this.items.add(item);
			this.currentSize = item.getSize() + this.currentSize;
			itemAdded = true;
		}
		return itemAdded;
	}

	/**
	 * An item can fit the box ? true:false
	 * @param item
	 * @return
	 */
	public boolean canFit(Item item) {
		return item.getSize() + this.currentSize <= this.capacity;
	}

	/**
	 * @return true if the box is full
	 */
	public boolean isFull() {
		return this.capacity <= items.stream().mapToInt(item -> item.getSize()).sum();
	}
}
