package per.javee.hitit.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码管理器
 */
public class UserPwdManager {
	
	private UserPwdManager(){}
	
	private static BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	/*
	 * 加密密码
	 */
	public static String encode(String pwd){
		return encoder.encode(pwd);
	}
	
	/**
	 * 验证密码
	 * @param rawPassword
	 * @param encodedPassword
	 * @return
	 */
	public static boolean matches(String rawPassword, String encodedPassword){
		return encoder.matches(rawPassword, encodedPassword);
	}
	
}
