import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String textBlock = """
        Available actions (select word or letter):
        (F)ORWARD
        (B)ackward
        (L)ist Places
        (M)enu
        (Q)uit
        """;
        System.out.print(textBlock);
        System.out.print("Enter choice: ");
        String choice = scanner.next().toUpperCase();
        System.out.println(choice);
        switch (choice){
            case "F" , "FORWARD":
                forward();
                System.out.println("Move Forward");
                break;
            case "B" , "BACKWARD":
                backward();
                System.out.println("Move Backward");
                break;
            case "L" , "LIST PLACES":
                listPlaces();
                break;
            case "Menu" , "M":
                String placesToVisit = """
        Town            Distance from Sydney (in km)
        Adelaide        1374
        Alice Springs   2771
        Brisbane        917
        Darwin          3972
        Melbourne       877
        Perth           3923""";
                System.out.println(placesToVisit);
                break;
            case "Quit","Q":
                System.out.println("Thank you and Good Bye!");
        }

    }

    private static void backward() {
    }

    private static void forward() {

        listPlaces();
    }

    private static void listPlaces() {

        LinkedList<Town> towns = new LinkedList<>();
        towns.add(new Town("Adelaide",1374));
        towns.add(new Town("Alice Springs",2771));
        towns.add(new Town("Brisbane",917));
        towns.add(new Town("Darwin",3972));
        towns.add(new Town("Melbourne",877));
        towns.add(new Town("Perth",3923));
//        System.out.println(towns);
        ListIterator<Town> iterator = towns.listIterator();

        while (iterator.hasNext()){
            var town1 = iterator.next();
//            System.out.println(town);
//            var previousTown = town;
            System.out.println(town1);
        }
        System.out.println();

        }
    }

