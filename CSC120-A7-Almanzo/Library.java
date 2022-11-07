import java.util.Enumeration;
import java.util.Hashtable;

/** class extends from the superclass Building */
public class Library extends Building{
    
    /** add attribute Hashtable
    * @param Hashtable a hashtable telling the collection in the library about the title of the book and whether it's in the library or not
    */
    private Hashtable <String,Boolean> collection;

    /** construtor
    * inherite attributes from Building 
    */
    public Library(String name, String address, int nFloors){

        super(name, address, nFloors);

        this.collection= new Hashtable<String, Boolean>();

        System.out.println("You have built a library: 📖");
    }

    /** Default constructor */
    public Library() {
        this("Name unknown library", "address unknown", 1);
      }

    /** @overload the constructor to a default one, since people do not know so much information about a library sometimes */
    // overload constructor, 1
    public Library(String name) {
        this("library","Smith College", 1);
        this.name = name;
    }

    /** a method to show all the methods using in the class
    * @return print a line to include what methods are using in the class
    */
    public void showOptions(){
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + addTitle() \n + removeTitle() \n + checkOut() \n + returnBook() \n + containsTitle() \n + isAvailable() \n + printCollection() \n");
    }

    /** add a method of goToFloor which inherited from the building class
    * @param int floorNum is the floor number some one would like to go through the elevator
    * @return print a line to indicate which floor some one is on, which is from super()
    */
    public void goToFloor(int floorNum){
        super.goToFloor(floorNum);
    }

    /** @overload the method goToFloor when the visitors don't know where to go, here is provided a recommendation about go to the second floor of the library */
    // overload method, 2
    public void goToFloor(){
        System.out.println("Not sure about where your should go? Why not try pushing '2' button and see what's on the second floor of the library.");
        super.goToFloor(2);
    }

    /** add a addTitle method to collection 
    * @param title the name of the book that is going to add
    */
    public void addTitle(String title){
        collection.put(title, true);
    }


    /** add a removeTitle method to collection 
    * @param title the book's title which is removed
    * @param removedbooks which is the title of books removed in this method
    * @return the removed books' title
    */
    public String removeTitle(String title){
        String removedbooks;
        removedbooks = Boolean.toString(collection.remove(title)); 
        //System.out.println(removedbooks + " is not in collection.");
        return removedbooks;
    }

    /** add a checkout method 
    * @param title the book's title which is going to be checked out
    */
    public void checkOut(String title){
        // using a if loop to identify whther meet both contain and available requirements
        if(containsTitle(title)&&isAvailable(title)){
            collection.replace(title,true,false);
        } else {
            System.out.println("This book is not available to checkout.");
        }
    }

    /** add a return method 
    * @param title the book's title which is going to be returned
    */
    public void returnBook(String title){
        // using a if loop to identify whther meet both contain and available requirements
        if(containsTitle(title)&&isAvailable(title)){
            collection.replace(title,false,true);
        } else {
            System.out.println("This book has been returned.");
        }
    }

    /** to find out whether it contains the title
    * 
    * @param answer to tell whether the collection contains the book
    * @return answer for that
    */
    public boolean containsTitle(String title){
        boolean answer = collection.containsKey(title);
        if (answer){
            System.out.println(title + " is in the collection.");
            return answer;
        } else {
            System.out.println(title + " is not in the collection.");
            return answer;
        }
    }
    
    /** to find out whether it contains the title
    * @param result to tell whether the book is available in the collection
    * @return result for that
    */
    public boolean isAvailable(String title){
        boolean result = collection.get(title);
        if (result){
            System.out.println(title + " is available.");
            return result;
        } else {
            System.out.println(title + " is not available.");
          return result;
        }
    }

    /** add a method of print out the full list of books with the sentence structure.
    * @param bookstitle is to check whether the book is available in the library.
    */
    public void printCollection(){
        // System.out.println(collection.toString());
        Enumeration<String> enutitle = collection.keys();
        while(enutitle.hasMoreElements()){
            String booktitle = enutitle.nextElement();
            System.out.println(booktitle + " is " + collection.get(booktitle) + " to be available.");
        } 
    }

    /** test the main */
    public static void main(String[] args) {
        Library Neilson = new Library("Neilson", "Chapin way", 3);
        System.out.println(Neilson);

        Neilson.addTitle("book");
        Neilson.addTitle("iii");
        Neilson.addTitle("ooo");
        System.out.println(Neilson.collection);
        Neilson.printCollection();
        Neilson.removeTitle("book");
        System.out.println(Neilson.collection);
        Neilson.printCollection();

        Neilson.showOptions();
        Neilson.enter();
        Neilson.goToFloor();
 
        Library myLibrary1 = new Library();
        System.out.println(myLibrary1);
        Library myLibrary2 = new Library("ASlibarary");
        System.out.println(myLibrary2);
    }
}