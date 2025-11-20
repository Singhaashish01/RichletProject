package com.iispl.messagedigest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

public class LoginComposer extends SelectorComposer<Window>{

	@Wire
    Textbox tUsername, tPassword;

    @Wire
    Button loginBtn;

    // Static stored password (hashed "Aashu@123")
    private static final String STORED_PASSWORD_HASH = hashPassword("Aashu@123");

    @Listen("onClick = #loginBtn")
    public void login(){

        String enteredPass = tPassword.getValue();

        // Hash user entered password
        String enteredHash = hashPassword(enteredPass);

        // Compare
        if(enteredHash.equals(STORED_PASSWORD_HASH)){
            Messagebox.show("Login Successful!");
        } else {
            Messagebox.show("Invalid username or password!");
        }
    }

    /**
     * Utility to hash a password using SHA-256
     */
    private static String hashPassword(String pwd) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");

            byte[] hashedBytes = md.digest(pwd.getBytes());

            // Convert byte array to hex string
            StringBuilder sb = new StringBuilder();
            for(byte b : hashedBytes){
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-256 not supported", e);
        }
    }
}
