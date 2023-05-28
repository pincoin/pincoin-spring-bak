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

    @JoinColumn(name = "fullname")
    private String fullName;

    @JoinColumn(name = "user_agent")
    private String userAgent;

    @JoinColumn(name = "accept_language")
    private String acceptLanguage;

    @JoinColumn(name = "ip_address")
    private String ipAddress;

    @JoinColumn(name = "payment_method")
    private Long paymentMethod;

    @JoinColumn(name = "transaction_id")
    private String transactionId;

    @JoinColumn(name = "status")
    private Long status;

    @JoinColumn(name = "visible")
    private Long visible;

    @JoinColumn(name = "total_list_price")
    private BigDecimal totalListPrice;

    @JoinColumn(name = "total_selling_price")
    private BigDecimal totalSellingPrice;

    @JoinColumn(name = "currency")
    private Long currency;

    @JoinColumn(name = "message")
    private String message;

    @JoinColumn(name = "suspicious")
    private Boolean suspicious;

    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private Order parent;
}
