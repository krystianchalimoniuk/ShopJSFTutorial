package krystian.javaee.jsf.sklep.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import krystian.javaee.jsf.sklep.encje.Kategoria;
import krystian.javaee.jsf.sklep.encje.Produkt;
import krystian.javaee.jsf.sklep.encje.Zamowienie;

public class DAO {
private static DAO instancja=new DAO();
private List<Kategoria> kategorie=new ArrayList<Kategoria>();
private List<Produkt> produkty=new ArrayList<Produkt>();
private List<Zamowienie> zamowienia=new ArrayList<Zamowienie>();
public static final int ROZMIAR_STRONY=3;
{
	Kategoria procesory=new Kategoria(1,"Procesory");
	Kategoria pamieci=new Kategoria(2,"Pamieci");
	kategorie.add(procesory);
	kategorie.add(pamieci);
	Produkt p1 =new Produkt(1,"Procesor Quad",new BigDecimal(550),10,procesory,"Opis parametru Quad");
    produkty.add(p1);
    Produkt p2 =new Produkt(2,"Procesor Dual",new BigDecimal(400),10,procesory,"Opis parametru Dual");
    produkty.add(p2);
    Produkt p3 =new Produkt(3,"Procesor Single",new BigDecimal(300),10,procesory,"Opis parametru Single");
    produkty.add(p3);
    Produkt p4 =new Produkt(4,"Pamięć 4 GB",new BigDecimal(350),10,pamieci,"Opis pamieci 4GB");
    produkty.add(p4);
}
public static DAO getDAO() {
	return instancja;
}
private List<Produkt> pobierzProduktyWgKategorii(Kategoria kategoria){
	List<Produkt> wybrane= null;
	if(kategoria==null)
		wybrane=this.produkty;
	else {
	    wybrane=new ArrayList<Produkt>();
	    for(Produkt p : produkty)
	    	if(p.getKategoria().equals(kategoria))
	    		wybrane.add(p);
	}
	return wybrane;
}

public List<Produkt> pobierzProduktyWgKategorii(Kategoria kategoria, int start,int liczba){
	List<Produkt> wybrane=pobierzProduktyWgKategorii(kategoria);
if(start>=wybrane.size())
	return new ArrayList<Produkt>();
else
	if(start < wybrane.size() && start+liczba>wybrane.size())
		wybrane=wybrane.subList(start, wybrane.size());
	else
		wybrane=wybrane.subList(start, start+liczba);
return wybrane;
}
public int pobierzLiczbeProduktow(Kategoria kategoria) {
	return pobierzProduktyWgKategorii(kategoria).size();
}
public List<Kategoria> pobierzKategorie(){
	return this.kategorie;
}
public Produkt pobierzProduktWgId(int produktId) {
	for(Produkt p : produkty)
		if(p.getId() ==produktId)
			return p;
	return null;
}
public List<Produkt> pobierzTopProdukty(){
	return this.produkty.subList(0, 2);
}
public void dodajZamowienie(Zamowienie zamowienie) {
	zamowienia.add(zamowienie);
}
}
