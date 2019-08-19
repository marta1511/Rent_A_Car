package cerovecki.ljetnizadatak;



import java.net.MalformedURLException;
import java.net.*;
import java.awt.Desktop;
import java.io.*;
import java.net.URLConnection;
import java.sql.SQLException;

import javax.swing.JOptionPane;





public class Start {

	
	
	public Start () {
		
		Crud.veza = Baza.getConnection();
		Url.veza = Baza.getConnection();
		
		glavna_petlja:
			izlaz: while(true) {
				Izbornik();
				switch (KontrolaUnosa.unosInteger("Unesite redni broj akcije")) {
				case 3: 
					Crud.Read(null);
					break;
				case 4:
					Crud.Insert();
					break;

				case 6:
					Crud.Delete();
					break;
					
				case 1:
					Url.urlEra();
					break; 
					
				case 2:
					Url.urlGitHub();
					break;
					
				case 5: 
					Crud.Update();
					break;
				
				case 7:
					try {
						Crud.veza.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					break izlaz;
		
				default:
					JOptionPane.showMessageDialog(null, "Nevažeći broj! Ponovite unos.");
					break;
				}
				
				}
	}
	
	
	
	private void Izbornik () {
		System.out.println("###### Konzolna aplikacija ######");
		System.out.println("1. URL ERA dijagrama");
		System.out.println("2. URL GitHub koda");
		System.out.println("3. Čitanje podataka iz odabrane tablice");
		System.out.println("4. Unos podataka u odabranu tablicu");
		System.out.println("5. Promjena podataka u odabranoj tablici ");
		System.out.println("6. Brisanje podataka u odabranoj tablici ");
		System.out.println("7. Izlaz iz programa");
	}
	
	
	public static void main(String[] args) {
		new Start();
	}
	
}
