package com.vsct.xspeedit.exceptions;

public class XspeeditIllegalException extends Exception {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 753595544403491515L;

	public XspeeditIllegalException(String message) {
		super(message);
	}

	public XspeeditIllegalException(String message, Throwable e) {
		super(message, e);
	}

	public XspeeditIllegalException(Throwable e) {
		super(e);
	}

}
