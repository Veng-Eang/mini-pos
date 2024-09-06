package com.vengeang.minipos.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="product_unit")
public class ProductUnit extends BaseEntity {
	

    @Column(name = "name", length = 150)
    private String name;
    
	@Column(name = "code", length = 10)
    private String code;


    @Enumerated(EnumType.STRING)
    @Column(name = "operator", length = 10)
    private EnumProductUnit operator;

    @Column(name = "operation_value")
    private Double operationValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    @JsonBackReference
    private ProductUnit parent;

    @OneToMany(mappedBy = "parent")
    @JsonManagedReference
    private List<ProductUnit> children;
}
