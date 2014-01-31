package ca.ualberta.tchang2_notes;

import java.util.ArrayList;

public class ListOfCounters {
	
	private ArrayList<String> list; 
	
	//Getters and Setters below
	public ListOfCounters(){
		this.list = new ArrayList<String>();
	}
	
	public void setList(ArrayList<String> list){
		this.list = list;
	}
	
	public void addList(String name){
		this.list.add(name);
	}
	
	public ArrayList<String> getList(){
		return this.list;
	}
}
