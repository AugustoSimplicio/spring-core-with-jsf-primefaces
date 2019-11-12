package br.com.augusto.view.managedbean;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MessagesView {
    public void sucessoDeletar() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Deletado com Sucesso!."));
    }
    public void erroDeletar() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Não foi possivel Deletar!."));
    }
    
    public void sucessoCadastro() {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Cadastrado com Sucesso!."));
    }
}
