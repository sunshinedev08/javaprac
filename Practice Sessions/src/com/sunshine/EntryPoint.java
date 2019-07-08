package com.sunshine;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import com.sunshine.javacollections.Array_List;

public class EntryPoint {

	public static void main(String[] args) {
		Scanner sn=new Scanner(System.in);
		int choice = -1;
		String strchoice=null;
		ArrayList<Integer> n=new ArrayList<Integer>();
		ArrayList<String> dbdata=new ArrayList<String>();
		Array_List arr = null;
		System.out.println("1)Store Direct Data  2)Store Data From ArrayList  3)Store Data From Properties File  4)Store Data from Database  5)Show Data  0)Exit");
		while(choice!=0) {
			try {
				System.out.print("Enter Your Choice:");
				choice=sn.nextInt(); 
				switch(choice){
				case 1:
					System.out.print("Enter integer Value:");
					choice=sn.nextInt();
					arr=new Array_List();
					arr.storeDataInArrayList(choice);
					break;
				case 2:
					System.out.print("Enter integer Value:");
					choice=sn.nextInt();
					arr=new Array_List();
					arr.storeDataInArrayList(choice);
					n=arr.getDataFromArrayList();
					arr.storeDataInArrayListFromAnother(n);
					break;
				case 3:
					System.out.print("Enter Filename:");
					strchoice=sn.next();
					arr=new Array_List(strchoice);
					System.out.print("Enter KeyValue:");
					strchoice=sn.next();
					arr.storeDataFromPropertiesFile(strchoice);
					break;
				case 4:
					System.out.print("Enter Host IP:");
					dbdata.add(0, sn.next());
					System.out.print("Enter DB Name:");
					dbdata.add(1, sn.next());
					System.out.print("Enter Port No.:");
					dbdata.add(2, sn.next());
					System.out.print("Enter Filename:");
					dbdata.add(3, sn.next());
					System.out.print("Enter Tablename:");
					dbdata.add(4, sn.next());
					arr=new Array_List(dbdata.get(0), dbdata.get(1), dbdata.get(2),dbdata.get(3));
					arr.storeDataFromDatabase(dbdata.get(4));
					break;
				case 5:
					//arr=new Array_List();
					try {
						n=arr.getDataFromArrayList();
						for(int i=0;i<n.size();i++) {
							System.out.println("Data:"+n.get(i));
						}
						break;
					}catch(NullPointerException npe) {
						System.err.println("No Data To Display,Use 1 to 4 options for saving the data.");
						break;
					}
				case 0:
					System.out.println("Exit");
					sn.close();
					break;
				}
			}catch(InputMismatchException ime) {
				System.err.println("Please Enter Only Integer Values."+"Terminating the Program becoz of wrong inputs.");
				break;
			}
		}
	}
}
