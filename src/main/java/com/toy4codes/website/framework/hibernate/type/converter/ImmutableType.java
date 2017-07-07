package com.toy4codes.website.framework.hibernate.type.converter;

import java.io.Serializable;
import java.util.Objects;

import org.hibernate.HibernateException;
import org.hibernate.usertype.UserType;

/**
 * http://blog.xebia.com/understanding-and-writing-hibernate-user-types/
 */
public abstract class ImmutableType implements UserType {

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
	public Object deepCopy(Object value) throws HibernateException {
		return value;
	}

	@Override
	public boolean isMutable() {
		return false;
	}

	@Override
	public Serializable disassemble(Object value) throws HibernateException {
		return (Serializable) value;
	}

	@Override
	public Object assemble(Serializable cached, Object owner) throws HibernateException {
		return cached;
	}

	@Override
	public Object replace(Object original, Object target, Object owner) throws HibernateException {
		return original;
	}

}
