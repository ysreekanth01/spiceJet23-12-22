package com.spicejet.genericUtility;

public enum PropertyFileKeys {
	BROWSER("browser"), URL("url");
	
	private String keys;
	
	private PropertyFileKeys(String keys) {
		this.keys=keys;
	}
	
	/**
	 * To convert to String
	 * @return
	 */
	public String convertToString() {
		return keys.toString();
	}

	
	
	
	
	

}
