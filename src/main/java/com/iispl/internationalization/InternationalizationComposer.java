package com.iispl.internationalization;

import java.util.Locale;

import org.zkoss.web.Attributes;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zul.Window;

public class InternationalizationComposer extends SelectorComposer<Window>{
	

	@Listen("onClick=#hindi")
	public void setLocalelanguageHI() {
		Locale l = Locale.of("hi","IN");
		Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE, l);
		Executions.sendRedirect("");
		
	}
	
	@Listen("onClick=#english")
	public void setLocalelanguageEN() {
		Locale local = Locale.of("en","IN");
		Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE, local);
		Executions.sendRedirect("");
		
	}
	
	@Listen("onClick=#french")
	public void setLocalelanguageFR() {
		alert("hii");
		Locale lcl = Locale.of("fr","FR");
		Sessions.getCurrent().setAttribute(Attributes.PREFERRED_LOCALE, lcl);
		Executions.sendRedirect("");
		
	}
	
}
