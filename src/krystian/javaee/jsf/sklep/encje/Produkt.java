package krystian.javaee.jsf.sklep.encje;

import java.math.BigDecimal;

public class Produkt {
private int id;
private String nazwa;
private BigDecimal cena;
private int ilosc;
private Kategoria kategoria;
private String opis;

public Produkt() {}

public Produkt(int id, String nazwa, BigDecimal cena, int ilosc, Kategoria kategoria, String opis) {
	super();
	this.id = id;
	this.nazwa = nazwa;
	this.cena = cena;
	this.ilosc = ilosc;
	this.kategoria = kategoria;
	this.opis = opis;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getNazwa() {
	return nazwa;
}

public void setNazwa(String nazwa) {
	this.nazwa = nazwa;
}

public BigDecimal getCena() {
	return cena;
}

public void setCena(BigDecimal cena) {
	this.cena = cena;
}

public int getIlosc() {
	return ilosc;
}

public void setIlosc(int ilosc) {
	this.ilosc = ilosc;
}

public Kategoria getKategoria() {
	return kategoria;
}

public void setKategoria(Kategoria kategoria) {
	this.kategoria = kategoria;
}

public String getOpis() {
	return opis;
}

public void setOpis(String opis) {
	this.opis = opis;
}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + id;
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
	Produkt other = (Produkt) obj;
	if (id != other.id)
		return false;
	return true;
}

}
