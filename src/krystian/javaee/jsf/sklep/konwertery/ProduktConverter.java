package krystian.javaee.jsf.sklep.konwertery;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import krystian.javaee.jsf.sklep.dao.DAO;
import krystian.javaee.jsf.sklep.encje.Produkt;

public class ProduktConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
     System.out.println(arg2+ "Konwerter");
		int id=Integer.parseInt(arg2);
     Produkt p=DAO.getDAO().pobierzProduktWgId(id);
     return p;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
	Produkt p=(Produkt)arg2;
	return p.getId()+"";
	}
	

}
