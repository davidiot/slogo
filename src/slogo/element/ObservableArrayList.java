package slogo.element;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class ObservableArrayList extends Observable {
	private List<String> list = new ArrayList<String>();

	public void add(String s) {
		list.add(s);
		this.setChanged();
		notifyObservers(s);
	}
	
	public void clear(){
		list.clear();
		this.setChanged();
		notifyObservers();
	}

	public String get(int i) {
		return list.get(i);
	}

	public List<String> getList() {
		return list;
	}
}
