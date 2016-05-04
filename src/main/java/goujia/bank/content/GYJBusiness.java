package goujia.bank.content;

import goujia.bank.model.Order;

import java.io.IOException;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.goujia.goujiabao.Constants;
import com.goujia.goujiabao.GYJTradeCode;
import com.goujia.goujiabao.model.GJWAnsAffirm;
import com.goujia.goujiabao.model.GYJQueryOrder;
import com.goujia.goujiabao.model.GYJQueryOrderPayment;
import com.goujia.goujiabao.model.GYJRequest;
import com.goujia.goujiabao.model.GYJResponse;
import com.goujia.goujiabao.util.Base64;
import com.goujia.goujiabao.util.Tool;
import com.goujia.goujiabao.util.XMLUtil;

/**
 * 
 * date: 2015年8月26日 下午2:02:14 <br/>
 * 
 * @author gwb
 */
public class GYJBusiness {
	private static final Logger LOG = LoggerFactory.getLogger(GYJBusiness.class);
	private String noticeURL;
	private String tradePath;
	private String merid;
	private String mername;
	private String password;

	public String getNoticeURL() {
		return noticeURL;
	}

	public void setNoticeURL(String noticeURL) {
		this.noticeURL = noticeURL;
	}

	public void setTradePath(String tradePath) {
		this.tradePath = tradePath;
	}

