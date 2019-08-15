package cerovecki.ljetnizadatak;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JOptionPane;

public class Start {

	
	
	public Start () {
		
	
		
		glavna_petlja:
			while(true) {
				
				Izbornik();
				
				switch (KontrolaUnosa.unosInteger("Unesi redni broj akcije")) {
				case 1:
					
					
					break;

				default:
					break;
				}
			}
			
		
	}
	
	
	private void Izbornik () {
		System.out.println("###### Konzolna aplikacija ######");
		System.out.println("1. URL ERA dijagrama");
		System.out.println("2. URL GitHub koda");
		System.out.println("3.  Čitanje podataka iz odabrane tablice");
		System.out.println("4. Unos podataka u odabranu tablicu");
		System.out.println("5. Promjena podataka u odabranoj tablici ");
		System.out.println("6. Brisanje podataka u odabranoj tablici ");
		System.out.println("7. Izlaz iz programa");
	}
	
	public static void main(String[] args) {
		new Start();
	}
	
}
