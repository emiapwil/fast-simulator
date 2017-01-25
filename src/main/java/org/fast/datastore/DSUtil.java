package org.fast.datastore;

public class DSUtil {

	public static String constructXId(int dataId, int attId) {
		String a = String.valueOf(dataId);
		String b = String.valueOf(attId);
		return a + "_" + b;
	}
	
	public static int getDataId(String xId) {
		String[] ab = xId.split("_");
		return Integer.parseInt(ab[0]);
	}
	
	public static int getAttId(String xId) {
		String[] ab = xId.split("_");
		return Integer.parseInt(ab[1]);
	}
}
