package com.zgp.domain;

import java.math.BigDecimal;

public class Dingdan {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dingdan.oid
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    private String oid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dingdan.ordertime
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    private String ordertime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dingdan.total
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    private BigDecimal total;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dingdan.status
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    private Integer status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dingdan.address
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    private String address;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dingdan.uid
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    private String uid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dingdan.oid
     *
     * @return the value of dingdan.oid
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public String getOid() {
        return oid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dingdan.oid
     *
     * @param oid the value for dingdan.oid
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public void setOid(String oid) {
        this.oid = oid == null ? null : oid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dingdan.ordertime
     *
     * @return the value of dingdan.ordertime
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public String getOrdertime() {
        return ordertime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dingdan.ordertime
     *
     * @param ordertime the value for dingdan.ordertime
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public void setOrdertime(String ordertime) {
        this.ordertime = ordertime == null ? null : ordertime.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dingdan.total
     *
     * @return the value of dingdan.total
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dingdan.total
     *
     * @param total the value for dingdan.total
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dingdan.status
     *
     * @return the value of dingdan.status
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dingdan.status
     *
     * @param status the value for dingdan.status
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dingdan.address
     *
     * @return the value of dingdan.address
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dingdan.address
     *
     * @param address the value for dingdan.address
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dingdan.uid
     *
     * @return the value of dingdan.uid
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public String getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dingdan.uid
     *
     * @param uid the value for dingdan.uid
     *
     * @mbggenerated Tue Jun 27 12:37:16 CST 2017
     */
    public void setUid(String uid) {
        this.uid = uid == null ? null : uid.trim();
    }
}