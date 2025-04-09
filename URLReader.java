import java.net.*;
import java.io.*;

public class URLReader {
    public static void main(String[] args) throws Exception {

        URL sattelites = new URL("https://celestrak.org/NORAD/elements/gp.php?GROUP=last-30-days&FORMAT=tle");
        BufferedReader in = new BufferedReader(
        new InputStreamReader(sattelites.openStream()));

        String name, tle1, tle2;
        int num=1, launchYear, catalogNum, hhOC;
        double orbitalInclination, holdOC;
        //change loop so that it reads 3 lines per itteration
        while (((name = in.readLine()) != null))
        {
            tle1 = in.readLine();
            tle2 = in.readLine();
            launchYear=Integer.parseInt(tle1.substring(9,11));
            catalogNum=Integer.parseInt(tle2.substring(2,7));
            holdOC=Double.parseDouble(tle2.substring(8,16));
            //"multiply by 100, giving you cents; add (or subtract if the number is negative) 0.5, so the next step rounds to the nearest cent; cast to int, which truncates the decimal part; divide by 100d, giving you dollars)"
            holdOC*=100;
            holdOC+=0.5;
            hhOC=(int)(holdOC);
            orbitalInclination=hhOC/100.0;
            for(int i=0;i<30;i++)
               System.out.print("-");
            System.out.println("\nSattelite no."+num+"\nSattelite name: "+name);
            System.out.println("Launch Year: "+launchYear);
            System.out.println("Catalog Number: "+catalogNum);
            System.out.println("Orbital Inclination: "+orbitalInclination);
            for(int i=0;i<30;i++)
               System.out.print("-");
            num++;
        }
        in.close();
    }
}