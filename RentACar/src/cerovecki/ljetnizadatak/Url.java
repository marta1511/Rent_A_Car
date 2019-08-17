package cerovecki.ljetnizadatak;

import java.awt.Desktop;


import java.net.URI;


import java.sql.Connection;
import java.sql.PreparedStatement;



public class Url {
	public static Connection veza;
	public static PreparedStatement izraz;
	
	public static void urlEra () {
	try {
     Desktop.getDesktop().browse(new URI ("https://github.com/marta1511/Rent_A_Car/blob/master/RentACar/era%20dijagram.png"));
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void urlGitHub () {
		try {
			Desktop.getDesktop().browse(new URI ("https://github.com/marta1511/Rent_A_Car/tree/master/RentACar/src/cerovecki/ljetnizadatak"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
