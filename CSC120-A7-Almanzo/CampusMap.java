import java.util.ArrayList;

public class CampusMap {

    ArrayList<Building> buildings;

    /* Default constructor, initializes empty ArrayList */
    public CampusMap() {
        buildings = new ArrayList<Building>();
    }

    /**
     * Adds a Building to the map
     * @param b the Building to add
     */
    public void addBuilding(Building b) {
        System.out.println("Adding building...");
        buildings.add(b);
        System.out.println("-->Successfully added " + b.getName() + " to the map.");
    }

    /**
     * Removes a Building from the map
     * @param b the Building to remove
     * @return the removed Building
     */
    public Building removeBuilding(Building b) {
        System.out.println("Removing building...");
        buildings.remove(b);
        System.out.println("-->Successfully removed " + b.getName() + " to the map.");
        return b;
    }

    public String toString() {
        String mapString = "DIRECTORY of BUILDINGS";

        for (int i = 0; i < this.buildings.size(); i ++) {
            mapString += "\n  " + (i+1) + ". "+ this.buildings.get(i).getName() + " (" + this.buildings.get(i).getAddress() + ")";
        }
        return mapString;
    }

    public static void main(String[] args) {
        CampusMap myMap = new CampusMap();
        
        myMap.addBuilding(new Building("Ford Hall", "100 Green Street Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("Bass Hall", "4 Tyler Court Northampton, MA 01063", 4));
        myMap.addBuilding(new Building("SabinReed Hall", "44 College Ln, Northampton, MA 01063", 4)); //1
        myMap.addBuilding(new Building("McConnell Hall", "01063, 2 Tyler Ct, Northampton, MA 01060", 5)); //2
        myMap.addBuilding(new Building("Wright Hall", "5 Chapin Way, Northampton, MA 01063", 2)); //3
        myMap.addBuilding(new House("Tyler House", "151-199 Green St, Northampton, MA 01060", 4, true )); //4
        myMap.addBuilding(new House("Lawrance House", "78 Green St, Northampton, MA 01060", 4, true)); //5
        myMap.addBuilding(new Cafe("Campus Center", "Smith College Campus Center, 100 Elm St, Northampton, MA 01063", 4)); //6
        myMap.addBuilding(new Building("Wilder House", "1 Mandelle Rd, Northampton, MA 01063", 5)); //7
        myMap.addBuilding(new Building("Sage Hall", "144 Green St, Northampton, MA 01063", 4)); //8
        myMap.addBuilding(new Building("Alumnae Gymnasium", "83 Green St, Northampton, MA 01063", 3)); //9
        myMap.addBuilding(new Library("Smith College Museum of Art", "20 Elm St, Northampton, MA 01063", 4)); //10
  
        System.out.println(myMap);
    }
    
}
