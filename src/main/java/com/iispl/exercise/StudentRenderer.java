package com.iispl.exercise;

import org.zkoss.zk.ui.event.Events;
import org.zkoss.zul.Button;
import org.zkoss.zul.ItemRenderer;
import org.zkoss.zul.Listcell;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.ListitemRenderer;
import org.zkoss.zul.RowRenderer;

public class StudentRenderer implements ListitemRenderer<Student>{

	private StudentController controller;

    public StudentRenderer(StudentController controller) {
        this.controller = controller;
    }

    @Override
    public void render(Listitem item, Student s, int index) throws Exception {

        new Listcell(String.valueOf(s.getId())).setParent(item);
        new Listcell(s.getName()).setParent(item);

        Listcell marksCell = new Listcell(String.valueOf(s.getMarks()));
        marksCell.setParent(item);

        if (s.getMarks() > 80) {
            marksCell.setStyle("color: green; font-weight: bold;");
        } else {
        	marksCell.setStyle("color: red; font-weight: bold;");
        } 

        Listcell deleteCell = new Listcell();
        Button deleteBtn = new Button("Delete");
        deleteBtn.setSclass("btn btn-danger");

        deleteBtn.addEventListener(Events.ON_CLICK, evt -> {
            controller.deleteStudent(s);
        });

        deleteBtn.setParent(deleteCell);
        deleteCell.setParent(item);
    }
    
    
}
