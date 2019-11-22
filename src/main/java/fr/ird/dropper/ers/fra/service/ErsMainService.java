package fr.ird.dropper.ers.fra.service;

import fr.ird.common.log.LogService;
import fr.ird.driver.eva.service.EvaDriverService;
import fr.ird.dropper.ers.fra.business.Ops;
import fr.ird.dropper.ers.fra.config.ERSDropperProperties;
import java.io.File;

import java.util.Properties;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Service permettant d'initialiser la connexion à la base de données, de lire
 * le fichier de configuration, d'initialiser le parseur Xstream.
 *
 * @author Julien Lebranchu
 */
public class ErsMainService {

    private Unmarshaller jaxbUnmarshaller;

    protected void init() throws JAXBException {
        LogService.getService().logApplicationInfo("Initialisation de «ErsMainService».");
        ERSDropperProperties.getService().init();
        Properties properties = new Properties();
        properties.put("javax.persistence.jdbc.url", ERSDropperProperties.JDBC_URL);
        properties.put("javax.persistence.jdbc.password", ERSDropperProperties.JDBC_PASSWORD);
        properties.put("javax.persistence.jdbc.driver", ERSDropperProperties.JDBC_DRIVER_CLASS);
        properties.put("javax.persistence.jdbc.user", ERSDropperProperties.JDBC_USERNAME);
        EvaDriverService.getService().init("eva", properties);

        // Initialisation du parser XML
        JAXBContext jaxbContext = JAXBContext.newInstance(Ops.class);
        jaxbUnmarshaller = jaxbContext.createUnmarshaller();

    }

    public Ops unmarshal(File file) throws JAXBException {
        return (Ops) jaxbUnmarshaller.unmarshal(file);
    }
}
