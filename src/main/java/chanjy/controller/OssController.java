package chanjy.controller;


import chanjy.util.OssUtil;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class OssController {

    @Autowired
    private OssUtil ossUtil;

    //处理文件上传
    @PostMapping("/upload")
    @ResponseBody
    public String homeImageUpload(@RequestParam("file")MultipartFile file) {
        try {
            String homeImage = ossUtil.checkImage(file);//此处是调用上传服务接口
            return homeImage;
        }catch (Exception e) {
            e.printStackTrace();
            return e.toString();
        }
    }

}