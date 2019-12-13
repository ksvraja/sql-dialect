/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.dialect;

import com.zitlab.palmyra.api2db.sqlbuilder.query.LimitClause;

public class MsSqlDialect extends Dialect{
	public void append(StringBuilder sb, LimitClause lc) {
		
		int offset = lc.getOffset();
		if(offset > 0) {
			sb.append(" OFFSET ").append(offset).append(" ROWS");
			sb.append(" FETCH NEXT ").append(lc.getLimit()).append(" ROWS ONLY");
		}else
			sb.append(" FETCH FIRST ").append(lc.getLimit()).append(" ROWS ONLY");
	}
}
