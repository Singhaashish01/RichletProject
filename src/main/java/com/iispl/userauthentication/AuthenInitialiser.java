package com.iispl.userauthentication;

import java.util.Map;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Page;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.util.Initiator;

public class AuthenInitialiser  implements Initiator{

	@Override
	public void doInit(Page page, Map<String, Object> args) throws Exception {
		// TODO Auto-generated method stub
		String sess = 	(String)Sessions.getCurrent().getAttribute("currentUser");
		if(sess==null || sess.equals("")) {
			Executions.sendRedirect("mainpage.zul");
		}
	}

}
