import javax.persistence.*;

@Entity
public class BuddyInfo {
    private Long id;
    private String bookID;
    private String name;
    private String address;
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "adBookId")
    private AddressBook ad;

    public BuddyInfo(Long id, String n, String a, String pn){
        this.id = id;
        name = n;
        address = a;
        phoneNumber = pn;
    }

    public BuddyInfo(){

    }
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name){this.name = name;}
    public String getAddress() {
        return address;
    }
    public void setAddress(String a){this.address=a;}
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String p){this.phoneNumber=p;}
    public String getBookID(){return bookID;}
    public void setBookID(String bId){bookID = bId;}

    public String toString(){
        String s = "";

        s += "Name: " + getName();
        s += "Address: " + getAddress();
        s += "Phone: " + getPhoneNumber();

        return s;
    }
}
