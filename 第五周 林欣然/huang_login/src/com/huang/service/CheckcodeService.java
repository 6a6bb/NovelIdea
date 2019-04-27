package com.huang.service;

import java.awt.image.BufferedImage;

public interface CheckcodeService {
	 /** 
	  * 生成验证码
     */ 
	public String creatCode(BufferedImage image);

}
