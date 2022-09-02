package beans;

import dao.Identifiable;
import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author stag
 */
public class Event implements Serializable, Identifiable {

    private static final long serialVersionUID = 2L;

    private Long id;
    private Date date;
    private String title;

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Event{id=").append(id);
        sb.append(", date=").append(date);
        sb.append(", title=").append(title);
        sb.append('}');
        return sb.toString();
    }

}
