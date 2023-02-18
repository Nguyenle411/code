
public class LibaryLan {
	@Override
	public String toString() {
		return "LibaryLan [vocabulary=" + vocabulary + ", Category=" + Category + ", past=" + past + ", vietnam="
				+ vietnam + "]";
	}
	private String vocabulary;
	private String Category;
	private String past;
	private String vietnam;
	public LibaryLan() {
		super();
	}
	public String getVocabulary() {
		return vocabulary;
	}
	public void setVocabulary(String vocabulary) {
		this.vocabulary = vocabulary;
	}
	public String getCategory() {
		return Category;
	}
	public void setCategory(String category) {
		Category = category;
	}
	public String getPast() {
		return past;
	}
	public void setPast(String past) {
		this.past = past;
	}
	public String getVietnam() {
		return vietnam;
	}
	public void setVietnam(String vietnam) {
		this.vietnam = vietnam;
	}
	public LibaryLan(String vietnam, String vocabulary, String Category, String past) {
		super();
		this.vocabulary = vocabulary;
		this.Category = Category;
		this.past = past;
		this.vietnam = vietnam;
	}
	
}
