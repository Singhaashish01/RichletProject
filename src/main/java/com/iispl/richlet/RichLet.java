package com.iispl.richlet;

import org.zkoss.zk.ui.GenericRichlet;
import org.zkoss.zk.ui.Page;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

public class RichLet extends GenericRichlet{

	@Override
	public void service(Page page) throws Exception {
		// TODO Auto-generated method stub
		page.setTitle("Richlet Test");
		
		 Window w = new Window("Richlet Class", "normal", false);
		new Label("Hello Pri").setParent(w);
		final Label l = new Label("New Label");
		l.setParent(w);
		
		final Button b = new Button("Change");
		b.setParent(w);
		w.setPage(page);
	}
	
	

}
