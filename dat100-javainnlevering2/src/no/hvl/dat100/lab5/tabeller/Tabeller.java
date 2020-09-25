package no.hvl.dat100.lab5.tabeller;

public class Tabeller {

	public static void main(String[] args) {
		int[] tab = new int[]{ 5, 6, 4, 5};
		
		System.out.print("Tabellen: ");
		
		skrivUt(tab);
		
		System.out.println("\nReturverdi: " + summer(tab));

	}
	
	// a)
	public static void skrivUt(int[] tabell) {

		String txt = "[ ";
				
		for(int i = 0; i < tabell.length; i++) {
			
			
			
			if(i != tabell.length-1) {
				txt += tabell[i] + ",";
			} else {
				txt += tabell[i];
			}
			
		}
		
		txt += " ]";
		
		System.out.println(txt);
		
		//throw new UnsupportedOperationException("skrivUt ikke implementert");
	}

	// b)
	public static String tilStreng(int[] tabell) {

		String txt = "[";
		
		for(int i = 0; i < tabell.length; i++) {
			
			if(i != tabell.length-1) {
				txt += tabell[i] + ",";
			} else {
				txt += tabell[i];
			}
			
			
		}
		
		txt += "]";
		
		return txt;
		//throw new UnsupportedOperationException("tilStreng ikke implementert");
		
	}

	// c)
	public static int summer(int[] tabell) {
		
		System.out.println("\n-------------\nsummer(): \n");

		int sum = 0;
		int teller = 0;
		
		//metode 1
		for(int i = 0; i < tabell.length; i++) {
			
			sum += tabell[i];
			
		}
		
		System.out.println("For løkke: " + sum);
		
		sum = 0;
		
		
		//metode 2
		while(teller < tabell.length) {
			
			sum += tabell[teller];
			
			teller++;
		}
		
		System.out.println("While løkke: " + sum);
		
		sum = 0;
		
		//metode 3
		for(int element : tabell) {
			sum += element;
		}
			
		System.out.println("Utvidet for løkke: " + sum);
		
		return sum;
		
		//throw new UnsupportedOperationException("summer ikke implementert");
	}

	// d)
	public static boolean finnesTall(int[] tabell, int tall) {

		for(int elem : tabell) {
			if(elem == tall) {
				return true;
			}
		}
		return false;
	}

	// e)
	public static int posisjonTall(int[] tabell, int tall) {

		for(int i = 0; i < tabell.length; i++) {
			if(tabell[i] == tall) {
				return i;
			}
		}
		return -1;
		
		
		//throw new UnsupportedOperationException("posisjonTall ikke implementert");

	}

	// f)
	public static int[] reverser(int[] tabell) {

		int[] nyTabell = new int[tabell.length];
		int teller = tabell.length-1;
		
		for(int i = 0; i < tabell.length; i++) {
			nyTabell[i] = tabell[teller];
			teller--;
		}
		
		return nyTabell;
		//throw new UnsupportedOperationException("reverser ikke implementert");
		
	}

	// g)
	public static boolean erSortert(int[] tabell) {

		int tempT = -69999;
		
		for(int i = 0; i < tabell.length; i++) {
			if(tabell[i] < tempT) {
				return false;
			}
			tempT = tabell[i];
			
		}
		return true;
		//throw new UnsupportedOperationException("erSortert ikke implementert");
	}

	// h)
	public static int[] settSammen(int[] tabell1, int[] tabell2) {

		int[] nyTab = new int[tabell1.length + tabell2.length];
		
		
		for(int i = 0; i < tabell1.length; i++) {
			nyTab[i] = tabell1[i];
		}
		
		for(int i = 0; i < tabell2.length; i++) {
			nyTab[i + tabell1.length] = tabell2[i];
		}
		
		return nyTab;
		
		
		//throw new UnsupportedOperationException("settSammen ikke implementert");
	}
}
