package controller;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

public class calendrier {

	
	
	private static void afficherMois(int mois, int annee) {
		GregorianCalendar calendrier = new GregorianCalendar(annee, mois, 1);
		
		System.out.printf(" * %s %d * %n", 
				calendrier.getDisplayName(GregorianCalendar.MONTH, GregorianCalendar.LONG_FORMAT, Locale.FRANCE),
				calendrier.get(GregorianCalendar.YEAR));
		
		System.out.println("L  Ma Me  J  V  S  D");
		
		int decalage = 0; 
		switch(calendrier.get(GregorianCalendar.DAY_OF_WEEK)) {
			case GregorianCalendar.TUESDAY: 
				decalage = 1;
				break;
			case GregorianCalendar.WEDNESDAY: 
				decalage = 2;
				break;
			case GregorianCalendar.THURSDAY: 
				decalage = 3;
				break;
			case GregorianCalendar.FRIDAY: 
				decalage = 4;
				break;
			case GregorianCalendar.SATURDAY: 
				decalage = 5;
				break;
			case GregorianCalendar.SUNDAY: 
				decalage = 6;
				break;
		}
		
		for(int i = 0 ; i < decalage ; i++) {
			System.out.print("   ");
		}
		
		int nbJoursMois = calendrier.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
		
		for(int i = 1; i <= nbJoursMois ; i++) {
			System.out.printf("%02d ", calendrier.get(GregorianCalendar.DAY_OF_MONTH));
			calendrier.add(GregorianCalendar.DAY_OF_MONTH, 1);
			
			if(calendrier.get(GregorianCalendar.DAY_OF_WEEK) == GregorianCalendar.MONDAY) {
				System.out.println();
			}
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		int mois;
		int annee;
		String choix; 
		Scanner sc = new Scanner(System.in);
		
		GregorianCalendar calendrier = new GregorianCalendar();
		
		do {
			
			afficherMois(calendrier.get(GregorianCalendar.MONTH), calendrier.get(GregorianCalendar.YEAR)); 
			System.out.println();
			
			System.out.println("****Entrez la commande que vous souhaitez****");
			System.out.println("**** - : mois précédent *********************");
			System.out.println("**** + : mois suivant ***********************");
			System.out.println("***** p : mois personnalisé *****************");
			System.out.println("***** q : quitter ***************************");
			System.out.println();
			
			choix = sc.nextLine();
		
			switch(choix) {
				case "-" : 
					calendrier.add(GregorianCalendar.MONTH, -1);
					break;
				case "+" : 
					calendrier.add(GregorianCalendar.MONTH, 1);
					break;
				case "p" : 
					System.out.println("Indiquez l'année que vous souhaitez voir");
					annee = sc.nextInt();
					sc.nextLine();
					System.out.println("Indiquez le mois que vous souhaitez voir");
					mois = sc.nextInt();
					sc.nextLine();
					calendrier.set(annee, mois -1, 1);
					break;
				case "q" : 
					break;
				default : 
					System.err.println("Saisie incorrecte");
					break;
			}
		
			
			
		} while(!choix.equals("q"));
		
	}

}
