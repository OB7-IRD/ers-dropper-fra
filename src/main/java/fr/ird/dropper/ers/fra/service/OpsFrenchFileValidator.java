package fr.ird.dropper.ers.fra.service;

import java.io.File;

/**
 * Validateur de fichiers xml au format français.
 *
 * @author christelle.jeanberne
 */
public class OpsFrenchFileValidator extends OpsFileValidator {

    private final String fichierXml = "formatage.xml";

    public OpsFrenchFileValidator(File opsFile) {
        super(opsFile);
    }

    /* (non-Javadoc)
     * @see fr.ird.injecteur.ers.service.OpsFileValidator#getFichierXml()
     */
    @Override
    public String getFichierXml() {
        return this.fichierXml;
    }

    /* (non-Javadoc)
     * @see fr.ird.injecteur.ers.service.OpsFileValidator#getLogger()
     */
}
