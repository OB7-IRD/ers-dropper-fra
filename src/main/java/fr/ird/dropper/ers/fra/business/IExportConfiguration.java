package fr.ird.dropper.ers.fra.business;

/**
 * Configuration pour l'export d'un OPS. Indique si les balises françaises
 * doivent être exportées ou non.
 *
 * @author adrian.carretero
 *
 */
public interface IExportConfiguration {

    /**
     * @param extensionsFrancaises the extensionsFrancaises to set
     */
    void setExtensionsFrancaises(boolean extensionsFrancaises);

    /**
     * @return the extensionsFrancaises
     */
    boolean isExtensionsFrancaises();

}
