/*
 * 用户注册信息校对
 */

function check() {
	var username = document.forms["form1"]["username"].value;
	var password =document.forms["form1"]["password"].value;
	var phonenumber =document.forms["form1"]["phonenumber"].value;
	if ( username == "" ||password == "" ||phonenumber == ""  ) {
		alert("信息不能为空");
		return false;
	} else if (username.length < 6 || username.length>25||!username.match("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$")) {
		alert("用户名格式不规范");
		return false;
	}else if (password.length < 6 || password.length > 25) {
		alert("密码长度不能小于6位或者大于25位");
		return false;
	} else if (phonenumber.length !=11) {
		alert("手机号应为11位");
		return false;
	}else if (username.length >= 6 && username.length <= 20
			&& password.length > 6 && password.match("^[0-9]{7,25}$")
			&& username.match("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$")) {
		return true;
	} 
}
