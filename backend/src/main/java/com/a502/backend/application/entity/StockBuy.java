package com.a502.backend.application.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "stock_buys")
public class StockBuy {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "stock_buy_id")
	private int id;

	@Column(name = "stock_buy_uuid")
	@UuidGenerator
	private UUID stockBuyUuid;

	@Column(name = "price")
	private int price;

	@Column(name = "cnt_total")
	private int cntTotal;

	@Column(name = "cnt_not")
	private int cntNot;

	@Column(name = "status")
	private int status;

	@CreationTimestamp
	@Column(name = "created_at")
	private LocalDateTime createdAt;

	@UpdateTimestamp
	@Column(name = "modified_at")
	private LocalDateTime modifiedAt;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@ManyToOne
	@JoinColumn(name = "stock_id")
	private Stock stock;

	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Builder
	public StockBuy(int price, int cntTotal, int status, Stock stock, User user) {
		this.price = price;
		this.cntTotal = cntTotal;
		this.cntNot = cntTotal;
		this.status = status;
		this.isDeleted = true;
		this.stock = stock;
		this.user = user;
	}

}
