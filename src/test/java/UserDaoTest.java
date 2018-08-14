import com.framework.ssm.dao.IStaffDao;
import com.framework.ssm.model.StaffDO;
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
    private IStaffDao staffDao;
    @Test
    public void testGetUser(){
        StaffDO staffDO = staffDao.selectByPrimaryKey(1);
        System.out.println(staffDO.getStaffId()+"---"+staffDO.getStaffName());
    }
}
