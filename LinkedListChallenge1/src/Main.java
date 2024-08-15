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
                System.out.println("Move Forward");
                break;
            case "B" , "BACKWARD":
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
        Perth           3923""";System.out.println(placesToVisit);
        }

    }

    private static void listPlaces() {

        LinkedList<String> name = new LinkedList<>();
        name.add(0,"Sydney");
        name.add(1,"Adelaide");
        name.add(2,"Alice Springs");
        name.add(3,"Brisbane");
        name.add(4,"Darwin");
        name.add(5,"Melbourne");
        name.add(6,"Perth");
        System.out.println(name);
        ListIterator<String> iterator = name.listIterator();
        String startingTown = name.getFirst();
        while (iterator.hasNext()){
            var town = iterator.next();
//            System.out.println(town);
//            var previousTown = town;
            System.out.println(startingTown + " to " + town);
        }
        System.out.println();
        Iterator iterator1 = name.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }
    }
}
