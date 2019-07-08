package com.sunshine.javacollections;

import java.util.ArrayList;

public interface ArrLst_Interface {
	public void storeDataInArrayList(int data);
	public void storeDataInArrayListFromAnother(ArrayList<Integer> num);
	public void storeDataFromPropertiesFile(String property);
	public void storeDataFromDatabase(String tabname);
	public ArrayList<Integer> getDataFromArrayList();
}
