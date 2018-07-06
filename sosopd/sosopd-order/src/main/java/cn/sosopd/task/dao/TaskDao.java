package cn.sosopd.task.dao;

import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.util.ObjectConverter;
import cn.sosopd.common.validator.BeanValidator;
import cn.sosopd.task.dto.TaskCreateDto;
import cn.sosopd.task.dto.TaskDto;
import cn.sosopd.task.entity.SosopdTask;
import cn.sosopd.task.entity.SosopdTaskExample;
import cn.sosopd.task.mapper.SosopdTaskMapper;
import cn.sosopd.task.type.TaskStatusEnum;
import cn.sosopd.task.type.TaskUpdateValidatorGroup;

@Component
public class TaskDao {

    @Autowired
    private SosopdTaskMapper mapper;

    public Integer saveOrInitTask(TaskCreateDto taskDto) throws ServiceException {
        SosopdTask record = ObjectConverter.convert(taskDto, SosopdTask.class);
        // 补全其他必要数据
        record.setCreateDatetime(DateTime.now().toDate()).setTaskStatus(TaskStatusEnum.executing.name());
        return mapper.insertUpdate(record);
    }

    public List<Integer> saveOrInitTask(List<TaskCreateDto> taskDtos) throws ServiceException {
        if (null == taskDtos || taskDtos.isEmpty()) {
            return null;
        }
        List<SosopdTask> record = ObjectConverter.convert(taskDtos, SosopdTask.class);
        Date now = DateTime.now().toDate();
        for (SosopdTask task : record) {
            task.setCreateDatetime(now).setTaskStatus(TaskStatusEnum.executing.name());
        }
        return mapper.insertUpdate(record);
    }

    public Integer upateTask(TaskDto taskDto) throws ServiceException {
        BeanValidator.validate(taskDto, TaskUpdateValidatorGroup.class);
        SosopdTask record = ObjectConverter.convert(taskDto, SosopdTask.class);
        return mapper.updateByPrimaryKeySelective(record);
    }

    public List<TaskDto> listTask(SosopdTaskExample example) {
        List<SosopdTask> list = mapper.selectByExample(example);
        return ObjectConverter.convert(list, TaskDto.class);
    }

}
