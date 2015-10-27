package slogo.screen;

import java.util.ArrayList;

import javafx.geometry.Side;
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
		manager.setSide(Side.BOTTOM);
		test = new SlogoTab(myLanguage, myScreen, 0);
		tabList.add(test);
		test.getTab().setClosable(false);
		currTab = test;
		Tab addTab = new Tab("+");
		manager.getTabs().add(test.getTab());
		manager.getTabs().add(addTab);
		SingleSelectionModel<Tab> selectionModel = manager.getSelectionModel();
		this.pane.getChildren().add(manager);
		selectionModel.selectedItemProperty().addListener((ov, oldTab, newTab) -> {
			if (newTab.getText().equals("+")) {
				SlogoTab temp = new SlogoTab(myLanguage, myScreen, tabList.size());
				newTab = temp.getTab();
				int tempID = Integer.parseInt(newTab.getId());
				newTab.setOnClosed(e -> {
					tabList.remove(tempID);
					resetID(tempID);
				});
				manager.getTabs().add(tabList.size(), newTab);
				tabList.add(temp);
				selectionModel.select(tempID);
			}
			currTab = tabList.get(Integer.parseInt(newTab.getId()));
		});
	}

	private void resetID(int index) {
		for (int i = index; i < tabList.size(); i++) {
			tabList.get(i).getTab().setId(Integer.toString(i));
			tabList.get(i).getTab().setText("Workspace " + (i + 1));
		}
	}

	public SlogoTab getCurrentTab() {
		return currTab;
	}

	public TabPane getPane() {
		return manager;
	}

}
