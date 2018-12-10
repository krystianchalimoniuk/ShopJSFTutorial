package krystian.javaee.jsf.sklep.walidatory;
import java.util.regex.Pattern;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.validator.ValidatorException;
import javax.faces.validator.Validator;
public class EmailValidator implements Validator{ 
	Pattern p= Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-Z]{2,6}$");
	public void validate(javax.faces.context.FacesContext arg0, UIComponent arg1, Object arg2) throws ValidatorException {
        String kandydat=(String)arg2; 
		if(!p.matcher(kandydat).matches())
        	 throw new ValidatorException(new FacesMessage("Podany e-mail jest nieprawidłowy!"));
}
	}
