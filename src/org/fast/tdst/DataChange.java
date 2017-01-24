package org.fast.tdst;

public class DataChange {
	
	private String xid;

	private int oldValue;
	
	private int newValue;
	
	public DataChange(String xid, int oldValue, int newValue) {
		this.xid = xid;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}
	
	public String geteXId() {
		return this.xid;
	}
	
	public int getOldValue() {
		return oldValue;
	}
	
	public int getNewValue() {
		return newValue;
	}
	
	public int getDelta() {
		return newValue - oldValue;
	}
}
