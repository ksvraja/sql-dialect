/** 
 * (C) Copyright 2018 - https://github.com/ksvraja
 *
 * Licensed under the MIT license;
 * 
 * Refer to the LICENSE file in the project root folder 
 *
 */
package com.zitlab.palmyra.api2db.sqlbuilder.condition;

import com.zitlab.palmyra.api2db.sqlbuilder.query.Table;

public class BinaryCondition extends Condition {
	private Operator operator;
	private Object left;
	private Object right;

	public BinaryCondition(Operator operator, String left) {
		this.operator = operator;
		this.left = left;
		this.right = "?";
	}
	
	public BinaryCondition(Operator operator, Table table, String left) {
		this.operator= operator;
		this.left = getColumnAlias(table, left);
		this.right = "?";
	}

	public BinaryCondition(Operator operator, String left, Object right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	public Operator getOperator() {
		return operator;
	}

	public Object getLeft() {
		return left;
	}

	public Object getRight() {
		return right;
	}

	public String toString() {
		return left + operator.toString() + right;
	}

	@Override
	public void append(StringBuilder sb) {
		if (parenthesis)
			sb.append("(");
		sb.append(left).append(operator).append(right);
		if (parenthesis)
			sb.append(")");
	}

	public static BinaryCondition lessThan(String column, Object value) {
		return new BinaryCondition(Operator.LESS_THAN, column, value);
	}

	public static BinaryCondition lessThanOrEq(String column, Object value) {
		return new BinaryCondition(Operator.LESS_THAN_OR_EQUAL_TO, column, value);
	}

	public static BinaryCondition greaterThan(String column, Object value) {
		return new BinaryCondition(Operator.GREATER_THAN, column, value);
	}

	public static BinaryCondition greaterThanOrEq(String column, Object value) {
		return new BinaryCondition(Operator.GREATER_THAN_OR_EQUAL_TO, column, value);
	}

	public static BinaryCondition equals(String column, Object value) {
		return new BinaryCondition(Operator.EQUAL_TO, column, value);
	}

	public static BinaryCondition notEquals(String column, Object value) {
		return new BinaryCondition(Operator.NOT_EQUAL_TO, column, value);
	}

	public static BinaryCondition like(String column, Object value) {
		return new BinaryCondition(Operator.LIKE, column, value);
	}

	public static BinaryCondition notLike(String column, Object value) {
		return new BinaryCondition(Operator.NOT_LIKE, column, value);
	}
	
	
	public static BinaryCondition lessThan(String column) {
		return new BinaryCondition(Operator.LESS_THAN, column);
	}

	public static BinaryCondition lessThanOrEq(String column) {
		return new BinaryCondition(Operator.LESS_THAN_OR_EQUAL_TO, column);
	}

	public static BinaryCondition greaterThan(String column) {
		return new BinaryCondition(Operator.GREATER_THAN, column);
	}

	public static BinaryCondition greaterThanOrEq(String column) {
		return new BinaryCondition(Operator.GREATER_THAN_OR_EQUAL_TO, column);
	}

	public static BinaryCondition equals(String column) {
		return new BinaryCondition(Operator.EQUAL_TO, column);
	}

	public static BinaryCondition notEquals(String column) {
		return new BinaryCondition(Operator.NOT_EQUAL_TO, column);
	}

	public static BinaryCondition like(String column) {
		return new BinaryCondition(Operator.LIKE, column);
	}

	public static BinaryCondition notLike(String column) {
		return new BinaryCondition(Operator.NOT_LIKE, column);
	}

	public static NullCondition isNull(String column) {
		return new NullCondition(column);
	}

	public static NotNullCondition isNotNull( String column) {
		return new NotNullCondition(column);
	}

	
	public static BinaryCondition lessThan(Table table, String column) {
		return new BinaryCondition(Operator.LESS_THAN, table, column);
	}

	public static BinaryCondition lessThanOrEq(Table table, String column) {
		return new BinaryCondition(Operator.LESS_THAN_OR_EQUAL_TO, table, column);
	}

	public static BinaryCondition greaterThan(Table table, String column) {
		return new BinaryCondition(Operator.GREATER_THAN, table, column);
	}

	public static BinaryCondition greaterThanOrEq(Table table, String column) {
		return new BinaryCondition(Operator.GREATER_THAN_OR_EQUAL_TO, table, column);
	}

	public static BinaryCondition equals(Table table, String column) {
		return new BinaryCondition(Operator.EQUAL_TO, table, column);
	}

	public static BinaryCondition notEquals(Table table, String column) {
		return new BinaryCondition(Operator.NOT_EQUAL_TO, table, column);
	}

	public static BinaryCondition like(Table table, String column) {
		return new BinaryCondition(Operator.LIKE, table, column);
	}

	public static BinaryCondition notLike(Table table, String column) {
		return new BinaryCondition(Operator.NOT_LIKE, table, column);
	}
	
	public static NullCondition isNull(Table table, String column) {
		return new NullCondition(getColumnAlias(table, column));
	}

	public static NotNullCondition isNotNull(Table table, String column) {
		return new NotNullCondition(getColumnAlias(table, column));
	}
}
