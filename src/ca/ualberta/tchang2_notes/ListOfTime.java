package ca.ualberta.tchang2_notes;

import java.util.ArrayList;
import java.util.Date;

public class ListOfTime {
	
	private String name;
	private ArrayList<Date> list; 
	private ArrayList<Integer> count;

	public ListOfTime(){
		this.name = new String();
		this.list = new ArrayList<Date>();
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public ArrayList<Date> getList() {
		return list;
	}


	public void setList(ArrayList<Date> list) {
		this.list = list;
	}
	
	public ArrayList<Integer> getCount() {
		return count;
	}

	public void setCount(ArrayList<Integer> count) {
		this.count = count;
	}
	
}
