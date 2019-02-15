package com.yidao.jdbc.bean;

import java.util.List;

public class GetCustomerBean extends BaseBean{
List<CustomerBean> customers;

public List<CustomerBean> getList() {
	return customers;
}

public void setList(List<CustomerBean> list) {
	this.customers = list;
}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("GetCustomerBean{");
		sb.append("customers=").append(customers);
		sb.append('}');
		return sb.toString();
	}
}
