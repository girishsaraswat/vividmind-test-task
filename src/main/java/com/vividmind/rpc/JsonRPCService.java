package com.vividmind.rpc;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * @author Girish Sarashwat
 */
public class JsonRPCService {
    private static final Logger LOGGER = LogManager.getLogger(JsonRPCService.class);
    private static final String SENDING_PARAMS="Sending :  params : ";
    private static final String RESPONSE="Response : ";
    private static final String UNABLE_TO_COMPLETE="unable to complete post request {}";
    private static final String UNABLE_TO_CLOSE="unable to close POST HTTP resources {}";

    public static String sendGet(final String url) {

        final HttpGet httpGet = new HttpGet(url);
        try (final CloseableHttpClient httpClient = HttpClients.createDefault()) {
            LOGGER.debug(SENDING_PARAMS + url);
            String responseJson = getString(httpGet, httpClient);
            LOGGER.debug(RESPONSE + responseJson);
            return responseJson;
        } catch (IOException e) {
            LOGGER.warn(UNABLE_TO_COMPLETE, e.getMessage());
        } finally {
            try {
                httpGet.releaseConnection();
            } catch (Exception e) {
                LOGGER.warn(UNABLE_TO_CLOSE, e.getMessage());
            }
        }
        return null;
    }



    private static String getString(final HttpRequestBase requestBase, final CloseableHttpClient httpClient) throws IOException {
        CloseableHttpResponse httpResponse = httpClient.execute(requestBase);
        return EntityUtils.toString(httpResponse.getEntity());
    }

    public static class RequestParameter {

        private final String name;

        private final Object value;

        public RequestParameter(String name, Object value) {
            this.name = name;
            this.value = value;
        }

        private String getName() {
            return name;
        }

        private Object getValue() {
            return value;
        }

        public String getEncoded() throws UnsupportedEncodingException {
            try {
                return this.getName() + "=" + URLEncoder.encode(String.valueOf(this.getValue()), StandardCharsets.UTF_8.name());
            } catch (UnsupportedEncodingException e) {
                LOGGER.warn("Unable to encode request parameters");
                throw e;
            }
        }

        @Override
        public String toString() {
            return "RequestParameter{name='" + name + "', value='" + value + "'}";
        }
    }


}
