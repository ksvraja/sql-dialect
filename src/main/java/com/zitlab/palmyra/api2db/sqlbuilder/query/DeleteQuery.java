/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.query;

import java.util.ArrayList;

import com.zitlab.palmyra.api2db.sqlbuilder.condition.Condition;
import com.zitlab.palmyra.api2db.sqlbuilder.condition.SqlQueryException;
import com.zitlab.palmyra.api2db.sqlbuilder.dialect.Dialect;

public class DeleteQuery extends Query{

	private ArrayList<Condition> conditions = new ArrayList<Condition>(4);
	
	public DeleteQuery(String table, String alias) {
		super(table, alias);
	}
	
	@Override
	public String getQuery(Dialect dialect) {
		StringBuilder sb = new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(table.getName());		
		sb.append(" WHERE ");
		addConditions(sb, dialect);
		return sb.toString();
	}
	
	
	private void addConditions(StringBuilder sb, Dialect dialect) {		
		int len = conditions.size();
		if(0 == len) {
			throw new SqlQueryException("No where clause conditions provided. Update query will not be generated");
		}
		int count = 1;
		for (Condition condition : conditions) {
			condition.append(sb, dialect);
			if(count < len) {
				sb.append(" AND ");
			}
			count++;
		}
	}

	public void addCondition(Condition condition) {
		this.conditions.add(condition);
	}
}
