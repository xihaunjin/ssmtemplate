import com.framework.ssm.dao.IUserDao;
import com.framework.ssm.model.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 请填写类注释
 *
 * @author tailless
 * @since 2018/07/12
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:applicationContext.xml"})
public class UserDaoTest {
    @Autowired
    private IUserDao userDao;
    @Test
    public void testGetUser(){
        UserDO userDO = userDao.selectByPrimaryKey(1);
        System.out.println(userDO.getName()+"---"+userDO.getAge());
    }
}
