package sg.nus.iss.workshop13.models;
import java.util.UUID;



public class w13models {


    private String id;
    private String name;
    private String email;
    private String phone;

    public w13models(){
       this.id= UUID.randomUUID().toString().substring(0, 8); //randomly generate 8 digit code
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

        @Override
        public String toString() {
            return "Contact [email=" + email + ",id=" + id + ", name=" + name + ", phone=" + phone + "]";
    }
    
}
