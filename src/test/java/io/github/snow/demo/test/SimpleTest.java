package io.github.snow.demo.test;

import io.github.snow.demo.User;
import io.github.snow.demo.UserService;
import jakarta.annotation.Resource;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
public class SimpleTest implements WithAssertions {

    @Resource
    private UserService userService;

    @Test
    public void saveBatchWithId() throws Exception {
        List<User> list = new ArrayList<>();
        LocalDateTime now = LocalDateTime.now();
        int count = 10;
        for (int i = 0; i < count; i++) {
            // 对主键自增的表 手动设置id
            User user = new User().setId(1000L + i)
                    .setUsername("zs" + i)
                    .setAge(i + 10)
                    .setCreateTime(now);
            list.add(user);
        }
        // 批量插入10条数据
        userService.saveBatch(list);

        // 再根据id查询出数据
        List<Long> idList = list.stream().map(User::getId).collect(Collectors.toList());
        List<User> userList = userService.listByIds(idList);
        // 数据量应该相等
        assertThat(idList.size()).isEqualTo(count);
        assertThat(userList.size()).isEqualTo(idList.size());
    }
}
