package slogo.screen;

import java.util.ArrayList;


import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import slogo.element.AbstractElement;

public class TabManager extends AbstractElement {

	private TabPane manager;
	private String myLanguage;
	private SlogoScreenInterface myScreen;
	private SlogoTab test;
	private SlogoTab currTab;
	private ArrayList<SlogoTab> tabList; 

	public TabManager(GridPane grid, String language, SlogoScreenInterface screen) {
		super(grid);
		myLanguage = language;
		myScreen = screen;
		tabList = new ArrayList<SlogoTab>();
		makePane();
	}

	@Override
	protected void makePane() {
		manager = new TabPane();
		test = new SlogoTab(myLanguage, myScreen, 0);
		tabList.add(test);
		currTab = test;
		SlogoTab test2 = new SlogoTab(myLanguage, myScreen, 1);
		tabList.add(test2);
		Tab addTab = new Tab("+");

		manager.getTabs().add(test.getTab());
		manager.getTabs().add(test2.getTab());
		manager.getTabs().add(addTab);
		SingleSelectionModel<Tab> selectionModel = manager.getSelectionModel();
		this.pane.getChildren().add(manager);
		manager.getSelectionModel().selectedItemProperty().addListener((ov, oldTab, newTab) -> {
			if(newTab.getText().equals("+")){
				SlogoTab temp = new SlogoTab(myLanguage, myScreen, tabList.size());
				manager.getTabs().add(tabList.size(), temp.getTab());
				tabList.add(temp);
				selectionModel.select(Integer.parseInt(temp.getTab().getId()));
			}
			currTab = tabList.get(Integer.parseInt(newTab.getId()));
		});
	}

	public SlogoTab getCurrentTab(){
		return currTab;
	}

	public TabPane getPane(){
		return manager;
	}

}
