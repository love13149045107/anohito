package com.ggjj.zhzz.pojo;

import java.util.ArrayList;
import java.util.List;

public class LocExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LocExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andLocIsNull() {
            addCriterion("loc is null");
            return (Criteria) this;
        }

        public Criteria andLocIsNotNull() {
            addCriterion("loc is not null");
            return (Criteria) this;
        }

        public Criteria andLocEqualTo(Integer value) {
            addCriterion("loc =", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotEqualTo(Integer value) {
            addCriterion("loc <>", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocGreaterThan(Integer value) {
            addCriterion("loc >", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocGreaterThanOrEqualTo(Integer value) {
            addCriterion("loc >=", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLessThan(Integer value) {
            addCriterion("loc <", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocLessThanOrEqualTo(Integer value) {
            addCriterion("loc <=", value, "loc");
            return (Criteria) this;
        }

        public Criteria andLocIn(List<Integer> values) {
            addCriterion("loc in", values, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotIn(List<Integer> values) {
            addCriterion("loc not in", values, "loc");
            return (Criteria) this;
        }

        public Criteria andLocBetween(Integer value1, Integer value2) {
            addCriterion("loc between", value1, value2, "loc");
            return (Criteria) this;
        }

        public Criteria andLocNotBetween(Integer value1, Integer value2) {
            addCriterion("loc not between", value1, value2, "loc");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneIsNull() {
            addCriterion("putawayzone is null");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneIsNotNull() {
            addCriterion("putawayzone is not null");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneEqualTo(String value) {
            addCriterion("putawayzone =", value, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneNotEqualTo(String value) {
            addCriterion("putawayzone <>", value, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneGreaterThan(String value) {
            addCriterion("putawayzone >", value, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneGreaterThanOrEqualTo(String value) {
            addCriterion("putawayzone >=", value, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneLessThan(String value) {
            addCriterion("putawayzone <", value, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneLessThanOrEqualTo(String value) {
            addCriterion("putawayzone <=", value, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneLike(String value) {
            addCriterion("putawayzone like", value, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneNotLike(String value) {
            addCriterion("putawayzone not like", value, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneIn(List<String> values) {
            addCriterion("putawayzone in", values, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneNotIn(List<String> values) {
            addCriterion("putawayzone not in", values, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneBetween(String value1, String value2) {
            addCriterion("putawayzone between", value1, value2, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andPutawayzoneNotBetween(String value1, String value2) {
            addCriterion("putawayzone not between", value1, value2, "putawayzone");
            return (Criteria) this;
        }

        public Criteria andStacklimitIsNull() {
            addCriterion("stacklimit is null");
            return (Criteria) this;
        }

        public Criteria andStacklimitIsNotNull() {
            addCriterion("stacklimit is not null");
            return (Criteria) this;
        }

        public Criteria andStacklimitEqualTo(Integer value) {
            addCriterion("stacklimit =", value, "stacklimit");
            return (Criteria) this;
        }

        public Criteria andStacklimitNotEqualTo(Integer value) {
            addCriterion("stacklimit <>", value, "stacklimit");
            return (Criteria) this;
        }

        public Criteria andStacklimitGreaterThan(Integer value) {
            addCriterion("stacklimit >", value, "stacklimit");
            return (Criteria) this;
        }

        public Criteria andStacklimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("stacklimit >=", value, "stacklimit");
            return (Criteria) this;
        }

        public Criteria andStacklimitLessThan(Integer value) {
            addCriterion("stacklimit <", value, "stacklimit");
            return (Criteria) this;
        }

        public Criteria andStacklimitLessThanOrEqualTo(Integer value) {
            addCriterion("stacklimit <=", value, "stacklimit");
            return (Criteria) this;
        }

        public Criteria andStacklimitIn(List<Integer> values) {
            addCriterion("stacklimit in", values, "stacklimit");
            return (Criteria) this;
        }

        public Criteria andStacklimitNotIn(List<Integer> values) {
            addCriterion("stacklimit not in", values, "stacklimit");
            return (Criteria) this;
        }

        public Criteria andStacklimitBetween(Integer value1, Integer value2) {
            addCriterion("stacklimit between", value1, value2, "stacklimit");
            return (Criteria) this;
        }

        public Criteria andStacklimitNotBetween(Integer value1, Integer value2) {
            addCriterion("stacklimit not between", value1, value2, "stacklimit");
            return (Criteria) this;
        }

        public Criteria andFootprintIsNull() {
            addCriterion("footprint is null");
            return (Criteria) this;
        }

        public Criteria andFootprintIsNotNull() {
            addCriterion("footprint is not null");
            return (Criteria) this;
        }

        public Criteria andFootprintEqualTo(Integer value) {
            addCriterion("footprint =", value, "footprint");
            return (Criteria) this;
        }

        public Criteria andFootprintNotEqualTo(Integer value) {
            addCriterion("footprint <>", value, "footprint");
            return (Criteria) this;
        }

        public Criteria andFootprintGreaterThan(Integer value) {
            addCriterion("footprint >", value, "footprint");
            return (Criteria) this;
        }

        public Criteria andFootprintGreaterThanOrEqualTo(Integer value) {
            addCriterion("footprint >=", value, "footprint");
            return (Criteria) this;
        }

        public Criteria andFootprintLessThan(Integer value) {
            addCriterion("footprint <", value, "footprint");
            return (Criteria) this;
        }

        public Criteria andFootprintLessThanOrEqualTo(Integer value) {
            addCriterion("footprint <=", value, "footprint");
            return (Criteria) this;
        }

        public Criteria andFootprintIn(List<Integer> values) {
            addCriterion("footprint in", values, "footprint");
            return (Criteria) this;
        }

        public Criteria andFootprintNotIn(List<Integer> values) {
            addCriterion("footprint not in", values, "footprint");
            return (Criteria) this;
        }

        public Criteria andFootprintBetween(Integer value1, Integer value2) {
            addCriterion("footprint between", value1, value2, "footprint");
            return (Criteria) this;
        }

        public Criteria andFootprintNotBetween(Integer value1, Integer value2) {
            addCriterion("footprint not between", value1, value2, "footprint");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNull() {
            addCriterion("quantity is null");
            return (Criteria) this;
        }

        public Criteria andQuantityIsNotNull() {
            addCriterion("quantity is not null");
            return (Criteria) this;
        }

        public Criteria andQuantityEqualTo(Integer value) {
            addCriterion("quantity =", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotEqualTo(Integer value) {
            addCriterion("quantity <>", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThan(Integer value) {
            addCriterion("quantity >", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("quantity >=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThan(Integer value) {
            addCriterion("quantity <", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("quantity <=", value, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityIn(List<Integer> values) {
            addCriterion("quantity in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotIn(List<Integer> values) {
            addCriterion("quantity not in", values, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityBetween(Integer value1, Integer value2) {
            addCriterion("quantity between", value1, value2, "quantity");
            return (Criteria) this;
        }

        public Criteria andQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("quantity not between", value1, value2, "quantity");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}