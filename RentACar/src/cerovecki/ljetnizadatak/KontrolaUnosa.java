package cerovecki.ljetnizadatak;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class KontrolaUnosa {
	
	public static final String FORMAT_DATUMA = "dd.MM.yyyy";
	
	
	public static Date unosDatuma (String poruka) {
		
		SimpleDateFormat df = new SimpleDateFormat(FORMAT_DATUMA);
		while(true) {
			
			try {
				return df.parse(JOptionPane.showInputDialog(poruka));
			} catch (Exception e) {
				JOptionPane.showConfirmDialog(null, 
						"Obavezan unos u formatu: " + FORMAT_DATUMA 
						+ "\nPrimjer na današnjem datumu:" + df.format(new Date()));
			}
		}
	}
	
	
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

public static BigDecimal  unosBigDecimal(String poruka) {
	
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

public static Byte unosByte(String poruka) {
	byte b;
	while (true) {

		try {
			b = Byte.parseByte(JOptionPane.showInputDialog(poruka));
			if (b == 1 || b == 0) {
				return b;
			} else {
				JOptionPane.showConfirmDialog(null, "Obavezano unijeti 1. ili 0.");
			}

		} catch (Exception e) {
			JOptionPane.showConfirmDialog(null, "Obavezano unijeti 1. ili 0.");
		}

	}
}

}
