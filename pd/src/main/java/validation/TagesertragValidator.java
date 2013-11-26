/**
 * 
 */
package validation;

import org.springframework.validation.Errors;

import com.mysql.jdbc.StringUtils;

import de.app.pd.entities.pv.Tagesertrag;

/**
 * @author pd Um eine Klasse zu validieren, muss es laut Konvention eine Klasse,
 *         die Modelname + Validator enthält. Hier in dem Fall
 *         TagesertragValidator (model=Tagesertrag). Hinzu kommt, dass diese
 *         Klasse eine Methode enthalten muss, die mit "validate" beginnt und
 *         den Namen des zu validierenden View-States enthält. Hier z.B.
 *         validateStartEnterPVData
 */
public class TagesertragValidator {

	public void validateStartEnterPVData(Tagesertrag tagesertrag, Errors errors) {

		if (StringUtils.isNullOrEmpty(tagesertrag.getErtrag().toString())) {
			errors.rejectValue("ertrag", "tagesertrag.ertragleer",
					"Bitte geben Sie einen Ertrag ein!");
		}
	}
}
