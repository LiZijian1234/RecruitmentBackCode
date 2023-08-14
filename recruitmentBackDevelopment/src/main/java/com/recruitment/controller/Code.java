package com.recruitment.controller;

//状态码
public class Code {
    /**
     * user 状态码
     */
    public static final Integer createNewUser_ok = 20011;
    public static final String createNewUser_ok_msg = "添加用户成功！";
    public static final Integer createNewUser_err = 20010;
    public static final String createNewUser_err_msg = "您已注册,添加用户失败！";

    public static final Integer modifyUserInfoById_ok = 20021;
    public static final String modifyUserInfoById_ok_msg = "修改用户成功！";
    public static final Integer modifyUserInfoById_err = 20020;
    public static final String modifyUserInfoById_err_msg = "修改用户失败！";

    public static final Integer getUserInfoById_ok = 20031;
    public static final String getUserInfoById_ok_msg = "查询单个用户成功！";
    public static final Integer getUserInfoById_err = 20030;
    public static final String getUserInfoById_err_msg = "查询单个用户失败，没有该用户！";

    public static final Integer getAllUserInfo_ok = 20041;
    public static final String getAllUserInfo_ok_msg = "查询所有用户信息成功！";
    public static final Integer getAllUserInfo_err = 20040;
    public static final String getAllUserInfo_err_msg = "查询所有用户信息失败！";

    public static final Integer deleteUserInfoById_ok = 20051;
    public static final String deleteUserInfoById_ok_msg = "删除用户信息 成功！";
    public static final Integer deleteUserInfoById_err = 20050;
    public static final String deleteUserInfoById_err_msg = "删除用户信息 失败！";
    /**
     * resume 状态码
     */
    public static final Integer creatResumeByUserId_ok = 20111;
    public static final String creatResumeByUserId_ok_msg = "创建简历成功！";
    public static final Integer creatResumeByUserId_err = 20110;
    public static final String creatResumeByUserId_err_msg = "创建简历失败,您已有简历！";


    public static final Integer modifyResumeByUserId_ok = 20121;
    public static final String modifyResumeByUserId_ok_msg = "修改简历成功！";
    public static final Integer modifyResumeByUserId_err = 20120;
    public static final String modifyResumeByUserId_err_msg = "修改简历失败！";


    public static final Integer getResumeByUserId_ok = 20131;
    public static final String getResumeByUserId_ok_msg = "查询单个简历成功！";
    public static final Integer getResumeByUserId_err = 20130;
    public static final String getResumeByUserId_err_msg = "查询单个简历失败！";


    public static final Integer getAllResume_ok = 20141;
    public static final String getAllResume_ok_msg = "查询所有简历成功！";
    public static final Integer getAllResume_err = 20140;
    public static final String getAllResume_err_msg = "查询所有简历失败！";

    public static final Integer getAResumeByEducation_ok = 20151;
    public static final String getAResumeByEducation_ok_msg = "按照学历筛选简历 成功！";
    public static final Integer getAResumeByEducation_err = 20150;
    public static final String getAResumeByEducation_err_msg = "按照学历筛选简历 失败！";

    public static final Integer getResumeByAge_ok = 20161;
    public static final String getResumeByAge_ok_msg = "按照年龄筛选简历 成功！";
    public static final Integer getResumeByAge_err = 20160;
    public static final String getResumeByAge_err_msg = "按照年龄筛选简历 失败！";

    public static final Integer deleteResumeByUserId_ok = 20171;
    public static final String deleteResumeByUserId_ok_msg = "根据用户ID 删除简历 成功！";
    public static final Integer deleteResumeByUserId_err = 20170;
    public static final String deleteResumeByUserId_err_msg = "根据用户ID 删除简历 失败 该简历不存在！";

    public static final Integer getResumeByWorkExperience_ok = 20181;
    public static final String getResumeByWorkExperience_ok_msg = "按照工作经验筛选简历 成功！";
    public static final Integer getResumeByWorkExperience_err = 20180;
    public static final String getResumeByWorkExperience_err_msg = "根按照工作经验筛选简历 失败！";
    /**
     * post_publicated 状态码
     */


