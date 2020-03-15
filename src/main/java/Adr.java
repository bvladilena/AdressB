
import java.util.ArrayList;
import java.util.TreeMap;

public class Adr{
    public static void main(String [] args){
        Adre book = new Adre();

        book.newAddress("Vlada", "Uliza",1,2);
        book.newAddress("Vlad","Uliza",3,4);
        System.out.println(book.getAddress("Vlada"));
        System.out.println(book.getByStreet("Uliza").length);
        System.out.println(book.getByHouse("Uliza",1).length);
        book.deleteAddress("Vlada");//, "Prospect", 3, 2465);
        System.out.println(book.getAddress("Vlada"));

    }
}
//пока что вместо тестов

 class Adre{

    TreeMap<String, Address> book = new TreeMap<String, Address>();

    public Adre() {
        System.out.println("Книга создана") ;
    }

    public void newAddress(String name, String street, int house, int flat) {
        Address adr = new Address(street, house, flat);
        book.put(name, adr);
    }

    public String getAddress(String name){
        if (book.containsKey(name))
            return book.get(name).getAddress();
        else return "Такой адрес не найден";
    }

    public  void deleteAddress(String name) {
        if (book.containsKey(name))
            book.remove(name);
        else
            System.out.println("Человек с таким именем не найден!");
    }

    public void changeAddress(String name, String street, int house, int flat) {
        if (book.containsKey(name)) {
            Address adr = new Address(street, house, flat);
            book.replace(name, adr);
        }
        else
            System.out.println("Человек с таким именем не найден!");
    }

    public String[] getByStreet(String street){
        ArrayList<String> list = new ArrayList<String>();

        for (String name: book.keySet())
        {
            if (book.get(name).getStreet().equals(street))
                list.add(name);
        }

        return list.toArray(new String[list.size()]);
    }

    public String[] getByHouse(String street, int house) {
        String [] searchRange = getByStreet(street);
        ArrayList<String> list = new ArrayList<String>();
        for (String name: searchRange)
        {
            if (book.get(name).getHouse() == house)
                list.add(name);
        }
        return list.toArray(new String [list.size()]);
    }


}


class Address{

    String street;
    int house;
    int flat;

    public Address(String street, int house, int flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getAddress() {
        return this.street + " " + this.house + " " + this.flat;
    }

    public String getStreet() {
        return this.street;
    }

    public int getHouse() {
        return this.house;
    }

    public int getFlat() {
        return this.flat;
    }
}