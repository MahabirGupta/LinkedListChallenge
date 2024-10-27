package challenge;

import java.util.LinkedList;
import java.util.Scanner;

record Place(String name, int distance){
    @Override
    public String toString() {
//        return "Place{" +
//                "name='" + name + '\'' +
//                ", distance=" + distance +
//                '}';
        return String.format("%s (%d)",name,distance);
    }
};
public class Main {

    public static void main(String[] args) {
//        printMenu();

        LinkedList<Place> placesToVisit = new LinkedList<>();
//        placesToVisit.add(new Place("Adelaide",1374));
//        placesToVisit.add(new Place("Alice Springs",2771));
//        placesToVisit.add(new Place("Brisbane",917));
//        placesToVisit.add(new Place("Darwin",3972));
//        placesToVisit.add(new Place("Melbourne",877));
//        placesToVisit.add(new Place("Perth",3923));
//        System.out.println(placesToVisit);
        Place place = new Place("Adelaide", 1374);
//        placesToVisit.add(place);
        addPlace(placesToVisit, place);
//        after adding
//        System.out.println(placesToVisit);
//        try to add duplicate element
        addPlace(placesToVisit, new Place("adelaide", 1374));

        addPlace(placesToVisit, new Place("Alice Springs", 2771));
        addPlace(placesToVisit, new Place("Brisbane", 917));
        addPlace(placesToVisit, new Place("Darwin", 3972));
        addPlace(placesToVisit, new Place("Melbourne", 877));
        addPlace(placesToVisit, new Place("Perth", 3923));

//        add Sydney as the first place to visit
        placesToVisit.addFirst(new Place("Sydney", 0));


        System.out.println(placesToVisit);

        var iterator = placesToVisit.listIterator();
        Scanner scanner = new Scanner(System.in);
        boolean quitLoop = false;
        boolean forward = true;

        printMenu();
        while (!quitLoop) {
            if (!iterator.hasPrevious()){//check if at the start of the list
                System.out.println("Originating: " + iterator.next());
                forward=true;
            }
            if (!iterator.hasNext()){//check if at the end of the list
                System.out.println("Ending: " + iterator.previous());
                forward=false;
            }
            System.out.print("Enter choice: ");
            String choice = scanner.next().toUpperCase().substring(0, 1);
            System.out.println(choice);
            switch (choice) {
                case "F", "FORWARD":
                    System.out.println("Move Forward");
                    if (!forward) {//Reversing Direction
                        forward = true;
                        if (iterator.hasNext()) {
                            iterator.next();//Adjust position forward
                        }
                    }
                    if (iterator.hasNext()){
                        System.out.println(iterator.next());
                    }
                    break;
                case "B", "BACKWARD":
//                backward();
                    System.out.println("Move Backward");
                    if (forward) {//Reversing Direction
                        forward = false;
                        if (iterator.hasPrevious()) {
                            iterator.previous();//Adjust position backward
                        }
                    }
                    if (iterator.hasPrevious()){
                        System.out.println(iterator.previous());
                    }
                    break;
                case "L", "LIST PLACES":
                    System.out.println(placesToVisit);
                    break;
                case "Menu", "M":
                    printMenu();
                    break;
//                case "Quit", "Q":
//                    System.out.println("Thank you and Good Bye!");
                default:
                    quitLoop = true;
                    break;

            }
        }
    }

    public static void addPlace(LinkedList<Place> list, Place place) {

        if (list.contains(place)) {
            System.out.println(place + " already exits");

        }
        for (Place place1 : list) {
            if (place1.name().equalsIgnoreCase(place.name())) {
                System.out.println(place + " already exits");
                return;
            }
        }

        int matchedIndex = 0;
        for (var listPlace : list) {
            if (place.distance() < listPlace.distance()) {
                list.add(matchedIndex, place);
                return;
            }
            matchedIndex++;

        }
        list.add(place);


//        System.out.println(list);

    }

    public static void printMenu() {

        String textBlock = """
                Available actions (select word or letter):
                (F)ORWARD
                (B)ackward
                (L)ist Places
                (M)enu
                (Q)uit
                """;
        System.out.print(textBlock);


    }


}
