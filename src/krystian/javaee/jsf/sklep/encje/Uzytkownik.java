package krystian.javaee.jsf.sklep.encje;

public class Uzytkownik {
private int id;
private String email;
private String imie;
private String nazwisko;
private String adres;


public Uzytkownik(int id, String email, String imie, String nazwisko, String adres) {
	super();
	this.id = id;
	this.email = email;
	this.imie = imie;
	this.nazwisko = nazwisko;
	this.adres = adres;
}
public Uzytkownik() {}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getImie() {
	return imie;
}
public void setImie(String imie) {
	this.imie = imie;
}
public String getNazwisko() {
	return nazwisko;
}
public void setNazwisko(String nazwisko) {
	this.nazwisko = nazwisko;
}
public String getAdres() {
	return adres;
}
public void setAdres(String adres) {
	this.adres = adres;
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
	Uzytkownik other = (Uzytkownik) obj;
	if (id != other.id)
		return false;
	return true;
}


}
