package com.iispl.userauthentication;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;

public class MainpageComposer extends SelectorComposer<Window>{

	@Wire
	Button loginBtn;
	
	@Listen("onClick=#loginBtn")
	public void onMain() {
		Executions.sendRedirect("Userauthentication.zul");
	}
}
