/*
🧙‍♂️ Harry Potter : Wizards and Simple Duel

Mission:

- Create a Wizard class with name, house, health (start 100), and magicPower (1-10).

- Create a Spell class with name and damage.

- Wizard can cast a spell on another wizard, reducing their health by spell damage * magicPower / 10.

- Add a method isDefeated() to check if health <= 0.

- Create a simple duel method to simulate one round where each wizard casts a spell on the other.

- Print the health after each spell and who wins or if it’s a tie.

*/

enum House {
    GRYFFINDOR, HUFFLEPUFF, RAVENCLAW, SLYTHERIN
}

// Represents a magical spell with a name and base damage

class Spell {
    private String name;      // Name of the spell
    private int damage;       // Base damage the spell causes

    
    // Constructor to initialize spell name and damage
    
    public Spell(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    // Getter for the damage value
    
    public int getDamage() {
        return damage;
    }

    // Getter for the spell name
    
    public String getName() {
        return name;
    }
}


// Represents a wizard with name, house, health, and magical power

class Wizard {
    private String name;       // Wizard's name
    private House house;       // Hogwarts house
    private int health;        // Current health (starts at 100)
    private int magicPower;    // Magical power (1 to 10)

    // Constructor to initialize wizard's details
    
    public Wizard(String name, House house, int magicPower) {
        this.name = name;
        this.house = house;
        this.health = 100;             // Wizards start with full health
        this.magicPower = magicPower;  // Magic power affects damage
    }

    
    /*
    Cast a spell on an opponent wizard.

    Damage dealt = spell's base damage * magicPower / 10.
    Opponent's health is reduced by this amount.
    */
    
    public void castSpell(Wizard opponent, Spell spell) {
        int damageDealt = spell.getDamage() * magicPower / 10;
        opponent.health -= damageDealt;
        System.out.println(name + " casts " + spell.getName() + " on " + opponent.name + " causing " + damageDealt + " damage!");
    }

    
    // Check if the wizard is defeated (health <= 0)
    
    public boolean isDefeated() {
        return health <= 0;
    }

    // Getter for current health
    
    public int getHealth() {
        return health;
    }

    // Getter for wizard's name
    
    public String getName() {
        return name;
    }
}

// Main class to simulate a simple duel between two wizards

public class HarryPotter {
    public static void main(String[] args) {
        
        // Create two wizard instances with names, houses, and magic power
        
        Wizard hermione = new Wizard("Hermione Granger", House.RAVENCLAW, 9);
        Wizard draco = new Wizard("Draco Malfoy", House.SLYTHERIN, 7);

        // Create two spells
        
        Spell expelliarmus = new Spell("Expelliarmus", 20);
        Spell stupefy = new Spell("Stupefy", 25);

        System.out.println("Duel starts between " + hermione.getName() + " and " + draco.getName() + "!\n");

        // Hermione casts Expelliarmus on Draco
        
        hermione.castSpell(draco, expelliarmus);
        System.out.println(draco.getName() + "'s health: " + Math.max(draco.getHealth(), 0) + "\n");

        // Draco casts Stupefy on Hermione
        
        draco.castSpell(hermione, stupefy);
        System.out.println(hermione.getName() + "'s health: " + Math.max(hermione.getHealth(), 0) + "\n");

        // Check who won or if it's a tie after one round
        
        if (hermione.isDefeated() && draco.isDefeated()) {
            System.out.println("It's a tie! Both wizards are defeated.");
        } else if (hermione.isDefeated()) {
            System.out.println(draco.getName() + " wins the duel!");
        } else if (draco.isDefeated()) {
            System.out.println(hermione.getName() + " wins the duel!");
        } else {
            System.out.println("Both wizards are still standing after one round!");
        }
    }
}
