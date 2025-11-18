package com.iispl.renderer;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelArray;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Window;
import java.util.*;

public class ListBoxComposer extends SelectorComposer<Window>{

	@Wire
	Listbox lb1,lb2;
	
	@Override
	public void doAfterCompose(Window comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		
		String[][] fruit = new String[][] {
			{"Mango", "60", "20 Boxes"},
			{"Guava", "30", "50 Boxes"},
			{"Papaya", "40", "30 Boxes"}
		};
		
		ListModelArray<String> lma = new ListModelArray(fruit);
		
		
		ArrayList<String[]> fruitList = new ArrayList<>();
		fruitList.add(new String[] {"Apple" , "50" , "35 Boxes"});
		ListModelList lml = new ListModelList(fruitList);
		lb1.setModel(lma);
		lb2.setModel(lml);
		
	}
}