    public static final Integer creatPostById_ok = 202011;
    public static final String creatPostById_ok_msg = "创建岗位信息成功！";
    public static final Integer creatPostById_err = 202010;
    public static final String creatPostById_err_msg = "创建岗位信息失败！";


    public static final Integer modifyPostById_ok = 202021;
    public static final String modifyPostById_ok_msg = "修改岗位信息成功！";
    public static final Integer modifyPostById_err = 202020;
    public static final String modifyPostById_err_msg = "修改岗位信息失败！";

    public static final Integer getPostById_ok = 202031;
    public static final String getPostById_ok_msg = "根据ID批量查询岗位信息成功！";
    public static final Integer getPostById_err = 202030;
    public static final String getPostById_err_msg = "根据ID批量查询岗位信息失败！";

    public static final Integer getAllPostInfo_ok = 202041;
    public static final String getAllPostInfo_ok_msg = "查询所有岗位信息成功！";
    public static final Integer getAllPostInfo_err = 202040;
    public static final String getAllPostInfo_err_msg = "查询所有岗位信息失败！";


    public static final Integer deleteLogicByID_ok = 202051;
    public static final String deleteLogicByID_ok_msg = "逻辑删除岗位信息成功！";
    public static final Integer deleteLogicByID_err = 202050;
    public static final String deleteLogicByID_err_msg = "逻辑删除岗位信息失败！";


    public static final Integer selectByCityOrderedByMonthSalaryDescendByAddtimeAscend_ok = 202061;
    public static final String selectByCityOrderedByMonthSalaryDescendByAddtimeAscend_ok_msg = "根据城市位置查询岗位 月薪 降序 创建时间 升序排序成功！";
    public static final Integer selectByCityOrderedByMonthSalaryDescendByAddtimeAscend_err = 202060;
    public static final String selectByCityOrderedByMonthSalaryDescendByAddtimeAscend_err_msg = "根据城市位置查询岗位 月薪 降序 创建时间 升序排序失败！";


    public static final Integer selectByCityOrderedByAddtimeDescendByMonthSalaryDescend_ok = 202071;
    public static final String selectByCityOrderedByAddtimeDescendByMonthSalaryDescend_ok_msg = "根据城市位置查询岗位 按照  增加时间  降序 ；月薪 降序 排序成功！";
    public static final Integer selectByCityOrderedByAddtimeDescendByMonthSalaryDescend_err = 202070;
    public static final String selectByCityOrderedByAddtimeDescendByMonthSalaryDescend_err_msg = "根据城市位置查询岗位 按照  增加时间  降序 ；月薪 降序 排序失败！";

    public static final Integer fuzzySelectByPostName_ok = 202081;
    public static final String fuzzySelectByPostName_ok_msg = "根据岗位名称 模糊 搜索成功！";
    public static final Integer fuzzySelectByPostName_err = 202080;
    public static final String fuzzySelectByPostName_err_msg = "根据岗位名称 模糊 搜索失败！";


    public static final Integer selectByIdUseless_ok = 202091;
    public static final String selectByIdUseless_ok_msg = "根据id_useless 查询岗位成功！";
    public static final Integer selectByIdUseless_err = 202090;
    public static final String selectByIdUseless_err_msg = "根据id_useless 查询岗位失败！";

    public static final Integer deleteLogicByIDUseless_ok = 202101;
    public static final String deleteLogicByIDUseless_ok_msg = "根据iduseless单个删除 成功！";
    public static final Integer deleteLogicByIDUseless_err = 202100;
    public static final String deleteLogicByIDUseless_err_msg = "根据iduseless单个删除 失败！";

    public static final Integer selectByAddtimeDescendByMonthSalaryDescend_ok = 202111;
    public static final String selectByAddtimeDescendByMonthSalaryDescend_ok_msg = "按照增加时间降序月薪降序排序 成功！";
    public static final Integer selectByAddtimeDescendByMonthSalaryDescend_err = 202110;
    public static final String selectByAddtimeDescendByMonthSalaryDescend_err_msg = "按照增加时间降序；薪降序排序 失败！";

    public static final Integer selectByCityAndMonthSalary_ok = 202121;
    public static final String selectByCityAndMonthSalary_ok_msg = "根据城市和月薪 联合筛选 成功！";
    public static final Integer selectByCityAndMonthSalary_err = 202120;
    public static final String selectByCityAndMonthSalary_err_msg = "根据城市和月薪 联合筛选 失败！";

