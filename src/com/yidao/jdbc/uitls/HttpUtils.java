package com.yidao.jdbc.uitls;


import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.UnsupportedEncodingException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.*;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.routing.HttpRoute;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.LayeredConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.pool.PoolStats;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

public class HttpUtils {
    private static final int CONNECT_TIMEOUT = 4000;
    private static final int SOCKET_TIMEOUT = 10000;
    private static final int REQUESTCONNECT_TIMEOUT = 2000;
    private static final int CONNECT_TOTAL = 200;
    private static final int CONNECT_ROUTE = 20;
    private static final String ENCODE_CHARSET = "utf-8";
    private static final String RESP_CONTENT = "通信失败";
    private static PoolingHttpClientConnectionManager connManager = null;
    private static CloseableHttpClient httpClient = null;

    public HttpUtils() {
    }

    public static String sendGetRequest(String reqURL, String param) {
        if (null != param) {
            reqURL = reqURL + "?" + param;
        }

        String respContent = "通信失败";
        HttpGet httpget = new HttpGet(reqURL);
        CloseableHttpResponse response = null;

        try {
            response = httpClient.execute(httpget, HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                Charset respCharset = ContentType.getOrDefault(entity).getCharset();
                respContent = EntityUtils.toString(entity, respCharset);
                EntityUtils.consume(entity);
            }
        } catch (ConnectTimeoutException var25) {
            ;
        } catch (SocketTimeoutException var26) {
            ;
        } catch (ClientProtocolException var27) {
            ;
        } catch (ParseException var28) {
            ;
        } catch (IOException var29) {
            ;
        } catch (Exception var30) {
            ;
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException var24) {
                var24.printStackTrace();
            }

            if (httpget != null) {
                httpget.releaseConnection();
            }

        }

