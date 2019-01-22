package com.yidao.jdbc.uitls;


import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.NoHttpResponseException;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
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

            if (httpPost != null) {
                httpPost.releaseConnection();
            }

        }

        return result;
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
            sslContext.init((KeyManager[])null, new TrustManager[]{trustManager}, (SecureRandom)null);
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

                while(var2.hasNext()) {
                    HttpRoute route = (HttpRoute)var2.next();
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
