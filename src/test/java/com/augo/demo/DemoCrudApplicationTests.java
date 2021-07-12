package com.augo.demo;

import com.augo.demo.dao.StaffMapper;
import com.augo.demo.pojo.AllStaff;
import com.augo.demo.pojo.Staff;
import com.augo.demo.service.impl.StaffServiceImpl;
import com.augo.demo.utils.VerificationCode;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.image.BufferedImage;
import java.util.List;

@SpringBootTest
class DemoCrudApplicationTests {

    @Autowired
    @Qualifier("staffService")
    private StaffServiceImpl staffService;

    @Autowired
    @Qualifier("checkCode")
    VerificationCode verificationCode;

    @Autowired
    @Qualifier("staffMapper")
    private StaffMapper staffMapper;

    @Test
    void contextLoads() {

    }

    @Test
    void test2(){
        BufferedImage image = verificationCode.getImage();
        String text = verificationCode.getText();
        System.out.println(text);
    }

}
