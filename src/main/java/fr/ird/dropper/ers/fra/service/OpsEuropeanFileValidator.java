package fr.ird.dropper.ers.fra.service;

import org.apache.log4j.Logger;

import java.io.File;

/**
 * Validateur de fichiers xml au format européen.
 *
 * @author christelle.jeanberne
 */
public class OpsEuropeanFileValidator extends OpsFileValidator {

    /**
     * Logger
     */
    private final Logger logger = Logger
            .getLogger(OpsEuropeanFileValidator.class);

    private String fichierXml = "formatageEuropeen.xml";

    public OpsEuropeanFileValidator(File opsFile) {
        super(opsFile);
    }

    /* (non-Javadoc)
     * @see fr.ird.injecteur.ers.service.OpsFileValidator#getFichierXml()
     */
    public String getFichierXml() {
        return this.fichierXml;
    }

    /* (non-Javadoc)
     * @see fr.ird.injecteur.ers.service.OpsFileValidator#getLogger()
     */
    public Logger getLogger() {
        return this.logger;
    }
}