	public void setMerid(String merid) {
		this.merid = merid;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getTradePath() {
		return tradePath;
	}

	public String getMerid() {
		return merid;
	}

	public String getPassword() {
		return password;
	}

	public String getMername() {
		return mername;
	}

	public void setMername(String mername) {
		this.mername = mername;
	}

	/**
	 * 查询订单支付结果接口
	 * 
	 * @param orderId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public GYJQueryOrder queryOrder(Order order) throws Exception {
		LOG.info("-----------------订单支付结果查询开始  orderId-----------------------" + order.getCode());
		GYJRequest request = new GYJRequest();
		request.setMerid("test1");
		request.setTrancode(GYJTradeCode.GYJODRQRY.name());
		String transtime = Tool.formatTime(new Date());
		String prefix = "";
		if (order.getStatus().equals("prepaying")) {
			prefix = "EART";
		} else if (order.getStatus().equals("accepted_AZZC")) {
			prefix = "CRET";
		} else {
			prefix = "STAG";
		}

		String reqdata = "<GYJ>" + "<transtime>" + transtime + "</transtime>" + // <!--和服务器时间间隔前后不超过15分钟,必输-->
		        "<orderid>" + prefix + order.getCode() + "</orderid>" + // <!--长度不超过35位,一个商户永不重复,必输-->
		        "</GYJ>";

		// String reqdata = "<GYJ>"+
		// "<transtime>"+transtime+"</transtime>"+ //<!--和服务器时间间隔前后不超过15分钟,必输-->
		// "<orderid>CRET20150813193928830036499</orderid>"+
		// //<!--长度不超过35位,一个商户永不重复,必输-->
		// "</GYJ>";

		// String reqdata = "<GYJ>"+
		// "<transtime>"+transtime+"</transtime>"+ //<!--和服务器时间间隔前后不超过15分钟,必输-->
		// "<orderid>"+"EART2015081211190269792175"+"</orderid>"+
		// //<!--长度不超过35位,一个商户永不重复,必输-->
		// "</GYJ>";

		// String reqdata = "<GYJ>"+
		// "<transtime>"+transtime+"</transtime>"+ //<!--和服务器时间间隔前后不超过15分钟,必输-->
		// "<orderid>"+"CRET2015081211055441258087"+"</orderid>"+
		// //<!--长度不超过35位,一个商户永不重复,必输-->
		// "</GYJ>";

		// String reqdata = "<GYJ>"+
		// "<transtime>"+transtime+"</transtime>"+ //<!--和服务器时间间隔前后不超过15分钟,必输-->
		// "<orderid>"+"CRET20150812112704461987743"+"</orderid>"+
		// //<!--长度不超过35位,一个商户永不重复,必输-->
		// "</GYJ>";

		//
		// String reqdata = "<GYJ>"+
		// "<transtime>"+transtime+"</transtime>"+ //<!--和服务器时间间隔前后不超过15分钟,必输-->
		// "<orderid>"+"CRET20150812134854107812812"+"</orderid>"+
		// //<!--长度不超过35位,一个商户永不重复,必输-->
		// "</GYJ>";

		// String reqdata = "<GYJ>"+
		// "<transtime>"+transtime+"</transtime>"+ //<!--和服务器时间间隔前后不超过15分钟,必输-->
		// "<orderid>"+"EART20150812140041377309078"+"</orderid>"+
		// //<!--长度不超过35位,一个商户永不重复,必输-->
		// "</GYJ>";

		// String reqdata = "<GYJ>"+
		// "<transtime>"+transtime+"</transtime>"+ //<!--和服务器时间间隔前后不超过15分钟,必输-->
		// "<orderid>"+"CRET20150812140041377309078"+"</orderid>"+
		// //<!--长度不超过35位,一个商户永不重复,必输-->
		// "</GYJ>";

		request.setReqdata(reqdata);
		LOG.info("-----------------订单支付结果查询开始 reqdata-----------------------" + request.getReqdata());
		request.signature(reqdata, "111111", transtime);
		LOG.info("-----------------订单支付结果查询开始 signature-----------------------" + request.getSignature());
		GYJQueryOrder gyjQueryOrder = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(Tool.convertToList(request), Constants.CHARSET);
			HttpPost httppost = new HttpPost(GYJTradeCode.GYJODRQRY.getTradeURL("web.zj.icbc.com.cn/cashiertest/"));
			httppost.setEntity(entity);
			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};
			String responseBody = httpclient.execute(httppost, responseHandler);
			LOG.info("-----------------" + responseBody);
			GYJResponse<GYJQueryOrder> response = new GYJResponse<GYJQueryOrder>(responseBody);
			gyjQueryOrder = (GYJQueryOrder) response.getData(GYJQueryOrder.class);
		} finally {
			httpclient.close();
			return gyjQueryOrder;
		}
	}

	/**
	 * 信用支付查询
	 * 
	 * @param orderId
	 * @param repayId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public GYJQueryOrderPayment queryOrderPayment(String orderId, String repayId) throws Exception {
		GYJRequest request = new GYJRequest();
		request.setMerid(merid);
		request.setTrancode(GYJTradeCode.GYJCREDQRY.name());

		String transtime = Tool.formatTime(new Date());
		String reqdata = "<GYJ>" + "<transtime>" + transtime + "</transtime>" + // <!--和服务器时间间隔前后不超过15分钟,必输-->
		        "<orderid>" + orderId + "</orderid>" + // <!--长度不超过35位,一个商户永不重复,必输-->
		        // **************
				// "<repayid>"+(Tool.isEmpty(repayId)?"":repayId)+"</repayid>"+
		        "</GYJ>";
		request.setReqdata(reqdata);

		request.signature(reqdata, password, transtime);

		GYJQueryOrderPayment order = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			UrlEncodedFormEntity entity = new UrlEncodedFormEntity(Tool.convertToList(request), Constants.CHARSET);
			HttpPost httppost = new HttpPost(GYJTradeCode.GYJCREDQRY.getTradeURL("cashier.gyj.com/cashier/"));
			httppost.setEntity(entity);

			// Create a custom response handler
			ResponseHandler<String> responseHandler = new ResponseHandler<String>() {
				public String handleResponse(final HttpResponse response) throws ClientProtocolException, IOException {
					int status = response.getStatusLine().getStatusCode();
					if (status >= 200 && status < 300) {
						HttpEntity entity = response.getEntity();
						return entity != null ? EntityUtils.toString(entity) : null;
					} else {
						throw new ClientProtocolException("Unexpected response status: " + status);
					}
				}
			};

			String responseBody = httpclient.execute(httppost, responseHandler);
			GYJResponse<GYJQueryOrderPayment> response = new GYJResponse<GYJQueryOrderPayment>(responseBody);
			order = (GYJQueryOrderPayment) response.getData(GYJQueryOrderPayment.class);
		} finally {
			httpclient.close();
			return order;
		}
	}

	/**
	 * 保证金确认支付
	 * 
	 * @param orderId
	 * @param repayId
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("finally")
	public GJWAnsAffirm verifyCashDeposit(String xmlStr, String signature) throws Exception {
		GJWAnsAffirm order = null;
		CloseableHttpClient httpclient = HttpClients.createDefault();
		try {
			// http://www.webxml.com.cn/WebServices/TranslatorWebService.asmx?disco
			HttpPost httppost = new HttpPost("http://109.6.13.1:12074?reqdata=" + xmlStr + "&signature=" + signature
			        + "&charset=utf-8");
			CloseableHttpResponse responseBody = httpclient.execute(httppost);
			String stringXml = EntityUtils.toString(responseBody.getEntity());
			System.out.println("#######################################################" + "="
			        + Base64.decode(stringXml));
			order = (GJWAnsAffirm) XMLUtil.parseXML(Base64.decode(stringXml), new GJWAnsAffirm());
		} finally {
			httpclient.close();
			return order;
		}
	}
}
