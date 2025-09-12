package top.sy.boot.config.test;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.sy.model.Team;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Slf4j
@SpringBootTest
public class TeamTest {
    @Resource
    private Team team;
    @Test
    void testTeam() {
        assertEquals("Web2班", team.getName());
        assertEquals("mqxu", team.getLeader());
    }
}
