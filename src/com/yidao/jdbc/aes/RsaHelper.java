package com.yidao.jdbc.aes;

import com.google.gson.Gson;
import com.innovamed.UUIDUtil;
import com.model.KeyPairInfo;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.*;

public class RsaHelper {

    private final String appId;
    private final String platformCode;

    private final int SEGMENTSIZE_JIAMI = 117;
    private final int SEGMENTSIZE_JIEMI = 128;

    private static final Gson GSON = new Gson();

    public RsaHelper(String appId) {
        this.appId = appId;
        this.platformCode = appId.substring(appId.length() - 4, appId.length());
    }

    /**
     * 生成公钥、私钥对
     *
     * @param keySize
     * @return
     */
    public KeyPairInfo getKeyPair(int keySize) {
        try {
            KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
            // 初始化密钥对生成器，密钥大小一般要大于1024位，
            keyPairGen.initialize(keySize);
            // 生成一个密钥对，保存在keyPair中
            KeyPair keyPair = keyPairGen.generateKeyPair();
            // 得到私钥
            RSAPrivateKey oraprivateKey = (RSAPrivateKey) keyPair.getPrivate();
            // 得到公钥
            RSAPublicKey orapublicKey = (RSAPublicKey) keyPair.getPublic();

            KeyPairInfo pairInfo = new KeyPairInfo(keySize);
            //公钥
            byte[] publicKeybyte = orapublicKey.getEncoded();
            String publicKeyString = Base64.encodeBase64String(publicKeybyte);
            pairInfo.setPublicKey(publicKeyString);
            //私钥
            byte[] privateKeybyte = oraprivateKey.getEncoded();
            String privateKeyString = Base64.encodeBase64String(privateKeybyte);
            pairInfo.setPrivateKey(privateKeyString);

            return pairInfo;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }
    }

//    /**
//     * 获取公钥对象
//     *
//     * @param publicKeyBase64
//     * @return
//     * @throws InvalidKeySpecException
//     * @throws NoSuchAlgorithmException
//     */
//    private PublicKey getPublicKey(String publicKeyBase64)
//            throws InvalidKeySpecException, NoSuchAlgorithmException {
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        X509EncodedKeySpec publicpkcs8KeySpec =
//                new X509EncodedKeySpec(Base64.decodeBase64(publicKeyBase64));
//        PublicKey publicKey = keyFactory.generatePublic(publicpkcs8KeySpec);
//        return publicKey;
//    }
//
//    /**
////     * 获取私钥对象
////     *
////     * @param privateKeyBase64
////     * @return
////     * @throws NoSuchAlgorithmException
////     * @throws InvalidKeySpecException
////     */
////    private PrivateKey getPrivateKey(String privateKeyBase64)
////            throws NoSuchAlgorithmException, InvalidKeySpecException {
////        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
////        PKCS8EncodedKeySpec privatekcs8KeySpec =
////                new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKeyBase64));
////        PrivateKey privateKey = keyFactory.generatePrivate(privatekcs8KeySpec);
////        return privateKey;
////    }
//
//
//
//    /**
//     * 使用共钥加密
//     *
//     * @param content         待加密内容
//     * @param publicKeyBase64 公钥 base64 编码
//     * @return 经过 base64 编码后的字符串
//     */
//    public String encipher(String content, String publicKeyBase64) {
//        Map<String, Object> param = new HashMap<String, Object>();
//        param.put("appId", appId);
//        param.put("signType", "RSA");
//        param.put("format", "JSON");
//        param.put("timestamp", System.currentTimeMillis());
//        param.put("version", "1.0");
//        param.put("serialNo", UUIDUtil.getSerialNo(platformCode));
//        param.put("bizContent", encode3Des(content));
//        param.put("sign", encipher(putPairsSequenceAndTogether(param), publicKeyBase64, SEGMENTSIZE_JIAMI));
//        return GSON.toJson(param);
//    }
//
//    /**
//     * 使用共钥加密（分段加密）
//     *
//     * @param content         待加密内容
//     * @param publicKeyBase64 公钥 base64 编码
//     * @param segmentSize     分段大小,一般小于 keySize/8（段小于等于0时，将不使用分段加密）
//     * @return 经过 base64 编码后的字符串
//     */
//    private String encipher(String content, String publicKeyBase64, int segmentSize) {
//        try {
//            PublicKey publicKey = getPublicKey(publicKeyBase64);
//            return encipher(content, publicKey, segmentSize);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 分段加密
//     *
//     * @param ciphertext  密文
//     * @param key         加密秘钥
//     * @param segmentSize 分段大小，<=0 不分段
//     * @return
//     */
//    private String encipher(String ciphertext, Key key, int segmentSize) {
//        try {
//            // 用公钥加密
//            byte[] srcBytes = ciphertext.getBytes();
//
//            // Cipher负责完成加密或解密工作，基于RSA
//            Cipher cipher = Cipher.getInstance("RSA");
//            // 根据公钥，对Cipher对象进行初始化
//            cipher.init(Cipher.ENCRYPT_MODE, key);
//            byte[] resultBytes = null;
//
//            if (segmentSize > 0) {
//                //分段处理
//                resultBytes = cipherDoFinal(cipher, srcBytes, segmentSize);
//            } else {
//                resultBytes = cipher.doFinal(srcBytes);
//            }
//            String base64Str = Base64.encodeBase64String(resultBytes);
//            return base64Str;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 分段大小
//     *
//     * @param cipher
//     * @param srcBytes
//     * @param segmentSize
//     * @return
//     * @throws IllegalBlockSizeException
//     * @throws BadPaddingException
//     * @throws IOException
//     */
//    private byte[] cipherDoFinal(Cipher cipher, byte[] srcBytes, int segmentSize)
//            throws IllegalBlockSizeException, BadPaddingException, IOException {
//        if (segmentSize <= 0) {
//            throw new RuntimeException("分段大小必须大于0");
//        }
//        ByteArrayOutputStream out = new ByteArrayOutputStream();
//        int inputLen = srcBytes.length;
//        int offSet = 0;
//        byte[] cache;
//        int i = 0;
//        // 对数据分段解密
//        while (inputLen - offSet > 0) {
//            if (inputLen - offSet > segmentSize) {
//                cache = cipher.doFinal(srcBytes, offSet, segmentSize);
//            } else {
//                cache = cipher.doFinal(srcBytes, offSet, inputLen - offSet);
//            }
//            out.write(cache, 0, cache.length);
//            i++;
//            offSet = i * segmentSize;
//        }
//        byte[] data = out.toByteArray();
//        out.close();
//        return data;
//    }
//
//    /**
//     * 使用私钥解密
//     *
//     * @param contentBase64    待加密内容,base64 编码
//     * @param privateKeyBase64 私钥 base64 编码
//     * @return
//     * @segmentSize 分段大小
//     */
//    public String decipher(String contentBase64, String privateKeyBase64) {
//        return decipher(contentBase64, privateKeyBase64, SEGMENTSIZE_JIEMI);
//    }
//
//    /**
//     * 使用私钥解密（分段解密）
//     *
//     * @param contentBase64    待加密内容,base64 编码
//     * @param privateKeyBase64 私钥 base64 编码
//     * @return
//     * @segmentSize 分段大小
//     */
//    private String decipher(String contentBase64, String privateKeyBase64, int segmentSize) {
//        try {
//            PrivateKey privateKey = getPrivateKey(privateKeyBase64);
//            return decipher(contentBase64, privateKey, segmentSize);
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
//
//    /**
//     * 分段解密
//     *
//     * @param contentBase64 密文
//     * @param key           解密秘钥
//     * @param segmentSize   分段大小（小于等于0不分段）
//     * @return
//     */
//    private String decipher(String contentBase64, Key key, int segmentSize) {
//        try {
//            // 用私钥解密
//            byte[] srcBytes = Base64.decodeBase64(contentBase64);
//            // Cipher负责完成加密或解密工作，基于RSA
//            Cipher deCipher = Cipher.getInstance("RSA");
//            // 根据公钥，对Cipher对象进行初始化
//            deCipher.init(Cipher.DECRYPT_MODE, key);
//            byte[] decBytes = null;
//            //deCipher.doFinal(srcBytes);
//            if (segmentSize > 0) {
//                //分段处理
//                decBytes = cipherDoFinal(deCipher, srcBytes, segmentSize);
//            } else {
//                decBytes = deCipher.doFinal(srcBytes);
//            }
//            String decrytStr = new String(decBytes);
//            return decrytStr;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }


