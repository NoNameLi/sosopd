package cn.sosopd.test;

import java.util.ArrayList;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.sosopd.common.exception.ServiceException;
import cn.sosopd.task.dao.TaskDao;
import cn.sosopd.task.dto.TaskCreateDto;
import cn.sosopd.task.service.TaskService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/spring/applicationContext-all.xml" })
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;
    
    @Autowired
    private TaskDao taskDao;

    @Test
    public void insertBatchTaskTest() {

        List<TaskCreateDto> taskList = new ArrayList<>();
        taskList.add(TaskCreateDto.builder().orderId(1).taskExecDatetime(DateTime.now().toDate()).build());
        taskList.add(TaskCreateDto.builder().orderId(2).taskExecDatetime(DateTime.now().toDate()).build());
        taskList.add(TaskCreateDto.builder().orderId(3).taskExecDatetime(DateTime.now().toDate()).build());
        try {
            System.out.println(taskDao.saveOrInitTask(taskList));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertTask() {

        TaskCreateDto taskDto = TaskCreateDto.builder().orderId(1).taskExecDatetime(DateTime.now().toDate()).build();
        try {
            System.out.println(taskService.saveOrInitTask(taskDto));
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

}
