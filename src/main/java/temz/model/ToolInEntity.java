package temz.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Сергей on 05.09.2017.
 */
@Entity
@Table(name = "ToolIn", schema = "Temz")
public class ToolInEntity {
    private int toolId;
    private int id;
    private int toolAmount;
    private Date date;
    private String userLogin;
    private ToolEntity tool;

    @ManyToOne
    @JoinColumn(name = "ToolId", referencedColumnName = "Id")
    public ToolEntity getTool() {
        return tool;
    }

    public void setTool(ToolEntity tool) {
        this.tool = tool;
    }

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ToolId", nullable = false, insertable = false, updatable = false)
    public int getToolId() {
        return toolId;
    }

    public void setToolId(int toolId) {
        this.toolId = toolId;
    }

    @Basic
    @Column(name = "ToolAmount", nullable = false)
    public int getToolAmount() {
        return toolAmount;
    }

    public void setToolAmount(int toolAmount) {
        this.toolAmount = toolAmount;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "Date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToolInEntity that = (ToolInEntity) o;

        if (id != that.id) return false;
        if (toolAmount != that.toolAmount) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + toolAmount;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Basic
    @Column(name = "UserLogin", nullable = false, length = 50)
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }
}
