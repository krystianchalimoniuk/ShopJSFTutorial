package krystian.javaee.jsf.sklep.beans;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Named;

import krystian.javaee.jsf.sklep.dao.DAO;
import krystian.javaee.jsf.sklep.encje.Kategoria;
import krystian.javaee.jsf.sklep.encje.Produkt;

@Named("listaProduktowBean")
@SessionScoped
public class ListaProduktowBean implements Serializable {
private ListDataModel<Produkt> modelProdukty =new ListDataModel<Produkt>();
private Kategoria kategoria;
private int strona=0;
private DAO dao=DAO.getDAO();

public ListDataModel<Produkt> getModelProdukty() {
	return modelProdukty;
}
public void setModelProdukty(ListDataModel<Produkt> modelProdukty) {
	this.modelProdukty = modelProdukty;
}
public Kategoria getKategoria() {
	return kategoria;
	
}
public void setKategoria(Kategoria kategoria) {
	this.kategoria = kategoria;
	this.strona=0;
	this.odswiezModel();
}
public boolean isPoprzedni() {
	return this.strona>0;
}
public boolean isNastepny() {
	double maxStrona=(Math.ceil(dao.pobierzLiczbeProduktow(this.kategoria)+0.0/DAO.ROZMIAR_STRONY));
	return(strona<maxStrona);
}
public ListaProduktowBean() {
	this.odswiezModel();
}
private void odswiezModel() {
	List<Produkt> lista= dao.pobierzProduktyWgKategorii(kategoria, strona*DAO.ROZMIAR_STRONY, DAO.ROZMIAR_STRONY);
this.modelProdukty.setWrappedData(lista);
}
}
