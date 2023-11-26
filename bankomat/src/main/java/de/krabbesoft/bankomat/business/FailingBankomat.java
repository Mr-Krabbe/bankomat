package de.krabbesoft.bankomat.business;

import de.krabbesoft.bankomat.model.Stueckelung;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Alternative;

/**
 * A <code>Bankomat</code> implementation for demonstration purposes, that will
 * always fail to calculate the denomination and throws an {@link UnsupportedOperationException}.
 * 
 * @author Christoph
 */
@RequestScoped
@Alternative
public class FailingBankomat implements Bankomat {

	@Override
	public Stueckelung berechneStueckelung(int euro, int cents) {
		throw new UnsupportedOperationException("I always fail to calculate the denomination");
	}

}