    /**
     * 3DES加密
     *
     * @param srcStr 将加密的字符串
     * @return lee on 2017-08-09 10:51:44
     */
    public String encode3Des(String srcStr) {
        byte[] keybyte = appId.getBytes();
        byte[] src = srcStr.getBytes();
        try {
            //生成密钥
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            //DES加密和解密过程中，密钥长度都必须是8的倍数
            DESKeySpec dks = new DESKeySpec(keybyte);
            SecretKey secretKey = keyFactory.generateSecret(dks);
            //加密
            Cipher c1 = Cipher.getInstance("DES/ECB/pkcs5padding");
            c1.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.encodeBase64String(c1.doFinal(src));
        } catch (Exception e3) {
            e3.printStackTrace();
        }
        return null;
    }


    /**
     * 使用私钥加签
     *
     * @param content       待加密内容
     * @param privateBase64 公钥 base64 编码
     * @return 经过 base64 编码后的字符串
     */
    public String sign(String content, String privateBase64) {
        Map<String, Object> param = new HashMap<String, Object>();
        param.put("appId", appId);
        param.put("signType", "RSA");
        param.put("format", "JSON");
        param.put("timestamp", String.valueOf(System.currentTimeMillis()));
        param.put("version", "1.0");
        param.put("serialNo", UUIDUtil.getSerialNo(platformCode));
        param.put("bizContent", encode3Des(content));
        param.put("sign", buildSign(putPairsSequenceAndTogether(param), privateBase64));
        return GSON.toJson(param);
    }


