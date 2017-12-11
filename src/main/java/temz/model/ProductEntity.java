package temz.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Сергей on 11.09.2017.
 */
@Entity
@Component
@Table(name = "Product", schema = "Temz")
public class ProductEntity {
    private int id;
    private String proLabel;
    private String ofLabel;
    private Set<ToolEntity> tools = new HashSet<>();


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "ToolForPro",
            //внешний ключ для продукта в таблице ToolForPro
            joinColumns = @JoinColumn(name = "Product_Id"),
            //внешний ключ для инструмента из той же таблицы
            inverseJoinColumns = @JoinColumn(name = "Tool_Id"))
    public Set<ToolEntity> getTools() {
        return tools;
    }

    public void setTools(Set<ToolEntity> tools) {
        this.tools = tools;
    }



    @Id
    @Column(name = "Id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "ProLabel", nullable = false, length = 50)
    public String getProLabel() {
        return proLabel;
    }

    public void setProLabel(String proLabel) {
        this.proLabel = proLabel;
    }

    @Basic
    @Column(name = "OfLabel", length = 50)
    public String getOfLabel() {
        return ofLabel;
    }

    public void setOfLabel(String ofLabel) {
        this.ofLabel = ofLabel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductEntity that = (ProductEntity) o;

        if (id != that.id) return false;
        if (proLabel != null ? !proLabel.equals(that.proLabel) : that.proLabel != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (proLabel != null ? proLabel.hashCode() : 0);
        return result;
    }
}
