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
    ITALY, FRANCE, ENGLAND, CHINA, JAPAN, MOROCCO
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
