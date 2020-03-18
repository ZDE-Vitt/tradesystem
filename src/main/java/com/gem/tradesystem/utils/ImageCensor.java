package com.gem.tradesystem.utils;


import com.baidu.aip.contentcensor.AipContentCensor;
import com.gem.tradesystem.config.ImageCensorProperties;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * @Auther: NoTomato
 * @DATE:2020/3/18 19:40
 * @Description:
 */
@Component
public class ImageCensor {
    @Autowired
    private ImageCensorProperties imageCensorProperties;

    public JSONObject imageCensorOne(MultipartFile file){
        AipContentCensor censor = new AipContentCensor(imageCensorProperties.getAppid(),imageCensorProperties.getApikey(),imageCensorProperties.getSecretkey());
        JSONObject response = new JSONObject();
        try {
            byte[] img = file.getBytes();
            response = censor.imageCensorUserDefined(img,null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
}
