/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.amkt922.jsfsample.mgdbean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author p
 */
@FacesValidator(value = "postalCodeValidator")
public class PostalCodeValidator implements Validator {

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String v = (String)value;
        Pattern p = Pattern.compile("[0-9]{3}-[0-9]{4}");
        Matcher m = p.matcher(v);
        if (!m.matches()) {
            throw new ValidatorException(new FacesMessage("郵便番号形式ではありません"));
        }
    }
}
