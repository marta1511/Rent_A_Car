package cerovecki.ljetnizadatak;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class PrikazTablice{
	public static Connection veza;
	public static PreparedStatement izraz;
	
	public static void prikazTablice(String poruka) {
		veza = Baza.getConnection();
		
		try {
			PreparedStatement izraz = veza.prepareStatement(poruka);
			ResultSet rs = izraz.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();
			int numberofcolumns = rsmd.getColumnCount();
			for (int i = 1; i <=numberofcolumns; i++) {
				System.out.print(rsmd.getColumnName(i) + " | ");
			}
			while (rs.next()) {
				for (int i = 1; i <= numberofcolumns; i++) {
					if (i > 1)
						System.out.print(" | ");
					System.out.print(rs.getString(i));
				}
				System.out.println("");
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
