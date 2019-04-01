package com.yidao.jdbc.aes;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.model.KeyPairInfo;
import com.yidao.jdbc.uitls.HttpUtils;
import com.yidao.jdbc.uitls.Ulog;

import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        testAes();


        doGetTest();
    }

    private static void testAes() {
        // 公钥
        String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCaxUxHsZHY3i5U5Ey4SQP4jzIy3AX/TaVSsED2BiXdZbjcVBREOkuFCUCrM4/cAaRNvb4dpLOK+JQHz1kYwS1yeMYgaHwpetFCMgAYPcI45Urun/GM+FgYt146xgQnt3/ndqJXyXNybslZeWAT28zs3TQ4XPInbZqK3LGRIkhmcQIDAQAB";
        // 私钥
        String priateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJrFTEexkdjeLlTkTLhJA/iPMjLcBf9NpVKwQPYGJd1luNxUFEQ6S4UJQKszj9wBpE29vh2ks4r4lAfPWRjBLXJ4xiBofCl60UIyABg9wjjlSu6f8Yz4WBi3XjrGBCe3f+d2olfJc3JuyVl5YBPbzOzdNDhc8idtmorcsZEiSGZxAgMBAAECgYB37ZBJMaiBMtEWCP4GAtYn4dYVIPcouKL1qwv7WBI5N5yCZkh6Ae4I/X116/N6mG8XqoLJ95kEg9A5KQuyKearS7nMUDSuI0I94e7e+N5SQzIKorOy+VTc96yf/UMl3Z/wtFZHVaV0MDKowTozuXYSYoFibnQt9AWMQ/Xj7gE4kQJBAMjN4Rz1/WP6aLsmzvTd2fNAKGINRcOFJPsXJ8EEUqiWgiqA9VoZbeqcCWHEWyOJPrwxUv5U4T825AQCOG9s/TUCQQDFUCXgw787ocvyw6U+uQhBwTno/REQs10Cm4OBmTStnDXdW7nwIayxWcZ08ZTCMj+99KkMkrdTo+DfGKzE1nfNAkAA8/EoiQZNzidnE/URdmgNXnWSmYuGNQCK7H40zUdzI1u0xe3kIpDB90GYJC1misUwcW96Y366JRGJ71TDOpotAkBFTC3Rb840+lEvtMjPa5rbxSo6is64h9YNuWKJXK5knu1IDhQSozEMpJQPtFzji1RZuZi5ormiNXcfw4HCK/StAkBez8DptPApuEwaDREHMv6KTwNyx9T9dWeeKKB7V+v6NY1vqG66QodzfJU2lZr5MBc2fIbc/vRxPEJqo4Oycq97";

        // 待加密的业务数据,json格式string
        String bizParam = "{\"hospitalID\":\"123200004660027298\",\"hospitalName\":\"苏州大学附属第一医院\",\"startTime\":\"2018-06-22\",\"endTime\":\"2018-06-26\",\"startRN\":0,\"recordNum\":1000}";

        // appId
        String appId = "MDMUD024";
        // 初始化签名工具对象
        RsaHelper rsaHelper = new RsaHelper(appId);

//        // 加签方法
        String ciphertext = rsaHelper.sign(bizParam, priateKey);
        Ulog.i("返回带sign的json数据：" + ciphertext);

//        // 发送post请求
//        String responseResult = HttpUtils.sendPostRequest("http://localhost:8018/order/test",ciphertext);
//        Ulog.i("responseResult:"+responseResult);

        // 服务端验签流程,实际环境ciphertext为获取的参数
        Gson GSON = new Gson();
        Map<String, Object> result = GSON.fromJson(ciphertext, new TypeToken<Map<String, Object>>() {
        }.getType());
        Ulog.i("解析：" + result);
        Ulog.i("验签结果:" + rsaHelper.decryptresponse(result, publicKey));
        Ulog.i("解析业务数据:" + rsaHelper.decode(result.get("bizContent").toString()));


        KeyPairInfo keyPairInfo = rsaHelper.getKeyPair(1024);
//        Ulog.i("PrivateKey:"+ keyPairInfo.getPrivateKey());
//        Ulog.i("PublicKey:"+  keyPairInfo.getPublicKey());


        String message = HttpUtils.sendGetRequest("http://116.247.74.76:8682/api/AutoUpdate?id=00000000000001", null);
        Ulog.i("message", message);


        Map<String,String> params = new HashMap<>();
        params.put("UDI_DI","010082700209497017201130108409387");
        params.put("UDI_EXPIDATE","201130");
        params.put("UDI_MANUDATE","8409387");
        params.put("UDI_LOT","161130");
        params.put("UDI_SN","30001");
        String result2 = HttpUtils.doPost("http://116.247.74.76:8681/CustomServicesApi/EasipassGetUdiInfo",params,"UTF-8");

        Ulog.i("result2",(result2));

        doPostTest();
    }

    private static void doGetTest() {
        String result = HttpUtils.sendGetRequest("http://easyway.com.cn:8088/CustomServicesApi/Scanner?type=1&code=test&msg=t&verify=1",null);
        Ulog.i("result",result);
    }

    private static void doPostTest() {
        String url = "http://admin.tingwen.me/index.php/api/interfaceXykj/touList";
        Map<String,String> params = new HashMap<>();
        params.put("page","100");
        String result = HttpUtils.doPost(url,params,"UTF-8");
        Ulog.i("doPostTest()",(result));
    }
}
