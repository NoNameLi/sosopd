package cn.sosopd.task.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.common.validator.BeanValidator;
import cn.sosopd.common.validator.ParamValidator;
import cn.sosopd.task.dao.TaskDao;
import cn.sosopd.task.dto.TaskCreateDto;
import cn.sosopd.task.dto.TaskDto;
import cn.sosopd.task.entity.SosopdTaskExample;
import cn.sosopd.task.service.TaskService;
import cn.sosopd.task.type.TaskStatusEnum;
import cn.sosopd.task.type.TaskUpdateValidatorGroup;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public Integer saveOrInitTask(TaskCreateDto taskDto) throws ServiceException {

        ParamValidator.assertNotNull(taskDto, "更新数据不能为空");
        BeanValidator.validate(taskDto);

        return taskDao.saveOrInitTask(taskDto);
    }

    @Override
    public Integer upateTask(TaskDto taskDto) throws ServiceException {

        ParamValidator.assertNotNull(taskDto, "更新数据不能为空");
        BeanValidator.validate(taskDto, TaskUpdateValidatorGroup.class);
        return taskDao.upateTask(taskDto);
    }

    @Override
    public List<TaskDto> listTaskByStatus(TaskStatusEnum taskStatus) {
        SosopdTaskExample example = new SosopdTaskExample();
        example.createCriteria().andTaskStatusEqualTo(taskStatus.name());

         return taskDao.listTask(example);
    }

}
