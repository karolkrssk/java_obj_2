package pl.wsb.student.karol.springmvcrestaurant.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "dish")


public class Dish implements java.io.Serializable {

    private Integer id;
    private Date created;
    private Date modified;
    private String name;
    private String description;
    private Integer price;
    private Integer deleted;
    private String productType;


    public Dish() {
        this.modified = modified;
    }

    public Dish(Date created, Date modified, String name, String description, Integer deleted, Integer price, String productType) {
        this.created = created;
        this.modified = modified;
        this.name = name;
        this.description = description;
        this.deleted = deleted;
        this.price = price;
        this.productType = productType;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created", length = 19)
    public Date getCreated() {
        return this.created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified", nullable = false, length = 19)
    public Date getModified() {
        return this.modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @Column(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "price")
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    @Column(name = "deleted")
    public Integer getDeleted() {
        return this.deleted;
    }

    public void setDeleted(Integer deleted) {
        this.deleted = deleted;
    }

    @Column(name = "product_type")
    public String getProductType() {
        return this.productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }
}


