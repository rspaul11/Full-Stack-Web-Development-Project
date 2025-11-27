package com.tap.model;

public class Restaurant {
	private int RestaurantId;
	private String Name;
	private String Address;
	private String PhoneNumber;
	private String CuisineType;
	private String DeliveryTime;
	private String AdminUserId;
	private float Rating;
	private String IsActive;
	private String ImagePath;
	//zero 
	public Restaurant() {
		
	}
	public int getRestaurantId() {
		return RestaurantId;
	}
	public void setRestaurantId(int restaurantId) {
		RestaurantId = restaurantId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getCuisineType() {
		return CuisineType;
	}
	public void setCuisineType(String cuisineType) {
		CuisineType = cuisineType;
	}
	public String getDeliveryTime() {
		return DeliveryTime;
	}
	public void setDeliveryTime(String deliveryTime) {
		DeliveryTime = deliveryTime;
	}
	public String getAdminUserId() {
		return AdminUserId;
	}
	public void setAdminUserId(String adminUserId) {
		AdminUserId = adminUserId;
	}
	public float getRating() {
		return Rating;
	}
	public void setRating(float rating) {
		Rating = rating;
	}
	public String getIsActive() {
		return IsActive;
	}
	public void setIsActive(String isActive) {
		IsActive = isActive;
	}
	public String getImagePath() {
		return ImagePath;
	}
	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}
	public Restaurant(int restaurantId, String name, String address, String phoneNumber, String cuisineType,
			String deliveryTime, String adminUserId, float rating, String isActive, String imagePath) {
		super();
		RestaurantId = restaurantId;
		Name = name;
		Address = address;
		PhoneNumber = phoneNumber;
		CuisineType = cuisineType;
		DeliveryTime = deliveryTime;
		AdminUserId = adminUserId;
		Rating = rating;
		IsActive = isActive;
		ImagePath = imagePath;
	}
	@Override
	public String toString() {
	    return "Restaurant{" +
	            "restaurantId=" + RestaurantId +
	            ", name='" + Name + '\'' +
	            ", address='" + Address + '\'' +
	            ", phoneNumber='" + PhoneNumber + '\'' +
	            ", cuisineType='" + CuisineType + '\'' +
	            ", deliveryTime='" + DeliveryTime + '\'' +
	            ", adminUserId='" + AdminUserId + '\'' +
	            ", rating=" + Rating +
	            ", isActive='" + IsActive + '\'' +
	            ", imagePath='" + ImagePath + '\'' +
	            '}';
	}

}

	