package kr.pincoin.api.shop.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import kr.pincoin.api.home.domain.BaseDateTime;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "shop_store")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Store extends BaseDateTime {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "theme")
    private String theme;

    @Column(name = "phone")
    private String phone;

    @Column(name = "phone1")
    private String phone1;

    @Column(name = "kakao")
    private String kakao;

    @Column(name = "bank_account")
    private String bankAccount;

    @Column(name = "escrow_account")
    private String escrowAccount;

    @Column(name = "chunk_size")
    @Min(1)
    private Long chunkSize;

    @Column(name = "block_size")
    @Min(1)
    private Long blockSize;

    @Column(name = "signup_open")
    private Boolean signUpOpen;

    @Column(name = "under_attack")
    private Boolean underAttack;

    public Store(String name,
                 String code,
                 String theme,
                 String phone,
                 String phone1,
                 String kakao,
                 String bankAccount,
                 String escrowAccount,
                 Long chunkSize,
                 Long blockSize,
                 Boolean signUpOpen,
                 Boolean underAttack) {
        this.name = name;
        this.code = code;
        this.theme = theme;
        this.phone = phone;
        this.phone1 = phone1;
        this.kakao = kakao;
        this.bankAccount = bankAccount;
        this.escrowAccount = escrowAccount;
        this.chunkSize = chunkSize;
        this.blockSize = blockSize;
        this.signUpOpen = signUpOpen;
        this.underAttack = underAttack;
    }
}
