package com.zfb.wff.exception;

public class NoMoneyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NoMoneyException() {
		super("余额不足！");
	}

}
