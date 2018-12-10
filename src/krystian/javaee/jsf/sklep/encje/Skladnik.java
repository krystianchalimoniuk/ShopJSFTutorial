package krystian.javaee.jsf.sklep.encje;

import java.math.BigDecimal;

public class Skladnik {
private int ilosc;
private BigDecimal cena;
private Produkt produkt;
private Zamowienie zamowienie;
public int getIlosc() {
	return ilosc;
}
public void setIlosc(int id) {
	this.ilosc = id;
}
public BigDecimal getCena() {
	return cena;
}
public void setCena(BigDecimal cena) {
	this.cena = cena;
}
public Produkt getProdukt() {
	return produkt;
}
public void setProdukt(Produkt produkt) {
	this.produkt = produkt;
}
public Zamowienie getZamowienie() {
	return zamowienie;
}
public void setZamowienie(Zamowienie zamowienie) {
	this.zamowienie = zamowienie;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((produkt == null) ? 0 : produkt.hashCode());
	result = prime * result + ((zamowienie == null) ? 0 : zamowienie.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Skladnik other = (Skladnik) obj;
	if (produkt == null) {
		if (other.produkt != null)
			return false;
	} else if (!produkt.equals(other.produkt))
		return false;
	if (zamowienie == null) {
		if (other.zamowienie != null)
			return false;
	} else if (!zamowienie.equals(other.zamowienie))
		return false;
	return true;
}
public BigDecimal getLacznie() {
	return this.cena.multiply(new BigDecimal(this.ilosc));
}
public Skladnik(int ilosc, BigDecimal cena, Produkt produkt, Zamowienie zamowienie) {
	super();
	this.ilosc = ilosc;
	this.cena = cena;
	this.produkt = produkt;
	this.zamowienie = zamowienie;
}
}
