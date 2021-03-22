package com.example.campus.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.campus.auth.DetailsUserService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DetailsUserService userDetailsService;

	//ユーザーの認証方式（3つの方法：インメモリ、DB、LDAP?）
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}

	//アクセス制御の役割を持ったメソッド
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/css/**").permitAll()
			.anyRequest().authenticated()
			.and()
			.formLogin()
				.loginPage("/login")//htmlファイルではない。あくまでリクエストURL
				.usernameParameter("id").permitAll()
				.passwordParameter("password").permitAll()
				.defaultSuccessUrl("/top");
		}

	@Bean //@Beanをつけることであらゆる場所から呼び出せるようにする
	//パスワードをハッシュ化するためのメソッド
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
