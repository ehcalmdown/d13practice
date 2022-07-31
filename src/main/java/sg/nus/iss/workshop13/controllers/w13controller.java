package sg.nus.iss.workshop13.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.iss.workshop13.models.w13models;
import sg.nus.iss.workshop13.services.DatabaseService;

@Controller
@RequestMapping(path = "/contact")
public class w13controller {
    
    @Autowired
    private DatabaseService dbSvc;

    @PostMapping(
        consumes="application/x-www-form-urlencoded", produces = "text/html")
        public String postContact(
            @RequestBody MultiValueMap<String, String> form, Model model
        ){
            w13models con = new w13models();
            con.setName("name");
            con.setEmail("email");
            con.setPhone("phone");
            dbSvc.save(con);


            model.addAttribute("contact", con);
            return "showContact";

        }

        @GetMapping(value = "/{id}", produces = "text/html")
        public String getw13models(@PathVariable("id") String id, Model model){

            w13models con = new w13models();

            con = dbSvc.readW13models(id);
            System.out.println("id: " + con);
            return "showContact";
        }

 
    
}
