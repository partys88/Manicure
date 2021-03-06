package com.manicure.technician.entity;

public class Technician {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column technician.id
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column technician.name
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column technician.orders
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    private Long orders;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column technician.comment
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    private Integer comment;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column technician.manner
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    private Integer manner;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column technician.pro
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    private Integer pro;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column technician.id
     *
     * @return the value of technician.id
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column technician.id
     *
     * @param id the value for technician.id
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column technician.name
     *
     * @return the value of technician.name
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column technician.name
     *
     * @param name the value for technician.name
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column technician.orders
     *
     * @return the value of technician.orders
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public Long getOrders() {
        return orders;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column technician.orders
     *
     * @param orders the value for technician.orders
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public void setOrders(Long orders) {
        this.orders = orders;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column technician.comment
     *
     * @return the value of technician.comment
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public Integer getComment() {
        return comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column technician.comment
     *
     * @param comment the value for technician.comment
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public void setComment(Integer comment) {
        this.comment = comment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column technician.manner
     *
     * @return the value of technician.manner
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public Integer getManner() {
        return manner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column technician.manner
     *
     * @param manner the value for technician.manner
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public void setManner(Integer manner) {
        this.manner = manner;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column technician.pro
     *
     * @return the value of technician.pro
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public Integer getPro() {
        return pro;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column technician.pro
     *
     * @param pro the value for technician.pro
     *
     * @mbggenerated Wed Jul 22 21:29:50 CST 2015
     */
    public void setPro(Integer pro) {
        this.pro = pro;
    }
}