package sg.nus.iss.workshop13.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import sg.nus.iss.workshop13.services.DatabaseService;

@Controller
@RequestMapping(path = "/contact")
public class w13controller {
    
    @Autowired
    private DatabaseService dbSvc;

    @PostMapping(
        consumes="application/x-www-form-urlencoded", produces = "text/html")
        public String postContact(
            @RequestBody MultiValueMap<>
        )

    public static void main(String[]args){
        
    }
    
    
}
