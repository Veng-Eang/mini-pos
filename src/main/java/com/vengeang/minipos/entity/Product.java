package com.vengeang.minipos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="products")
public class Product extends BaseEntity {
	@Column(name = "name", length = 150)
    private String name;

    @Column(name = "code", length = 30)
    private String code;

    @Column(name = "type", length = 10)
    @Enumerated(EnumType.STRING)
    private EnumProductType type;

    @Column(name = "barcode_symbology", length = 30)
    private String barcodeSymbology;

    @Column(name = "cost")
    private Double cost;

    @Column(name = "price")
    private Double price;

    @Column(name = "qty")
    private Integer qty;

    @Column(name = "alert_qty")
    private Integer alertQty;

    @Column(name = "image_path")
    private String imagePath;

    @Column(name = "image", length = 250)
    private String image;

    @Column(name = "is_override_price", columnDefinition = "boolean default false")
    private boolean isOverridePrice;

    @Column(name = "is_show_in_pos", columnDefinition = "boolean default true")
    private boolean isShowInPos;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_unit_id")
    private ProductUnit productUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "purchase_product_unit_id")
    private ProductUnit purchaseProductUnit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sale_product_unit_id")
    private ProductUnit saleProductUnit;
}
