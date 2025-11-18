package com.iispl.renderer;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

public class FruitRenderer implements ListitemRenderer<String[]>{

	@Override
	public void render(Listitem item, String[] data, int index) throws Exception {
		// TODO Auto-generated method stub
		item.appendChild(new Listcell(data[0]));
		Listcell cell = new Listcell(data[1]);
		if(Integer.valueOf(data[1])>=50) {
			cell.setStyle("color: green");
		} else {
			cell.setStyle("color: red");
		}
		item.appendChild(cell);
		item.appendChild(new Listcell(data[2]));
				
	}

	
}
