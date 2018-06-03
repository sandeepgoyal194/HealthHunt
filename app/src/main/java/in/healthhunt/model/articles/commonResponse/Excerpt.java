package in.healthhunt.model.articles.commonResponse;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;

@Table(name = "Excerpts")
public class Excerpt extends Model {

	/*@Column(name = "parent_id", onDelete = Column.ForeignKeyAction.CASCADE)
	private long parent_id;

	public long getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}
*/
	@Column(name = "rendered")
	private String rendered;

	@Column(name = "raw")
	private String raw;

	public Excerpt(){
		super();
	}

	public void setRendered(String rendered){
		this.rendered = rendered;
	}

	public String getRendered(){
		return rendered;
	}

	public void setRaw(String raw){
		this.raw = raw;
	}

	public String getRaw(){
		return raw;
	}

	@Override
 	public String toString(){
		return 
			"Excerpt{" + 
			"rendered = '" + rendered + '\'' + 
			",raw = '" + raw + '\'' + 
			"}";
		}
}
