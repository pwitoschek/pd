/**
 * 
 */
package de.app.pd.entities.pv;

import java.io.Serializable;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.binding.validation.ValidationContext;
import org.springframework.stereotype.Component;

/**
 * @author Peter
 * 
 */
@Component
public class Tagesverbrauch extends Unit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7196263870929574803L;
	// @NotNull
	private double gebrauchteKWH;
	private double sumToday;

	/*
	 * Um eine Klasse zu validieren, muss es laut Konvention eine Klasse, die
	 * Modelname + Validator enthält. Hier in dem Fall TagesertragValidator
	 * (model=Tagesertrag). Hinzu kommt, dass diese Klasse eine Methode
	 * enthalten muss, die mit "validate" beginnt und den Namen des zu
	 * validierenden View-States enthält. Hier z.B. validateStartEnterPVData
	 */
	public void validateEnterVerbrauch(ValidationContext context) {
		MessageContext messages = context.getMessageContext();
		// So sollte man es NICHT machen!
		String durchschnittsTemperatur = String
				.valueOf(getDurchschnittsTemperatur());
		if (durchschnittsTemperatur == "null") {
			messages.addMessage(new MessageBuilder()
					.error()
					.source("durchschnittsTemperatur")
					.defaultText(
							"Bitte geben Sie die Tagesdurchschnittstemperatur ein")
					.build());
		}
	}

	public double getGebrauchteKWH() {
		return gebrauchteKWH;
	}

	public void setGebrauchteKWH(double gebrauchteKWH) {
		this.gebrauchteKWH = gebrauchteKWH;
	}

	public double getSumToday() {
		return sumToday;
	}

	public void setSumToday(double sumToday) {
		this.sumToday = sumToday;
	}
}
