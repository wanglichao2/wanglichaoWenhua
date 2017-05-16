package com.wenhua.svr.domain;

import java.util.Date;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.util.Assert;

import com.wenhua.svr.domain.base.BaseAccount;

public class Account extends BaseAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Account() {
	}
	
	/**
	 * 
	 * delete:(删除账号). <br/>
	 *
	 * @author zhuzhaohua
	 * @return
	 * @since 0.0.1-SNAPSHOT
	 */
	public Account delete() {
		this.setIsDeleted(true);
		this.setLastModifiedTime(new Date());
		return this;
	}
	
	/**
	 * 利用登录名对密码进行加密处理
	 * @param password
	 * @return
	 */
	public String hashPassword(String password) {
		Assert.notNull(getAccountName());
		
		return hashPassword(password, getAccountName());
	}
	
	/**
	 * 对密码进行加密处理
	 * @param password
	 * @return
	 */
	private String hashPassword(String password, String salt) {
		return DigestUtils.sha1Hex(String.format("%s{%s}", password, salt));
	}
	
	/**
	 * 
	 * newOne:(创建一个新的账户). <br/>
	 *
	 * @author zhuzhaohua
	 * @param accountName 账户名
	 * @param password	密码
	 * @return
	 * @since 0.0.1-SNAPSHOT
	 */
	public static Account newOne(String accountName, String password) {
		Assert.notNull(accountName);
		Assert.notNull(password);
		
		Account account = new Account();
		account.setAccountName(accountName);
		account.setIsDeleted(false);
		Date now = new Date();
		account.setLastModifiedTime(now);
		account.setCreatedTime(now);
		account.setPwd(account.hashPassword(password));
		
		return account;
	}

}
