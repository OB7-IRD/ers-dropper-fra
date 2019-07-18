package fr.ird.dropper.ers.fra.business;

import java.util.ArrayList;
import java.util.List;

/**
 * Fichier de constantes.
 *
 * @author christelle_jeanberne
 */
@SuppressWarnings("serial")
public final class Constant {

    public static final String SENT_NAMESPACE = "ers";

    public static final String QUE_CD_GET_VESSEL_DATA = "get_vessel_data";
    public static final String QUE_CD_GET_HISTORICAL_DATA = "get_historical_data";
    public static final String QUE_CD_GET_ALL_VESSELS_DATA = "get_all_vessels_data";

    public static final String QUE_ID_VALUE1 = "RC";
    public static final String QUE_ID_VALUE2 = "IR";
    public static final String QUE_ID_VALUE3 = "XR";
    public static final String QUE_ID_VALUE4 = "NA";

    public static final String FRENCH_3CHARACTERS = "FRA";
    public static final String FRENCH_2CHARACTERS = "FR";

    public static final String XMLNS = "http://ec.europa.eu/fisheries/schema/ers/v3";
    public static final String XMLNS_XSI = "http://www.w3.org/2001/XMLSchema-instance";
    public static final String XSI_SCHEMA_LOCATION = "ers-operations-3.xsd";

    // A terme, cette liste de pays sera récupérée en base de données
    public static final List<String> PAYS_TRANSFERT_COE_COX = new ArrayList<String>() {
        {
            add("MOZ");
            add("GRL");
            add("GNB");
            add("SYC");
        }
    };

    public static final String EUROPEAN_AGENCY_3CHARACTERS = "XFA";

//	public static final String CNSP = "NNA";
//	public static final String FRANCE_AGRIMER = "NNB";
    public static final String CNSP = "NNC";
    public static final String FRANCE_AGRIMER = "NND";

    public static final String MESSAGE_V1_RET_RS_LB = "Message V1";

    public static final int ELOG_TN_LB_LENGTH = 8;

    public static final String FAO_ATLANTIQUE_NORD_EST_CODE = "27";
}
