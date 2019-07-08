package com.sunshine.javaBasics;

public class Array_Variables {
	/*
	 * Syntax: ArrayDataType[] VariableName;
	 */
	int[] intarray;
	public void storeDataIntoArray() {
		intarray=new int[5];
		for(int i=0;i<intarray.length;i+=2) {
			int j=2;
			intarray[i]=j*i;
		}
		System.out.println("Integer Values Stored");
	}
	
	public int[] getDataFromArray() {
		return intarray;
	}
}
