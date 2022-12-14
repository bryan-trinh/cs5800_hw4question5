package hw4;

public class Account {
    private AccountHolder holder;
    private double balance = 0.0;

    // constructor
    public Account(double amt, AccountHolder holder){
        this.balance = amt;
        this.holder = holder;
    }

    // adds onto balance by amt
    public void deposit(double amt){
        this.balance += amt;
    }

    // subtracts from balance by amt
    public void withdraw(double amt){
        this.balance -= amt;
    }

    // returns the Account balance
    public double getBalance(){
        return this.balance;
    }

    // returns the Account holder
    public AccountHolder getHolder(){
        return this.holder;
    }

    // sets the balance for the Account
    public void setBalance(double amt){
        this.balance = amt;
    }

    // sets the holder for the Account
    public void setHolder(AccountHolder holder){
        this.holder = holder;
    }

    // sample main function
    public static void main(String args[]){
        // can use AccountHolder.getNextID()
        IndividualHolder bryan = new IndividualHolder(IndividualHolder.getNextID(), "123 Street St", "bryan", "123");
        // convert name
        System.out.println("current name: " + bryan.getName());
        bryan.setName(bryan.convertNameUpperCase(bryan.getName()));
        System.out.println("converted name: " + bryan.getName());
        // change ssn
        System.out.println("SSN: " + bryan.getSSN());
        bryan.setSSN("321");
        System.out.println("uh oh identity theft is not a joke, new SSN: " + bryan.getSSN());
        System.out.println();

        Account acc = new Account(0.0, bryan);
        System.out.println("new account, with holder bryan: " + acc.getHolder());
        System.out.println("curr balance for bryan: " + acc.getBalance());
        // turn bryan into a millionaire
        acc.deposit(1000000);
        System.out.println("new balance: " + acc.getBalance());
        System.out.println();

        // can also use AccountHolder.getNextID()
        CorporateHolder ericsson = new CorporateHolder(CorporateHolder.getNextID(), "321 Road Rd", "123-345-6789");
        System.out.println("new holder ericsson's contact: " + ericsson.getContact());
        // update contact
        ericsson.setContact("321-543-0000");
        System.out.println("too much political calls, changed contact to: " + ericsson.getContact());
        System.out.println();

        System.out.println("curr account holder: " + acc.getHolder());
        acc.setHolder(ericsson);
        System.out.println("somehow account got hacked, new account holder: " + acc.getHolder());
        // ericsson stole all of bryan's money
        acc.withdraw(1000000);
        System.out.println("ericsson stole all of bryan's money, account's balance: " + acc.getBalance());
    }
}
