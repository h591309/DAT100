package no.hvl.dat100ptc.oppgave3;

import static java.lang.Math.*;

import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;

public class GPSUtils {
	
	public static double findMax(double[] da) {

		double max; 
		
		max = da[0];
		
		for (double d : da) {
			if (d > max) {
				max = d;
			}
		}
		
		return max;
	}

	public static double findMin(double[] da) {

		double min;
		
		min = da[0];
		
		for (double d : da) {
			if (d < min) {
				min = d;
			}
		}
		return min;
	}

	public static double[] getLatitudes(GPSPoint[] gpspoints) {

		double[] gpsLatitudes = new double[gpspoints.length];
		
		for(int i = 0; i < gpsLatitudes.length; i++) {
			gpsLatitudes[i] = gpspoints[i].getLatitude();
		}
		
		return gpsLatitudes;
	}

	public static double[] getLongitudes(GPSPoint[] gpspoints) {

		double[] gpsLongitudes = new double[gpspoints.length];
		
		for(int i = 0; i < gpsLongitudes.length; i++) {
			gpsLongitudes[i] = gpspoints[i].getLongitude();
		}
		
		return gpsLongitudes;

	}

	private static int R = 6371000; // jordens radius

	
	//Beregner distanse mellom 2 punkt ved hjelp av Haversine-formelen
	public static double distance(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double d;
		double latitude1, longitude1, latitude2, longitude2;
		
		
		double distLat, distLong;
		
		double a;
		double c;
		
		latitude1 = Math.toRadians(gpspoint1.getLatitude());
		latitude2 = Math.toRadians(gpspoint2.getLatitude());
		longitude1 = Math.toRadians(gpspoint1.getLongitude());
		longitude2 = Math.toRadians(gpspoint2.getLongitude());
		
		
		distLat = latitude1 - latitude2;
		distLong = longitude1 - longitude2;
		
		a = Math.pow(Math.sin(distLat/2), 2) + Math.cos(latitude1) * Math.cos(latitude2) * Math.pow(Math.sin(distLong/2), 2);
		
		c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		
		d = c * R;
		
		return d;
	}

	public static double speed(GPSPoint gpspoint1, GPSPoint gpspoint2) {

		double speed;
		
		double dist = distance(gpspoint1, gpspoint2);
		
		int time = gpspoint2.getTime() - gpspoint1.getTime();
		
		speed = dist/time * 3.6;
		
		
		return speed;
	}

	public static String formatTime(int secs) {

		String timestr = "";
		
		int hr, min, sec;
		
		min = secs / 60;
		sec = secs % 60;
		hr = min / 60;
		min = min % 60;
		
		
		timestr = String.format("  %02d:%02d:%02d", hr, min, sec);
		
		return timestr;
	}
	
	
	private static int TEXTWIDTH = 10;

	public static String formatDouble(double d) {

		String str;
		
		str = String.format("%" + TEXTWIDTH + ".2f", d);
		
		return str;
		
	}
}
