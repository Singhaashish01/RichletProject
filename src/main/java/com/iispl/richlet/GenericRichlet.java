package com.iispl.richlet;

import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Richlet;
import org.zkoss.zk.ui.RichletConfig;
import org.zkoss.zk.ui.metainfo.LanguageDefinition;
import org.zkoss.zul.Button;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

public class GenericRichlet implements Richlet{

	
	
	@Override
	public void init(RichletConfig config) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void service(Page page) throws Exception {
		// TODO Auto-generated method stub
		page.setTitle("Richlet Example");
		
		 Window w = new Window("Richlet Class", "normal", false);
		new Label("This is Genericrichlet page").setParent(w);
		final Label l = new Label("New Label");
		l.setParent(w);
		
		final Button b = new Button("Change");
		b.setParent(w);
		w.setPage(page);
	}

	@Override
	public LanguageDefinition getLanguageDefinition() {
		// TODO Auto-generated method stub
		return LanguageDefinition.lookup("xul/html");
	}

}
