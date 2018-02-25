package com.example.demo.dzj.ebuy.util;

import javax.servlet.http.HttpServletRequest;

public class CheckVrifyCodeUtil {

	public static boolean checkVrifyCode(HttpServletRequest request,String parameter ) {

		String captchaId = (String) request.getSession().getAttribute("vrifyCode");


		if (!captchaId.equals(parameter)) {
			return false;
		} else {
			return true;

		}

	}
}
