package cerovecki.ljetnizadatak;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

public class KontrolaUnosa {
	
	
public static int unosInteger(String poruka) {
	
	int i;
	
	while(true) {
		try {
			i=Integer.parseInt(JOptionPane.showInputDialog(poruka));
			if(i<=0) {
				JOptionPane.showConfirmDialog(null, "Uneseni broj mora biti veći od nula");
				continue;
				
			}return i;
			
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Obavezan unos broja");
		}
	}
}

public static String unosStringa (String poruka) {
	String s;
	
	while(true) {
		s=JOptionPane.showInputDialog(poruka);
		if(s.trim().length()==0) {
			JOptionPane.showConfirmDialog(null, "Obavezan unos");
			continue;
		}return s;
	}
}

public static BigDecimal  unosBigDecimal() {
	
	double d;
	
	while(true) {
		try {
			d=Double.parseDouble(JOptionPane.showInputDialog(poruka));
			if (d<=0) {
			JOptionPane.showConfirmDialog(null,"Uneseni broj mora biti veći od nula");
			continue;
			} return BigDecimal.valueOf(d);
		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Obavezan unos");
		}
	}
}

}
