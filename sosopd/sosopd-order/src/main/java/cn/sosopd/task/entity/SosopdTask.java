package cn.sosopd.task.entity;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class SosopdTask {
    /**
     * 任务的工单
     */
    private Integer orderId;

    /**
     * 任务类型（在任务模板中定义）
     */
    private String taskType;

    /**
     * 任务执行时间线
     */
    private Date taskExecDatetime;

    /**
     * 任务的状态
     */
    private String taskStatus;

    /**
     * 执行结果备注
     */
    private String taskResult;

    /**
     * 
     */
    private Date createDatetime;

    /**
     * 
     */
    private Date lastSyncDatetime;
}