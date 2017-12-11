package temz.model;

import javax.persistence.*;

/**
 * Created by Сергей on 05.09.2017.
 */

@Entity
@Table(name = "Storage", schema = "Temz")
public class StorageEntity {
    private int toolId;
    private Integer toolAmount;
    private Integer toolInTransit;

    @Id
    @Column(name = "id", nullable = false)
    public int getToolId() {
        return toolId;
    }

    public void setToolId(int toolId) {
        this.toolId = toolId;
    }

    @Basic
    @Column(name = "amount", nullable = true)
    public Integer getToolAmount() {
        return toolAmount;
    }

    public void setToolAmount(Integer toolAmount) {
        this.toolAmount = toolAmount;
    }

    @Basic
    @Column(name = "transit", nullable = true)
    public Integer getToolInTransit() {
        return toolInTransit;
    }

    public void setToolInTransit(Integer toolInTransit) {
        this.toolInTransit = toolInTransit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        StorageEntity that = (StorageEntity) o;

        if (toolId != that.toolId) return false;
        if (toolAmount != null ? !toolAmount.equals(that.toolAmount) : that.toolAmount != null) return false;
        if (toolInTransit != null ? !toolInTransit.equals(that.toolInTransit) : that.toolInTransit != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = toolId;
        result = 31 * result + (toolAmount != null ? toolAmount.hashCode() : 0);
        result = 31 * result + (toolInTransit != null ? toolInTransit.hashCode() : 0);
        return result;
    }
}