    /**
     * 加签名
     *
     * @param content
     * @param privateKey
     * @return
     */
    private String buildSign(String content, String privateKey) {
        try {
            PKCS8EncodedKeySpec priPKCS8 = new PKCS8EncodedKeySpec(Base64.decodeBase64(privateKey));
            KeyFactory keyf = KeyFactory.getInstance("RSA");
            PrivateKey priKey = keyf.generatePrivate(priPKCS8);

            Signature signature = Signature.getInstance("SHA1WithRSA");

            signature.initSign(priKey);
            signature.update(content.getBytes("UTF-8"));

            byte[] signed = signature.sign();

            return Base64.encodeBase64String(signed);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 3DES解密
     *
     * @param encryptText 加密文本
     * @return
     * @throws Exception
     */
    public String decode(String encryptText) {
        try {
            // 从原始密匙数据创建一个DESKeySpec对象
            DESKeySpec dks = null;

            dks = new DESKeySpec(appId.getBytes());
            // 创建一个密匙工厂，然后用它把DESKeySpec对象转换成
            // 一个SecretKey对象
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey secretKey = keyFactory.generateSecret(dks);
            // using DES in ECB mode
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            // 正式执行解密操作
            byte[] decryptData = cipher.doFinal(Base64.decodeBase64(encryptText));
            return new String(decryptData, "UTF-8");
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }


    private String putPairsSequenceAndTogether(Map<String, Object> info) {
        List<Map.Entry<String, Object>> infoIds = new ArrayList<Map.Entry<String, Object>>(info.entrySet());
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Object>>() {
            public int compare(Map.Entry<String, Object> arg0, Map.Entry<String, Object> arg1) {
                return (arg0.getKey()).compareTo(arg1.getKey());
            }
        });
        StringBuffer ret = new StringBuffer();
        for (Map.Entry<String, Object> entry : infoIds) {
            ret.append(entry.getKey()).append("=").append(entry.getValue()).append("&");
        }
        return ret.toString().substring(0, ret.length() - 1);
    }


    public boolean decryptresponse(Map<String, Object> param, String publicKey) {
        try {
            String sign = (String) param.remove("sign");

            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(new X509EncodedKeySpec(Base64.decodeBase64(publicKey)));

            Signature signature = Signature.getInstance("SHA1WithRSA");

            signature.initVerify(pubKey);
            signature.update(putPairsSequenceAndTogether(param).getBytes("UTF-8"));

            return signature.verify(Base64.decodeBase64(sign));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
