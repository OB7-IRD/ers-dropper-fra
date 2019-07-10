package fr.ird.dropper.ers.fra.business;

/**
 * Table des navires concernés par ERS V3
 * 
 * @author conor.morgan
 */
public class NavireErs {

	private Long cdn;

	private Long opCdn;

	public Long getOpCdn() {
		return opCdn;
	}

	public void setOpCdn(Long opCdn) {
		this.opCdn = opCdn;
	}

	public Long getCdn() {
		return cdn;
	}

	public void setCdn(Long cdn) {
		this.cdn = cdn;
	}

}