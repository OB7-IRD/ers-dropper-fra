package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Fin de la pêche.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("EOF")
public class Eof extends EvenementDePecheImpl {

	private static final long serialVersionUID = 1182051750078974167L;

	/** identifier field */
	@XStreamOmitField
	private Long eofCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("DA")
	@XStreamConverter(DateConverter.class)
	private Date eofDaDt;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TI")
	private String eofTiLb;

	/** nullable persistent field */
	@XStreamOmitField
	private Date eofDatiDt;

	/** persistent field */
	@XStreamOmitField
	private Log log;

    public Long getEofCdn() {
        return this.eofCdn;
    }

    public void setEofCdn(Long eofCdn) {
        this.eofCdn = eofCdn;
    }

    public Date getEofDaDt() {
        return this.eofDaDt;
    }

    public void setEofDaDt(Date eofDaDt) {
        this.eofDaDt = eofDaDt;
    }

    public String getEofTiLb() {
        return this.eofTiLb;
    }

    public void setEofTiLb(String eofTiLb) {
        this.eofTiLb = eofTiLb;
    }

    public Date getEofDatiDt() {
        return this.eofDatiDt;
    }

    public void setEofDatiDt(Date eofDatiDt) {
        this.eofDatiDt = eofDatiDt;
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePecheImpl#getLog()
	 */
	@Override
	public Log getLog() {
		return this.log;
	}

	public void setLog(Log log) {
		this.log = log;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getEofCdn();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if (!(other instanceof Eof)) {
			return false;
		}
		Eof castOther = (Eof) other;
		return new EqualsBuilder().append(this.getEofCdn(),
				castOther.getEofCdn()).isEquals();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getEofCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return eofCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (EOF)
	 * 
	 * @return this
	 */
	private Object readResolve() {
		// On crée l'attribut eofDatiDt (date/heure) qui est une concaténation
		// des attributs eofDaDt (date) et eofTiLb (heure)
		DateConverter converter = new DateConverter();
		String dateHeure = converter.toString(getEofDaDt()) + " "
				+ getEofTiLb();
		Date eofDatiDt = (Date) converter.fromDateTimeString(dateHeure);
		setEofDatiDt(eofDatiDt);
		return this;
	}

	/** 
	 * Retourne un clone qui pourra être exporté par XStream dans 
	 * un fichie XML (on ne peut pas exporter directement un objet
	 * obtenu par Hibernate car ce dernier est rempli de "proxies"
	 * que XStream ne gère pas correctement).
	 * 
	 * @return un objet qui peur être exporté par XStream
	 */
	public Eof cloneExportedFields(IExportConfiguration exportConfiguration)  {
		Eof clone = new Eof();

		clone.setEofDaDt(getEofDaDt());
		clone.setEofTiLb(getEofTiLb());

		return clone;
	}

	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getType()
	 */
	public String getType() {
		return "EOF";
	}

	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
	 */
	public Date getDatiDt() {
		return getEofDatiDt();
	}
	
	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
	 */
	public Date getDaDt() {
		return getEofDaDt();
	}

	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
	 */
	public String getTiLb() {
		return getEofTiLb();
	}
	
	public void addToLog(Log log) {
		if (log.getListEof() == null) {
			log.setListEof(new ArrayList<Eof>());
		}
		log.getListEof().add(this);
	}
	
	
	
	public List<Ras> getRasList() {
		List<Ras> listRas = new ArrayList<Ras>();
		return listRas;
	}
	
}