package cerovecki.ljetnizadatak;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Url {
	public static Connection veza;
	public static PreparedStatement izraz;
	
	public static void urlEra () {
		try {
            URL url = new URL("https://github.com/marta1511/Rent_A_Car/blob/master/RentACar/era%20dijagram.png");
            URLConnection u = url.openConnection();
            DataInputStream dis = new DataInputStream(u.getInputStream());
          
            dis.close();
        } catch (MalformedURLException me) {
            System.out.println("MalformedURLException: " + me);
        } catch (IOException ioe) {
            System.out.println("IOException: " + ioe);
        }
	}
	
}
