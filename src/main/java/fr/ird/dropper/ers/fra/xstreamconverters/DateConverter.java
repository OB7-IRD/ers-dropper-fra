package fr.ird.dropper.ers.fra.xstreamconverters;

import com.thoughtworks.xstream.converters.ConversionException;
import com.thoughtworks.xstream.converters.basic.AbstractSingleValueConverter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Classe utilitaire de conversion de dates.
 *
 * @author christelle.jeanberne
 */
public class DateConverter extends AbstractSingleValueConverter {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    SimpleDateFormat dateTimeFormatWithSeconds = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat frenchDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    SimpleDateFormat frenchTimeFormat = new SimpleDateFormat("HH:mm");
    SimpleDateFormat frenchTimeWithSecondsFormat = new SimpleDateFormat("HH:mm:ss");
    SimpleDateFormat frenchDateTimeFormat = new SimpleDateFormat(
            "dd/MM/yyyy HH:mm");
    SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");
    SimpleDateFormat americanDateFormat = new SimpleDateFormat("yyyyMMdd");
    SimpleDateFormat testTimeStampFormat = new SimpleDateFormat("HHmmss");

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
        try {
            Date date = new Date();
            switch (value.length()) {
                case 10:
                    date = dateFormat.parse(value);
                    break;
                case 5:
                    date = timeFormat.parse(value);
                    break;
                case 8:
                    date = frenchTimeWithSecondsFormat.parse(value);
                    break;
                case 16:
                    date = dateTimeFormat.parse(value);
                    break;
                case 19:
                    date = dateTimeFormatWithSeconds.parse(value);
                    break;
                default:
                    break;
            }
            return date;
        } catch (ParseException e) {
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
        Date date = (Date) source;
        return dateFormat.format(date);
    }

    /**
     * Retourne une date(de type String) au format dd/MM/yyyy.
     *
     * @param source
     * @return
     */
    public String frenchDateToString(Object source) {
        Date date = (Date) source;
        return frenchDateFormat.format(date);
    }

    /**
     * Retourne une date(de type String) au format HH:mm.
     *
     * @param source
     * @return
     */
    public String frenchTimeToString(Object source) {
        Date date = (Date) source;
        return frenchTimeFormat.format(date);
    }

    /**
     * Retourne une date(de type String) au format HH:mm:ss.
     *
     * @param source
     * @return
     */
    public String frenchTimeWithSecondsFormat(Object source) {
        Date date = (Date) source;
        return frenchTimeWithSecondsFormat.format(date);
    }

    /**
     * Retourne une date(de type String) au format dd/MM/yyyy HH:mm.
     *
     * @param source
     * @return
     */
    public String frenchDateTimeToString(Object source) {
        Date date = (Date) source;
        return frenchDateTimeFormat.format(date);
    }

    /**
     * Retourne un objet Date au format yyyy-MM-dd HH:mm.
     *
     * @param value
     * @return
     */
    public Object fromDateTimeString(String value) {
        try {
            Date date = dateTimeFormat.parse(value);
            return date;
        } catch (ParseException e) {
            throw new ConversionException(e.getMessage(), e);
        }
    }

    /**
     * Retourne une date(de type String) au format yyyy-MM-dd HH:mm.
     *
     * @param source
     * @return
     */
    public String toDateTimeString(Object source) {
        Date date = (Date) source;
        return dateTimeFormat.format(date);
    }

    /**
     * Retourne un objet Date au format HH:mm.
     *
     * @param value
     * @return
     */
    public Object fromTimeString(String value) {
        try {
            Date date = timeFormat.parse(value);
            return date;
        } catch (ParseException e) {
            throw new ConversionException(e.getMessage(), e);
        }
    }

    /**
     * Retourne une date(de type String) au format HH:mm.
     *
     * @param source
     * @return
     */
    public String toTimeString(Object source) {
        Date date = (Date) source;
        return timeFormat.format(date);
    }

    /**
     * Retourne un objet Date au format yyyyMMdd.
     *
     * @param value
     * @return
     */
    public Object fromAmericanDateFormatString(String value) {
        try {
            Date date = americanDateFormat.parse(value);
            return date;
        } catch (ParseException e) {
            throw new ConversionException(e.getMessage(), e);
        }
    }

    /**
     * Retourne une date(de type String) au format yyyyMMdd.
     *
     * @param source
     * @return
     */
    public String toAmericanDateFormatString(Object source) {
        Date date = (Date) source;
        return americanDateFormat.format(date);
    }

    /**
     * Retourne une date au format yyyyMMddHHmmssSSS.
     *
     * @param source
     * @return
     */
    public String toTestTimeStampString(Object source) {
        Date date = (Date) source;
        return testTimeStampFormat.format(date);
    }

    /**
     * Retourne une date au format yyyyMMdd.
     *
     * @param date
     * @return
     */
    public static Date removeTime(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
}
