import com.framework.ssm.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2019/03/15
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class TestJedisClient {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    private static final Logger log  = LoggerFactory.getLogger(TestJedisClient.class);

    @Test
    public void test(){

//        RedisUtil redisUtil= RedisUtil.getInstance();

        redisUtil.leftPush("aaa","acde");

        log.info(redisUtil.listSize("aaa").toString());

        redisTemplate.opsForValue().set("name", "tailless");
        log.info(redisUtil.get("name"));
//        log.info("value："+redisTemplate.opsForValue().get("name"));
    }
}