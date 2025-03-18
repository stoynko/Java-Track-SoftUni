package D_OOP.D_InterfacesAndAbstraction.E07_CollectionHierarchy;

import java.util.*;

public class Main {

/*Create 3 different string collections – AddCollection, AddRemoveCollection and MyListImpl.

The AddCollection should have:
    •	Only a single method add(String) which adds an item to the end of the collection.
The AddRemoveCollection should have:
    •	An add(String) method – which adds an item to the start of the collection.
    •	A remove() method removes the last item in the collection.
The MyListImpl collection should have:
    •	An add(String) method adds an item to the start of the collection.
    •	A remove() method removes the first element in the collection.
    •	A used field that displays the size of elements currently in the collection.

Create interfaces that define the functionality of the collection, and think about how to model the relations between interfaces to reuse code.
Add an extra bit of functionality to the methods in the custom collections, add methods should return the index in which the item
was added, remove methods should return the item that was removed.

<<Abstract>>
Collection
-	maxSize: int = 100
-	items: List<String>

Collection()
Your task is to create a single copy of your collections, after which on the first input line you will receive a random amount of
strings in a single line separated by spaces - the elements you have to add to each of your collections.
For each of your collections write a single line in the output that holds the results of all add operations separated by spaces
(check the examples to better understand the format). On the second input line, you will receive a single number -
the amount of remove operations you have to call on each collection. In the same manner as with the add operations for each collection
(except the AddCollection), print a line with the results of each remove operation separated by spaces.

<<Interface>>                   <<Interface>>                   <<Interface>>
Addable                         AddRemovable                    MyList
+ add(String) : int             + remove() : String             + getUsed() : int

AddCollection                   AddRemoveCollection             MyListImpl
+ add(String) : int             + add(String) : int             + add(String)
                                + remove() : String             + remove() : String
                                                                + getUsed() : int

Input
The input comes from the console. It will hold two lines:
    •	The first line will contain a random amount of strings separated by spaces -
        the elements you have to add to each of your collections.
    •	The second line will contain a single number - the amount of removed operations.
Output
The output will consist of 5 lines:
    •	The first line contains the results of all add operations on the AddCollection separated by spaces.
    •	The second line contains the results of all add operations on the AddRemoveCollection separated by spaces.
    •	The third line contains the result of all add operations on the MyListImpl collection separated by spaces.
    •	The fourth line contains the result of all remove operations on the AddRemoveCollection separated by spaces.
    •	The fifth line contains the result of all removes operations on the MyListImpl collection separated by spaces.
Constraints
    •	All collections should have a length of 100.
    •	There will never be more than 100 added operations.
    •	The number of removed operations will never be more than the amount of added operations. */

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        AddCollection addCollection = new AddCollection();
        AddRemovable addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] words = scanner.nextLine().split(" ");
        int itemsToRemove = Integer.parseInt(scanner.nextLine());

        addElements(addCollection, words);
        addElements(addRemoveCollection, words);
        addElements(myList, words);
        removeElements(addRemoveCollection, itemsToRemove);
        removeElements(myList, itemsToRemove);
    }

    public static void addElements (Addable addable, String[] words) {
        for (String word : words) {
            System.out.print(addable.add(word) + " ");
        }
        System.out.println();
    }

    public static void removeElements (AddRemovable addRemoveable, int itemsToRemove) {
        for (int i = 0; i < itemsToRemove; i++) {
            System.out.print(addRemoveable.remove() + " ");
        }
        System.out.println();
    }
}
