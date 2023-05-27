package kr.pincoin.api.shop.domain;

import jakarta.persistence.*;
import kr.pincoin.api.home.domain.BaseDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shop_voucher")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Voucher extends BaseDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false,
            fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "code")
    private String code;

    @Column(name = "remarks")
    private String remarks;

    @Column(name = "status")
    private Long status;

    public Voucher(Product product,
                   String code,
                   String remarks,
                   Long status) {
        this.product = product;
        this.code = code;
        this.remarks = remarks;
        this.status = status;
    }
}
