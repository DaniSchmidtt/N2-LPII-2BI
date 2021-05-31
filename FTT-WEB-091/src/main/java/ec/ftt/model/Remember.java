package ec.ftt.model;

import java.util.Objects;

public class Remember {
	
	  private long id;
	    private String question,
	                   answer,
	                   site;

	    public Remember() {

	    }
	    
	    
	    public Remember(String id, String question, String answer, String site) {
			super();
			setId(id);
			setQuestion(question);
			setAnswer(answer);
			setSite(site);
		}
	    
	    public Remember( String question, String answer, String site) {
			super();
			setQuestion(question);
			setAnswer(answer);
			setSite(site);
		}
	    
	    public Remember(long id, String question, String answer, String site) {
			super();
			setId(id);
			setQuestion(question);
			setAnswer(answer);
			setSite(site);
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}
		

		public void setId(String id) {
	        if (id.length()==0)
	            setId(0);
	        else
	            setId(Long.valueOf(id));
	    }

		public String getQuestion() {
			return question;
		}

		public void setQuestion(String question) {
			this.question = question;
		}

		public String getAnswer() {
			return answer;
		}

		public void setAnswer(String answer) {
			this.answer = answer;
		}

		public String getSite() {
			return site;
		}

		public void setSite(String site) {
			this.site = site;
		}
		
		@Override
		public String toString() {
			return "Remember: [id=" + id + ", question=" + question + ", answer=" + answer + ", site=" + site + "]";
		}

}
