package cn.sosopd.task.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SosopdTaskExample {
    /**
     * sosopd_task
     */
    protected String orderByClause;

    /**
     * sosopd_task
     */
    protected boolean distinct;

    /**
     * sosopd_task
     */
    protected List<Criteria> oredCriteria;

    /**
     * sosopd_task
     */
    protected Integer limitStart = 0;

    /**
     * sosopd_task
     */
    protected Integer limitEnd = 20;

    public SosopdTaskExample() {
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

    public void setLimitStart(Integer limitStart) {
        this.limitStart = limitStart;
    }

    public Integer getLimitStart() {
        return limitStart;
    }

    public void setLimitEnd(Integer limitEnd) {
        this.limitEnd = limitEnd;
    }

    public Integer getLimitEnd() {
        return limitEnd;
    }

    /**
     * sosopd_task 2018-07-05
     */
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNull() {
            addCriterion("task_type is null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIsNotNull() {
            addCriterion("task_type is not null");
            return (Criteria) this;
        }

        public Criteria andTaskTypeEqualTo(String value) {
            addCriterion("task_type =", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotEqualTo(String value) {
            addCriterion("task_type <>", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThan(String value) {
            addCriterion("task_type >", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeGreaterThanOrEqualTo(String value) {
            addCriterion("task_type >=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThan(String value) {
            addCriterion("task_type <", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLessThanOrEqualTo(String value) {
            addCriterion("task_type <=", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeLike(String value) {
            addCriterion("task_type like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotLike(String value) {
            addCriterion("task_type not like", value, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeIn(List<String> values) {
            addCriterion("task_type in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotIn(List<String> values) {
            addCriterion("task_type not in", values, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeBetween(String value1, String value2) {
            addCriterion("task_type between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskTypeNotBetween(String value1, String value2) {
            addCriterion("task_type not between", value1, value2, "taskType");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeIsNull() {
            addCriterion("task_exec_datetime is null");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeIsNotNull() {
            addCriterion("task_exec_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeEqualTo(Date value) {
            addCriterion("task_exec_datetime =", value, "taskExecDatetime");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeNotEqualTo(Date value) {
            addCriterion("task_exec_datetime <>", value, "taskExecDatetime");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeGreaterThan(Date value) {
            addCriterion("task_exec_datetime >", value, "taskExecDatetime");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("task_exec_datetime >=", value, "taskExecDatetime");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeLessThan(Date value) {
            addCriterion("task_exec_datetime <", value, "taskExecDatetime");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("task_exec_datetime <=", value, "taskExecDatetime");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeIn(List<Date> values) {
            addCriterion("task_exec_datetime in", values, "taskExecDatetime");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeNotIn(List<Date> values) {
            addCriterion("task_exec_datetime not in", values, "taskExecDatetime");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeBetween(Date value1, Date value2) {
            addCriterion("task_exec_datetime between", value1, value2, "taskExecDatetime");
            return (Criteria) this;
        }

        public Criteria andTaskExecDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("task_exec_datetime not between", value1, value2, "taskExecDatetime");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNull() {
            addCriterion("task_status is null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIsNotNull() {
            addCriterion("task_status is not null");
            return (Criteria) this;
        }

        public Criteria andTaskStatusEqualTo(String value) {
            addCriterion("task_status =", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotEqualTo(String value) {
            addCriterion("task_status <>", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThan(String value) {
            addCriterion("task_status >", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusGreaterThanOrEqualTo(String value) {
            addCriterion("task_status >=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThan(String value) {
            addCriterion("task_status <", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLessThanOrEqualTo(String value) {
            addCriterion("task_status <=", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusLike(String value) {
            addCriterion("task_status like", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotLike(String value) {
            addCriterion("task_status not like", value, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusIn(List<String> values) {
            addCriterion("task_status in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotIn(List<String> values) {
            addCriterion("task_status not in", values, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusBetween(String value1, String value2) {
            addCriterion("task_status between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskStatusNotBetween(String value1, String value2) {
            addCriterion("task_status not between", value1, value2, "taskStatus");
            return (Criteria) this;
        }

        public Criteria andTaskResultIsNull() {
            addCriterion("task_result is null");
            return (Criteria) this;
        }

        public Criteria andTaskResultIsNotNull() {
            addCriterion("task_result is not null");
            return (Criteria) this;
        }

        public Criteria andTaskResultEqualTo(String value) {
            addCriterion("task_result =", value, "taskResult");
            return (Criteria) this;
        }

        public Criteria andTaskResultNotEqualTo(String value) {
            addCriterion("task_result <>", value, "taskResult");
            return (Criteria) this;
        }

        public Criteria andTaskResultGreaterThan(String value) {
            addCriterion("task_result >", value, "taskResult");
            return (Criteria) this;
        }

        public Criteria andTaskResultGreaterThanOrEqualTo(String value) {
            addCriterion("task_result >=", value, "taskResult");
            return (Criteria) this;
        }

        public Criteria andTaskResultLessThan(String value) {
            addCriterion("task_result <", value, "taskResult");
            return (Criteria) this;
        }

        public Criteria andTaskResultLessThanOrEqualTo(String value) {
            addCriterion("task_result <=", value, "taskResult");
            return (Criteria) this;
        }

        public Criteria andTaskResultLike(String value) {
            addCriterion("task_result like", value, "taskResult");
            return (Criteria) this;
        }

        public Criteria andTaskResultNotLike(String value) {
            addCriterion("task_result not like", value, "taskResult");
            return (Criteria) this;
        }

        public Criteria andTaskResultIn(List<String> values) {
            addCriterion("task_result in", values, "taskResult");
            return (Criteria) this;
        }

        public Criteria andTaskResultNotIn(List<String> values) {
            addCriterion("task_result not in", values, "taskResult");
            return (Criteria) this;
        }

        public Criteria andTaskResultBetween(String value1, String value2) {
            addCriterion("task_result between", value1, value2, "taskResult");
            return (Criteria) this;
        }

        public Criteria andTaskResultNotBetween(String value1, String value2) {
            addCriterion("task_result not between", value1, value2, "taskResult");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNull() {
            addCriterion("create_datetime is null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIsNotNull() {
            addCriterion("create_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeEqualTo(Date value) {
            addCriterion("create_datetime =", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotEqualTo(Date value) {
            addCriterion("create_datetime <>", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThan(Date value) {
            addCriterion("create_datetime >", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_datetime >=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThan(Date value) {
            addCriterion("create_datetime <", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("create_datetime <=", value, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeIn(List<Date> values) {
            addCriterion("create_datetime in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotIn(List<Date> values) {
            addCriterion("create_datetime not in", values, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeBetween(Date value1, Date value2) {
            addCriterion("create_datetime between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andCreateDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("create_datetime not between", value1, value2, "createDatetime");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeIsNull() {
            addCriterion("last_sync_datetime is null");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeIsNotNull() {
            addCriterion("last_sync_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeEqualTo(Date value) {
            addCriterion("last_sync_datetime =", value, "lastSyncDatetime");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeNotEqualTo(Date value) {
            addCriterion("last_sync_datetime <>", value, "lastSyncDatetime");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeGreaterThan(Date value) {
            addCriterion("last_sync_datetime >", value, "lastSyncDatetime");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("last_sync_datetime >=", value, "lastSyncDatetime");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeLessThan(Date value) {
            addCriterion("last_sync_datetime <", value, "lastSyncDatetime");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeLessThanOrEqualTo(Date value) {
            addCriterion("last_sync_datetime <=", value, "lastSyncDatetime");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeIn(List<Date> values) {
            addCriterion("last_sync_datetime in", values, "lastSyncDatetime");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeNotIn(List<Date> values) {
            addCriterion("last_sync_datetime not in", values, "lastSyncDatetime");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeBetween(Date value1, Date value2) {
            addCriterion("last_sync_datetime between", value1, value2, "lastSyncDatetime");
            return (Criteria) this;
        }

        public Criteria andLastSyncDatetimeNotBetween(Date value1, Date value2) {
            addCriterion("last_sync_datetime not between", value1, value2, "lastSyncDatetime");
            return (Criteria) this;
        }
    }

    /**
     * sosopd_task
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * sosopd_task 2018-07-05
     */
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