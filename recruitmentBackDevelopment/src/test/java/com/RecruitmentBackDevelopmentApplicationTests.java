package com;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.recruitment.dao.*;
import com.recruitment.domain.PostPublicated;
import com.recruitment.domain.Referrer;
import com.recruitment.service.impl.*;
import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.javassist.ClassPath;
//import org.apache.rocketmq.client.exception.MQBrokerException;
//import org.apache.rocketmq.client.exception.MQClientException;
//import org.apache.rocketmq.client.producer.DefaultMQProducer;
//import org.apache.rocketmq.client.producer.SendResult;
//import org.apache.rocketmq.common.message.Message;
//import org.apache.rocketmq.remoting.exception.RemotingException;
import org.apache.commons.lang3.StringEscapeUtils;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.Array;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


@SpringBootTest
@MapperScan("com.recruitment")
@Slf4j
class RecruitmentBackDevelopmentApplicationTests {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ResumeDao resumeDao;
    @Autowired
    private ResumeServiceImpl resumeService;
    @Autowired
    private CorporationDao corporationDao;
    @Autowired
    private CorporationServiceImpl corporationService;
    @Autowired
    private PostPublicatedDao postPublicatedDao;
    @Autowired
    private PostPublicatedServiceImpl postPublicatedService;
    @Autowired
    private UserFavoritePostServiceImpl userFavoritePostService;
    @Autowired
    private HrResumeUserServiceImpl hrResumeUserService;
    @Autowired
    private UserEvaluateCorporationServiceImpl userEvaluateCorporationService;
    @Autowired
    private UserEvaluateCorporationDao userEvaluateCorporationDao;
    @Autowired
    private OssService ossService;
    @Autowired
    private EvaluateLikeDislikeDao evaluateLikeDislikeDao;
    @Autowired
    private EvaluateLikeDislikeServiceImpl evaluateLikeDislikeService;
    @Autowired
    private ReferrerDao referrerDao;
    @Autowired
    private ReferrerServiceImpl referrerService;


    @Test
    void testLogicDeleted() {

//        System.out.println(postPublicatedDao.deleteById("245234545325") > 0);

    }

    @Test
    void testSelfDefinitionSelectFunction() {
//        System.out.println(postPublicatedDao.selectByCityOrderedByAddtimeDescendByMonthSalaryDescend("北京"));
//        System.out.println(postPublicatedService.getPostById("1596285238983"));
//        System.out.println(postPublicatedService.fuzzySelectByPostName("发垂直"));
//        List<PostPublicated> list = postPublicatedService.fuzzySelectByPostName("实习");
//        System.out.println(list);
//        List<PostPublicated> list =  postPublicatedDao.selectByCityAndMonthSalary("西安",concat( ,2___,\'));

//城市 月薪联合搜索
//        List<PostPublicated> list = postPublicatedService.selectByCityAndMonthSalary(null, "2000");
////        期望薪资
////        List<PostPublicated> list = postPublicatedService.selectByExpectedSalary("2000");
//        System.out.println(list);
    }

    @Test
    void testStringReplace() {
//        String str = "asdf123456";
//        byte[] a = str.getBytes(StandardCharsets.UTF_8);
//        for (int i = 1; i < a.length; i++) {
//            a[i] = '_';
//
//        }
//        String s = new String(a);
//        System.out.println(s);

    }

    @Test
    void testUSer() {
//        System.out.println(userService.getAllUserInfo());
    }

    @Test
    void testCorporation() {
//        List list = corporationService.getCorporationById("1528705221977477122");
//        System.out.println(list);
    }

    @Test
    void favoritePost() {
//    System.out.println(userFavoritePostService.isUserFavoritePost("3", "1596372486661"));
//        System.out.println(userFavoritePostService.selectUserFavoritePost("1"));
    }

    @Test
    void testCount() {
//        LambdaQueryWrapper<PostPublicated> lqw = new LambdaQueryWrapper<>();
//        lqw.orderByDesc(PostPublicated::getAddtime, PostPublicated::getMonthSalary);
//        Integer list = postPublicatedDao.selectCount(lqw);
//        System.out.println(list);
    }

    @Test
    void testHrResumeUser() {


//    System.out.println(hrResumeUserService.getResumeStatusByPostIduseless("1596372486663", "erw").get(0));
//    org.apache.commons.lang3.StringUtils.join(temp.toArray(),separator).System.out.println();;
    }

