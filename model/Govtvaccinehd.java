
	package project.springboot.model;

	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;

	@Entity
	@Table(name="govthd")
	public class Govtvaccinehd {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private long contactId;


		
		@Column(name="contact_name")
		private String contactName;
		
		@Column(name="contact_state")
		private String contactState;
		
		@Column(name="submitted_issues")
		private String submittedIssues;
		
		public  Govtvaccinehd() {
		
		}
		
		
		
		public Govtvaccinehd(long adminId, String contactName, String contactState, String submittedIssues) {
			super();
		
			this.contactName = contactName;
			this.contactState = contactState;
			this.submittedIssues = submittedIssues;
		}
		public long getContactId() {
			return contactId;
		}
		public void setContactId(long contactId) {
			this.contactId = contactId;
		}
		
		public String getContactName() {
			return contactName;
		}
		public void setContactName(String contactName) {
			this.contactName = contactName;
		}
		public String getContactState() {
			return contactState;
		}
		public void setContactState(String contactState) {
			this.contactState = contactState;
		}
		public String getSubmittedIssues() {
			return submittedIssues;
		}
		public void setSubmittedIssues(String submittedIssues) {
			this.submittedIssues = submittedIssues;
		}

		

	}

