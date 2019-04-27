package com.huang.util;

import java.util.UUID;

public class RandomUtil {
	public static String getUUid() {
		return UUID.randomUUID().toString();
	}
	public static void main(String[] args) {
		System.err.println(RandomUtil.getUUid());
	}

}
