import java.net.*;
import java.io.*;

public class KlijentMain 
{
	public static void main(String[] args) 
	{
		try
		{
			Socket konekcija = new Socket("192.168.2.207", 1234);

			InputStream saServera = konekcija.getInputStream();
			InputStreamReader citac = new InputStreamReader(saServera);
			BufferedReader bCitac = new BufferedReader(citac);

			//BufferedReader primer = new InputStreamReader(konekcija.GetInputStream());
			//izlazniTok.read(b) //Ovde su bajti :( :( :(
			//citac.read(cbuf) //Ovde su karakteri :(
			//bCitac.readLine() //Ovde fino dobijem string :) 

			InputStream konzola = System.in;
			InputStreamReader citacKonzole = new InputStreamReader(konzola);
			BufferedReader odKorisnika = new BufferedReader(citacKonzole);


			while (true)
			{
				System.out.println("Unesite nesto: ");
				String poruka = odKorisnika.readLine();

				OutputStream kaServeru = konekcija.getOutputStream();
				OutputStreamWriter upisivac = new OutputStreamWriter(kaServeru);
				BufferedWriter bUpisivac = new BufferedWriter(upisivac);

				bUpisivac.write(poruka);
				bUpisivac.newLine();
				bUpisivac.flush();

				System.out.println("Ovo je za pauzu, unesi q da izadjes :) ");
				odKorisnika.readLine();
				if (bCitac.ready())
					System.out.println(bCitac.readLine());
			}


		} catch (IOException joj)
		{
			joj.printStackTrace();
		}

	}
}
