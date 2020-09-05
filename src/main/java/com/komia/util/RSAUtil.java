package com.komia.util;
import java.io.IOException;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

import com.komia.common.exception.KomiaException;

import java.util.Base64.Encoder;
import java.util.Base64;
import java.util.Base64.Decoder;
 
public class RSAUtil {
	public static final String PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAlqskpfcGt5OKQ8Xq/pSwwih4iCTCBivxTa1pcoZ9wKrcYLLd+SSuHBHmlt0s7F7+Ts3/cAIjiOYgcLV5IeOdUvoefrARKZJ/HDixdJwGD65gLj6/f6qXusNuxjnI+rAgdfs0eSelOkCN6vNfJmKFyj/HVLXkGQK6k9NlKSP/xn0OwpvUR3bQ9CkSe3qWuZoWKLpYmIBdtDFib5ujzR9k6+86pTZ8/dRDBS5+Y9Kvkp5sS+Gh/gpyFkGAUNZ/xp60OTMeapQt9fGBxn6pNINu4Dn5UIhbPVTAu4HRzooHNXDZ0gLd1JNlO2swG5w/Zy1mWhsReCRAKila+g9LmXxTzQIDAQAB";
	
	private static final String PRIVATE_KEY = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCWqySl9wa3k4pDxer+lLDCKHiIJMIGK/FNrWlyhn3Aqtxgst35JK4cEeaW3SzsXv5Ozf9wAiOI5iBwtXkh451S+h5+sBEpkn8cOLF0nAYPrmAuPr9/qpe6w27GOcj6sCB1+zR5J6U6QI3q818mYoXKP8dUteQZArqT02UpI//GfQ7Cm9RHdtD0KRJ7epa5mhYouliYgF20MWJvm6PNH2Tr7zqlNnz91EMFLn5j0q+SnmxL4aH+CnIWQYBQ1n/GnrQ5Mx5qlC318YHGfqk0g27gOflQiFs9VMC7gdHOigc1cNnSAt3Uk2U7azAbnD9nLWZaGxF4JEAqKVr6D0uZfFPNAgMBAAECggEAFPNdWDqeU36Pllb6E0ZnwcfQ4tWBqUwI9M0tQYCUEetwU33rwc4o67xNfSLqMUAQSrL4VwHlIQ8m6aVCX8T/xl8DSIiBCm/Vfv4fJuDfMuUDeMq+5Ci7invMdoHogXtmOCGjLUmm/w+k7EvFKlg+1F3EAPJ98kBf41hc07iuw1G/DTXdUbpIrGbiyslPS5h7LMbrFNRxkMF4oONgTXnLyneF8IREPyH5MEiZJz4tNuwOr3U6oPX1xhGcd4RJ1PALRvUUzDpNof2WpenearPLyh5QIvtC9t5LxsTvkqGjn1CvAuw7W8UGJZrn+vN3MxzY3imXBmHK1t6Zai5N0nyyAQKBgQDoQAQ6KNhexERlrH6qAZh3zQODj0KT2Glmtc/1pSN0uY41s5tEEcTN6KYNUh4Fk3Y6Tiv2e4D6WmaSYTMM9Oj4lkVbMZBb9nGuL/pd5VKGgq3z+6/3HvJX+FwihXvVGmbsdBHLqc57K2tyappGN+G9QQGhaOkOVffrbU6W/XpkTQKBgQCmE2+AD9qURWyFbuEfdIIWqvyIIMR6L0wA8NPD7nMRXaGloJywlOnjySJ01oHVT7drALfGP3coy5NkkFuxQsEpBo9hmGIvMruA5l33v5uy2mI9wmuCUEvOK+/95fEdGCMBA56ythftgAcAE4NNslBomWGoBN7Z07QGt7aCFAdtgQKBgQCrDVsPqr2RLmRhreWsOHie43PPFVgno6AdcZK0jOfMNE20549XVu7n6I1EClLqMG1HDAP9CYE44hPhg40h4c8kJyj1vU9hK+UWMWfod9mMD/smUxyKmVRLzjOtiTpm/YcIZ4Qjx/C3boc4QaNWTBoKVTJqOuZLFK3/ywWy1wWpkQKBgBEDiLa76Q6rlhSNaW7JhtI/riNcCATkd4rZITi/YvZyey72p1bHyrZVUrxZhW+O/SFvL2SV9+UsBeuVhm9AgX1seJ/s9pITRnZMI3BQJulJyiq9kjoFc96pTarbNbpfUKa38jgow4bHSPBPD3KUQ/yTShfmd9YlBBp0E7R7zM8BAoGBANhooWgGn0pUr5qG3b0yZU3WJXDzcl/hjkfzs+0QlVgR75dBaOelQXMzdwDHr3Fe8LeExJC75HO998oQOVW14b1/EYOy8So84beHWjI8d073m2Ivzj3OU0f9NCPvJdbhaDnXzBo7ayF7YgSnSFW2ax3XCSyLKxw8dkB2mUdKAJHW";
	
	private static PublicKey publickey;
	
	private static PrivateKey privatekey;
	
	static {
		try {
			publickey = string2PublicKey(PUBLIC_KEY);
			privatekey = string2PrivateKey(PRIVATE_KEY);
		} catch (Exception e) {
			e.printStackTrace();
			throw new KomiaException("RSA初始化出错", e);
		}
	}
	
    //生成秘钥对
    public static KeyPair getKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        return keyPair;
    }
    
    //获取公钥(Base64编码)
    public static String getPublicKey(KeyPair keyPair){
        PublicKey publicKey = keyPair.getPublic();
        byte[] bytes = publicKey.getEncoded();
        return byte2Base64(bytes);
    }
    
    //获取私钥(Base64编码)
    public static String getPrivateKey(KeyPair keyPair){
        PrivateKey privateKey = keyPair.getPrivate();
        byte[] bytes = privateKey.getEncoded();
        return byte2Base64(bytes);
    }
    
    //将Base64编码后的公钥转换成PublicKey对象
    public static PublicKey string2PublicKey(String pubStr) throws Exception{
        byte[] keyBytes = base642Byte(pubStr);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }
    
    //将Base64编码后的私钥转换成PrivateKey对象
    public static PrivateKey string2PrivateKey(String priStr) throws Exception{
        byte[] keyBytes = base642Byte(priStr);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }
    
    //公钥加密
    public static byte[] publicEncrypt(byte[] content) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publickey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }
    
    //私钥解密
    public static byte[] privateDecrypt(byte[] content) throws Exception{
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privatekey);
        byte[] bytes = cipher.doFinal(content);
        return bytes;
    }
    
    //私钥解密
    public static String privateDecrypt(String content) {
    	String decryptPassword = "";
		try {
			byte[] base642BytePwd = RSAUtil.base642Byte(content);
			decryptPassword = new String(RSAUtil.privateDecrypt(base642BytePwd));
		} catch (Exception e) {
			e.printStackTrace();
			throw new KomiaException("密码认证出错", e);
		}
		return decryptPassword;
    }
    
	//字节数组转Base64编码
    public static String byte2Base64(byte[] bytes){
        Encoder encoder = Base64.getEncoder();
        return encoder.encodeToString(bytes);
    }
    
    //Base64编码转字节数组
    public static byte[] base642Byte(String base64Key) throws IOException{
    	Decoder decoder = Base64.getDecoder();
        return decoder.decode(base64Key);
    }
}