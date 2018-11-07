package jp.co.rakus.stockmanagement.web;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

/**
 * メンバー関連のリクエストパラメータが入るフォーム.
 * @author igamasayuki
 *
 */
public class MemberForm {
	/** 名前 */
	@Size(min=1, max=50, message="名前を50文字以内で入力してください")
	private String name;
	/** メールアドレス */
	@Email(message="Eメールの形式が不正です")
	@Size(min=1, max=100, message="メールアドレスは100文字以内で入力してください")
	private String mailAddress;
	/** パスワード */
	@Size(min=1, max=50, message="パスワードは50文字以内で入力してください")
	private String password;
	
	/** 確認用パスワード */
	private String confirmPassword;
	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMailAddress() {
		return mailAddress;
	}
	public void setMailAddress(String mailAddress) {
		this.mailAddress = mailAddress;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
