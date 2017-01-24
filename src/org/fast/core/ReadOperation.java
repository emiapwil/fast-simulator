package org.fast.core;

public class ReadOperation extends Operation{

	private int dataId;
	
	private int attributeId;
	
	private Object valve;
	
	public ReadOperation(int dataId, int attributeId, Object value) {
		this.dataId = dataId;
		this.attributeId = attributeId;
		this.valve = value;
	}
}