    public static final Integer selectByExpectedSalary_ok = 202131;
    public static final String selectByExpectedSalary_ok_msg = "根据 期望月薪资山下浮动 numer(以代码中数值为准)  查询岗位 或者 查询所有岗位 成功！";
    public static final Integer selectByExpectedSalary_err = 202130;
    public static final String selectByExpectedSalary_err_msg = "根据 期望月薪资山下浮动 numer(以代码中数值为准)  查询岗位 或者 查询所有岗位 失败！";

    public static final Integer selectAllAddressDecode_ok = 202141;
    public static final String selectAllAddressDecode_ok_msg = "查询所有岗位的地理编码 成功！";
    public static final Integer selectAllAddressDecode_err = 202140;
    public static final String selectAllAddressDecode_err_msg = "查询所有岗位的地理编码 失败！";


    public static final Integer selectBatchPostByAddressDecode_ok = 202151;
    public static final String selectBatchPostByAddressDecode_ok_msg = "根据地理编码批量查询岗位 成功！";
    public static final Integer selectBatchPostByAddressDecode_err = 202150;
    public static final String selectBatchPostByAddressDecode_err_msg = "根据地理编码批量查询岗位 失败！";


    public static final Integer selectBatchPostByDailySettlement_ok = 202161;
    public static final String selectBatchPostByDailySettlement_ok_msg = "查询日结 岗位 成功！";
    public static final Integer selectBatchPostByDailySettlement_err = 202160;
    public static final String selectBatchPostByDailySettlement_err_msg = "查询日结 岗位 失败！";
    /**
     * tbl_corporation_register_info 状态码
     */
    public static final Integer registerCorporationById_ok = 20311;
    public static final String registerCorporationById_ok_msg = "创建公司信息成功！";
    public static final Integer registerCorporationById_err = 20310;
    public static final String registerCorporationById_err_msg = "公司信息已存在，创建公司信息失败！";


    public static final Integer corporationRegisterDeleteLogicByID_ok = 20321;
    public static final String corporationRegisterDeleteLogicByID_ok_msg = "据id删除成功！";
    public static final Integer corporationRegisterDeleteLogicByID_err = 20320;
    public static final String corporationRegisterDeleteLogicByID_err_msg = "据id删除失败！";

    public static final Integer getCorporationRegisterInfoById_ok = 20331;
    public static final String getCorporationRegisterInfoById_ok_msg = "根据Id（批量）查询公司注册信息成功！";
    public static final Integer getCorporationRegisterInfoById_err = 20330;
    public static final String getCorporationRegisterInfoById_err_msg = "根据Id（批量）查询公司注册信息失败！";

    public static final Integer getAllCorporationRegisterInfo_ok = 20341;
    public static final String getAllCorporationRegisterInfo_ok_msg = "查询所有公司注册信息成功！";
    public static final Integer getAllCorporationRegisterInfo_err = 20340;
    public static final String getAllCorporationRegisterInfo_err_msg = "查询所有公司注册信息失败！";

    /**
     * tbl_corporation 状态码
     */
    public static final Integer creatCorporationById_ok = 20411;
    public static final String creatCorporationById_ok_msg = "根据id 增加 公司信息成功！";
    public static final Integer creatCorporationById_err = 20410;
    public static final String creatCorporationById_err_msg = "根据id 增加 公司信息失败！";


    public static final Integer modifyCorporationById_ok = 20421;
    public static final String modifyCorporationById_ok_msg = "根据ID 修改 公司信息成功！";
    public static final Integer modifyCorporationById_err = 20420;
    public static final String modifyCorporationById_err_msg = "根据ID 修改 公司信息失败！";

    public static final Integer getCorporationById_ok = 20431;
    public static final String getCorporationById_ok_msg = "根据ID 查询 公司信息成功！";
    public static final Integer getCorporationById_err = 20430;
    public static final String getCorporationById_err_msg = "根据ID 查询 公司信息失败！";

    public static final Integer getCorporationByName_ok = 20441;
    public static final String getCorporationByName_ok_msg = "根据名字 查询 公司信息成功！";
    public static final Integer getCorporationByName_err = 20440;
    public static final String getCorporationByName_err_msg = "根据名字 查询 公司信息失败！";


