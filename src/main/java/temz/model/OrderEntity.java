package temz.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Сергей on 05.09.2017.
 */
@Entity
@Table(name = "ToolOrder", schema = "Temz")
public class OrderEntity {
    private int id;
    private String userName;
    private String toolLabel;
    private String manufacturer;
    private Integer amount;
    private Date date;

    @Basic
    @Column(name = "ToolManufacturer")
    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Basic
    @Column(name = "UserName", nullable = true)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "ToolLabel", nullable = true)
    public String getToolLabel() {
        return toolLabel;
    }

    public void setToolLabel(String toolLabel) {
        this.toolLabel = toolLabel;
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
    @Column(name = "amount", nullable = true)
    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer toolAmount) {
        this.amount = toolAmount;
    }

    @Basic
    @Temporal(TemporalType.DATE)
    @Column(name = "date", nullable = true)
    public Date getDate() {
        return date;
    }

    public void setDate(Date orderDate) {
        this.date = orderDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderEntity that = (OrderEntity) o;

        if (id != that.id) return false;
        if (amount != null ? !amount.equals(that.amount) : that.amount != null) return false;
        if (date != null ? !date.equals(that.date) : that.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (amount != null ? amount.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
