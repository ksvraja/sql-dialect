/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.condition;

import java.util.ArrayList;

import com.zitlab.palmyra.api2db.sqlbuilder.dialect.Dialect;

public class ComboCondition extends Condition {
	private ArrayList<Condition> conditions = new ArrayList<Condition>();
	private Op operator = Op.AND;

	public ComboCondition(Op operator) {
		this.operator = operator;
	}

	public int count() {
		return conditions.size();
	}
	
	public ComboCondition addCondition(Condition condition) {
		conditions.add(condition);
		return this;
	}

	public enum Op {
		AND(" AND "), OR(" OR ");

		private final String operator;

		private Op(String operator) {
			this.operator = operator;
		}

		@Override
		public String toString() {
			return operator;
		}
	}

	@Override
	public void append(StringBuilder sb) {
		throw new RuntimeException("This method is not supported");
	}

	@Override
	public void append(StringBuilder sb, Dialect dialect) {
		int len = conditions.size();
		boolean isParenthesis = len != 1;
		if (len > 0) {
			if(isParenthesis)
				sb.append(" (");
			else
				sb.append(" ");
			int count = 1;
			for (Condition condition : conditions) {
				condition.append(sb, dialect);
				if (count < len) {
					sb.append(operator);
				}
				count++;
			}
			if(isParenthesis)
				sb.append(")");			
		}
	}

}
