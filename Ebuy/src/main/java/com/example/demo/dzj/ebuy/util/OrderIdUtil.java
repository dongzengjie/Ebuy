package com.example.demo.dzj.ebuy.util;

import java.util.UUID;

public class OrderIdUtil {
	public static String getOrderIdByUUId() {
		int machineId = 1;// 最大支持1-9个集群机器部署
		int hashCodeV = UUID.randomUUID().toString().hashCode();
		if (hashCodeV < 0) {// 有可能是负数
			hashCodeV = -hashCodeV;
		}

		return machineId + String.format("%015d", hashCodeV);
	}
}
