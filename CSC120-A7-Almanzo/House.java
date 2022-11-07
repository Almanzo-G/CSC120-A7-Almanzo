import java.util.ArrayList;

/** class extends from superclasss Building */
public class House extends Building{
  
    /** add attributes of a arraylist of residents and a boolean to check whether there is a diningroom 
    * @param ArrayList of residents
    * @param boolean to tell whether there is a Dining room
    * @param boolean to tell whether there is ab elevator
    */
    private static ArrayList<String> residents; 
    private boolean hasDiningRoom;
    private boolean haselevator;
  
    /** constructor 
    * inherite attributes from Building 
    */
    public House(String name, String address, int nFloors, boolean haselevator) {
    
        super(name, address, nFloors);
    
        House.residents = new ArrayList<String>();

        System.out.println("You have built a house: 🏠");

    }


    /** Default constructor */
    public House() {
        this("Name Unknown", "Address Unknown", 1, false);
    }

    /** @overload the constructor when at its default status when some houses' information is missing or unknown
    * @param String name to to indicator when only known the name of the house
    */
    // overloading constructor, 1
    public House(String name){

        this(name, "Northampton, MA 01063", 1, false);
  
    }

    /** a method to show all the methods using in the class
    * @return print a line to include what methods are using in the class
    */
    public void showOptions(){
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + hasDiningroom() \n + nResidents() \n + moveIn() \n + moveOut() \n + isResident()\n ");
    }

    /** add accessors 
    * @return the answer of whether there is a dining room
    */
    public boolean hasDiningRoom(){
        return hasDiningRoom;
    }

    /** add methods about how many residents
    * @return the number of residents by returning the size of arraylist
    */
    public int nResidents(){
        int nResidents = residents.size();
        return nResidents;
    }

    /** add methods of move in residents
    * @param name, the name of person move into the house
    */
    public void moveIn(String name){
      residents.add(name);
    }

    /** @overload a method with no input for moveIn method, since sometimes someone comes but no one knows who is him/her/they, which I used this overloading method to show: there is someone entering but not know who is that? */
    // overloading method, 2
    public void moveIn(){
      residents.add("Some one");
    }

    /** add methods of move out residents
    * @param name, the name of the person move out from the house
    */
    public void moveOut(String name){
      String removedresident = residents.remove(residents.indexOf(name));
      System.out.println(removedresident + " is not in the house.");
    }

    /** add a boolean method to identify whether person is the residents or not
    * @param person find out the person is a resident or not
    * @return answer of whether is a resident
    */
    public boolean isResident(String person){
  
        // using boolean to tell true or false
        boolean answer = residents.contains(person);
        //a if loop to itentify
        if (answer){
            System.out.println(person + " is a resident.");
            return answer;
        } else {
            System.out.println(person + " is not our resident.");
            return answer;
        }
    }

    /** add a method to indicate whether there is a elevator or not */
    public boolean haselevator(){
        return haselevator();
    }

    /** add a method of goToFloor which inherited from the building class
    * @param int floorNum is the floor number some one would like to go through the elevator
    * @return print a line to indicate which floor some one is on
    */
    public void goToFloor(int floorNum){
        if (haselevator){
            super.goToFloor(floorNum);
        } else {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        }

        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    /** test main */
    public static void main(String[] args) {
        House Morris = new House("Morris", "Green Street", 2, true);
        System.out.println(Morris);
    
        House A = new House("Ahouse");
        System.out.println(A);

        //Morris.showOptions();

        //Morris.enter();
        //Morris.goToFloor(2);

        Morris.moveIn("Almanzo");
        Morris.moveIn("bbbbb");
        Morris.moveIn();
        System.out.println(Morris.nResidents());
        System.out.println(residents);
        /** Morris.moveOut("Almanzo");
        System.out.println(residents);
        Morris.isResident("Almanzo");
        System.out.println(Morris.isResident("ccccc"));
        System.out.println(Morris.isResident("bbbbb"));
        System.out.println(Morris.isResident("aaaaa"));
        */
    }
}