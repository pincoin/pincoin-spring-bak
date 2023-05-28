package kr.pincoin.api.shop.dto;

import kr.pincoin.api.shop.domain.OrderProduct;
import kr.pincoin.api.shop.domain.OrderProductVoucher;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class OrderProductVoucherResponse {
    private String code;

    private String remarks;

    private Boolean revoked;

    private String productName;

    private String productSubtitle;

    private String productCode;

    private BigDecimal listPrice;

    private BigDecimal sellingPrice;

    private Long quantity;

    public OrderProductVoucherResponse(OrderProductVoucher orderProductVoucher) {
        this.code = orderProductVoucher.getCode();
        this.remarks = orderProductVoucher.getRemarks();
        this.revoked = orderProductVoucher.getRevoked();

        OrderProduct orderProduct = orderProductVoucher.getOrderProduct();

        this.productName = orderProduct.getName();
        
        this.productSubtitle = orderProduct.getSubtitle();
        this.productCode = orderProduct.getCode();

        this.listPrice = orderProduct.getListPrice();
        this.sellingPrice = orderProduct.getSellingPrice();
        this.quantity = orderProduct.getQuantity();
    }
}
