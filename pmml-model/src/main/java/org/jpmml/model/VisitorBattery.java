/*
 * Copyright (c) 2018 Villu Ruusmann
 */
package org.jpmml.model;

import java.util.ArrayList;
import java.util.List;

import org.dmg.pmml.Visitable;
import org.dmg.pmml.Visitor;

public class VisitorBattery extends ArrayList<Class<? extends Visitor>> {

	public void applyTo(Visitable visitable){
		List<Class<? extends Visitor>> visitorClazzes = this;

		for(Class<? extends Visitor> visitorClazz : visitorClazzes){
			Visitor visitor;

			try {
				visitor = visitorClazz.newInstance();
			} catch(ReflectiveOperationException roe){
				throw new RuntimeException(roe);
			}

			visitor.applyTo(visitable);
		}
	}
}