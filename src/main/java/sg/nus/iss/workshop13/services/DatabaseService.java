package sg.nus.iss.workshop13.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.springframework.stereotype.Service;

import sg.nus.iss.workshop13.models.w13models;

@Service
public class DatabaseService {

    private File dataDir = new File("some directory"); // remember to generate getters and setters

    public File getDataDir() {
        return dataDir; 
    }

    public void setDataDir(File dataDir) {
        this.dataDir = dataDir;
    }

public Boolean dataDirValidity(){
    return dataDir.exists() && dataDir.isDirectory() && dataDir.canWrite(); //this is to check absolute state of boolean
}

public Boolean save(final w13models contact){ 
    File file = new File(this.dataDir, contact.getId());
    try (OutputStream os = new FileOutputStream(file)) {
        PrintWriter pWriter = new PrintWriter(os);
        pWriter.println(contact.getId());
        pWriter.println(contact.getEmail());
        pWriter.println(contact.getName());
        pWriter.println(contact.getPhone());

        return true; //in this case, info obtained therefore true

        

        
    } catch (IOException e) {//since case IOException, return false
        // TODO Auto-generated catch block
        //e.printStackTrace();

        System.err.println("Error " + e.getMessage() );
        return false;
    }
}
    public w13models readW13models(String fileID){
        try{
            w13models contact = new w13models();
            Path filePath = new File(this.dataDir, fileID).toPath(); //set filepath to data dir
            Charset charset = Charset.forName("utf-8");
            List<String> stringVal = Files.readAllLines(filePath, charset);

            contact.setName(stringVal.get(1));
            contact.setEmail(stringVal.get(2));
            contact.setPhone(stringVal.get(3));

            return contact;

        }
        
         catch (IOException e) {
            //TODO: handle exception
            System.err.println("Error " + e.getMessage());
            return null;

        }
    }

}

    

