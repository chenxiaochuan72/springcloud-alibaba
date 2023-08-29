package cn.it.xiaodongbei.controller;

import cn.it.xiaodongbei.model.Complaint;
import cn.it.xiaodongbei.tool.EmailSendTool;
import com.qiniu.util.Json;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

/**
 * @Author cxc
 * @Date 2023/8/23 3:02 PM
 * @Version 1.0
 * @Description:
 */
@RestController
public class ComplaintApiAct {
    Logger logger= LoggerFactory.getLogger(ComplaintApiAct.class);

    @RequestMapping("/submit")
    public String submitComplaint1(@RequestBody Complaint complaint) {
//        try {
//            // 发送邮件通知
//            extracted(complaint);
//        } catch (Exception e) {
//            logger.info("邮件发送异常，邮件内容为:"+complaint.toString());
//            throw new RuntimeException(e);
//        }
        return Json.encode(new Response("成功","200"));

    }

    private  void extracted(Complaint complaint) {
        String message="投保产品:"+ complaint.getInsuranceType()
                +"姓名:"+ complaint.getName()
                +"性别:"+ complaint.getGender()
                +"联系电话:"+ complaint.getContactNumber()
                +"投保地区:"+ complaint.getLocation()
                +"保单号码:"+ complaint.getPolicyNumber()
                +"留言:"+ complaint.getMessage()
                +"投保人姓名:"+ complaint.getApplicantName();
        EmailSendTool sendTool = new EmailSendTool("smtp.exmail.qq.com",
                465,"chenxiaochuan@sinosoft.com.cn", "TZe7ZHESAyjbzjec", "zhouxin002@sinosoft.com.cn",
                "官网渠道投诉建议", message, "JEECMS", "", "");
        sendTool.sendEmilComplain();
    }
}
class Response implements Serializable {
    private String message;
    private String code;

    public Response(String message, String code) {
        this.message = message;
        this.code = code;
    }


}


