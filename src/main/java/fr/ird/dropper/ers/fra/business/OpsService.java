package fr.ird.dropper.ers.fra.business;

import java.io.Serializable;
import java.util.Date;

/**
 * @author conor.morgan
 *
 */
public class OpsService implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 8383857542128856389L;

    private Long id;
    private Ops ops;
    private Date creationDt;
    private boolean treated;

    public boolean isTreated() {
        return treated;
    }

    public void setTreated(boolean treated) {
        this.treated = treated;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDt() {
        return creationDt;
    }

    public void setCreationDt(Date creationDt) {
        this.creationDt = creationDt;
    }

    public Ops getOps() {
        return ops;
    }

    public void setOps(Ops ops) {
        this.ops = ops;
    }

}
