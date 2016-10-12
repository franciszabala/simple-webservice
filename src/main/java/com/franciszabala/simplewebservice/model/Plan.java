package com.franciszabala.simplewebservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Builder
public class Plan {
	
	public Plan() {
		//Haha jpa
	}
	
	/** We need this for @Builder **/
	@JsonCreator
	public Plan(
			@JsonProperty("plan_id") String planId, 
			@JsonProperty("plan_name") String planName, 
			@JsonProperty("plan_price") BigDecimal planPrice, 
			@JsonProperty("expiry") Integer expiry, 
			@JsonProperty("is_plan") Boolean _plan, 
			@JsonProperty("is_unlimited") Boolean _unlimited,
			@JsonProperty("size_mb") Integer sizeMb, 
			@JsonProperty("is_4g") Boolean _4g, 
			@JsonProperty("is_auto_renew") Boolean _autoRenew, 
			@JsonProperty("terms_url") String termsUrl, 
			@JsonProperty("info_url") String infoUrl) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.planPrice = planPrice;
		this.expiry = expiry;
		this._plan = _plan;
		this._unlimited = _unlimited;
		this.sizeMb = sizeMb;
		this._4g = _4g;
		this._autoRenew = _autoRenew;
		this.termsUrl = termsUrl;
		this.infoUrl = infoUrl;
	}
	
	
	@Id
	@Column(name="plan_id")
	@JsonProperty("plan_id")
	@Getter @Setter private String planId;

	@Column(name="plan_name")
	@JsonProperty("plan_name")
	@Getter @Setter private String planName;
	
	@Column(name="plan_price")
	@JsonProperty("plan_price")
	@Getter @Setter private BigDecimal planPrice;
	
	@Column(name="expiry")
	@JsonProperty("expiry")
	@Getter @Setter private Integer expiry;
	
	@Column(name="is_plan")
	@JsonProperty("is_plan")
	private Boolean _plan;
	
	@Column(name="is_unlimited")
	@JsonProperty("is_unlimited")
	private Boolean _unlimited;
	
	@Column(name="size_mb")
	@JsonProperty("size_mb")
	@Getter @Setter private Integer sizeMb;
	
	@Column(name="is_4g")
	@JsonProperty("is_4g")
	private Boolean _4g;
	
	@Column(name="is_auto_renew")
	@JsonProperty("is_auto_renew")
	private Boolean _autoRenew;
	
	@Column(name="terms_url")
	@JsonProperty("terms_url")
	@Getter @Setter private String termsUrl;
	
	@Column(name="info_url")
	@JsonProperty("info_url")
	@Getter @Setter private String infoUrl;

	public Boolean isPlan() {
		return _plan;
	}

	public void setPlan(Boolean _plan) {
		this._plan = _plan;
	}

	public Boolean isUnlimited() {
		return _unlimited;
	}

	public void setUnlimited(Boolean _unlimited) {
		this._unlimited = _unlimited;
	}

	public Boolean is4g() {
		return _4g;
	}

	public void set4g(Boolean _4g) {
		this._4g = _4g;
	}

	public Boolean isAutoRenew() {
		return _autoRenew;
	}

	public void setAutoRenew(Boolean _autoRenew) {
		this._autoRenew = _autoRenew;
	}
	
	
}