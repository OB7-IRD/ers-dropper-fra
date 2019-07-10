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
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import fr.ird.dropper.ers.fra.xstreamconverters.DateConverter;

/**
 * Retour au port.
 * 
 * @author christelle.jeanberne
 */
@XStreamAlias("RTP")
public class Rtp extends EvenementDePecheImpl {

	private static final long serialVersionUID = -5909311993263624722L;

	/** identifier field */
	@XStreamOmitField
	private Long rtpCdn;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("DA")
	@XStreamConverter(DateConverter.class)
	private Date rtpDaDt;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("TI")
	private String rtpTiLb;

	/** persistent field */
	@XStreamAsAttribute
	@XStreamAlias("PO")
	private String rtpPoLb;

	/** nullable persistent field */
	@XStreamAsAttribute
	@XStreamAlias("RE")
	private String rtpReLb;

	/** nullable persistent field */
	@XStreamOmitField
     private Date rtpDatiDt;

    /** persistent field */
	@XStreamImplicit(itemFieldName = "GEA")
	private List<Gea> listGea;

    /** persistent field */
	@XStreamAlias("ERTP")
     private Ertp ertp;

    /** persistent field */
	@XStreamOmitField
     private Log log;

    public Long getRtpCdn() {
        return this.rtpCdn;
    }

    public void setRtpCdn(Long rtpCdn) {
        this.rtpCdn = rtpCdn;
    }

    public Date getRtpDaDt() {
        return this.rtpDaDt;
    }

    public void setRtpDaDt(Date rtpDaDt) {
        this.rtpDaDt = rtpDaDt;
    }

    public String getRtpTiLb() {
        return this.rtpTiLb;
    }

    public void setRtpTiLb(String rtpTiLb) {
        this.rtpTiLb = rtpTiLb;
    }

    public String getRtpPoLb() {
        return this.rtpPoLb;
    }

    public void setRtpPoLb(String rtpPoLb) {
        this.rtpPoLb = rtpPoLb;
    }

    public String getRtpReLb() {
        return this.rtpReLb;
    }

    public void setRtpReLb(String rtpReLb) {
        this.rtpReLb = rtpReLb;
    }

    public Date getRtpDatiDt() {
        return this.rtpDatiDt;
    }

    public void setRtpDatiDt(Date rtpDatiDt) {
        this.rtpDatiDt = rtpDatiDt;
    }

    public Ertp getErtp() {
        return this.ertp;
    }

    public void setErtp(Ertp ertp) {
        this.ertp = ertp;
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

	public List<Gea> getListGea() {
		return this.listGea;
	}

	public void setListGea(List<Gea> listGea) {
		this.listGea = listGea;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "" + getRtpCdn();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		if ((this == other)) {
			return true;
		}
		if (!(other instanceof Rtp)) {
			return false;
		}
		Rtp castOther = (Rtp) other;
		return new EqualsBuilder().append(this.getRtpCdn(),
				castOther.getRtpCdn()).isEquals();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		return new HashCodeBuilder().append(getRtpCdn()).toHashCode();
	}

	/**
	 * Retourne l'identifiant.
	 * 
	 * @return l'identifiant
	 */
	public Serializable getIdentifier() {
		return rtpCdn;
	}

	/**
	 * On va remplir les champs non présents dans le XML reçu. Cette méthode est
	 * appelée automatiquement par XStream après la création de l'objet (RTP)
	 * 
	 * @return this
	 */
	private Object readResolve() {
		// On crée l'attribut rtpDatiDt (date/heure) qui est une concaténation
		// des attributs rtpDaDt (date) et rtpTiLb (heure)
		DateConverter converter = new DateConverter();
		String dateHeure = converter.toString(getRtpDaDt()) + " "
				+ getRtpTiLb();
		Date rtpDatiDt = (Date) converter.fromDateTimeString(dateHeure);
		setRtpDatiDt(rtpDatiDt);
		return this;
	}

	/** 
	 * Retourne un clone qui pourra être exporté par XStream dans 
	 * un fichier XML (on ne peut pas exporter directement un objet
	 * obtenu par Hibernate car ce dernier est rempli de "proxies"
	 * que XStream ne gère pas correctement).
	 * 
	 * @return un objet qui peut être exporté par XStream
	 */
	public Rtp cloneExportedFields(IExportConfiguration exportConfiguration)  {
		Rtp clone = new Rtp();

		clone.setRtpDaDt(getRtpDaDt());
		clone.setRtpTiLb(getRtpTiLb());
		clone.setRtpPoLb(getRtpPoLb());
		clone.setRtpReLb(getRtpReLb());

		// Clone des GEA
		if (getListGea() != null && !getListGea().isEmpty()) {
			ArrayList<Gea> cloneGeas = new ArrayList<Gea>();
			for (Gea gea : getListGea()) {
				cloneGeas.add(gea.cloneExportedFields(exportConfiguration));
			}
			clone.setListGea(cloneGeas);
		}
		
		Ertp ertp = getErtp();
		if (exportConfiguration.isExtensionsFrancaises() && ertp != null) {
			clone.setErtp(ertp.cloneExportedFields(exportConfiguration));
		} else {
			clone.setErtp(null);
		}
	
		return clone;
	}

	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getType()
	 */
	public String getType() {
		return "RTP";
	}

	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDatiDt()
	 */
	public Date getDatiDt() {
		return getRtpDatiDt();
	}
	
	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getDaDt()
	 */
	public Date getDaDt() {
		return getRtpDaDt();
	}

	/* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.EvenementDePeche#getTiLb()
	 */
	public String getTiLb() {
		return getRtpTiLb();
	}


	public void addToLog(Log log) {
		if (log.getListRtp() == null) {
			log.setListRtp(new ArrayList<Rtp>());
		}
		log.getListRtp().add(this);
	}
	
	
	public List<Ras> getRasList() {
		List<Ras> listRas = new ArrayList<Ras>();
		/**listRas.add(getRas());
		for(Spe spe : getListSpe()){
			listRas.add(spe.getRas());
		}**/
		return listRas;
	}
}