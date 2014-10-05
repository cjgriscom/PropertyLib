package com.quirkygaming.propertylib;

import java.util.HashSet;
import java.util.Set;

/**
 * A class used for the purpose of internally mutating Field objects.
 *
 * @author  CJ Griscom
 * @version 1.0
 */
public class Mutator {
	
	private Set<Field<?>> fieldSet = new HashSet<Field<?>>();
	
	/**
	 * No-arg constructor
	 */
	public Mutator() {
		
	}
	
	void internalAddPermission(Field<?> field) {
		fieldSet.add(field);
	}
	
	/**
	 * Use this method to set the value of an immutable field.  The field MUST have been constructed 
	 * with a reference to this mutator, otherwise the mutator will throw a runtime exception.
	 * 
	 * @param field The field to be modified
	 * @param value The new value
	 * @return A copy of the new value
	 */
	public <T> T set(Field<T> field, T value) {
		if (field instanceof MutableField || fieldSet.contains(field)) {
			field.set(value);
			return value;
		} else {
			throw new RuntimeException("Caller attempted to illegally set field with mutator");
		}
	}
	
}