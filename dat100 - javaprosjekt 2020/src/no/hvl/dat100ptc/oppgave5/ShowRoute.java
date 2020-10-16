package no.hvl.dat100ptc.oppgave5;

import javax.swing.JOptionPane;

import easygraphics.EasyGraphics;
import no.hvl.dat100ptc.TODO;
import no.hvl.dat100ptc.oppgave1.GPSPoint;
import no.hvl.dat100ptc.oppgave3.GPSUtils;
import no.hvl.dat100ptc.oppgave4.GPSComputer;

public class ShowRoute extends EasyGraphics {

	private static int MARGIN = 50;
	private static int MAPXSIZE = 800;
	private static int MAPYSIZE = 800/2;

	private GPSPoint[] gpspoints;
	private GPSComputer gpscomputer;
	
	public ShowRoute() {

		String filename = JOptionPane.showInputDialog("GPS data filnavn: ");
		gpscomputer = new GPSComputer(filename);

		gpspoints = gpscomputer.getGPSPoints();

	}

	public static void main(String[] args) {
		launch(args);
	}

	public void run() {

		makeWindow("Route", MAPXSIZE + 2 * MARGIN, MAPYSIZE + 2 * MARGIN);

		showRouteMap(MARGIN + MAPYSIZE);
		
		showStatistics();
	}

	// antall x-pixels per lengdegrad
	public double xstep() {

		double maxlon = GPSUtils.findMax(GPSUtils.getLongitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));

		double xstep = MAPXSIZE / (Math.abs(maxlon - minlon)); 

		return xstep;
	}

	// antall y-pixels per breddegrad
	public double ystep() {
	
		double ystep;
		
		double maxlat = GPSUtils.findMax(GPSUtils.getLatitudes(gpspoints));
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));

		
		//Deler map størrelsen på differansen mellom største og minste punkt
		ystep = MAPYSIZE / (Math.abs(maxlat - minlat)); 

		return ystep;
	}

	public void showRouteMap(int ybase) {
		
		int x = 0, y = 0;
		int oldx = 0, oldy = 0;
		int rad = 2;
		
		int[] allX = new int[gpspoints.length]; 
		int[] allY = new int[gpspoints.length] ;
		
		setColor(0, 150, 0);
		
		double minlat = GPSUtils.findMin(GPSUtils.getLatitudes(gpspoints));
		double minlon = GPSUtils.findMin(GPSUtils.getLongitudes(gpspoints));
		
		
		for(int i = 0; i < gpspoints.length; i++) {
			if(i > 0) {
				oldx = x;
				oldy = y;
			}
			//setColor((int)Math.round(Math.random() * 255), (int)Math.round(Math.random() * 255), (int)Math.round(Math.random() * 255));
			x = MARGIN + (int) ((gpspoints[i].getLongitude() - minlon) * xstep());
			y = ybase - (int) ((gpspoints[i].getLatitude() - minlat) * ystep());
			
			allX[i] = x;
			allY[i] = y;
			if(i > 0) {
				drawLine(oldx, oldy, x, y);
			}
			fillCircle(x, y, rad);
			System.out.println("x: " + x + ", y: " + y);
			
		}
		playRoute(allX, allY, rad, ybase);
		
	}

	public void showStatistics() {

		int TEXTDISTANCE = 20;

		setColor(0,0,0);
		setFont("Courier",12);
		
	}
	
	public void playRoute(int[] x, int[] y, int rad, int ybase) {
		
		setSpeed(1);
		setColor(0, 0, 255);
		int circle = fillCircle(x[0], y[0], rad+rad);
		
		
		
		for(int i = 1; i < gpspoints.length; i++) {
			pause(300);
			moveCircle(circle, x[i], y[i]);
		}
	}

}
