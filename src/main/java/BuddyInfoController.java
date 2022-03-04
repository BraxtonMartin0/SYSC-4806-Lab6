import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BuddyInfoController {

    @Autowired
    private BuddyRepo bRepo;
    @Autowired
    private AddressBookRepo adRepo;

    @Autowired
    public BuddyInfoController(BuddyRepo br, AddressBookRepo adr){
        bRepo = br;
        adRepo = adr;
    }

    @GetMapping("/buddyInfoAdd")
    public String buddyForm(Model m){
        m.addAttribute("buddyInfo", new BuddyInfo());

        return "buddyInfoAdd";
    }

    @PostMapping("/buddyInfoAdd")
    public String buddySubmit(@ModelAttribute BuddyInfo b, Model m){
        m.addAttribute("buddyInfo",b);
        bRepo.save(b);
        AddressBook ad = adRepo.findById(Long.parseLong(b.getBookID()));
        ad.addBuddy(b);
        adRepo.save(ad);

        return "buddyInfoDisplay";
    }

}
