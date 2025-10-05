//Consider the class SantaSleigh that models a container of objects of type Gift. Each gift is characterized by:

//1. an integer identifier,
//2. a string representing the delivery address,
//3. and an enumeration representing the Country, i.e., the Nation, where it must be delivered.

//Provide the implementation of the classes SantaSleigh and Gift, appropriately defining the fields and constructors.
//It is NOT necessary to provide a full implementation of the Country enum.

java import.util.LinkedList
  
public class SantaSleigh {
    private LinkedList<Gift> list;

    public SantaSleigh() {
        list = new LinkedList<Gift>();
    }
}

class Gift {
    private int id;
    private String address;
    private Country country;

    public Gift(int id, String address, Country country) {
        this.id = id;
        this.address = address;
        this.country = country;
    }
}

enum Country {
    ITALY, FRANCE, ENGLAND, CANADA, JAPAN, KENYA
}

//Write the code for the following methods, which serve these purposes:

//1. Add a new gift to the sleigh, if it is not already present. The sleigh cannot contain multiple gifts with the same ID and delivery country. The method returns true if the gift was added, false otherwise.

//2. Deliver a gift in a given country (the first occurrence in the sleigh). Delivery means removing it from the sleigh, if present. The method returns a reference to the Gift object if it was found and removed, null otherwise.

//3. Get a list of all gifts to be delivered in a given country, passed as an argument. If no gifts are to be delivered to that country, an empty list is returned.

//4. Check if the sleigh is empty or not. An empty sleigh contains no gifts.

//NOTE: The Gift class is assumed to provide getter methods for its fields.

public boolean addGift(Gift g) {
    for (Gift gift : list) {
        if (gift.getId() == g.getId() && gift.getCountry().equals(g.getCountry())) {
            return false;
        }
    }
    list.add(g);
    return true;
}

public Gift deliverGift(Country c) {
    for (Gift gift : list) {
        if (gift.getCountry().equals(c)) {
            list.remove(gift);
            return gift;
        }
    }
    return null;
}

public LinkedList<Gift> giftsToDeliverToCountry(Country c) {
    LinkedList<Gift> toDeliver = new LinkedList<Gift>();
    for (Gift gift : list) {
        if (gift.getCountry().equals(c)) {
            toDeliver.add(gift);
        }
    }
    return toDeliver;
}

public boolean isSleighEmpty() {
    return list.isEmpty();
}

//Main class

public class Main {
    public static void main(String[] args) {
        SantaSleigh sleigh = new SantaSleigh();

        Gift gift1 = new Gift(1, "123 Ottawa", Country.CANADA);
        Gift gift2 = new Gift(2, "456 Paris", Country.FRANCE);
        Gift gift3 = new Gift(1, "789 Toronto", Country.CANADA); 

        // Add gifts
        System.out.println("Add gift1: " + sleigh.addGift(gift1));
        System.out.println("Add gift2: " + sleigh.addGift(gift2)); 
        System.out.println("Add gift3: " + sleigh.addGift(gift3)); 

        // Check if sleigh is empty
        System.out.println("Is sleigh empty? " + sleigh.isSleighEmpty());

        // Deliver a gift to Canada
        Gift delivered = sleigh.deliverGift(Country.CANADA);
        System.out.println("Delivered gift id: " + (delivered != null ? delivered.getId() : "None"));

        // Get all gifts to deliver to France
        LinkedList<Gift> franceGifts = sleigh.giftsToDeliverToCountry(Country.FRANCE);
        System.out.println("Gifts to deliver to France: " + franceGifts.size()); 

        // Deliver a gift to Japan (no gift)
        Gift deliveredJapan = sleigh.deliverGift(Country.JAPAN);
        System.out.println("Delivered gift to Japan: " + (deliveredJapan != null ? deliveredJapan.getId() : "None")); 
    }
}
