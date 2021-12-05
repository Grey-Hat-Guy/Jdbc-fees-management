package application;

public class ViewController {

		private String nameString;
		private Integer erp;
		private String fString;
		private String mString;
		private Long number;
		private String yearString;
		private String feestypeString;
		private Integer fees;
		public ViewController(String nameString, Integer erp, String fString, String mString, Long number, String yearString,
				String feestypeString, Integer fees) {
			super();
			this.nameString = nameString;
			this.erp = erp;
			this.fString = fString;
			this.mString = mString;
			this.number = number;
			this.yearString = yearString;
			this.feestypeString = feestypeString;
			this.fees = fees;
		}
		public String getNameString() {
			return nameString;
		}
		public Integer getErp() {
			return erp;
		}
		public String getFString() {
			return fString;
		}
		public String getMString() {
			return mString;
		}
		public Long getNumber() {
			return number;
		}
		public String getYearString() {
			return yearString;
		}
		public String getFeestypeString() {
			return feestypeString;
		}
		public Integer getFees() {
			return fees;
		}
		public void setNameString(String nameString) {
			this.nameString = nameString;
		}
		public void setErp(Integer erp) {
			this.erp = erp;
		}
		public void setFString(String fString) {
			this.fString = fString;
		}
		public void setMString(String mString) {
			this.mString = mString;
		}
		public void setNumber(Long number) {
			this.number = number;
		}
		public void setYearString(String yearString) {
			this.yearString = yearString;
		}
		public void setFeestypeString(String feestypeString) {
			this.feestypeString = feestypeString;
		}
		public void setFees(Integer fees) {
			this.fees = fees;
		}
		
		
		
		
		
}		