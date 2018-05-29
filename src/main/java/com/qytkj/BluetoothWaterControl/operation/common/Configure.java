package com.qytkj.BluetoothWaterControl.operation.common;

public class Configure {
	private static String key = "d5LD2fGg1L0erFFygmyDiSDQtYc35LI7";

	//url
	private static String sessionKeyUrl ="https://api.weixin.qq.com/sns/jscode2session";
	//小程序ID	
	private static String appID = "wx8eac7f97ba6c97a2";
	//商户号
	private static String mch_id = "1279245901";
	//secret
	private static String secret = "9b3857541cf6b4665ee411c85830fcbb";
	//授权码模式
	private static String grantType = "authorization_code";
	
	
	public static String getGrantType() {
		return grantType;
	}

	public static void setGrantType(String grantType) {
		Configure.grantType = grantType;
	}

	public static String getSessionKeyUrl() {
		return sessionKeyUrl;
	}

	public static void setSessionKeyUrl(String sessionKeyUrl) {
		Configure.sessionKeyUrl = sessionKeyUrl;
	}

	public static String getSecret() {
		return secret;
	}

	public static void setSecret(String secret) {
		Configure.secret = secret;
	}

	public static String getKey() {
		return key;
	}

	public static void setKey(String key) {
		Configure.key = key;
	}

	public static String getAppID() {
		return appID;
	}

	public static void setAppID(String appID) {
		Configure.appID = appID;
	}

	public static String getMch_id() {
		return mch_id;
	}

	public static void setMch_id(String mch_id) {
		Configure.mch_id = mch_id;
	}

}
