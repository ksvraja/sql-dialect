/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.query;

public class LimitClause {
	private int offset;
	private int limit;

	public LimitClause(int limit, int offset) {
		if (limit > 0) {
			this.offset = offset;
			this.limit = limit;
		}else
			throw new RuntimeException("limit should be a positive integer and greater than zero");
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}
