package krystian.javaee.jsf.sklep.encje;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Zamowienie {
private int id;
private Date data;
private List<Skladnik> skladniki= new ArrayList<Skladnik>();
private Uzytkownik uzytkownik=new Uzytkownik();
public Zamowienie() {}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getData() {
	return data;
}
public void setData(Date data) {
	this.data = data;
}
public List<Skladnik> getSkladniki() {
	return skladniki;
}
public void setSkladniki(List<Skladnik> skladniki) {
	this.skladniki = skladniki;
}
public Uzytkownik getUzytkownik() {
	return uzytkownik;
}
public void setUzytkownik(Uzytkownik uzytkownik) {
	this.uzytkownik = uzytkownik;
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
	Zamowienie other = (Zamowienie) obj;
	if (id != other.id)
		return false;
	return true;
}

}
