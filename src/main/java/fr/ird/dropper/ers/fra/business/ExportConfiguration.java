package fr.ird.dropper.ers.fra.business;

import fr.ird.dropper.ers.fra.business.*;

/**
 * Configuration pour l'export d'un OPS. Indique si les balises françaises
 * doivent être exportées ou non.
 *
 * @author adrian.carretero
 *
 */
public class ExportConfiguration implements IExportConfiguration {

    private boolean extensionsFrancaises = false;

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.IExportConfiguration#setExtensionsFrancaises(boolean)
     */
    public void setExtensionsFrancaises(boolean extensionsFrancaises) {
        this.extensionsFrancaises = extensionsFrancaises;
    }

    /* (non-Javadoc)
	 * @see fr.gouv.agriculture.adage.ers.business.IExportConfiguration#isExtensionsFrancaises()
     */
    public boolean isExtensionsFrancaises() {
        return extensionsFrancaises;
    }
}
