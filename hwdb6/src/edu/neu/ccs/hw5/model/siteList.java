package edu.neu.ccs.hw5.model;

import java.util.List;

import javax.xml.bind.annotation.*;



	@XmlRootElement
	@XmlAccessorType(value = XmlAccessType.FIELD)
	public class siteList {
		@XmlElement(name="site")
		private List<site> sites;

		public List<site> getSites() {
			return sites;
		}

		public void setSites(List<site> sites) {
			this.sites = sites;
		}

		public siteList() {
			super();
		}

		public siteList(List<site> sites) {
			super();
			this.sites = sites;
		}
}
