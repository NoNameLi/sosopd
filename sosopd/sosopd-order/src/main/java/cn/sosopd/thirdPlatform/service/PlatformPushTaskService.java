package cn.sosopd.thirdPlatform.service;

import cn.sosopd.thirdPlatform.dto.SyncTaskDataDto;
import cn.sosopd.thirdPlatform.dto.SyncTaskResultDto;

/**
 * 平台任务推送数据服务
 * 
 * @author remote
 *
 */
public interface PlatformPushTaskService {

    // 自动完工同步
    SyncTaskResultDto autoFinishSync(String accoutn, String password, SyncTaskDataDto dto);
}
