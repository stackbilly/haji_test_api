package com.stackbilly.haji_test.models;

import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "UUID")
    @UuidGenerator
    private UUID uid;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("mobile")
    private String mobile;

    @JsonProperty("address")
    private String address;

    @JsonProperty("createdAt")
    private String createdAt;

    @Enumerated(EnumType.STRING)
    @JsonProperty("userRole")
    private UserRole userRole;

    @JsonProperty("isEmailNotification")
    private boolean emailNotification;

    @JsonProperty("isPushNotification")
    private boolean pushNotification;

    @JsonProperty("isSMSNotification")
    private boolean smsNotification;

    // @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssx", shape =
    // JsonFormat.Shape.STRING, timezone = "UTC")
    @JsonProperty("updatedAt")
    private String updatedAt;

    @JsonProperty("fcmToken")
    private String fcmToken;

    public User() {
    }

    // Parameterized constructor
    public User(String firstName, String lastName, String email, String mobile,
            String address, String createdAt, UserRole userRole,
            boolean emailNotification, boolean pushNotification,
            boolean smsNotification, String updatedAt, String fcmToken) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.address = address;
        this.createdAt = createdAt;
        this.userRole = userRole;
        this.emailNotification = emailNotification;
        this.pushNotification = pushNotification;
        this.smsNotification = smsNotification;
        this.updatedAt = updatedAt;
        this.fcmToken = fcmToken;
    }

    // --- Getters/Setters ---
    public UUID getUid() {
        return uid;
    }

    public void setUid(UUID uid) {
        this.uid = uid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
    }

    public boolean isEmailNotification() {
        return emailNotification;
    }

    public void setEmailNotification(boolean emailNotification) {
        this.emailNotification = emailNotification;
    }

    public boolean isPushNotification() {
        return pushNotification;
    }

    public void setPushNotification(boolean pushNotification) {
        this.pushNotification = pushNotification;
    }

    public boolean isSmsNotification() {
        return smsNotification;
    }

    public void setSmsNotification(boolean smsNotification) {
        this.smsNotification = smsNotification;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getFcmToken() {
        return fcmToken;
    }

    public void setFcmToken(String fcmToken) {
        this.fcmToken = fcmToken;
    }
}