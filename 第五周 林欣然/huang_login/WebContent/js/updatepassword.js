/*
 * 用户修改密码验证
 */

function check() {
	var username =  document.forms["form3"]["username"].value;
	var oldPassword = document.forms["form3"]["oldPassword"].value;
	var newPassword = document.forms["form3"]["newPassword"].value;
	if ( newPassword == "" ||username== "" ||oldPassword == ""  ) {
		alert("信息不能为空");
		return false;
	} else if (newPassword.length < 6 || newPassword.length > 25) {
		alert("新密码长度不能小于6位或者大于25位");
		return false;
	} else if (username.length >= 6 && username.length <= 20
			&& oldPassword.length > 6 && oldPassword.match("^[0-9]{7,25}$")
			&& newPassword.length > 6 && newPassword.match("^[0-9]{7,25}$")
			&& username.match("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$")) {
		return true;
	} 

}