        return respContent;
    }

    public static String sendPostRequest(String reqURL, String param) {
        return sendPostRequest(reqURL, param, "JSON");
    }

    private static String sendPostRequest(String reqURL, String param, String type) {
        String result = "通信失败";
        HttpPost httpPost = new HttpPost(reqURL);
        if (type != null && type.length() > 0) {
            httpPost.setHeader("Content-Type", "application/json; charset=utf-8");
        } else {
            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        }

        CloseableHttpResponse response = null;

        try {
            if (param != null) {
                StringEntity entity = new StringEntity(param, "utf-8");
                httpPost.setEntity(entity);
            }

            response = httpClient.execute(httpPost, HttpClientContext.create());
            HttpEntity entity = response.getEntity();
            if (null != entity) {
                result = EntityUtils.toString(entity, ContentType.getOrDefault(entity).getCharset());
                EntityUtils.consume(entity);
            }
        } catch (ConnectTimeoutException exc) {
            return exc.getMessage();
        } catch (SocketTimeoutException exc) {
            return exc.getMessage();
        } catch (ClientProtocolException exc) {
            return exc.getMessage();
        } catch (ParseException exc) {
            return exc.getMessage();
        } catch (IOException exc) {
            return exc.getMessage();
        } catch (Exception exc) {
            return exc.getMessage();
        } finally {
            try {
                if (response != null) {
                    response.close();
                }
            } catch (IOException var24) {
                var24.printStackTrace();
            }

            if (httpPost != null) {
                httpPost.releaseConnection();
            }

        }

        return result;
    }


    public static String doPost(String url, Map<String, String> map, String charset) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        String result = null;
        try {
            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost(url);
            //设置参数
            List<NameValuePair> list = new ArrayList<>();
            Iterator iterator = map.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> elem = (Map.Entry<String, String>) iterator.next();
                list.add(new BasicNameValuePair(elem.getKey(), elem.getValue()));
            }
            if (list.size() > 0) {
                UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list, charset);
                httpPost.setEntity(entity);
            }
            HttpResponse response = httpClient.execute(httpPost);
            if (response != null) {
                HttpEntity resEntity = response.getEntity();
                if (null != resEntity) {
                    result = EntityUtils.toString(resEntity, ContentType.getOrDefault(resEntity).getCharset());
                    EntityUtils.consume(resEntity);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return unicodeToString(result);
    }

    /**
     * 获取字符串的unicode编码
     * 汉字“木”的Unicode 码点为Ox6728
     *
     * @param s 木
     * @return \ufeff\u6728  \ufeff控制字符 用来表示「字节次序标记（Byte Order Mark）」不占用宽度
     * 在java中一个char是采用unicode存储的 占用2个字节 比如 汉字木 就是 Ox6728 4bit+4bit+4bit+4bit=2字节
     */
    public static String stringToUnicode(String s) {
        try {
            StringBuffer out = new StringBuffer("");
            //直接获取字符串的unicode二进制
            byte[] bytes = s.getBytes("unicode");
            //然后将其byte转换成对应的16进制表示即可
            for (int i = 0; i < bytes.length - 1; i += 2) {
                out.append("\\u");
                String str = Integer.toHexString(bytes[i + 1] & 0xff);
                for (int j = str.length(); j < 2; j++) {
                    out.append("0");
                }
                String str1 = Integer.toHexString(bytes[i] & 0xff);
                out.append(str1);
                out.append(str);
            }
            return out.toString();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Unicode转 汉字字符串
     *
     * @param str \u6728
     * @return '木' 26408
     */
    public static String unicodeToString(String str) {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");
        Matcher matcher = pattern.matcher(str);
        char ch;
        while (matcher.find()) {
            //group 6728
            String group = matcher.group(2);
            //ch:'木' 26408
            ch = (char) Integer.parseInt(group, 16);
            //group1 \u6728
            String group1 = matcher.group(1);
            str = str.replace(group1, ch + "");
        }
        return str;
    }


    private static SSLConnectionSocketFactory createSSLConnSocketFactory() {
        SSLConnectionSocketFactory sslsf = null;
        X509TrustManager trustManager = new X509TrustManager() {
            public X509Certificate[] getAcceptedIssuers() {
                return null;
            }

            public void checkClientTrusted(X509Certificate[] arg0, String authType) throws CertificateException {
            }

            public void checkServerTrusted(X509Certificate[] arg0, String authType) throws CertificateException {
            }
        };

        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init((KeyManager[]) null, new TrustManager[]{trustManager}, (SecureRandom) null);
            sslsf = new SSLConnectionSocketFactory(sslContext, NoopHostnameVerifier.INSTANCE);
        } catch (Exception var4) {
            var4.printStackTrace();
        }

        return sslsf;
    }

    private static Map<HttpRoute, PoolStats> getConnManagerStats() {
        if (connManager != null) {
            Set<HttpRoute> routeSet = connManager.getRoutes();
            if (routeSet != null && !routeSet.isEmpty()) {
                Map<HttpRoute, PoolStats> routeStatsMap = new HashMap();
                Iterator var2 = routeSet.iterator();

                while (var2.hasNext()) {
                    HttpRoute route = (HttpRoute) var2.next();
                    PoolStats stats = connManager.getStats(route);
                    routeStatsMap.put(route, stats);
                }

                return routeStatsMap;
            }
        }

        return null;
    }

    private static PoolStats getConnManagerTotalStats() {
        return connManager != null ? connManager.getTotalStats() : null;
    }

    private static void releaseHttpClient() {
        try {
            httpClient.close();
        } catch (IOException var4) {
            var4.printStackTrace();
        } finally {
            if (connManager != null) {
                connManager.shutdown();
            }

        }

    }

    static {
        ConnectionSocketFactory plainsf = PlainConnectionSocketFactory.getSocketFactory();
        LayeredConnectionSocketFactory sslsf = createSSLConnSocketFactory();
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create().register("http", plainsf).register("https", sslsf).build();
        connManager = new PoolingHttpClientConnectionManager(registry);
        connManager.setMaxTotal(200);
        connManager.setDefaultMaxPerRoute(20);
        connManager.setValidateAfterInactivity(30000);
        SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(10000).build();
        connManager.setDefaultSocketConfig(socketConfig);
        RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(2000).setConnectTimeout(4000).setSocketTimeout(10000).build();
        HttpRequestRetryHandler httpRequestRetryHandler = new HttpRequestRetryHandler() {
            public boolean retryRequest(IOException exception, int executionCount, HttpContext context) {
                if (executionCount >= 3) {
                    return false;
                } else if (exception instanceof NoHttpResponseException) {
                    return true;
                } else if (exception instanceof SSLHandshakeException) {
                    return false;
                } else if (exception instanceof InterruptedIOException) {
                    return true;
                } else if (exception instanceof UnknownHostException) {
                    return false;
                } else if (exception instanceof ConnectTimeoutException) {
                    return false;
                } else if (exception instanceof SSLException) {
                    return false;
                } else {
                    HttpClientContext clientContext = HttpClientContext.adapt(context);
                    HttpRequest request = clientContext.getRequest();
                    return !(request instanceof HttpEntityEnclosingRequest);
                }
            }
        };
        httpClient = HttpClients.custom().setConnectionManager(connManager).setDefaultRequestConfig(requestConfig).setRetryHandler(httpRequestRetryHandler).build();
        if (connManager != null && connManager.getTotalStats() != null) {
            ;
        }

    }
}
