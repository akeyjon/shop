package com.miaoshashop.miaoshashop.dataobject;

public class ItemDO {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.id
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.title
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.price
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    private Double price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.sales
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    private Integer sales;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.desription
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    private String desription;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column item.imge_url
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    private String imgeUrl;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.id
     *
     * @return the value of item.id
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.id
     *
     * @param id the value for item.id
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.title
     *
     * @return the value of item.title
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.title
     *
     * @param title the value for item.title
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.price
     *
     * @return the value of item.price
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public Double getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.price
     *
     * @param price the value for item.price
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.sales
     *
     * @return the value of item.sales
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public Integer getSales() {
        return sales;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.sales
     *
     * @param sales the value for item.sales
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public void setSales(Integer sales) {
        this.sales = sales;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.desription
     *
     * @return the value of item.desription
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public String getDesription() {
        return desription;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.desription
     *
     * @param desription the value for item.desription
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public void setDesription(String desription) {
        this.desription = desription == null ? null : desription.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column item.imge_url
     *
     * @return the value of item.imge_url
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public String getImgeUrl() {
        return imgeUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column item.imge_url
     *
     * @param imgeUrl the value for item.imge_url
     *
     * @mbg.generated Sat Mar 23 23:44:06 CST 2019
     */
    public void setImgeUrl(String imgeUrl) {
        this.imgeUrl = imgeUrl == null ? null : imgeUrl.trim();
    }
}