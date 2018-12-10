package krystian.javaee.jsf.sklep.encje;

public class Kategoria {
private int id;
public Kategoria() {}
public Kategoria(int id, String nazwa) {
	super();
	this.id = id;
	this.nazwa = nazwa;
}
private String nazwa;
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
	Kategoria other = (Kategoria) obj;
	if (id != other.id)
		return false;
	return true;
}
}
