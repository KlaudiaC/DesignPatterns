package komputer;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        Strategy sorting = new Strategy();
        int choice;
        boolean ok = false;

        while(!ok){
            System.out.println("Jaki jest format pliku?");
            System.out.println("1) Tekstowy.");
            System.out.println("2) XML.");
            System.out.print("Wybor: ");
            choice = scan.nextInt();
            if(choice == 1){
                sorting.setRead(new StandardRead());
                ok = true;
            }
            else if(choice == 2){
                sorting.setRead(new XMLRead());
                ok = true;
            }
            else
                System.out.println("Blad. Nie ma takiej opcji.\n");
        }

        while(ok){
            System.out.println("W jakim formacie zapisac wynik?");
            System.out.println("1) Tekstowym.");
            System.out.println("2) XML.");
            System.out.print("Wybor: ");
            choice = scan.nextInt();
            if(choice == 1){
                sorting.setSave(new StandardSave());
                ok = false;
            }
            else if(choice == 2){
                sorting.setSave(new XMLSave());
                ok = false;
            }
            else
                System.out.println("Blad. Nie ma takiej opcji.\n");
        }

        while(!ok){
            System.out.println("Jaka metoda posortowac?");
            System.out.println("1) Standardowa (systemowa).");
            System.out.println("2) Sortowanie przez wstawianie.");
            System.out.print("Wybor: ");
            choice = scan.nextInt();
            if(choice == 1){
                sorting.setSort(new StandardSort());
                ok = true;
            }
            else if(choice == 2){
                sorting.setSort(new InsertionSort());
                ok = true;
            }
            else
                System.out.println("Blad. Nie ma takiej opcji.\n");
        }

        sorting.doWork("in_standard.txt");
        // sorting.doWork("in_xml.txt");
    }
}
