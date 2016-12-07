package com.revature.multilang;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class International {

	public static void main(String[] args) {
		/*en_US
		en_UK
		es_MX
		es_SP
		fr_FR
		fr_CA*/
		Locale.setDefault(new Locale("es", "MX"));

		// bundle of messages.. uses Locale
		/*
		 * basename --> name of properties file for messages
		 * messages.properties      (default)
		 * messages_en.properties    (default for english)
		 * messages_en_US.properties (default for US)
		 * messages_es_MX.properties
		 */
		ResourceBundle bundle = 
				ResourceBundle.getBundle("messages");
		System.out.println( bundle.getString("enter") );
		
		// NumberFormat
		System.out.println(NumberFormat.
				getCurrencyInstance().format(25.995097285783));
	}
	
}
