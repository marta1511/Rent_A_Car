package cerovecki.ljetnizadatak;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Crud {

	public static Connection veza;
	public static PreparedStatement izraz;
	
	public static void Update() {
		
		veza = Baza.getConnection();
		int sifra;
		izlaz: while (true) {
			System.out.println("\n1. iznajmljivanje\n2. klijent\n3. zaposlenik\n4. vozilo\n5. model\n6. izlaz\n");
			switch (KontrolaUnosa.unosInteger("Unesite broj tablice u kojoj želite napraviti promjenu ")) {
			case 1:
				try {
					PrikazTablice.prikazTablice("SELECT *FROM iznajmljivanje");
					sifra = KontrolaUnosa.unosInteger("Unesite šifru stavke koju želite promjeniti");
					izraz = veza.prepareStatement("UPDATE iznajmljivanje");
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				break;
			case 2:
				try {
					PrikazTablice.prikazTablice("SELECT *FROM klijent");
					sifra = KontrolaUnosa.unosInteger("Unesite šifru klijenta kod kojeg želite napraviti promjenu");
					izraz = veza.prepareStatement("UPDATE klijent SET ime = ? WHERE sifra = ?");
					izraz.setInt(1, sifra);
					izraz.setString(1, KontrolaUnosa.unosStringa("Unesite novo ime klijenta"));
					JOptionPane.showMessageDialog(null, "Uspješno promjenjeno (" + izraz.executeUpdate() + ")");
					
					PreparedStatement izraz1 = veza.prepareStatement("UPDATE klijent SET prezime = ? WHERE sifra = ?");
					
					izraz1.setInt(1, sifra);
					izraz1.setString(1, KontrolaUnosa.unosStringa("Unesite novo prezime klijenta"));
					JOptionPane.showMessageDialog(null, "Uspješno promjenjeno (" + izraz.executeUpdate() + ")");
					
					PreparedStatement izraz2 = veza.prepareStatement("UPDATE klijent SET email = ? WHERE sifra = ?");
					izraz2.setInt(1, sifra);
					izraz2.setString(1, KontrolaUnosa.unosStringa("Unesite novi email klijenta"));
					JOptionPane.showMessageDialog(null, "Uspješno promjenjeno (" + izraz.executeUpdate() + ")");
					
					PreparedStatement izraz3 = veza.prepareStatement("UPDATE klijent SET telefon = ? WHERE sifra = ?");
					izraz3.setInt(1, sifra);
					izraz3.setString(1, KontrolaUnosa.unosStringa("Unesite novi kontakt broj klijenta"));
					JOptionPane.showMessageDialog(null, "Uspješno promjenjeno (" + izraz.executeUpdate() + ")");
					
					PreparedStatement izraz4 = veza.prepareStatement("UPDATE klijent SET broj_vozacke = ? WHERE sifra = ?");
					izraz4.setInt(1, sifra);
					izraz4.setString(1, KontrolaUnosa.unosStringa("Unesite novi broj vozačke dozvole klijenta"));
					JOptionPane.showMessageDialog(null, "Uspješno promjenjeno (" + izraz.executeUpdate() + ")");
					
					System.out.println("\n\n");
					PrikazTablice.prikazTablice("SELECT *FRIM klijent");
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				break;

			default:
				break;
			}
		}
		
	}
	
	public static void Read (String poruka) {
		
		veza = Baza.getConnection();
		
		izlaz :while (true) {
			System.out.println("\n1. iznajmljivanje\n2. klijent\n3. zaposlenik\n4. vozilo\n5. model\n6. izlaz\n");
			switch (KontrolaUnosa.unosInteger("Unesite broj tablice iz koje želite čitati")) {
			case 1:
				try {
					PrikazTablice.prikazTablice("SELECT *FROM iznajmljivanje");
					JOptionPane.showConfirmDialog(null, "Tablica prikazana");
				} catch (Exception e) {
					e.printStackTrace();
				}

				break;
			case 2:
				try {
					PrikazTablice.prikazTablice("SELECT *FROM klijent");
					JOptionPane.showConfirmDialog(null, "Tablica prikazana");
				
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 3:
				try {
					PrikazTablice.prikazTablice("SELECT *FROM zaposlenik");
					JOptionPane.showConfirmDialog(null, "Tablica prikazana");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
				case 4:
					try {
						PrikazTablice.prikazTablice("SELECT *FROM vozilo");
						JOptionPane.showConfirmDialog(null, "Tablica prikazana");
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					break;
					
				case 5:
					try {
						PrikazTablice.prikazTablice("SELECT *FROM model");
						JOptionPane.showConfirmDialog(null, "Tablica prikazana");
					} catch (Exception e) {
						e.printStackTrace();
					}
					break;
				case 6:
					break izlaz;
					
				default:
					JOptionPane.showMessageDialog(null, "Nevažeći broj! Ponovite unos.");
					break;
				

			}
			}
			
		}
	
	
	public static void Insert () {
		 
		veza = Baza.getConnection();
		
		izlaz :while (true) {
			System.out.println("\n1. iznajmljivanje\n2. klijent\n3. zaposlenik\n4. vozilo\n5. model\n6. izlaz\n");
			switch (KontrolaUnosa.unosInteger("Unesite broj tablice u kojoj želite napraviti unos")) {
			case 1:
				try {
					
					izraz = veza.prepareStatement("INSERT INTO iznajmljivanje"
							+ " (datum_preuzimanja, datum_povratka, broj_ugovora, ukupan_iznos_najma, klijent, vozilo, zaposlenik)"
							+ " VALUES (?, ?, ?, ?, ?, ?, ?)");
					//nešto mi ne valja sa datumom
					//izraz.setDate(1, KontrolaUnosa.unosDatum("Unesite datum preuzimanja vozila"));
					//izraz.setDate(2, KontrolaUnosa.unosDatum("Unesite datum povratka vozila"));
					izraz.setString(3, KontrolaUnosa.unosStringa("Unesite broj ugovora"));
					izraz.setBigDecimal(4, KontrolaUnosa.unosBigDecimal("Unesite ukupnu cijenu za najam ovog vozila"));
					izraz.setInt(5, KontrolaUnosa.unosInteger("Unesite šifru klijenta"));
					izraz.setInt(6, KontrolaUnosa.unosInteger("Unesite šifru vozila"));
					izraz.setInt(7, KontrolaUnosa.unosInteger("Unesite šifru zaposlenika"));
					JOptionPane.showConfirmDialog(null, "Uspješno uneseno (" + izraz.executeUpdate() + ")");
					System.out.println("");
					PrikazTablice.prikazTablice("SELECT * FROM iznajmljivanje");
					JOptionPane.showMessageDialog(null, "Tablica iznajmljivanje prikazana!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				break;
				
			case 2:
				try {
					
					izraz = veza.prepareStatement("INSERT INTO klijent"
							+ "(ime, prezime, email, telefon, broj_vozacke)"
							+ "VALUES(?,?,?,?,?)");
					izraz.setString(1, KontrolaUnosa.unosStringa("Unesite ime klijenta"));
					izraz.setString(2, KontrolaUnosa.unosStringa("Unesite prezime klijenta"));
					izraz.setString(3,KontrolaUnosa.unosStringa("Unesite email adresu"));
					izraz.setString(4, KontrolaUnosa.unosStringa("Unesite broj telefona"));
					izraz.setString(5, KontrolaUnosa.unosStringa("Unesite broj vozačke dozvole"));
					JOptionPane.showConfirmDialog(null, "Uspješno uneseno (" + izraz.executeUpdate() + ")");
					System.out.println("");
					PrikazTablice.prikazTablice("SELECT * FROM klijent");
					JOptionPane.showMessageDialog(null, "Tablica klijent prikazana!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 3:
				try {
					
					izraz = veza.prepareStatement("INSERT INTO zaposlenik"
							+ "(ime, prezime, telefon, iban)"
							+ "VALUES (?,?,?,?)");
					izraz.setString(1, KontrolaUnosa.unosStringa("Unesite ime zaposlenika"));
					izraz.setString(2, KontrolaUnosa.unosStringa("Unesite prezime zaposlenika"));
					izraz.setString(3, KontrolaUnosa.unosStringa("Unesite broj telefona zaposlenika"));
					izraz.setString(4, KontrolaUnosa.unosStringa("Unesite broj računa zaposlenika"));
					JOptionPane.showConfirmDialog(null, "Uspješno uneseno (" + izraz.executeUpdate() + ")");
					System.out.println("");
					PrikazTablice.prikazTablice("SELECT * FROM zaposlenik");
					JOptionPane.showMessageDialog(null, "Tablica klijent zaposlenik!");
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 4:
				try {
					PrikazTablice.prikazTablice("SELECT * FROM vozilo");
					izraz = veza.prepareStatement("INSERT INTO vozilo"
							+ "(registracijska_oznaka, datum_registracije, model)"
							+ "VALUES (?,?,?)");
					izraz.setString(1, KontrolaUnosa.unosStringa("Unesite registraciju vozila"));
					//izraz.setDate(2, KontrolaUnosa.unosDatum("Unesite datum registracije vozila"));
					izraz.setInt(3, KontrolaUnosa.unosInteger("Unesite šifru modela vozila"));
					JOptionPane.showConfirmDialog(null, "Uspješno uneseno (" + izraz.executeUpdate() + ")");
					System.out.println("");
					PrikazTablice.prikazTablice("SELECT * FROM vozilo");
					JOptionPane.showMessageDialog(null, "Tablica vozilo prikazana!");
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Ne možete obrisati odabrani podatak! Negdje se koristi odabrani podatak");
				}
				break;
				
			case 5:
				try {
					PrikazTablice.prikazTablice("SELECT * FROM model");
					izraz = veza.prepareStatement("INSERT INTO model"
				+ "(naziv, marka, tip,broj_sjedala, vrsta_motora, automatik, godina_proizvodnje,cijena_po_danu)"
							+ "VALUES(?,?,?,?,?,?,?)");
					izraz.setString(1, KontrolaUnosa.unosStringa("Inesite naziv vozila"));
					izraz.setString(2, KontrolaUnosa.unosStringa("Unesite marku vozila"));
					izraz.setInt(3, KontrolaUnosa.unosInteger("Unesite Broj sjededala"));
					izraz.setString(4, KontrolaUnosa.unosStringa("Unesite vrstu motora: (Disele ili Benzin)"));
					izraz.setByte(5, KontrolaUnosa.unosByte("Za automatik unesite 1, za manual unesite 0"));
					//izraz.setDate(6, "Unesite godinu proizvodnje");
					izraz.setBigDecimal(7, KontrolaUnosa.unosBigDecimal("Unesite cijenu vozila po danu"));
					JOptionPane.showConfirmDialog(null, "Uspješno uneseno (" + izraz.executeUpdate() + ")");
					System.out.println("");
					PrikazTablice.prikazTablice("SELECT * FROM model");
					JOptionPane.showMessageDialog(null, "Tablica klijent prikazana!");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 6:
				break izlaz;
				
			default:
				JOptionPane.showMessageDialog(null, "Nevažeći broj! Ponovite unos.");
				break;
							}
			}
	}
	
	public static void Delete () {
		veza = Baza.getConnection();
		int dialogButton;
		izlaz :while (true) {
			System.out.println("\n1. iznajmljivanje\n2. klijent\n3. zaposlenik\n4. vozilo\n5. model\n6. izlaz\n");
			switch (KontrolaUnosa.unosInteger("Unesite broj tablice u kojoj želite brisati podatke")) {
			case 1:
				try {
					PrikazTablice.prikazTablice("SELECT *FROM iznajmljivanje");
					izraz = veza.prepareStatement("DELETE FROM iznajmljivanje WHERE sifra = ?");
					while (true) {
						izraz.setInt(1, KontrolaUnosa.unosInteger("Unesite šifru reda u tablici iznajmljivanje koji želite obrisati"));
						dialogButton = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite obrisati ovaj podatak?", 
								"Brisanje podatka",JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null,  "Uspješno obrisano ("+ izraz.executeUpdate() + ")");
							System.out.println("");
							PrikazTablice.prikazTablice("SELECT * FROM iznajmljivanje");
							JOptionPane.showMessageDialog(null, "Tablica iznajmljivanje prikazana!");
							break izlaz;
						}
					}
				} catch (Exception e) {
				
					e.printStackTrace();
				
				}
				break;

			case 2:
				try {
					PrikazTablice.prikazTablice("SELECT *FROM klijent");
					izraz = veza.prepareStatement("DELETE FROM klijent WHERE sifra = ?");
					while (true) {
						izraz.setInt(1, KontrolaUnosa.unosInteger("Unesite šifru reda u tablici klijent koji želite obrisati"));
						dialogButton = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite obrisati ovaj podatak?", 
								"Brisanje podatka",JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null,  "Uspješno obrisano ("+ izraz.executeUpdate() + ")");
							System.out.println("");
							PrikazTablice.prikazTablice("SELECT * FROM klijent");
							JOptionPane.showMessageDialog(null, "Tablica klijent prikazana!");
							
							break izlaz;
						}
					}
				} catch (Exception e) {
				
					JOptionPane.showMessageDialog(null, "Nije moguće obrisati podatak pod ovom šifrom. Podatak se negdje koristi!");
					
				}
				break;
			case 3:
				try {
					PrikazTablice.prikazTablice("SELECT *FROM zaposlenik");
					izraz = veza.prepareStatement("DELETE FROM zaposlenik WHERE sifra = ?");
					while (true) {
						izraz.setInt(1, KontrolaUnosa.unosInteger("Unesite šifru reda u tablici zaposlenik koji želite obrisati"));
						dialogButton = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite obrisati ovaj podatak?", 
								"Brisanje podatka",JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null,  "Uspješno obrisano ("+ izraz.executeUpdate() + ")");
							System.out.println("");
							PrikazTablice.prikazTablice("SELECT * FROM zaposlenik");
							JOptionPane.showMessageDialog(null, "Tablica zaposlenik prikazana!");
							break izlaz;
						}
					}
				} catch (Exception e) {
				
					JOptionPane.showMessageDialog(null, "Nije moguće obrisati podatak pod ovom šifrom. Podatak se negdje koristi!");
					
				
				}
				break;
			case 4: 
				
				try {
					PrikazTablice.prikazTablice("SELECT *FROM vozilo");
					izraz = veza.prepareStatement("DELETE FROM vozilo WHERE sifra = ?");
					while (true) {
						izraz.setInt(1, KontrolaUnosa.unosInteger("Unesite šifru reda u tablici vozilo koji želite obrisati"));
						dialogButton = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite obrisati ovaj podatak?", 
								"Brisanje podatka",JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null,  "Uspješno obrisano ("+ izraz.executeUpdate() + ")");
							System.out.println("");
							PrikazTablice.prikazTablice("SELECT * FROM vozilo");
							JOptionPane.showMessageDialog(null, "Tablica vozilo prikazana!");
							break izlaz;
						}
					}
				} catch (Exception e) {
				
					JOptionPane.showMessageDialog(null, "Nije moguće obrisati podatak pod ovom šifrom. Podatak se negdje koristi!");
					
				
				}
				break;
				
			case 5: 
				try {
					PrikazTablice.prikazTablice("SELECT *FROM model");
					izraz = veza.prepareStatement("DELETE FROM model WHERE sifra = ?");
					while (true) {
						izraz.setInt(1, KontrolaUnosa.unosInteger("Unesite šifru reda u tablici model koji želite obrisati"));
						dialogButton = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite obrisati ovaj podatak?", 
								"Brisanje podatka",JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null,  "Uspješno obrisano ("+ izraz.executeUpdate() + ")");
							System.out.println("");
							PrikazTablice.prikazTablice("SELECT * FROM model");
							JOptionPane.showMessageDialog(null, "Tablica model prikazana!");
							break izlaz;
						}
					}
				} catch (Exception e) {
				
					JOptionPane.showMessageDialog(null, "Nije moguće obrisati podatak pod ovom šifrom. Podatak se negdje koristi!");
					
				
				}
				break;
				
			case 6:
				break izlaz;
				
			default:
				JOptionPane.showMessageDialog(null, "Nevažeći broj! Ponovite unos.");
				break;
				
			}
			}
	}
	
}
