package krystian.javaee.jsf.sklep.beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Named;

import krystian.javaee.jsf.sklep.dao.DAO;
import krystian.javaee.jsf.sklep.encje.Produkt;
import krystian.javaee.jsf.sklep.encje.Skladnik;
import krystian.javaee.jsf.sklep.encje.Zamowienie;

@Named("koszykBean")
@SessionScoped
public class KoszykBean implements Serializable {
private Zamowienie zamowienie=new Zamowienie();
private Skladnik wybranySkladnik;
private Produkt wybranyProdukt;
public Produkt getWybranyProdukt() {
	return wybranyProdukt;
}
public void setWybranyProdukt(Produkt wybranyProdukt) {
	this.wybranyProdukt = wybranyProdukt;
}
public Zamowienie getZamowienie() {
	return zamowienie;
}
public void setZamowienie(Zamowienie zamowienie) {
	this.zamowienie = zamowienie;
}
public Skladnik getWybranySkladnik() {
	return wybranySkladnik;
}
public void setWybranySkladnik(Skladnik wybranySkladnik) {
	this.wybranySkladnik = wybranySkladnik;
}
public String zakonczZamowienie() {
	DAO.getDAO().dodajZamowienie(zamowienie);
	zamowienie=new Zamowienie();
	
	return "ok";
}
public String usun() {
	for(Skladnik skl : zamowienie.getSkladniki())
		if(skl.equals(this.wybranySkladnik)) {
			zamowienie.getSkladniki().remove(skl);
			break;
		}return "";
}
public String dodajDoKoszyka() {
	for(Skladnik skl : zamowienie.getSkladniki()) {
		if(skl.getProdukt().equals(wybranyProdukt)) {
			skl.setIlosc(skl.getIlosc()+1);
		    return "koszyk.xhtml";	
		}
}
Skladnik s= new Skladnik(1,wybranyProdukt.getCena(),wybranyProdukt,zamowienie);
zamowienie.getSkladniki().add(s);
return "koszyk.xhtml";
}
public void actionListener(ActionEvent evt) {
	String tekstId =FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("produktId");
	int id= Integer.parseInt(tekstId);
	this.wybranyProdukt=DAO.getDAO().pobierzProduktWgId(id);
	
}
}
