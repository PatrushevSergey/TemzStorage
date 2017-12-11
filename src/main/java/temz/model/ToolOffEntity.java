package temz.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Сергей on 05.09.2017.
 */
@Entity
@Table(name = "ToolOff", schema = "Temz")

public class ToolOffEntity {
    private int toolId;
    private int toolAmount;
    private Date date;
    private String userLogin;
    private int id;
    private ToolEntity tool;


    @ManyToOne
    @JoinColumn(name = "ToolId", referencedColumnName = "Id")
    public ToolEntity getTool() {
        return tool;
    }

    public void setTool(ToolEntity tool) {
        this.tool = tool;
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
    @Column(name = "Date", nullable = false)
    public Date getDate() {
        return date;
    }

    public ToolOffEntity() {
    }

    public ToolOffEntity(int toolId, int toolAmount, Date date) {

        this.toolId = toolId;
        this.toolAmount = toolAmount;
        this.date = date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "UserLogin", nullable = false, length = 200)
    public String getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToolOffEntity that = (ToolOffEntity) o;

        if (toolId != that.toolId) return false;
        if (toolAmount != that.toolAmount) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;
        if (userLogin != null ? !userLogin.equals(that.userLogin) : that.userLogin != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = toolId;
        result = 31 * result + toolAmount;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (userLogin != null ? userLogin.hashCode() : 0);
        return result;
    }

    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
