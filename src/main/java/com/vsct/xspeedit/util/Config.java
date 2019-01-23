/**
 * 
 */
package com.vsct.xspeedit.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author sebarin
 *
 */
@Component
public class Config {
	
	@Value("${xspeedIt.box.capacity}")
	public int CAPACITY;

}
