package br.com.augusto.view.managedbean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;

@ManagedBean
public class MenuView {
 
    private MenuModel model;
 
    @PostConstruct
    public void init() {
        model = new DefaultMenuModel();
 
        //First submenu
        DefaultSubMenu firstSubmenu = new DefaultSubMenu("Dynamic Submenu");
 
        DefaultMenuItem item = new DefaultMenuItem("External");
        item.setUrl("http://www.primefaces.org");
        item.setIcon("pi pi-home");
        firstSubmenu.addElement(item);
 
        model.addElement(firstSubmenu);
 
        //Second submenu
        DefaultSubMenu secondSubmenu = new DefaultSubMenu("Dynamic Actions");
 
        item = new DefaultMenuItem("Save");
        item.setIcon("pi pi-save");
        item.setCommand("#{menuView.save}");
        item.setUpdate("messages");
        secondSubmenu.addElement(item);
 
        item = new DefaultMenuItem("Delete");
        item.setIcon("pi pi-times");
        item.setCommand("#{menuView.delete}");
        item.setAjax(false);
        secondSubmenu.addElement(item);
 
        item = new DefaultMenuItem("Redirect");
        item.setIcon("pi pi-search");
        item.setCommand("#{menuView.redirect}");
        secondSubmenu.addElement(item);
 
        model.addElement(secondSubmenu);
    }
 
    public MenuModel getModel() {
        return model;
    }
 
    public String pessoa() {
        return "/pages/pessoa.jsf";
    }
    public String fundo() {
        return "/pages/fundo.jsf";
    }
    
    public String cidade() {
        return "/pages/cidade.jsf";
    }
    
    public String loja() {
        return "/pages/cadastroloja.jsf";
    }
 
    public String consultar() {
        return "/pages/pessoaconsultar.jsf";
    }
    
    public String listarLojas() {
        return "/pages/listarlojas.jsf";
    }
 
}
