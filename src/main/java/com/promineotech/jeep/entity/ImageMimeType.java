package com.promineotech.jeep.entity;

public enum ImageMimeType {
	IMAGE_JPEG("image/jpeg");
	private String mimeType;
	
	private ImageMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	
	public String getMimeType() {
		return mimeType;
	}
}
