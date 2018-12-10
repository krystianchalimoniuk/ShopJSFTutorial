package krystian.javaee.jsf.sklep.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Model;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import krystian.javaee.jsf.sklep.dao.DAO;
import krystian.javaee.jsf.sklep.encje.Produkt;
@Named("topProduktyBean")
@ApplicationScoped
public class TopProduktyBean {
private Produkt wybranyProdukt;
private List<SelectItem> topProdukty;
private DAO dao=DAO.getDAO();
public Produkt getWybranyProdukt() {
	return wybranyProdukt;
}

public void setWybranyProdukt(Produkt wybranyProdukt) {
	this.wybranyProdukt = wybranyProdukt;
}

public List<SelectItem> getTopProdukty() {
	return topProdukty;
}

public void setTopProdukty(List<SelectItem> topProdukty) {
	this.topProdukty = topProdukty;
}
public TopProduktyBean() {
	this.topProdukty=new ArrayList<SelectItem>();
	List<Produkt> produkty=dao.pobierzTopProdukty();
	for(Produkt p : produkty)
		this.topProdukty.add(new SelectItem(p,p.getNazwa()));
}
}
