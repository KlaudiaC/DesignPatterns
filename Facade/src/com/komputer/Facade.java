package com.komputer;
import java.util.Scanner;

public class Facade{
    private PumpsDriver pumps;
    private BrakeDriver brake;
    private MainSwitchDriver mainSwitch;
    private PowerSwitchDriver powerSwitch;
    private Fan[] fans;
    private static int fansNumber = 2;
    private Scanner scan;

    public Facade(){
        pumps = new PumpsDriver();
        brake = new BrakeDriver();
        mainSwitch = new MainSwitchDriver();
        powerSwitch = new PowerSwitchDriver();
        fans = new Fan[fansNumber];

        for(int i = 1; i <= fansNumber; i++){
            fans[i - 1] = new Fan();
            System.out.println("Wiatrak " +i +": Uruchomiono.");
        }
        scan = new Scanner(System.in);
        choices();
    }

    private void turnOn(int fan){
        System.out.println("Wiatrak " +fan +": " +pumps.turnOn());
        System.out.println("Wiatrak " +fan +": " +brake.turnOff());
        System.out.println("Wiatrak " +fan +": " +mainSwitch.turnOn());
        System.out.println("Wiatrak " +fan +": " +powerSwitch.turnOn());
        System.out.println("Czekaj...");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("Wiatrak " +fan +": " +powerSwitch.turnOff());
        fans[fan - 1].fanSwitch();
        System.out.println("Wiatrak " +fan +": Uruchomiono.\n");
    }

    private void turnOff(int fan){
        System.out.println("Wiatrak " +fan +": " +mainSwitch.turnOff());
        System.out.println("Wiatrak " +fan +": " +brake.turnOn());
        System.out.println("Czekaj...");
        try{
            Thread.sleep(2000);
        }catch(InterruptedException ex){
            Thread.currentThread().interrupt();
        }
        System.out.println("Wiatrak " +fan +": " +pumps.turnOff());
        fans[fan - 1].fanSwitch();
        System.out.println("Wiatrak " +fan +": Zatrzymano.\n");
    }

    private void choices(){
        while(true){
            System.out.println("\nCo chcesz zrobic?");
            System.out.println("1. Wlaczyc wiatrak.");
            System.out.println("2. Wylaczyc wiatrak.");
            System.out.println("3. Wylaczyc program.");
            System.out.print("Twoj wybor: ");
            int n = scan.nextInt();
            switch(n){
                case 1:
                    System.out.print("Podaj numer wiatraka: ");
                    n = scan.nextInt();
                    if(n > fans.length || n < 1)
                        System.out.println("Blad. Nie ma takiego numeru.");
                    else if(fans[n - 1].turnedOn)
                        System.out.println("Blad. Wiatrak " +n +" jest juz wlaczony.");
                    else
                        turnOn(n);
                    break;

                case 2:
                    System.out.print("Podaj numer wiatraka: ");
                    n = scan.nextInt();
                    if(n > fans.length || n < 1)
                        System.out.println("Blad. Nie ma takiego numeru.");
                    else if(!fans[n - 1].turnedOn)
                        System.out.println("Blad. Wiatrak " +n +" jest juz wylaczony.");
                    else
                        turnOff(n);
                    break;

                case 3:
                    System.out.println("Zycze milego dnia.");
                    return;

                default:
                    System.out.println("Blad. Nie ma takiej opcji.\n");
                    break;
            }
        }
    }
}
