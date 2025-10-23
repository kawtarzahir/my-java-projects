// Consider the class AlienZoo that models a container of objects of type Alien. 
// Each alien is characterized by:
//
// 1. an integer identifier,
// 2. a string representing its species,
// 3. and an enumeration representing the Planet where it comes from.
//
// Provide the implementation of the classes AlienZoo and Alien, appropriately defining
// the fields and constructors. It is NOT necessary to provide a full implementation of the Planet enum.

import java.util.LinkedList;

public class AlienZoo {
    private LinkedList<Alien> list;

    public AlienZoo() {
        list = new LinkedList<Alien>();
    }

    // Write the code for the following methods, which serve these purposes:

    // 1. Add a new alien to the zoo if it is not already present. 
    // The zoo cannot contain multiple aliens with the same ID and planet.
    // The method returns true if the alien was added, false otherwise.
  
    public boolean addAlien(Alien a) {
        for (Alien alien : list) {
            if (alien.getId() == a.getId() && alien.getPlanet().equals(a.getPlanet())) {
                return false;
            }
        }
        list.add(a);
        return true;
    }

    // 2. Release an alien from a given planet (the first occurrence in the zoo).
    // Releasing means removing it from the zoo, if present.
    // The method returns a reference to the Alien object if it was found and removed, null otherwise.
  
    public Alien releaseAlien(Planet p) {
        for (Alien alien : list) {
            if (alien.getPlanet().equals(p)) {
                list.remove(alien);
                return alien;
            }
        }
        return null;
    }

    // 3. Get a list of all aliens coming from a given planet, passed as an argument.
    // If no aliens are from that planet, an empty list is returned.
  
    public LinkedList<Alien> aliensFromPlanet(Planet p) {
        LinkedList<Alien> fromPlanet = new LinkedList<Alien>();
        for (Alien alien : list) {
            if (alien.getPlanet().equals(p)) {
                fromPlanet.add(alien);
            }
        }
        return fromPlanet;
    }

    // 4. Check if the zoo is empty or not. 
    // An empty zoo contains no aliens.
  
    public boolean isZooEmpty() {
        return list.isEmpty();
    }
}

class Alien {
    private int id;
    private String species;
    private Planet planet;

    public Alien(int id, String species, Planet planet) {
        this.id = id;
        this.species = species;
        this.planet = planet;
    }

    public int getId() {
        return id;
    }

    public String getSpecies() {
        return species;
    }

    public Planet getPlanet() {
        return planet;
    }
}

enum Planet {
    EARTH, MARS, VENUS, JUPITER, SATURN, NEPTUNE, PLUTO
}
