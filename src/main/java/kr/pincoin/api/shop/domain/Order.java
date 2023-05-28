package kr.pincoin.api.shop.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import kr.pincoin.api.home.domain.BaseDateTime;
import kr.pincoin.api.user.domain.User;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "shop_order")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Order extends BaseDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "order_no")
    @NotNull
    private UUID orderNo;

    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @NotNull
    private User user;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "user_agent")
    private String userAgent;

    @Column(name = "accept_language")
    private String acceptLanguage;

    @Column(name = "ip_address")
    private String ipAddress;

    @Column(name = "payment_method")
    private Long paymentMethod;

    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "status")
    private Long status;

    @Column(name = "visible")
    private Long visible;

    @Column(name = "total_list_price")
    private BigDecimal totalListPrice;

    @Column(name = "total_selling_price")
    private BigDecimal totalSellingPrice;

    @Column(name = "currency")
    private String currency;

    @Column(name = "message")
    private String message;

    @Column(name = "suspicious")
    private Boolean suspicious;

    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Order parent;
}
