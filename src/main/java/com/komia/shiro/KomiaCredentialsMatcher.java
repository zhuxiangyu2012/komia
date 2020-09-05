package com.komia.shiro;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

import com.komia.common.exception.KomiaException;
import com.komia.util.RSAUtil;

public class KomiaCredentialsMatcher implements CredentialsMatcher {

	@Override
	public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
		UsernamePasswordToken utoken=(UsernamePasswordToken) token;
		String tokenPassword = new String(utoken.getPassword());
		
		try {
			byte[] base642BytePwd = RSAUtil.base642Byte(tokenPassword);
			String decryptPassword = new String(RSAUtil.privateDecrypt(base642BytePwd));
			
			String dbPassword = (String) info.getCredentials();
			
			return decryptPassword.equals(dbPassword);
		} catch (Exception e) {
			e.printStackTrace();
			throw new KomiaException("密码认证器出错", e);
		}
		
	}

}
