package com.agl.bixi.model;

public class CheckSumModel {
	String checkSumHash;
	String orderID;
	String CustomerId;

	public String getCheckSumHash() {
		return checkSumHash;
	}

	public void setCheckSumHash(String checkSumHash) {
		this.checkSumHash = checkSumHash;
	}

	public String getOrderID() {
		return orderID;
	}

	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}

	public String getCustomerId() {
		return CustomerId;
	}

	public void setCustomerId(String customerId) {
		CustomerId = customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CustomerId == null) ? 0 : CustomerId.hashCode());
		result = prime * result + ((checkSumHash == null) ? 0 : checkSumHash.hashCode());
		result = prime * result + ((orderID == null) ? 0 : orderID.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CheckSumModel other = (CheckSumModel) obj;
		if (CustomerId == null) {
			if (other.CustomerId != null)
				return false;
		} else if (!CustomerId.equals(other.CustomerId))
			return false;
		if (checkSumHash == null) {
			if (other.checkSumHash != null)
				return false;
		} else if (!checkSumHash.equals(other.checkSumHash))
			return false;
		if (orderID == null) {
			if (other.orderID != null)
				return false;
		} else if (!orderID.equals(other.orderID))
			return false;
		return true;
	}
}
