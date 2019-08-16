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
	
	public static void Read (String poruka) {
		
		veza = Baza.getConnection();
		int columnsNumber;
		izlaz :while (true) {
			System.out.println("\n1. iznajmljivanje\n2. klijent\n3. zaposlenik\n4. vozilo\n5. model\n6. izlaz\n");
			switch (KontrolaUnosa.unosInteger("Unesite vroj tablice iz koje želite ćitati")) {
			case 5:
				try {
					PreparedStatement izraz0 = veza.prepareStatement("SELECT *FROM model");
					ResultSet rs = izraz0.executeQuery();
					ResultSetMetaData rsmd = rs.getMetaData();
					columnsNumber = rsmd.getColumnCount();
					
					while (rs.next()) {
						for (int i = 1; i <= columnsNumber; i++) {
							if (i > 1)
								System.out.print(" | ");
							System.out.print(rs.getString(i));
						}
						
					}
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}

			}

				break;

			
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
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 4:
				try {
					izraz = veza.prepareStatement("INSERT INTO vozilo"
							+ "(registracijska_oznaka, datum_registracije, model)"
							+ "VALUES (?,?,?)");
					izraz.setString(1, KontrolaUnosa.unosStringa("Unesite registraciju vozila"));
					//izraz.setDate(2, KontrolaUnosa.unosDatum("Unesite datum registracije vozila"));
					izraz.setInt(3, KontrolaUnosa.unosInteger("Unesite šifru modela vozila"));
					JOptionPane.showConfirmDialog(null, "Uspješno uneseno (" + izraz.executeUpdate() + ")");
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
				
			case 5:
				try {
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
					izraz = veza.prepareStatement("DELETE FROM iznajmljivanje WHERE sifra = ?");
					while (true) {
						izraz.setInt(1, KontrolaUnosa.unosInteger("Unesite šifru reda u tablici iznajmljivanje koji želite obrisati"));
						dialogButton = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite obrisati ovaj podatak?", 
								"Brisanje podatka",JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null,  "Uspješno obrisano ("+ izraz.executeUpdate() + ")");
							break izlaz;
						}
					}
				} catch (Exception e) {
				
					e.printStackTrace();
				
				}
				break;

			case 2:
				try {
					izraz = veza.prepareStatement("DELETE FROM klijent WHERE sifra = ?");
					while (true) {
						izraz.setInt(1, KontrolaUnosa.unosInteger("Unesite šifru reda u tablici klijent koji želite obrisati"));
						dialogButton = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite obrisati ovaj podatak?", 
								"Brisanje podatka",JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null,  "Uspješno obrisano ("+ izraz.executeUpdate() + ")");
							break izlaz;
						}
					}
				} catch (Exception e) {
				
					e.printStackTrace();
				
				}
				break;
			case 3:
				try {
					izraz = veza.prepareStatement("DELETE FROM zaposlenik WHERE sifra = ?");
					while (true) {
						izraz.setInt(1, KontrolaUnosa.unosInteger("Unesite šifru reda u tablici zaposlenik koji želite obrisati"));
						dialogButton = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite obrisati ovaj podatak?", 
								"Brisanje podatka",JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null,  "Uspješno obrisano ("+ izraz.executeUpdate() + ")");
							break izlaz;
						}
					}
				} catch (Exception e) {
				
					e.printStackTrace();
				
				}
				break;
			case 4: 
				
				try {
					izraz = veza.prepareStatement("DELETE FROM vozilo WHERE sifra = ?");
					while (true) {
						izraz.setInt(1, KontrolaUnosa.unosInteger("Unesite šifru reda u tablici vozilo koji želite obrisati"));
						dialogButton = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite obrisati ovaj podatak?", 
								"Brisanje podatka",JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null,  "Uspješno obrisano ("+ izraz.executeUpdate() + ")");
							break izlaz;
						}
					}
				} catch (Exception e) {
				
					e.printStackTrace();
				
				}
				break;
				
			case 5: 
				try {
					izraz = veza.prepareStatement("DELETE FROM model WHERE sifra = ?");
					while (true) {
						izraz.setInt(1, KontrolaUnosa.unosInteger("Unesite šifru reda u tablici model koji želite obrisati"));
						dialogButton = JOptionPane.showConfirmDialog(null, "Jeste li sigurni da želite obrisati ovaj podatak?", 
								"Brisanje podatka",JOptionPane.YES_NO_OPTION);
						if (dialogButton == JOptionPane.YES_OPTION) {
							JOptionPane.showMessageDialog(null,  "Uspješno obrisano ("+ izraz.executeUpdate() + ")");
							break izlaz;
						}
					}
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
	
}
