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
import java.util.HashMap;

import com.zitlab.palmyra.api2db.sqlbuilder.condition.BinaryCondition;
import com.zitlab.palmyra.api2db.sqlbuilder.condition.Condition;
import com.zitlab.palmyra.api2db.sqlbuilder.condition.JoinType;
import com.zitlab.palmyra.api2db.sqlbuilder.dialect.Dialect;

public class SelectQuery extends Query {
	
	private HashMap<String, Table> subTables = new HashMap<String, Table>(4);
	
	private HashMap<String, Join> joinMap = new HashMap<String, Join>(4); 
	private ArrayList<Condition> conditions = new ArrayList<Condition>(4);
	private ArrayList<String> groupBy;
	private ArrayList<OrderClause> orders = new ArrayList<OrderClause>();
	private LimitClause limitClause;
	
	
	public SelectQuery(String table, String alias) {
		super(table, alias);
	}
		
	public Table getSubTable(String table, String alias) {
		String key = table + alias;
		Table sub = subTables.get(key);
		if(null == sub) {
			sub = new Table(table, alias);
			subTables.put(key, sub);
		}
		return sub;
	}
	
	private void addJoin(String key, Table table, JoinType type, Condition condition) {
		Join join = new Join(table, type, condition);
		joinMap.put(key, join);
	}

	public void addCondition(Condition condition) {
		this.conditions.add(condition);
	}

	public void addOrder(String field, boolean asc) {
		OrderClause order = new OrderClause(field, asc);
		orders.add(order);
	}
	
	public void setLimit(Integer limit, Integer offset) {
		if(limit > 0 && offset > -1) {
			limitClause = new LimitClause(limit, offset);
		}
		else
			limitClause = new LimitClause(15, 0);
	}

	public void addGroupBy(String field) {
		if (null == groupBy)
			groupBy = new ArrayList<String>();
		groupBy.add(field);
	}

	@Override
	public String getQuery(Dialect dialect) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		appendColumns(sb);
		sb.append(" FROM ").append(table.getName()).append(" AS ").append(table.getAlias());
		addJoins(sb, dialect);
		if (conditions.size() > 0) {
			addConditions(sb, dialect);
		}
		if(orders.size() > 0) {
			addOrdering(sb, dialect);
		}
		if(null != limitClause) {
			dialect.append(sb, limitClause);
		}
		//TODO  add group by conditions
		return sb.toString();
	}

	
	public String getCountQuery(Dialect dialect) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT COUNT(*) FROM (SELECT ");
		appendColumns(sb);
		sb.append(" FROM ").append(table.getName()).append(" AS ").append(table.getAlias());
		addJoins(sb, dialect);
		if (conditions.size() > 0) {
			addConditions(sb, dialect);
		}
		//TODO  add group by conditions	
		sb.append(") as _temp");
		return sb.toString();
	}
	
	private void addJoins(StringBuilder sb, Dialect dialect) {
		Table table = null;
		for (Join join : this.joinMap.values()) {
			sb.append(" ").append(join.joinType).append(" ");
			table = join.table;
			sb.append(table.getName()).append(" ").append(table.getAlias()).append(" ON ");
			join.condition.append(sb, dialect);
		}
	}

	private void addOrdering(StringBuilder sb, Dialect dialect) {
		sb.append(" ORDER BY ");
		int len = orders.size();
		int count = 1;
		for(OrderClause order : orders) {			
			//if required change for dialect based ordering.
			order.append(sb);
			if(count < len) {
				sb.append(',');
			}
			count++;
		}
	}
	
	private void addConditions(StringBuilder sb, Dialect dialect) {
		sb.append(" WHERE ");
		int len = conditions.size();
		int count = 1;
		for (Condition condition : conditions) {
			condition.append(sb, dialect);
			if(count < len) {
				sb.append(" AND ");
			}
			count++;
		}
	}
	
	private void appendColumns(StringBuilder sb) {
		this.appendColumns(sb, this.table);
		for (Join join : this.joinMap.values()) {
			this.appendColumns(sb, join.table);
		}
		sb.deleteCharAt(sb.length() - 1);
	}
	
	public void addLeftOuterJoin(String rootColumn,Table subTable, String subTableColumn) {
		String left = table.getAlias() + "." + rootColumn;
		String right = subTable.getAlias() + "." + subTableColumn;
		String key = left + right;
		addJoin(key, subTable, JoinType.LEFT_OUTER_JOIN, BinaryCondition.equals(left, right));
	}
}
