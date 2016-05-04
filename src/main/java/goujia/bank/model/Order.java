package goujia.bank.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by Archer on 2015/3/9.
 *
 * 销售订单
 */
public class Order{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    private Integer id;

    /**
     * 订单编号
     */
    private String code;

    /**
     * 4S店ID
     */
    private Integer shopId;

    /**
     * 4S店名
     */
    private String shopName;

    /**
     * 运营商ID
     */
    private Integer operatorId;

    /**
     * 运营商名
     */
    private String operatorName;

    /**
     * 销售方收款账户
     */
    private String sellerAccountNum;

    /**
     * 销售方收款人
     */
    private String sellerAccountName;

    /**
     * 产品包ID
     */
    private Integer goodsId;

    /**
     * 产品包名
     */
    private String goodsName;

    /**
     * 购买者ID
     */
    private Integer buyerId;

    /**
     * 购买者姓名
     */
    private String buyerName;

    /**
     * 签订合同者的身份证
     */
    private String IDCard;

    /**
     * 签订合同者的手机
     */
    private String mobile;

    /**
     * 总金额
     */
    private BigDecimal totalAmount;

    /**
     * 总支付笔数
     */
    private Integer totalPaymentNum;

    /**
     * 已支付金额
     */
    private BigDecimal payedAmount;

    /**
     *已支付笔数
     */
    private Integer payedNum;

    /**
     * 支付后产生的利息
     */
    private BigDecimal paymentInterest;

    /**
     * 合同路径
     */
    private String bargainPath;

    /**
     * 备注
     */
    private String memo;

    /**
     * 状态
     * 'booked'|'signed'|'starting'|'started'|'accepting'|'freezing'|'repaying'|'mediating'|'aborted'|'ended'：
     * '已预定' |'已签署' |'待开工'   |'已开工' |'待验收'    |'待冻结'   |'待确认支付'|'待调解'   |'合同中止' |'合同结束'
     */
    private String status;

    /**
     * 是否删除
     *  'y'|'n':'是'|'否'
     */
    private String isDeleted;

    /**
     * 开工时间
     */
    private Date gmtStart;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 修改时间
     */
    private Date gmtModified;

    /**
     * 拥有者
     */
    private Integer ownerId;
    /**
     * 收货地址
     */
    private String takeAddress;
    /**
     * 联系电话
     */
    private String takeContactMobile;
    
    /**
     * 联系人
     */
    private String takeContact;
    
    /**
     * 采购状态
     * topurchase｜purchasing｜purchased : '待采购'｜'采购中'｜'采购完成'
     */
    private String purchaseStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public Integer getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(Integer operatorId) {
        this.operatorId = operatorId;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    public String getSellerAccountNum() {
        return sellerAccountNum;
    }

    public void setSellerAccountNum(String sellerAccountNum) {
        this.sellerAccountNum = sellerAccountNum;
    }

    public String getSellerAccountName() {
        return sellerAccountName;
    }

    public void setSellerAccountName(String sellerAccountName) {
        this.sellerAccountName = sellerAccountName;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalPaymentNum() {
        return totalPaymentNum;
    }

    public void setTotalPaymentNum(Integer totalPaymentNum) {
        this.totalPaymentNum = totalPaymentNum;
    }

    public BigDecimal getPayedAmount() {
        return payedAmount;
    }

    public void setPayedAmount(BigDecimal payedAmount) {
        this.payedAmount = payedAmount;
    }

    public Integer getPayedNum() {
        return payedNum;
    }

    public void setPayedNum(Integer payedNum) {
        this.payedNum = payedNum;
    }

    public BigDecimal getPaymentInterest() {
        return paymentInterest;
    }

    public void setPaymentInterest(BigDecimal paymentInterest) {
        this.paymentInterest = paymentInterest;
    }

    public String getBargainPath() {
        return bargainPath;
    }

    public void setBargainPath(String bargainPath) {
        this.bargainPath = bargainPath;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(String isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getGmtStart() {
        return gmtStart;
    }

    public void setGmtStart(Date gmtStart) {
        this.gmtStart = gmtStart;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

	public String getTakeAddress() {
		return takeAddress;
	}

	public void setTakeAddress(String takeAddress) {
		this.takeAddress = takeAddress;
	}

	public String getTakeContactMobile() {
		return takeContactMobile;
	}

	public void setTakeContactMobile(String takeContactMobile) {
		this.takeContactMobile = takeContactMobile;
	}

	public String getTakeContact() {
		return takeContact;
	}

	public void setTakeContact(String takeContact) {
		this.takeContact = takeContact;
	}

	public String getPurchaseStatus() {
		return purchaseStatus;
	}

	public void setPurchaseStatus(String purchaseStatus) {
		this.purchaseStatus = purchaseStatus;
	}

    public String getIDCard() {
        return IDCard;
    }

    public void setIDCard(String IDCard) {
        this.IDCard = IDCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
