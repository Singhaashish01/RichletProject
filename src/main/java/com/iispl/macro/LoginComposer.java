package com.iispl.macro;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

public class LoginComposer extends SelectorComposer<Window>{

	@Wire
	LoginScreen ls;
	
	@Override
	public void doAfterCompose(Window comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
		//ls.setPassword("Priyanshu");
	}
	
	@Listen("onSubmit=#ls")
	public void onSubmit() {
		if(ls.validateUser()) {
			Messagebox.show("Authorised User");
		}
		else {
			Messagebox.show("Unauthorised User");
		}
	}
	
	
}
