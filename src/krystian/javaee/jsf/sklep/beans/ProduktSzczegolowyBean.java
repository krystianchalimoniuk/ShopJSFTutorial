package krystian.javaee.jsf.sklep.beans;

import java.io.Serializable;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.omnifaces.cdi.Param;

import krystian.javaee.jsf.sklep.dao.DAO;
import krystian.javaee.jsf.sklep.encje.Produkt;

@Named("produktSzczegolowyBean")
@RequestScoped
public class ProduktSzczegolowyBean implements Serializable {
private DAO dao=DAO.getDAO();
private Produkt wybranyProdukt;


@ManagedProperty("#{topProduktyBean}")
private TopProduktyBean topProduktyBean;


private int produktId;
public ProduktSzczegolowyBean() {
	
	produktId=getProduktId();
	if(produktId>0)
		this.wybranyProdukt=dao.pobierzProduktWgId(produktId);
	
	
}
public Produkt getWybranyProdukt() {
	return wybranyProdukt;
}
public void setWybranyProdukt(Produkt wybranyProdukt) {
	this.wybranyProdukt = wybranyProdukt;
}
public int getProduktId() {
	FacesContext context = FacesContext.getCurrentInstance();
    
	Map<String, String> paramMap = context.getExternalContext().getRequestParameterMap();
	if(paramMap.get("id")!=null)
		produktId = Integer.parseInt(paramMap.get("id"));
	return produktId;
}
public TopProduktyBean getTopProduktyBean() {
	return topProduktyBean;
}
@PostConstruct
public void setTopProduktyBean(TopProduktyBean topProduktyBean) {
	this.topProduktyBean = topProduktyBean;
	System.out.println(topProduktyBean.getWybranyProdukt().getNazwa());
	Produkt p=topProduktyBean.getWybranyProdukt();
	if(p!=null) {
		this.wybranyProdukt=p;
		System.out.println(p.toString());
	}
}




}
