import javax.persistence.*;
import javax.swing.*;

import java.util.*;
@Entity
public class AddressBook extends DefaultListModel {
    private List<BuddyInfo> buddies = new ArrayList<>();

    public AddressBook(){

    }
    public AddressBook(long id){
        this.id = id;
    }

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL)
    public List<BuddyInfo> getBuddyList(){
        return buddies;
    }

    public void setBuddyList(List<BuddyInfo> buddyList){
        buddies = buddies;
    }

    public Long getId(){
        return this.id;
    }

    public void setId(Long id){
        this.id=id;
    }

    public void addBuddy(BuddyInfo b){
        buddies.add(b);
    }

    public void removeBuddy(BuddyInfo b){
        buddies.remove(b);
    }

    public BuddyInfo getBuddy(int n){
        return buddies.get(n);
    }

    @Override
    public String toString() {
        String allBuddies = "ID: " + id;

        for(BuddyInfo b: buddies){
            allBuddies += b.toString() + "\n";
        }
        return  allBuddies;
    }
}