    public static final Integer getAllCorporationInfo_ok = 20451;
    public static final String getAllCorporationInfo_ok_msg = "查询所有 公司信息成功！";
    public static final Integer getAllCorporationInfo_err = 20450;
    public static final String getAllCorporationInfo_err_msg = "查询所有 公司信息失败！";

    public static final Integer getCorporationByFuzzyInput_ok = 20461;
    public static final String getCorporationByFuzzyInput_ok_msg = "根据输入模糊搜索 公司名称成功！";
    public static final Integer getCorporationByFuzzyInput_err = 20460;
    public static final String getCorporationByFuzzyInput_err_msg = "根据输入模糊搜索 公司名称 失败 没有该公司！";


    public static final Integer getAllCorporationAddressDecode_ok = 20471;
    public static final String getAllCorporationAddressDecode_ok_msg = "查询所有公司的地理位置编码 成功！";
    public static final Integer getAllCorporationAddressDecode_err = 20470;
    public static final String getAllCorporationAddressDecode_err_msg = "查询所有公司的地理位置编码 失败 ！";


    public static final Integer getCorporationByAddressDecode_ok = 20481;
    public static final String getCorporationByAddressDecode_ok_msg = "根据地理位置编码查询公司 成功！";
    public static final Integer getCorporationByAddressDecode_err = 20480;
    public static final String getCorporationByAddressDecode_err_msg = "根据地理位置编码查询公司 失败！";


    public static final Integer getCorporationByCorporationIndustry_ok = 20491;
    public static final String getCorporationByCorporationIndustry_ok_msg = "按照行业返回公司信息 成功！";
    public static final Integer getCorporationByCorporationIndustry_err = 20490;
    public static final String getCorporationByCorporationIndustry_err_msg = "按照行业返回公司信息 失败！";

    public static final Integer deleteCorporationById_ok = 20491;
    public static final String deleteCorporationById_ok_msg = "根据ID 删除 公司信息 成功！";
    public static final Integer deleteCorporationById_err = 20490;
    public static final String deleteCorporationById_err_msg = "根据ID 删除 公司信息 失败！";
    /**
     * tbl_user_favorite_post 状态码
     */
    public static final Integer hasUserFavoritePost_ok = 20511;
    public static final String hasUserFavoritePost_ok_msg = "该用户已经收藏该岗位！";


    public static final Integer createUserFavoritePost_ok = 20521;
    public static final String createUserFavoritePost_ok_msg = "添加收藏 成功！";
    public static final Integer createUserFavoritePost_err = 20520;
    public static final String createUserFavoritePost_err_msg = "添加收藏 失败！";

    public static final Integer selectUserFavoritePost_ok = 20531;
    public static final String selectUserFavoritePost_ok_msg = "根据具 用户IDuseless 查询 收藏的职位 id成功！";
    public static final Integer selectUserFavoritePost_err = 20530;
    public static final String selectUserFavoritePost_err_msg = "没有收藏的 岗位！";


    public static final Integer deleteUserFavoritePost_ok = 20531;
    public static final String deleteUserFavoritePost_ok_msg = "根据 两个iduseless 逻辑删除成功！";
    public static final Integer deleteUserFavoritePost_err = 20530;
    public static final String deleteUserFavoritePost_err_msg = "根据 两个iduseless 逻辑删除失败！";
    /**
     * tbl_hr_resume_user 状态码
     */
    public static final Integer hasSubmitResume_ok = 206011;
    public static final String hasSubmitResume_ok_msg = "已经投递过简历！";


    public static final Integer submitResume_ok = 206021;
    public static final String submitResume_ok_msg = "投递简历成功！";
    public static final Integer submitResume_err = 206020;
    public static final String submitResume_err_msg = "投递简历失败,id不正确！";

    public static final Integer getResumeByHrId_ok = 206031;
    public static final String getResumeByHrId_ok_msg = "根据hr id 批量查询已收简历id成功！";
    public static final Integer getResumeByHrId_err = 206030;
    public static final String getResumeByHrId_err_msg = "根据hr id 批量查询已收简历id失败！";

