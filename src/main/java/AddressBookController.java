import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AddressBookController {

    @Autowired
    private AddressBookRepo adRepo;

    @GetMapping("/adForm")
    public String addressBookForm(Model m){
        m.addAttribute("UI", new Form());

        return "adForm";
    }

    @GetMapping("/adCreate")
    public String addressBookCreate(Model m){
        AddressBook ad = new AddressBook();
        m.addAttribute("addressBook", ad);
        adRepo.save(ad);

        return "addressBookCreate";
    }

    @GetMapping("/adForm")
    public String adSubmit(@ModelAttribute Form f, Model m){
        AddressBook ad = adRepo.findById((Long.parseLong(f.getId())));
        m.addAttribute("addressBook", ad);
        return "/adBookDisplay";
    }
}