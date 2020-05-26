/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.trabalhoupload;

import java.io.IOException;
import java.util.Scanner;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author danie
 */

@ManagedBean(name="UploadMB")
@ViewScoped
public class UploadMB {
    
    private UploadedFile file;
    public String conteudo;

        public String getConteudo() {
            return conteudo;
        }

        public void setConteudo(String conteudoDoArquivo) {
            this.conteudo = conteudoDoArquivo;
        }    
   
     
    public void handleFileUpload(FileUploadEvent event) throws IOException {
        System.err.println("chegou");
        FacesMessage msg = new FacesMessage("Succesful", event.getFile().getFileName() + " is uploaded.");
     
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        conteudo = new Scanner(event.getFile().getInputstream(),"UTF-8").useDelimiter("\\A").next();
        System.out.println(conteudo);
    }
}
