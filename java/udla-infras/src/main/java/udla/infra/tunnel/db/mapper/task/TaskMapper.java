package udla.infra.tunnel.db.mapper.task;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;
import udla.infra.tunnel.db.task.TaskDO;

@Component
public interface TaskMapper extends BaseMapper<TaskDO> {}