    public static final Integer countResumeByHrId_ok = 206041;
    public static final String countResumeByHrId_ok_msg = "根据hr id 统计已收简历成功！";
    public static final Integer countResumeByHrId_err = 206040;
    public static final String countResumeByHrId_err_msg = "根据hr id 统计已收简历失败！";


    public static final Integer getUnhandleResumeByHrId_ok = 206051;
    public static final String getUnhandleResumeByHrId_ok_msg = "根据hr id 批量查询未审核的简历成功！";
    public static final Integer getUnhandleResumeByHrId_err = 206050;
    public static final String getUnhandleResumeByHrId_err_msg = "根据hr id 批量查询未审核的简历失败！";


    public static final Integer countUnhandleResumeByHrId_ok = 206061;
    public static final String countUnhandleResumeByHrId_ok_msg = "根据hr id 统计未审核的简历成功！";
    public static final Integer countUnhandleResumeByHrId_err = 206060;
    public static final String countUnhandleResumeByHrId_err_msg = "根据hr id 统计未审核的简历失败！";


    public static final Integer deleteSubmitResume_ok = 206071;
    public static final String deleteSubmitResume_ok_msg = "逻辑删除成功！";
    public static final Integer deleteSubmitResume_err = 206070;
    public static final String deleteSubmitResume_err_msg = "逻辑删除失败！";


    public static final Integer getPostByResumeId_ok = 206081;
    public static final String getPostByResumeId_ok_msg = "根据resumeid查询投的岗位iduseless成功！";
    public static final Integer getPostByResumeId_err = 206080;
    public static final String getPostByResumeId_err_msg = "根据resumeid查询投的岗位iduseless失败！";


    public static final Integer getResumeByPostIduseless_ok = 206091;
    public static final String getResumeByPostIduseless_ok_msg = "根据岗位查询投的简历id成功！";
    public static final Integer getResumeByPostIduseless_err = 206090;
    public static final String getResumeByPostIduseless_err_msg = "根据岗位查询投的简历id失败！";

    public static final Integer getResumeStatusByPostIduseless_ok = 206101;
    public static final String getResumeStatusByPostIduseless_ok_msg = "用户查询自己的简历状态码成功！";
    public static final Integer getResumeStatusByPostIduseless_err = 206100;
    public static final String getResumeStatusByPostIduseless_err_msg = "用户查询自己的简历状态码失败！";

    public static final Integer passResumeStatusByPostIduseless_ok = 206111;
    public static final String passResumeStatusByPostIduseless_ok_msg = "hr 对简历处理 审核通过成功！";
    public static final Integer passResumeStatusByPostIduseless_err = 206110;
    public static final String passResumeStatusByPostIduseless_err_msg = "hr 对简历处理 审核通过失败！";

    public static final Integer rejectResumeStatusByPostIduseless_ok = 206121;
    public static final String rejectResumeStatusByPostIduseless_ok_msg = "hr 对简历处理 审核不通过成功！";
    public static final Integer rejectResumeStatusByPostIduseless_err = 206120;
    public static final String rejectResumeStatusByPostIduseless_err_msg = "hr 对简历处理 审核不通过(简历不存在 或者 id错误)！";


    public static final Integer HavingCorporation_ok = 206131;
    public static final String HavingCorporation_ok_msg = "已经注册公司 注册失败！(简历不存在 或者 id错误)";


    /**
     * tbl_user_evaluate_corporation 状态码
     */
    public static final Integer isEvaluate_ok = 207011;
    public static final String isEvaluate__ok_msg = "已经评价过！";


    public static final Integer createEvaluate_ok = 207021;
    public static final String createEvaluate_ok_msg = "增加 评价成功！";
    public static final Integer createEvaluate_err = 207020;
    public static final String createEvaluate_err_msg = "增加 评价失败！";

    public static final Integer getAverageScore_ok = 207031;
    public static final String getAverageScore_ok_msg = "查询公司平均分数成功！";
    public static final Integer getAverageScore_err = 207030;
    public static final String getAverageScore_err_msg = "查询公司平均分数失败！";

    public static final Integer getEvaluatePerson_ok = 207041;
    public static final String getEvaluatePerson_ok_msg = "查询评价的人数成功！";
    public static final Integer getEvaluatePerson_err = 207040;
    public static final String getEvaluatePerson_err_msg = "查询评价的人数失败！";


