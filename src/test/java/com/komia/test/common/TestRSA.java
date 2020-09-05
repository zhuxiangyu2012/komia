package com.komia.test.common;

import java.io.IOException;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

import org.junit.Test;

import com.komia.util.RSAUtil;

public class TestRSA {
	@Test
	public void testRSA() throws Exception {
		 //===============生成公钥和私钥，公钥传给客户端，私钥服务端保留==================
        //生成RSA公钥和私钥，并Base64编码
        KeyPair keyPair = RSAUtil.getKeyPair();
        String publicKeyStr = RSAUtil.getPublicKey(keyPair);
        String privateKeyStr = RSAUtil.getPrivateKey(keyPair);
        System.out.println("RSA公钥Base64编码:" + publicKeyStr);
        System.out.println("RSA私钥Base64编码:" + privateKeyStr);
        
        //=================客户端=================
        //hello, i am infi, good night!加密
        String message = "hello, i am infi, good night!";
        //将Base64编码后的公钥转换成PublicKey对象
        PublicKey publicKey = RSAUtil.string2PublicKey(publicKeyStr);
        //用公钥加密
        byte[] publicEncrypt = RSAUtil.publicEncrypt(message.getBytes());
        //加密后的内容Base64编码
        String byte2Base64 = RSAUtil.byte2Base64(publicEncrypt);
        System.out.println("公钥加密并Base64编码的结果：" + byte2Base64);
        
        
        //##############    网络上传输的内容有Base64编码后的公钥 和 Base64编码后的公钥加密的内容     #################
        
        
        
        //===================服务端================
        //将Base64编码后的私钥转换成PrivateKey对象
        PrivateKey privateKey = RSAUtil.string2PrivateKey(privateKeyStr);
        //加密后的内容Base64解码
        byte[] base642Byte = RSAUtil.base642Byte(byte2Base64);
        //用私钥解密
        byte[] privateDecrypt = RSAUtil.privateDecrypt(base642Byte);
        //解密后的明文
        System.out.println("解密后的明文: " + new String(privateDecrypt));
		
	}
	
	@Test
	public void testRSA2() throws Exception {
		try {
			//公私加密后的字符串
			String s = "ftyeDwU2exvSnZRHhFsjdrq1gIYi+TFRQMZr0v6VXaIW0FoOx3NOCcOwXZL+Lo2yamTgZNP34qSz9nq0xVY9kbV8v2bvdH4/GhRN/sGpUogrn/YzjUDthzupFZw8jGxo5qqKPF8Xic3ZckzFGlFBK8A9/3WR24TTu3eUOCU104g7aECny920rZNjWkVqNqAFs0K7NEojVckq/DKEakcADDSy1bdPxwGem0rSMflboUW/WQaUlrUAQzGaQ+zm+i5zD+gvZdp2DgXTvAvgWg1rprW1ytYZFGxFcpPePu1bo/VkMEUB6Gx+jMhgWAoEqJaslG2v/cQ4EEDXsXv8mB3gAA==";
			byte[] base642Byte = RSAUtil.base642Byte(s);
			//用私钥解密
			byte[] privateDecrypt = RSAUtil.privateDecrypt(base642Byte);
			//解密后的明文
			System.out.println("解密后的明文: " + new String(privateDecrypt));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
