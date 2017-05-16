package com.wenhua.util.web;

import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.alibaba.fastjson.JSON;
import com.google.common.base.CharMatcher;
import com.google.common.base.Charsets;
import com.google.common.base.Preconditions;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;

/**
 * @author Fuchun
 * @version $Id: HttpRequests.java 33583 2013-06-11 08:50:00Z zhuzhaohua $
 * @since 1.0
 */
public final class HttpRequests {
	
	public final static String APPLICATION_JSON = "application/json";
	public final static String APPLICATION_FORM_URLENCODED = "application/x-www-form-urlencoded";

	private static final Logger LOGGER = LoggerFactory
			.getLogger(HttpRequests.class);

	private static final MultiThreadedHttpConnectionManager httpClientManager;

	static {
		httpClientManager = new MultiThreadedHttpConnectionManager();
		httpClientManager.getParams().setStaleCheckingEnabled(true);
		httpClientManager.getParams().setMaxTotalConnections(20);
		httpClientManager.getParams().setDefaultMaxConnectionsPerHost(100);
		httpClientManager.getParams().setConnectionTimeout(60000);
		httpClientManager.getParams().setSoTimeout(60000);
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {
		private final List<Header> headers = Lists.newArrayList();
		private Map<String, String> params;
		private HttpClient client;
		private HttpMethod httpMethod;
		private String path;
		private Charset charset;
		private boolean isJsonParam = false;

		private Builder() {
		}
		
		public Builder addHeader(String name, String value) {
			headers.add(new Header(name, value));
			return this;
		}

		public Builder addHeaders(Header header, Header... headers) {
			if (header != null) {
				this.headers.add(header);
			}
			if (headers != null && headers.length > 0) {
				for (Header h : headers) {
					this.headers.add(h);
				}
			}
			return this;
		}

		public Builder addHeaders(Iterable<Header> headers) {
			Iterables.addAll(this.headers, headers);
			return this;
		}

		public Builder setUrl(String url) {
			Preconditions.checkArgument(url != null && url.length() > 0,
					"The url must not be null or empty!");
			String noSchemeUrl = "";
			if (url.startsWith("http://")) {
				noSchemeUrl = url.substring(7);
			} else if (url.startsWith("https://")) {
				noSchemeUrl = url.substring(8);
			}
			int firstSlush = noSchemeUrl.indexOf("/");
			String host;
			if (firstSlush != -1) {
				host = noSchemeUrl.substring(0, firstSlush);
				path = noSchemeUrl.substring(firstSlush);
			} else {
				host = noSchemeUrl;
				path = "";
			}
			int colonIndex = host.indexOf(":");
			int port;
			if (colonIndex != -1) {
				String[] parts = StringUtils.split(host, ":");
				host = parts[0];
				port = CharMatcher.DIGIT.matchesAllOf(parts[1]) ? Integer
						.valueOf(parts[1]) : 80;
			} else {
				port = 80;
			}
			client = new HttpClient(httpClientManager);
			client.getHostConfiguration().setHost(host, port);
			return this;
		}

		/**
		 * POST method.
		 */
		public Builder post() {
			if (httpMethod instanceof PostMethod) {
				return this;
			}
			PostMethod postMethod = new PostMethod(path);
			
			this.httpMethod = postMethod;
			
			String format = "application/x-www-form-urlencoded;charset=%s";
			
			return addHeader("Content-Type", String.format(
					format,
					Charsets.UTF_8.displayName()));
		}
		
		/**
		 * POST method.
		 */
		public Builder postJson() {
			
			PostMethod postMethod = new PostMethod(path);
			this.httpMethod = postMethod;
			this.isJsonParam = true;
			String format = "application/json;charset=%s";

			return addHeader("Content-Type", String.format(
					format,
					Charsets.UTF_8.displayName()));
		}
		
		/**
		 * GET method.
		 */
		public Builder get() {
			GetMethod getMethod = new GetMethod(path);
			this.httpMethod = getMethod;
			return this;
		}

		public Builder params(Map<String, String> params) {
			this.params = params;
			return this;
		}
		
		public Builder charset(Charset charset) {
			this.charset = charset;
			return this;
		}

		public String request() {
			if (client == null) {
				throw new IllegalStateException("The url must not be null.");
			}
			if (httpMethod == null) {
				get();
			}
			if (params != null && params.size() > 0) {
				List<NameValuePair> paramList = new LinkedList<NameValuePair>();
				for (Map.Entry<String, String> entry : params.entrySet()) {
					paramList.add(new NameValuePair(entry.getKey(), entry
							.getValue()));
				}
				if (httpMethod instanceof PostMethod) {
					PostMethod post = (PostMethod) httpMethod;
					
					if(isJsonParam) {
						try {
							String jsonParams = JSON.toJSONString(params);
							LOGGER.info("request : {}", jsonParams);
							post.setRequestEntity(new StringRequestEntity(jsonParams, "application/json", Charsets.UTF_8.displayName()));
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					} else {
						post.setRequestBody(paramList
								.toArray(new NameValuePair[paramList.size()]));
					}
					
					httpMethod = post;
				} else {
					httpMethod.setQueryString(paramList
							.toArray(new NameValuePair[paramList.size()]));
				}
			}
			
			if (charset == null) {
				charset = Charsets.UTF_8;
			}
			
			if (headers.size() > 0) {
				for (Header header : headers) {
					httpMethod.addRequestHeader(header);
				}
			}
			String result = null;
			int status = 0;
			try {
				if (httpMethod instanceof PostMethod) {
					PostMethod post = (PostMethod) httpMethod;
					
					RequestEntity requestEntity = post.getRequestEntity();
					long contentLength = null == requestEntity ? 0 : requestEntity.getContentLength();
					
					httpMethod.addRequestHeader("Content-Length",
							String.valueOf(contentLength));
				}
				status = client.executeMethod(httpMethod);
				result = CharStreams.toString(new InputStreamReader(httpMethod
						.getResponseBodyAsStream(), charset));
			} catch (Exception ex) {
				LOGGER.error(String.format(
						"http request url: %s, status: %s, error: %s",
						httpMethod.getPath(), status, ex.getMessage()));
				ex.printStackTrace();
			} finally {
				httpMethod.releaseConnection();
			}
			return result;
		}
	}
}