    public static final Integer getAllEvaluate_ok = 207051;
    public static final String getAllEvaluate_ok_msg = "根据公司ID查询所有评论成功！";
    public static final Integer getAllEvaluate_err = 207050;
    public static final String getAllEvaluate_err_msg = "根据公司ID查询所有评论失败！";
    /**
     * 地理位置 编码 状态码
     */
    public static final Integer geographicalDecode_ok = 208011;
    public static final String geographicalDecode_ok_msg = "地理位置 编码成功！";
    public static final Integer geographicalDecode_err = 208010;
    public static final String geographicalDecode_err_msg = "地理位置 编码失败！";

    public static final Integer inverseGeographicalDecode_ok = 208021;
    public static final String inverseGeographicalDecode_ok_msg = "逆地理位置 编码成功！";
    public static final Integer inverseGeographicalDecode_err = 208020;
    public static final String inverseGeographicalDecode_err_msg = "逆地理位置 编码失败！";
    /**
     * OssOperation 状态码
     */
    public static final Integer isEmpty = 209011;
    public static final String isEmpty_msg = "文件为空！";

    public static final Integer upLoadImgFile_ok = 209021;
    public static final String upLoadImgFile_ok_msg = "图片 上传成功！";
    public static final Integer upLoadImgFile_err = 209020;
    public static final String upLoadImgFile_err_msg = "图片 上传失败！";
    public static final Integer upLoadFile_ok = 209021;
    public static final String upLoadFile_ok_msg = "文件 上传成功！";
    public static final Integer upLoadFile_err = 209020;
    public static final String upLoadFile_err_msg = "文件 上传失败！";

    /**
     * Rocketmq 状态码
     */
//    public static final Integer notExist = 210011;
//    public static final String notExist_msg = "没有点赞或者踩的数据 ！";
//    public static final Integer creatProducer_err = 210010;
//    public static final String creatProducer_err_msg = "同步消息生产者发送 失败！";
   /**
     * EvaluateLikeDislike 状态码
     */
    public static final Integer notExist = 211011;
    public static final String notExist_msg = "没有点赞或者踩的数据 ！";


    public static final Integer hasLike = 211021;
    public static final String hasLike_msg = "已点赞！";

    public static final Integer hasDislike = 211031;
    public static final String hasDislike_msg = "已踩 ！";

    public static final Integer abnormal = 211041;
    public static final String abnormal_msg = "数据存在 但是 没有点赞 或者 踩 属于非正常数据 ！";

     public static final Integer dislike_ok = 211051;
    public static final String dislike_ok_msg = "踩 成功！";
    public static final Integer dislike_err = 2110050;
    public static final String dislike_err_msg = "踩 失败！";

    public static final Integer like_ok = 211061;
    public static final String like_ok_msg = "喜欢 成功！";
    public static final Integer like_err = 2110060;
    public static final String like_err_msg = "喜欢 失败！";

    public static final Integer cancelDislike_ok = 211071;
    public static final String cancelDislike_ok_msg = "取消踩 成功！";
    public static final Integer cancelDislike_err = 2110070;
    public static final String cancelDislike_err_msg = "取消踩 失败！";

    public static final Integer cancelLike_ok = 211081;
    public static final String cancelLike_ok_msg = "取消点赞 成功！";
    public static final Integer cancelLike_err = 2110080;
    public static final String cancelLike_err_msg = "取消点赞 失败！";

    public static final Integer countLikePeople_ok = 211091;
    public static final String countLikePeople_ok_msg = "统计评价点赞数 成功！";

    public static final Integer countDislikePeople_ok = 211091;
    public static final String countDislikePeople_ok_msg = "统计评价踩数 成功！";
    /**
     * Referrer 状态码
     */
    public static final Integer isCreated_ok = 212001;
    public static final String isCreated_ok_msg = "已经增加！";


    public static final Integer creatRecommendedMember_ok = 212011;
    public static final String creatRecommendedMember_ok_msg = "增加推荐人 成功！";
    public static final Integer creatRecommendedMember_err = 2120010;
    public static final String creatRecommendedMember_err_msg = "增加推荐人 失败！";

