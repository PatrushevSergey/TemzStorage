package temz.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Сергей on 05.09.2017.
 */
@Entity
@Component
@Table(name = "Tool", schema = "Temz")
public class ToolEntity {
    private int id;
    private String manufacturer;
    private String label;
    private String function;
    private String comment;
    private int toolAmount;
    private Set<ProductEntity> products = new HashSet<>();
    private Set<ToolOffEntity> toolOff = new HashSet<>();
    private Set<ToolInEntity> toolIn = new HashSet<>();

    @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ToolInEntity> getToolIn() {
        return toolIn;
    }

    public void setToolIn(Set<ToolInEntity> toolIn) {
        this.toolIn = toolIn;
    }

    @OneToMany(mappedBy = "tool", cascade = CascadeType.ALL, orphanRemoval = true)
    public Set<ToolOffEntity> getToolOff() {
        return toolOff;
    }

    public void setToolOff(Set<ToolOffEntity> toolOff) {
        this.toolOff = toolOff;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "ToolForPro",
            //внешний ключ для инструмента в таблице ToolForPro
            joinColumns = @JoinColumn(name = "Tool_Id"),
            //внешний ключ для детали из той же таблицы
            inverseJoinColumns = @JoinColumn(name = "Product_Id"))
    public Set<ProductEntity> getProducts() {
        return products;
    }

    public void setProducts(Set<ProductEntity> products) {
        this.products = products;
    }



    public int getToolAmount() {
        return toolAmount;
    }

    public void setToolAmount(int toolAmount) {
        this.toolAmount = toolAmount;
    }



    public ToolEntity(String manufacturer, String label, String function, String comment) {
        this.manufacturer = manufacturer;
        this.label = label;
        this.function = function;
        this.comment = comment;
    }

    public ToolEntity() {
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
    @Column(name = "Manufacturer", nullable = false, length = 50)
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "Label", nullable = false, length = 50)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "Function", nullable = true, length = 100)
    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    @Basic
    @Column(name = "Comment", nullable = true, length = 200)
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToolEntity that = (ToolEntity) o;

        if (id != that.id) return false;
        if (manufacturer != null ? !manufacturer.equals(that.manufacturer) : that.manufacturer != null) return false;
        if (label != null ? !label.equals(that.label) : that.label != null) return false;
        if (function != null ? !function.equals(that.function) : that.function != null) return false;
        if (comment != null ? !comment.equals(that.comment) : that.comment != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        Integer result = id;
        result = 31 * result + (manufacturer != null ? manufacturer.hashCode() : 0);
        result = 31 * result + (label != null ? label.hashCode() : 0);
        result = 31 * result + (function != null ? function.hashCode() : 0);
        result = 31 * result + (comment != null ? comment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tool{" +
                "manufacturer='" + manufacturer + '\'' +
                ", label='" + label + '\'' +
                ", function='" + function + '\'' +
                ", comment='" + comment + '\'' +
                '}';
    }
}
