package com.iispl.dynamicpath;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.Properties;

import org.apache.tomcat.util.http.fileupload.FileUpload;
import org.zkoss.zk.ui.Sessions;
import org.zkoss.zk.ui.event.UploadEvent;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Label;
import org.zkoss.zul.Window;

public class DynamicPathComposer extends SelectorComposer<Window>{
	
	@Wire
	private FileUpload fUpload;
	@Wire
	Label onUp;

	@Override
	public void doAfterCompose(Window comp) throws Exception {
		// TODO Auto-generated method stub
		super.doAfterCompose(comp);
	
		File dbProfile = new File(
				Sessions.getCurrent().getWebApp()
				.getResource("/WEB-INF/resources/db.properties").getFile());
		FileReader fr = new FileReader(dbProfile);
		char [] chr = new char[100];
		fr.read(chr);
		System.out.println(new String(chr));
		
		//Example2
		FileInputStream fis = new FileInputStream(dbProfile);
		Properties pro = new Properties();
		pro.load(fis);
		System.out.println(pro.get("dbname"));
	}
	
	@Listen("onUpload=#fUpload")
	public void imageUpload(UploadEvent event) {
		var media = event.getMedia();

		 if(media == null) {
	            alert("File is not uploaded.");
	            return;
	        }
	        
	        if(media.isBinary()) {
	            byte[] data = media.getByteData();
	            System.out.println("File Size :- " + data.length);
	        }
	        else {
	            String str = media.getStringData();
	            System.out.println("Text Contains");
	            System.out.println(str);
	        }
	        
	        alert("Uploaded " + media.getName());
	        
	        File file = new File("/WEB-INF/images/" + media.getName());
	            try (FileOutputStream fos = new FileOutputStream(file)) {
	                fos.write(media.getByteData());
	            }
	            catch (Exception e) {
	                // TODO: handle exception
	                alert(e.getMessage());
	                e.printStackTrace();     
	            }

	}
	
}