    public static final Integer creatWithdrawCash_ok = 212021;
    public static final String creatWithdrawCash_ok_msg = "增加 已提现金额 成功！";
    public static final Integer creatWithdrawCash_err = 212020;
    public static final String creatWithdrawCash_err_msg = "增加 已提现金额 失败！";

    public static final Integer selectReferrerTotalCash_ok = 212031;
    public static final String selectReferrerTotalCash_ok_msg = "查询园长的总积分 成功！";
    public static final Integer selectReferrerTotalCash_err = 2120030;
    public static final String selectReferrerTotalCash_err_msg = "查询园长的总积分 失败！";

    public static final Integer selectWithdrawCash_ok = 212041;
    public static final String selectWithdrawCash_ok_msg = "查询园长 已提现金额 成功！";
    public static final Integer selectWithdrawCash_err = 212040;
    public static final String selectWithdrawCash_err_msg = "查询园长 已提现金额 失败！";

    public static final Integer selectAllReferrerInfo_ok = 212051;
    public static final String selectAllReferrerInfo_ok_msg = "查询所有园长的信息 成功！";
    public static final Integer selectAllReferrerInfo_err = 212050;
    public static final String selectAllReferrerInfo_err_msg = "查询所有园长的信息 失败！";

    public static final Integer selectRecommendedMemberInfo_ok = 212061;
    public static final String selectRecommendedMemberInfo_ok_msg = "查询所有被推荐人的简历进度 成功！";

    public static final Integer selectRecommendedMemberInfo_err = 212060;
    public static final String selectRecommendedMemberInfo_err_msg = "查询所有被推荐人的简历进度 成功！";

    public static final Integer selectRemainedWithdrawCash_ok = 212071;
    public static final String selectRemainedWithdrawCash_ok_msg = "查询园长 可提现金额 成功！";

    public static final Integer selectRemainedWithdrawCash_err = 212070;
    public static final String selectRemainedWithdrawCash_err_msg = "查询园长 可提现金额 成功！";
    /**
     * front 状态码
     */

    public static final Integer updateContent_ok = 213011;
    public static final String updateContent_ok_msg = "更新内容 成功！";
    public static final Integer updateContent_err = 213010;
    public static final String updateContent_err_msg = "更新内容 失败！";

    public static final Integer getAll_ok = 213021;
    public static final String getAll_ok_msg = "查询所有 成功！";
    public static final Integer getAll_err = 213020;
    public static final String getAll_err_msg = "查询所有 失败！";

//    public static final Integer selectReferrerTotalCash_ok = 212031;
//    public static final String selectReferrerTotalCash_ok_msg = "查询园长的总积分 成功！";
//    public static final Integer selectReferrerTotalCash_err = 2120030;
//    public static final String selectReferrerTotalCash_err_msg = "查询园长的总积分 失败！";
//
//    public static final Integer selectWithdrawCash_ok = 212041;
//    public static final String selectWithdrawCash_ok_msg = "查询园长 已提现金额 成功！";
//    public static final Integer selectWithdrawCash_err = 212040;
//    public static final String selectWithdrawCash_err_msg = "查询园长 已提现金额 失败！";
//
//    public static final Integer selectAllReferrerInfo_ok = 212051;
//    public static final String selectAllReferrerInfo_ok_msg = "查询所有园长的信息 成功！";
//    public static final Integer selectAllReferrerInfo_err = 212050;
//    public static final String selectAllReferrerInfo_err_msg = "查询所有园长的信息 失败！";
//
//    public static final Integer selectRecommendedMemberInfo_ok = 212061;
//    public static final String selectRecommendedMemberInfo_ok_msg = "查询所有被推荐人的简历进度 成功！";
//
//    public static final Integer selectRecommendedMemberInfo_err = 212060;
//    public static final String selectRecommendedMemberInfo_err_msg = "查询所有被推荐人的简历进度 成功！";
//
//    public static final Integer selectRemainedWithdrawCash_ok = 212071;
//    public static final String selectRemainedWithdrawCash_ok_msg = "查询园长 可提现金额 成功！";
//
//    public static final Integer selectRemainedWithdrawCash_err = 212070;
//    public static final String selectRemainedWithdrawCash_err_msg = "查询园长 可提现金额 成功！";
}