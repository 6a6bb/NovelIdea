/**
 * 权限更改校对
 */
function check() {
	var username = document.forms["form88"]["username"].value;
	var newRight =document.forms["form88"]["newRight"].value;
	if (username == "" || newRight == ""  ) {
		alert("信息不能为空");
		return false;
	} else if (username.length < 6 || username.length>25||!username.match("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,20}$")) {
		alert("用户名格式不规范");
		return false;
	}else if(newRight!="超级管理员"&&newRight!="管理员"&&newRight!="用户"){
		alert("不存在这样的权限哦");
		return false;		
	}
	
	return true;
	
}