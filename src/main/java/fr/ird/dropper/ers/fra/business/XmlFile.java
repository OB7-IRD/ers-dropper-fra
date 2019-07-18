package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.Date;

/**
 * @author conor.morgan
 *
 */
public class XmlFile implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8383857542128856389L;

    private Long id;
    private Long fdCdn;
    private String xmlFileNameLb;
    private String xmlOnLb;
    private Date xmlCreationDt;
    private String xmlContentsTxt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getXmlFileNameLb() {
        return xmlFileNameLb;
    }

    public void setXmlFileNameLb(String xmlFileNameLb) {
        this.xmlFileNameLb = xmlFileNameLb;
    }

    public Date getXmlCreationDt() {
        return xmlCreationDt;
    }

    public void setXmlCreationDt(Date xmlCreationDt) {
        this.xmlCreationDt = xmlCreationDt;
    }

    public String getXmlContentsTxt() {
        return xmlContentsTxt;
    }

    public void setXmlContentsTxt(String xmlContentsTxt) {
        this.xmlContentsTxt = xmlContentsTxt;
    }

    public String getXmlOnLb() {
        return xmlOnLb;
    }

    public void setXmlOnLb(String xmlOnLb) {
        this.xmlOnLb = xmlOnLb;
    }

    public Long getFdCdn() {
        return fdCdn;
    }

    public void setFdCdn(Long fdCdn) {
        this.fdCdn = fdCdn;
    }

}
