package com.ntiques.model;


	import java.io.Serializable;
	import java.util.UUID;

	import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

	import org.springframework.stereotype.Component;

	@Entity
	@Component
	public class OrderedItems implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private int orderedItemId;
		private int userId;
		private int productId;
		private int productName;
		private double totalPrice;
		private int quantity;
		
		public int getOrderedItemId() {
			return orderedItemId;
		}
		public void setOrderedItemId(int orderedItemId) {
			this.orderedItemId = orderedItemId;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public int getProductId() {
			return productId;
		}
		public void setProductId(int productId) {
			this.productId = productId;
		}
		public int getProductName() {
			return productName;
		}
		public void setProductName(int productName) {
			this.productName = productName;
		}
		public double getTotalPrice() {
			return totalPrice;
		}
		public void setTotalPrice(double totalPrice) {
			this.totalPrice = totalPrice;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		
		
}
