/**
 * 
 */
package com.vsct.xspeedit.models;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.vsct.xspeedit.exceptions.XspeeditIllegalException;
import com.vsct.xspeedit.util.Constants;

/**
 * @author sebarin
 *
 */
@Component
public class BoxPack {

	/**
	 * box list
	 */
	private List<Box> boxes;

	public BoxPack() {
		this.boxes = new ArrayList<Box>();
	}

	/**
	 * 
	 * @param item
	 * @return
	 * @throws XspeeditIllegalException
	 */
	public Box addBoxWithItem(Box box, Item item) {
		box.add(item);
		this.boxes.add(box);
		return box;
	}

	/**
	 * 
	 * @param box
	 * @return
	 */
	public Box addBox(Box box) {
		this.boxes.add(box);
		return box;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		boxes.stream().forEach(box -> builder.append(box.toString()).append(Constants.SEPARATOR));
		return builder.toString();
	}

	/**
	 * @return the boxes
	 */
	public List<Box> getBoxes() {
		return boxes;
	}

	/**
	 * @param boxes
	 *            the boxes to set
	 */
	public void setBoxes(List<Box> boxes) {
		this.boxes = boxes;
	}

}
