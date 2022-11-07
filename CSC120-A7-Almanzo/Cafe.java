/** extend from the superclass Building
 * @param nCoffeeOunces, the number of ounces of coffee remaining in inventor
 * @param nSugarPackets, the number of sugar packets remaining in inventory
 * @param nCreams, the number of "splashes" of cream remaining in inventory
 * @param nCups, the number of cups remaining in inventory
 */
public class Cafe extends Building {

    private int nCoffeeOunces;
    private int nSugarPackets;
    private int nCreams;
    private int nCups;
    private boolean haselevator;

    /** construtor
     *inherite attributes from Building
     *set the initial numbers of coffee quantity, sugarpackets, creams, and cups.
     */
    public Cafe(String name, String address, int nFloors){

        super(name, address, nFloors);
        System.out.println("You have built a cafe: ☕");

        this.nCoffeeOunces = 100;
        this.nSugarPackets = 100;
        this.nCreams = 100;
        this.nCups = 100;

    }
    
    /** Default constructor */
    public Cafe() {
        this("Name unknown cafe", "address unknown", 1);
        }
  
    /** @overload the constructor to a default one, since people do not know so much information about a library sometimes */
    // overloading constructor, 1
    public Cafe(String name) {
        this("cafe","Smith College", 1);
        this.name = name;
      }

    /** a method to show all the methods using in the class
    * @return print a line to include what methods are using in the class
    */
    public void showOptions(){
        super.showOptions();
        System.out.println("Available options at " + this.name + ":\n + enter() \n + exit() \n + goUp() \n + goDown()\n + goToFloor(n) \n + sellCoffee() \n + restock() \n ");
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
        if (floorNum < 1 || floorNum > this.nFloors || floorNum > 1) {
            throw new RuntimeException("Invalid floor number. Valid range for this Building for customers is floor 1.");
        }
        }
        System.out.println("You are now on floor #" + floorNum + " of " + this.name);
        this.activeFloor = floorNum;
      }

    /** add a method to sell coffee and decrease the remaining inventory 
    * if everything is enough, cafe can sell the coffee. If not, just restock, which is called from outside the selling method.
    */
    public void sellCoffee(int size, int sweet, int cream){
        
        if(size<nCoffeeOunces&&sweet<nSugarPackets&&cream<nCreams&&nCups>1){
        this.nCoffeeOunces -= size;
        this.nSugarPackets -= sweet;
        this.nCreams -= cream;
        this.nCups -= 1;
        } else {
        this.restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
        }
    }

    /** @overload the method of sellCoffee since sometimes customers would like to order more than one cup, maybe someone like me who is crazy about coffee and would like to order several kinds each time to cafe */
    // overload method, 2
    public void sellCoffee(int size, int sweet, int cream, int nCups){
        
        if(size<nCoffeeOunces&&sweet<nSugarPackets&&cream<nCreams&&nCups>1){
            this.nCoffeeOunces -= size;
            this.nSugarPackets -= sweet;
            this.nCreams -= cream;
            this.nCups -= nCups;
            } else {
            this.restock(nCoffeeOunces, nSugarPackets, nCreams, nCups);
            }
    }
    
    /** add a method restock to check out whether there is enough materials and accesories inside sellCoffee */
    private void restock(int nCoffeeOunces, int nSugarPackets, int nCreams, int nCups){
       
        this.nCoffeeOunces += nCoffeeOunces;
        this.nSugarPackets += nSugarPackets;
        this.nCreams += nCreams;
        this.nCups += 1;

    }
    
    /** test the main */
    public static void main(String[] args) {
        Cafe cafeee = new Cafe();
        System.out.println(cafeee);

        Cafe cafee = new Cafe("cafe");
        System.out.println(cafee);
        
        cafee.sellCoffee(1,1,1);
        System.out.println(cafee.nCups);

        cafee.sellCoffee(1,1,1,3);
        System.out.println(cafee.nCups);

       //cafee.showOptions();

        //cafee.enter();
        //cafee.goToFloor(1);
        
        
    }
    
}
