package view.backing;

import java.io.BufferedReader;
import java.io.InputStream;

import java.io.InputStreamReader;

import javax.faces.application.FacesMessage;

import javax.faces.context.FacesContext;

import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.nav.RichButton;

import org.apache.myfaces.trinidad.model.UploadedFile;

public class FileUpload {
    private RichInputFile if1;
    private RichButton b1;
    private UploadedFile file;

    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public UploadedFile getFile() {
        return file;
    }

    public void setIf1(RichInputFile if1) {
        this.if1 = if1;
    }

    public RichInputFile getIf1() {
        return if1;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }

    public String processFileUpload() {

        UploadedFile file = this.getFile();
        
        //File Name
        String filename =file.getFilename();
        
        //ContentType
        String contenttype = file.getContentType();
        
        //GetInputStream
        try{
            InputStream is  = file.getInputStream();
            BufferedReader bReader = new BufferedReader(new InputStreamReader(is));
            String line = null;
            
                while( (line = bReader.readLine()) != null){
                            System.out.println(line);
                    }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        
        FacesMessage Message = new FacesMessage("File Saved Successfully!");   
        Message.setSeverity(FacesMessage.SEVERITY_INFO);   
        FacesContext fc = FacesContext.getCurrentInstance();   
        fc.addMessage(null, Message);
        // Add event code here...
        return null;
    }
}
