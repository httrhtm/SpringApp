package com.example.campus.entity;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class Users implements UserDetails {

	private static final long serialVersionUID = -4292831594774687625L;

	//インターフェースに書いてない値を代入するための変数を用意する
	private int id;
	private String name;
	private String password;
	private int deleteflag;
	private byte admin_flag;

	public Users() {
	}

	public long getId() {
		//idを返す
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte getAdminFlag() {
		return admin_flag;
	}

	public void setAdminFlag(byte admin_flag) {
		this.admin_flag = admin_flag;
	}

	//UserDetailsに書いてあるメソッドを使うからオーバーライドしないとエラーが出るかも。
	@Override
	public String getPassword() {
		//パスワードを返す
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDeleteFlag() {
		//deleteflagを返す
		return deleteflag;
	}

	public void setDeleteflag(int deleteflag) {
		this.deleteflag = deleteflag;
	}

	//UserDetailsインターフェースに書いてあるメソッドはオーバライドで実装する必要がある
	//https://spring.pleiades.io/spring-security/site/docs/current/api/org/springframework/security/core/userdetails/UserDetails.html
	@Override
	//getAuthorities：ユーザーに付与された権限を返す
	public Collection<? extends GrantedAuthority> getAuthorities() {
		//返すものがないからとりあえずnull
		return null;
	}

	@Override
	public String getUsername() {
		//返すものがないからとりあえずnull
		return null;
	}

	@Override
	//ユーザーのアカウントの有効期限が切れているかどうかを示す（ユーザーのアカウントが有効な場合はtrue）
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	//ユーザーがロックされているかを示す（ユーザーがロックされていない場合はtrue）
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	//ユーザーの資格情報（パスワード）の有効期限が切れているかどうかを示す（ユーザーの資格情報が有効な場合true）
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	//ユーザーが有効か無効かを示す（ユーザーが有効な場合は true）
	public boolean isEnabled() {
		return true;
	}

}
