package hw4;
import java.lang.Math;

abstract class AccountHolder{
    protected int ID;
    protected String address;

    // constructor
    public AccountHolder(int ID, String address){
        this.ID = ID;
        this.address = address;
    }

    // returns a random number in the range of [1, 1000000]
    public static int getNextID(){
        return (int)(Math.random() * 1000000) + 1;
    }
}

interface Util{
    // converts name to upper case (interface method has no body)
    public String convertNameUpperCase(String name);
}

class IndividualHolder extends AccountHolder implements Util{
    private String name;
    private String SSN;

    // updated constructor
    public IndividualHolder(int ID, String address, String name, String SSN) {
        // super constructor from parent
        super(ID, address);
        this.name = name;
        this.SSN = SSN;
    }

    // returns the name of IndividualHolder
    public String getName(){
        return this.name;
    }

    // returns the SSN;
    public String getSSN(){
        return this.SSN;
    }

    // sets the name of the IndividualHolder
    public void setName(String name){
        this.name = name;
    }

    // sets the SSN of the IndividualHolder
    public void setSSN(String SSN){
        this.SSN = SSN;
    }

    // interface method implemented to capitalize first letter of each word
    public String convertNameUpperCase(String name) {
        String[] arr = name.split(" ");
        StringBuffer buffer = new StringBuffer();

        for (int i = 0; i < arr.length; i++) {
            buffer.append(Character.toUpperCase(arr[i].charAt(0)))
                .append(arr[i].substring(1)).append(" ");
        }          
        return buffer.toString().trim();
    }
}

class CorporateHolder extends AccountHolder{
    private String contact;

    // updated constructor
    public CorporateHolder(int ID, String address, String contact) {
        super(ID, address);
        this.contact = contact;
    }
    
    // returns the contact
    public String getContact(){
        return this.contact;
    }

    // sets the contact of CorporateHolder
    public void setContact(String contact){
        this.contact = contact;
    }
}