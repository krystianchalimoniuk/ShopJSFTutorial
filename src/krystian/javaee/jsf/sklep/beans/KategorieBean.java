package krystian.javaee.jsf.sklep.beans;


import javax.enterprise.context.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import krystian.javaee.jsf.sklep.dao.DAO;
import krystian.javaee.jsf.sklep.encje.Kategoria;

@Named
@RequestScoped
public class KategorieBean {
private ListDataModel<Kategoria> modelKategorie=new ListDataModel<Kategoria>();

public KategorieBean() {
modelKategorie.setWrappedData(DAO.getDAO().pobierzKategorie());
}

public ListDataModel<Kategoria> getModelKategorie() {
	return modelKategorie;
}

public void setModelKategorie(ListDataModel<Kategoria> modelKategorie) {
	this.modelKategorie = modelKategorie;
}
  

}

