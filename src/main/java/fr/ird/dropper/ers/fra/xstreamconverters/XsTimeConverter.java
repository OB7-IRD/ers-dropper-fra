package fr.ird.dropper.ers.fra.xstreamconverters;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.format.DateTimeFormatter;
import org.joda.time.format.ISODateTimeFormat;

import java.util.Date;

/**
 * Conversion des attributs typés xs:time, leur format est celui de l'iso8601 :
 * hh:mm:ss[Z|(+|-)hh:mm]
 *
 * @author adrian.carretero
 */
public class XsTimeConverter extends AbstractSingleValueConverter {

    /* (non-Javadoc)
	 * @see com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter#canConvert(java.lang.Class)
     */
    @SuppressWarnings("unchecked")
    @Override
    public boolean canConvert(Class type) {
        return type.equals(Date.class);
    }

    /**
     * Retourne un objet Date au format yyyy-MM-dd.
     *
     * @param value
     * @return
     */
    @Override
    public Object fromString(String value) {
        DateTimeFormatter iso8601Formater = ISODateTimeFormat.timeParser();
        // On essaye d'abbord de lire la date au format iso8601 (hh:mm:ss[Z|(+|-)hh:mm])
        try {
            DateTime dateTime = iso8601Formater.parseDateTime(value);
            return dateTime.toDate();
        } catch (IllegalArgumentException e) {
            throw new ConversionException(e.getMessage(), e);
        }
    }

    /**
     * Retourne une date(de type String) au format yyyy-MM-dd.
     *
     * @param source
     * @return
     */
    @Override
    public String toString(Object source) {

        DateTimeFormatter iso8601Formater = ISODateTimeFormat.time();

        Date date = (Date) source;
        return iso8601Formater.print(new Instant(date));
    }

}
