/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.dialect;

import java.security.InvalidParameterException;

import com.zitlab.palmyra.api2db.sqlbuilder.condition.NestableObject;
import com.zitlab.palmyra.api2db.sqlbuilder.query.LimitClause;
import com.zitlab.palmyra.api2db.sqlbuilder.query.OrderClause;
import com.zitlab.palmyra.api2db.sqlbuilder.query.SqlObject;

public abstract class Dialect {			
	public void append(StringBuilder sb, SqlObject object) {
		throw new InvalidParameterException("SQLObject is not supported");
	}
	
	public void append(StringBuilder sb, LimitClause lc) {
		sb.append(" LIMIT ").append(lc.getLimit());
		int offset = lc.getOffset();
		if(offset > 0)
			sb.append(" OFFSET ").append(offset);
	}
	
	public void append(StringBuilder sb, OrderClause oc) {
		oc.append(sb);
	}
	
	protected void openParanthesis(StringBuilder sb, NestableObject nestable) {
		if(nestable.isParenthesis())
			sb.append("(");
	}
	
	protected void closeParanthesis(StringBuilder sb, NestableObject nestable) {
		if(nestable.isParenthesis())
			sb.append(")");
	}
}
