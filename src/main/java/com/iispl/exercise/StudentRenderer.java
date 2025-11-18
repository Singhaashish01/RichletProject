package com.iispl.exercise;

import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;

public class StudentRenderer implements ListitemRenderer<Student>{

	@Override
	public void render(Listitem item, Student s, int index) throws Exception {
		 new Listcell(String.valueOf(s.getId())).setParent(item);
	        new Listcell(s.getName()).setParent(item);

	        Listcell marksCell = new Listcell(String.valueOf(s.getMarks()));
	        marksCell.setParent(item);

	        if (s.getMarks() > 80) {
	            marksCell.setStyle("color: green; font-weight: bold;");
	        }
	}

}
