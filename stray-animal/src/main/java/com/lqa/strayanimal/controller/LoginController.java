package com.lqa.strayanimal.controller;

import com.google.code.kaptcha.Producer;
import com.lqa.strayanimal.entity.RespBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author 10411
 */
@RestController
@Api(tags = "登录")
public class LoginController {

    @Autowired
    Producer producer;

    @GetMapping("/login")
    @CrossOrigin(originPatterns = "*")
    @ApiOperation(value = "管理员登录")
    public RespBean login() {
        return RespBean.error("尚未登录");
    }

    @GetMapping("/verifyCode")
    @ApiOperation(value = "请求验证码")
    public void getVerifyCode(HttpServletResponse httpServletResponse, HttpSession httpSession) throws IOException {
        httpServletResponse.setContentType("image/jpeg");
        String str = producer.createText();
        httpSession.setAttribute("verify_code", str);
        BufferedImage bufferedImage = producer.createImage(str);
        try (ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream()) {
            ImageIO.write(bufferedImage, "jpg", servletOutputStream);
        }
    }
}
