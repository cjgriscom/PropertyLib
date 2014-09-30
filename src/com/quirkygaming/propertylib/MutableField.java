package com.quirkygaming.propertylib;

public class MutableField<T> extends Field<T> {
	private final Field<T> field;
	
	public static <T> MutableField<T> newField(T initialValue) {
		return new MutableField<T>(new FieldImpl<T>(initialValue));
	}
	
	public static <T, E extends Enum<E>> MutableField<T> newField(ProtectedEnumPropertyMap<?, T> map, E property) {
		return new MutableField<T>(new MappedFieldImpl<T>(map, property));
	}
	
	public static <T, E extends Enum<E>> MutableField<T> newWeaklyLinkedField(ProtectedEnumPropertyMap<?, ?> map, E property, Class<T> type) {
		return new MutableField<T>(new WeakMappedFieldImpl<T>(map, property));
	}
	
	private MutableField(Field<T> field) {
		this.field = field;
	}
	
	@Override
	public void set(T v) {
		field.set(v);
	}

	@Override
	public T get() {
		return field.get();
	}
}
