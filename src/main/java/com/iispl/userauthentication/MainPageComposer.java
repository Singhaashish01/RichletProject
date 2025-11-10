package com.iispl.userauthentication;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Window;

public class MainPageComposer extends SelectorComposer<Window>{

	@Wire
	Button logout;
	
	
	@Listen("onClick=#logout")
	public void onlogout() {
		Sessions.getCurrent().removeAttribute("currentUser");
		Sessions.getCurrent().invalidate();
		Executions.sendRedirect("mainpage.zul");
	}
}