    @Test
    void ossUpload() throws Exception {

//        String result = ossUploadService.upLoadFile(new File("D:\\EG_download\\79894B73175DCA4DB17F61BDE1519AD5.txt"));
//    System.out.println(result);

    }
    @Test
    void testEvaluateLike(){
//        System.out.println(userEvaluateCorporationService.getAverageScore("西安乐驰环保科技有限公司"));
//        System.out.println(evaluateLikeDislikeService.isExist("4", "5"));
    }
@Test
    void  testPostPublicated(){
//    List list = postPublicatedService.selectAllAddressDecode();
//    System.out.println(list);
//    PostPublicated postPublicated = new PostPublicated();
//    postPublicated.setPostWelfare({
//            "name":"liubei",
//            "age":12,
//            "des":"1"
//});
//    System.out.println(StringEscapeUtils.unescapeJava("[\"五险一金\", \"年终奖金\", \"绩效奖金\"]"));
//    List list = postPublicatedService.selectBatchPostByAddressDecode("108.833100,34.208600");
//    System.out.println(list);
}
@Test
    void  testReferrer(){
//    System.out.println(resumeService.getAResumeByWorkExperience(10));
//    Integer referrerCeshi = referrerService.selectReferrerTotalCash("referrerCeshi");
//    System.out.println(referrerCeshi);
//    LambdaQueryWrapper<Referrer> lqw = new LambdaQueryWrapper<>();
//    lqw.select(Referrer::getRecommendedMemberId).eq(Referrer::getId,"referrerCeshi");
//    List<Object> recommendedId = referrerDao.selectObjs(lqw);
//    System.out.println(recommendedId);
//
}
//    @Test
//    void testRocketmqProducer() throws MQBrokerException, RemotingException, InterruptedException, MQClientException {
//
//    }
}
//@Test
//    void testEvaluate(){
//    LambdaQueryWrapper<UserEvaluateCorporation> lqw1 = new LambdaQueryWrapper<>();
//    //根据公司id 查询所有用户评分 计算分数总和
//
//    lqw1.select(UserEvaluateCorporation::getUserScore).eq(UserEvaluateCorporation::getCorporationId,"oGB1h5A52MvCZaPKBZfz1wxLJ190");
//
//    System.out.println(userEvaluateCorporationDao.selectCount(lqw1));
//    LambdaQueryWrapper<UserEvaluateCorporation> lqw1 = new LambdaQueryWrapper<>();
//    //根据公司id 查询所有用户评分 计算分数总和
//
//    lqw1.select(UserEvaluateCorporation::getUserScore).eq(UserEvaluateCorporation::getCorporationId,"oGB1h5A52MvCZaPKBZfz08xLJ194");
//
//    int personNumber =  userEvaluateCorporationDao.selectCount(lqw1);
//
//
//    List list = userEvaluateCorporationDao.selectObjs(lqw1);
//    int sum = 0;
//    for (int i = 0; i < list.size(); i++) {
//        list.get(i);
//    }
//    System.out.println(userEvaluateCorporationService.getAverageScore("oGB1h5A52MvCZaPKBZfz1wxLJ190"));

//}
//    @Test
//    void testCreateNewUser() {
//        User user = new User();
//        user.setGender("男");
//        user.setNickName("唐老鸭");
//        user.setHeadPortrait("nizhiado.com");
//        user.setPhone("17626532993");
////        userService.createNewUser(user);
//        System.out.printf("" + userService.createNewUser(user));
//
//
//    }
//
//    @Test
//    void testModifyUserInfoById() {
//        long id = 1596285238983L;
//        User user1 = new User();
//        user1.setNickName("wanglwi");
//        user1.setId(""+id);
//        System.out.println(userService.modifyUserInfoById(user1));
////        int i = userDao.updateById(user1);
////        System.out.println(i);
//    }
//
//    @Test
//    void testGetBypage() {
//        IPage page = new Page(2, 3);
//        userDao.selectPage(page, null);
//        System.out.println("当前页码值：" + page.getCurrent());
//        System.out.println("一共多少页：" + page.getPages());
//        System.out.println("每页显示数：" + page.getSize());
//        System.out.println("一共多少条数据：" + page.getRecords());
//        System.out.println("数据：" + page.getTotal());
//    }
//
//    @Test
//    void testSelect() {
////        userDao.se\\\\\\   }
//        long id = 1596285238983L;
//        System.out.println(resumeDao.selectById(id));
//
//    }
//    @Test
//    void testSelectByCorporationName(){
//        Corporation corporation = new Corporation();
//        corporation = corporationDao.selectByName("北京小米科技有限责任公司");
//        System.out.println(corporation);
//
//    }
//    @Test
////    void testModifyResumeByUserId(){
//////        QueryWrapper queryWrapper = new QueryWrapper();
////        Resume resume = new Resume();
//
////        resume.setId(1596372486576L);
////        resume.setRealname("王公主");
////        resume.setId();
////        resume.setRealname("王磊");
////        resumeService.modifyResumeByUserId(resume);
////        resumeDao.updateById(resume);
//resumeService.modifyResumeByUserId(resume);
//    }
//}
