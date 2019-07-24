package com.jonlin.entity;

import com.jonlin.common.entity.BaseEntity;
import java.util.Date;

public class TransLadingBill extends BaseEntity {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.id
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.workflow_no
     *
     * @mbggenerated
     */
    private String workflowNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.vessel_voyage
     *
     * @mbggenerated
     */
    private String vesselVoyage;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.bill_of_lading_no
     *
     * @mbggenerated
     */
    private String billOfLadingNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.case_type_quantity
     *
     * @mbggenerated
     */
    private String caseTypeQuantity;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.starting_point
     *
     * @mbggenerated
     */
    private String startingPoint;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.destination
     *
     * @mbggenerated
     */
    private String destination;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.arrival_date
     *
     * @mbggenerated
     */
    private Date arrivalDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.trans_date
     *
     * @mbggenerated
     */
    private Date transDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.business_unit
     *
     * @mbggenerated
     */
    private String businessUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.entrusted_unit
     *
     * @mbggenerated
     */
    private String entrustedUnit;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.goods_name
     *
     * @mbggenerated
     */
    private String goodsName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.pieces
     *
     * @mbggenerated
     */
    private Integer pieces;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.weight
     *
     * @mbggenerated
     */
    private Double weight;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.shipping_company
     *
     * @mbggenerated
     */
    private String shippingCompany;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.quarantine_no
     *
     * @mbggenerated
     */
    private String quarantineNo;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.settle_mark
     *
     * @mbggenerated
     */
    private Integer settleMark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.closing_mark
     *
     * @mbggenerated
     */
    private Integer closingMark;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.create_by
     *
     * @mbggenerated
     */
    private String createBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.create_time
     *
     * @mbggenerated
     */
    private Date createTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.modify_by
     *
     * @mbggenerated
     */
    private String modifyBy;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column trans_lading_bill.modify_time
     *
     * @mbggenerated
     */
    private Date modifyTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trans_lading_bill
     *
     * @mbggenerated
     */
    public TransLadingBill(Integer id, String workflowNo, String vesselVoyage, String billOfLadingNo, String caseTypeQuantity, String startingPoint, String destination, Date arrivalDate, Date transDate, String businessUnit, String entrustedUnit, String goodsName, Integer pieces, Double weight, String shippingCompany, String quarantineNo, Integer settleMark, Integer closingMark, String createBy, Date createTime, String modifyBy, Date modifyTime) {
        this.id = id;
        this.workflowNo = workflowNo;
        this.vesselVoyage = vesselVoyage;
        this.billOfLadingNo = billOfLadingNo;
        this.caseTypeQuantity = caseTypeQuantity;
        this.startingPoint = startingPoint;
        this.destination = destination;
        this.arrivalDate = arrivalDate;
        this.transDate = transDate;
        this.businessUnit = businessUnit;
        this.entrustedUnit = entrustedUnit;
        this.goodsName = goodsName;
        this.pieces = pieces;
        this.weight = weight;
        this.shippingCompany = shippingCompany;
        this.quarantineNo = quarantineNo;
        this.settleMark = settleMark;
        this.closingMark = closingMark;
        this.createBy = createBy;
        this.createTime = createTime;
        this.modifyBy = modifyBy;
        this.modifyTime = modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table trans_lading_bill
     *
     * @mbggenerated
     */
    public TransLadingBill() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.id
     *
     * @return the value of trans_lading_bill.id
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.id
     *
     * @param id the value for trans_lading_bill.id
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.workflow_no
     *
     * @return the value of trans_lading_bill.workflow_no
     *
     * @mbggenerated
     */
    public String getWorkflowNo() {
        return workflowNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.workflow_no
     *
     * @param workflowNo the value for trans_lading_bill.workflow_no
     *
     * @mbggenerated
     */
    public void setWorkflowNo(String workflowNo) {
        this.workflowNo = workflowNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.vessel_voyage
     *
     * @return the value of trans_lading_bill.vessel_voyage
     *
     * @mbggenerated
     */
    public String getVesselVoyage() {
        return vesselVoyage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.vessel_voyage
     *
     * @param vesselVoyage the value for trans_lading_bill.vessel_voyage
     *
     * @mbggenerated
     */
    public void setVesselVoyage(String vesselVoyage) {
        this.vesselVoyage = vesselVoyage;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.bill_of_lading_no
     *
     * @return the value of trans_lading_bill.bill_of_lading_no
     *
     * @mbggenerated
     */
    public String getBillOfLadingNo() {
        return billOfLadingNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.bill_of_lading_no
     *
     * @param billOfLadingNo the value for trans_lading_bill.bill_of_lading_no
     *
     * @mbggenerated
     */
    public void setBillOfLadingNo(String billOfLadingNo) {
        this.billOfLadingNo = billOfLadingNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.case_type_quantity
     *
     * @return the value of trans_lading_bill.case_type_quantity
     *
     * @mbggenerated
     */
    public String getCaseTypeQuantity() {
        return caseTypeQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.case_type_quantity
     *
     * @param caseTypeQuantity the value for trans_lading_bill.case_type_quantity
     *
     * @mbggenerated
     */
    public void setCaseTypeQuantity(String caseTypeQuantity) {
        this.caseTypeQuantity = caseTypeQuantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.starting_point
     *
     * @return the value of trans_lading_bill.starting_point
     *
     * @mbggenerated
     */
    public String getStartingPoint() {
        return startingPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.starting_point
     *
     * @param startingPoint the value for trans_lading_bill.starting_point
     *
     * @mbggenerated
     */
    public void setStartingPoint(String startingPoint) {
        this.startingPoint = startingPoint;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.destination
     *
     * @return the value of trans_lading_bill.destination
     *
     * @mbggenerated
     */
    public String getDestination() {
        return destination;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.destination
     *
     * @param destination the value for trans_lading_bill.destination
     *
     * @mbggenerated
     */
    public void setDestination(String destination) {
        this.destination = destination;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.arrival_date
     *
     * @return the value of trans_lading_bill.arrival_date
     *
     * @mbggenerated
     */
    public Date getArrivalDate() {
        return arrivalDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.arrival_date
     *
     * @param arrivalDate the value for trans_lading_bill.arrival_date
     *
     * @mbggenerated
     */
    public void setArrivalDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.trans_date
     *
     * @return the value of trans_lading_bill.trans_date
     *
     * @mbggenerated
     */
    public Date getTransDate() {
        return transDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.trans_date
     *
     * @param transDate the value for trans_lading_bill.trans_date
     *
     * @mbggenerated
     */
    public void setTransDate(Date transDate) {
        this.transDate = transDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.business_unit
     *
     * @return the value of trans_lading_bill.business_unit
     *
     * @mbggenerated
     */
    public String getBusinessUnit() {
        return businessUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.business_unit
     *
     * @param businessUnit the value for trans_lading_bill.business_unit
     *
     * @mbggenerated
     */
    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.entrusted_unit
     *
     * @return the value of trans_lading_bill.entrusted_unit
     *
     * @mbggenerated
     */
    public String getEntrustedUnit() {
        return entrustedUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.entrusted_unit
     *
     * @param entrustedUnit the value for trans_lading_bill.entrusted_unit
     *
     * @mbggenerated
     */
    public void setEntrustedUnit(String entrustedUnit) {
        this.entrustedUnit = entrustedUnit;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.goods_name
     *
     * @return the value of trans_lading_bill.goods_name
     *
     * @mbggenerated
     */
    public String getGoodsName() {
        return goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.goods_name
     *
     * @param goodsName the value for trans_lading_bill.goods_name
     *
     * @mbggenerated
     */
    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.pieces
     *
     * @return the value of trans_lading_bill.pieces
     *
     * @mbggenerated
     */
    public Integer getPieces() {
        return pieces;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.pieces
     *
     * @param pieces the value for trans_lading_bill.pieces
     *
     * @mbggenerated
     */
    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.weight
     *
     * @return the value of trans_lading_bill.weight
     *
     * @mbggenerated
     */
    public Double getWeight() {
        return weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.weight
     *
     * @param weight the value for trans_lading_bill.weight
     *
     * @mbggenerated
     */
    public void setWeight(Double weight) {
        this.weight = weight;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.shipping_company
     *
     * @return the value of trans_lading_bill.shipping_company
     *
     * @mbggenerated
     */
    public String getShippingCompany() {
        return shippingCompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.shipping_company
     *
     * @param shippingCompany the value for trans_lading_bill.shipping_company
     *
     * @mbggenerated
     */
    public void setShippingCompany(String shippingCompany) {
        this.shippingCompany = shippingCompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.quarantine_no
     *
     * @return the value of trans_lading_bill.quarantine_no
     *
     * @mbggenerated
     */
    public String getQuarantineNo() {
        return quarantineNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.quarantine_no
     *
     * @param quarantineNo the value for trans_lading_bill.quarantine_no
     *
     * @mbggenerated
     */
    public void setQuarantineNo(String quarantineNo) {
        this.quarantineNo = quarantineNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.settle_mark
     *
     * @return the value of trans_lading_bill.settle_mark
     *
     * @mbggenerated
     */
    public Integer getSettleMark() {
        return settleMark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.settle_mark
     *
     * @param settleMark the value for trans_lading_bill.settle_mark
     *
     * @mbggenerated
     */
    public void setSettleMark(Integer settleMark) {
        this.settleMark = settleMark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.closing_mark
     *
     * @return the value of trans_lading_bill.closing_mark
     *
     * @mbggenerated
     */
    public Integer getClosingMark() {
        return closingMark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.closing_mark
     *
     * @param closingMark the value for trans_lading_bill.closing_mark
     *
     * @mbggenerated
     */
    public void setClosingMark(Integer closingMark) {
        this.closingMark = closingMark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.create_by
     *
     * @return the value of trans_lading_bill.create_by
     *
     * @mbggenerated
     */
    public String getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.create_by
     *
     * @param createBy the value for trans_lading_bill.create_by
     *
     * @mbggenerated
     */
    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.create_time
     *
     * @return the value of trans_lading_bill.create_time
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.create_time
     *
     * @param createTime the value for trans_lading_bill.create_time
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.modify_by
     *
     * @return the value of trans_lading_bill.modify_by
     *
     * @mbggenerated
     */
    public String getModifyBy() {
        return modifyBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.modify_by
     *
     * @param modifyBy the value for trans_lading_bill.modify_by
     *
     * @mbggenerated
     */
    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column trans_lading_bill.modify_time
     *
     * @return the value of trans_lading_bill.modify_time
     *
     * @mbggenerated
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column trans_lading_bill.modify_time
     *
     * @param modifyTime the value for trans_lading_bill.modify_time
     *
     * @mbggenerated
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}