package dev.seanrogan.gallery.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "purchase_orders")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(nullable = false, unique = true)
    @MapsId
    private Long id;
    @Temporal(TemporalType.DATE)
    private Date orderDate;
    private BigDecimal totalDue;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "purchaser_user_id", referencedColumnName = "id")
    private User user;
    @OneToMany(mappedBy = "id" , fetch = FetchType.LAZY)
    private List<OrderItem> itemsOrdered;

}
