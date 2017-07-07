package com.toy4codes.website.framework.hibernate.type.converter;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.type.TimestampType;

/**
 * DateTime(Database) - String(Java) Converter
 * http://blog.xebia.com/understanding-and-writing-hibernate-user-types/
 */
public class DateTimeStringConverter extends ImmutableType {

	private static final Logger log = Logger.getLogger(DateTimeStringConverter.class);

	private static final String DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss";

	@Override
	public int[] sqlTypes() {
		return new int[] { TimestampType.INSTANCE.sqlType() };
	}

	@Override
	public Class<String> returnedClass() {
		return String.class;
	}

	@Override
	@SuppressWarnings("deprecation")
	public Object nullSafeGet(ResultSet rs, String[] names, Object owner) throws HibernateException, SQLException {
		assert names.length == 1;
		Date timestamp = (Date) TimestampType.INSTANCE.get(rs, names[0]);
		FastDateFormat dateFormat = FastDateFormat.getInstance(DATETIME_FORMAT);
		return timestamp == null ? null : dateFormat.format(timestamp);
	}

	@Override
	@SuppressWarnings("deprecation")
	public void nullSafeSet(PreparedStatement st, Object value, int index) throws HibernateException, SQLException {
		if (value == null) {
			TimestampType.INSTANCE.set(st, null, index);
		} else {
			final String timestamp = (String) value;
			FastDateFormat dateFormat = FastDateFormat.getInstance(DATETIME_FORMAT);
			try {
				TimestampType.INSTANCE.set(st, dateFormat.parse(timestamp), index);
			} catch (ParseException e) {
				log.error(e);
			}
		}
	}

}
