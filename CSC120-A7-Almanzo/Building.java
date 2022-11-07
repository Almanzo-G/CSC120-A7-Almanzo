//import javax.management.RuntimeErrorException;

/** The parent class Building
* @param String of the name of the building
* @param String of the address of the building
* @param int of how many floors the building has 
* @param int of the activefloor which is -1 as the default number
*/
public class Building {

    protected String name;
    protected String address;
    protected int nFloors;
    protected int activeFloor = -1; // Default value indicating we are not inside this building

    /** Default constructor */
    public Building() {
        this("<Name Unknown>", "<Address Unknown>", 1);
    }

    /** Overloaded constructor with address only
     * @param String of the address of the building
     */
    public Building(String address) {
        this(); // Call default constructor
        this.address = address; // Override address
    }

    /** Overloaded constructor with name, address
    * @param String of the name of the building
    * @param String of the address of the building
    */
    public Building(String name, String address) {
        this(name, address, 1); // Call full constructor with hard-coded # floors
    }

    /** Full constructor 
    * @param String of the name of the building
    * @param String of the address of the building
    * @param int of how many floors the building has 
    */
    public Building(String name, String address, int nFloors) {
        if (name != null) { this.name = name; }
        if (address != null) { this.address = address; } 
        if (nFloors < 1) {
            throw new RuntimeException("Cannot construct a building with fewer than 1 floor.");
        }
        this.nFloors = nFloors;
    }

    /** Accessors 
    * @return the name of the building  
    * @return the address of the building 
    * @return the number of the floor in the building 
    */
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public int getFloors() {
        return this.nFloors;
    }

    /** Navigation methods */
    public Building enter() {
        if (activeFloor != -1) {
            throw new RuntimeException("You are already inside this Building.");
        }
        this.activeFloor = 1;
        System.out.println("You are now inside " + this.name + " on the ground floor.");
        return this; // Return a pointer to the current building
    }

    public Building exit() {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before exit().");
        }
        if (this.activeFloor > 1) {
            throw new RuntimeException("You have fallen out a window from floor #" +this.activeFloor + "!");
        }
        System.out.println("You have left " + this.name + ".");
        this.activeFloor = -1; // We're leaving the building, so we no longer have a valid active floor
        return null; // We're outside now, so the building is null
    }

    public void goToFloor(int floorNum) {
        if (this.activeFloor == -1) {
            throw new RuntimeException("You are not inside this Building. Must call enter() before navigating between floors.");
        }
        if (floorNum < 1 || floorNum > this.nFloors) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building is 1-" + this.nFloors +".");
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
    }

    public void goUp() {
        this.goToFloor(this.activeFloor + 1);
    }

    public void goDown() {
        this.goToFloor(this.activeFloor - 1);
    }

    /** a method to show all the methods using in the class
    * @return print a line to include what methods are using in the class
    */
    public void showOptions() {
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n)");
    }

    public String toString() {
        return this.name + " is a " + this.nFloors + "-story building located at " + this.address + ".";
    }

    /** test the main */
    public static void main(String[] args) {
        System.out.println("------------------------------------");
        System.out.println("Test of Building constructor/methods");
        System.out.println("------------------------------------");
        
        Building fordHall = new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4);
        System.out.println(fordHall);
        fordHall.showOptions();

        System.out.println("-----------------------------------");
        System.out.println("Demonstrating enter/exit/navigation");
        System.out.println("-----------------------------------");
        fordHall.enter();
        fordHall.goUp();
        fordHall.goDown();
        fordHall.exit();

        Building fordHalll = new Building("aaa","100 street");
        System.out.println(fordHalll);
    }

}
