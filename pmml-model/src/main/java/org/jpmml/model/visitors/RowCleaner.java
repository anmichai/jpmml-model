/*
 * Copyright (c) 2018 Villu Ruusmann
 */
package org.jpmml.model.visitors;

import java.util.List;
import java.util.ListIterator;

import org.dmg.pmml.Row;
import org.dmg.pmml.VisitorAction;

public class RowCleaner extends AbstractVisitor {

	@Override
	public VisitorAction visit(Row row){

		if(row.hasContent()){
			List<Object> content = row.getContent();

			for(ListIterator<Object> it = content.listIterator(); it.hasNext(); ){
				Object object = it.next();

				if(object instanceof String){
					String string = (String)object;

					string = string.trim();

					if(("").equals(string)){
						it.remove();
					}
				}
			}
		}

		return super.visit(row);
	}
}