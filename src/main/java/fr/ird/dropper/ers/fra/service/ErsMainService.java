package fr.ird.dropper.ers.fra.service;

import fr.ird.common.log.LogService;
import fr.ird.driver.eva.service.EvaService;
import fr.ird.dropper.ers.fra.config.ERSDropperProperties;

import java.util.Properties;

/**
 * Service permettant d'initialiser la connexion à la base de données, de lire
 * le fichier de configuration, d'initialiser le parseur Xstream.
 *
 * @author christelle.jeanberne
 */
public class ErsMainService {

    protected void init() {
        LogService.getService().logApplicationInfo("Initialisation de «ErsMainService».");
        ERSDropperProperties.getService().init();
        Properties properties = new Properties();
        properties.put("javax.persistence.jdbc.url", ERSDropperProperties.JDBC_URL);
        properties.put("javax.persistence.jdbc.password", ERSDropperProperties.JDBC_PASSWORD);
        properties.put("javax.persistence.jdbc.driver", ERSDropperProperties.JDBC_DRIVER_CLASS);
        properties.put("javax.persistence.jdbc.user", ERSDropperProperties.JDBC_USERNAME);
        EvaService.getService().init("eva", properties);

        // Initialisation du parser XML
        XmlReader.initXstreamParser();

    }

}
