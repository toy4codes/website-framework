package com.toy4codes.website.framework.hibernate.type.converter;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

/**
 * You should override the following method in subclass
 * public Object deepCopy(Object value) throws HibernateException;
 * http://blog.xebia.com/understanding-and-writing-hibernate-user-types/
 */
public abstract class MutableType implements UserType {

	@Override
	public boolean equals(Object x, Object y) throws HibernateException {
		return Objects.equals(x, y);
	}

	@Override
	public int hashCode(Object x) throws HibernateException {
		assert (x != null);
		return x.hashCode();
	}

	@Override
	public boolean isMutable() {
		return true;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) deepCopy(value);
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return deepCopy(cached);
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return deepCopy(original);
	}
}
