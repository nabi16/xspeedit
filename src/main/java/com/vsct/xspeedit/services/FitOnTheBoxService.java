/**
 * 
 */
package com.vsct.xspeedit.services;

import com.vsct.xspeedit.exceptions.XspeeditIllegalException;
import com.vsct.xspeedit.models.BoxPack;

/**
 * @author sebarin
 *
 */
public interface FitOnTheBoxService {

	/**
	 * fit on the box method
	 */
	BoxPack fitOnTheBox(String[] items, int capacity) throws XspeeditIllegalException;
}
