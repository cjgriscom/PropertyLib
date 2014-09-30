package com.quirkygaming.propertylib;

public class MutableField<T> extends Field<T> {
	private final Field<T> field;
	
	public static <T> MutableField<T> newField(T initialValue) {
		return new MutableField<T>(new FieldImpl<T>(initialValue));
	}
	
	public static <T, E extends Enum<E>> MutableField<T> newField(EnumPropertyMap<E, T> map, E property) {
		return new MutableField<T>(new MappedFieldImpl<T>(map, property));
	}
	
	private MutableField(Field<T> field) {
		super(null);
		this.field = field;
	}

	public void set(T v) {
		field.setInternal(v);
	}

	@Override
	protected void setInternal(T v) {
		set(v);
	}

	@Override
	public T get() {
		return field.get();
	}
}
