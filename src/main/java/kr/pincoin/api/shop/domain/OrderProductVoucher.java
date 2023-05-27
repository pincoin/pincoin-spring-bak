package kr.pincoin.api.shop.domain;

import jakarta.persistence.*;
import kr.pincoin.api.home.domain.BaseDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shop_orderproductvoucher")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProductVoucher extends BaseDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "order_product_id")
    private OrderProduct orderProduct;

    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "voucher_id")
    private Voucher voucher;

    @Column(name = "code")
    private String code;

    @Column(name = "revoked")
    private Boolean revoked;

    @Column(name = "remarks")
    private String remarks;

    public OrderProductVoucher(OrderProduct orderProduct,
                               Voucher voucher,
                               String code,
                               Boolean revoked,
                               String remarks) {
        this.orderProduct = orderProduct;
        this.voucher = voucher;
        this.code = code;
        this.revoked = revoked;
        this.remarks = remarks;
    }
}
