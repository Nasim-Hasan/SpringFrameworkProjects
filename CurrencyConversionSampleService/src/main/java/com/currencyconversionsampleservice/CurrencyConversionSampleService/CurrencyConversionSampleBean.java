package com.currencyconversionsampleservice.CurrencyConversionSampleService;

import java.math.BigDecimal;

public class CurrencyConversionSampleBean {
    // We need to set all the fields that is going to
    // received in response
    private Long id;
    private String from;
    private String to;
    private BigDecimal ConversionMultiple;
    private BigDecimal quantity;
    private BigDecimal totalCalculatedAmount;
    private int port;

    // default constructor
    public CurrencyConversionSampleBean() {}

    // creating constructor
    public CurrencyConversionSampleBean(
            Long id, String from, String to,
            BigDecimal conversionMultiple, BigDecimal quantity,
            BigDecimal totalCalculatedAmount, int port)
    {
        super();
        this.id = id;
        this.from = from;
        this.to = to;
        ConversionMultiple = conversionMultiple;
        this.quantity = quantity;
        this.totalCalculatedAmount = totalCalculatedAmount;
        this.port = port;
    }

    // creating setters and getters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getFrom() { return from; }

    public void setFrom(String from) { this.from = from; }

    public String getTo() { return to; }

    public void setTo(String to) { this.to = to; }

    public BigDecimal getConversionMultiple()
    {
        return ConversionMultiple;
    }

    public void
    setConversionMultiple(BigDecimal conversionMultiple)
    {
        ConversionMultiple = conversionMultiple;
    }

    public BigDecimal getQuantity() { return quantity; }

    public void setQuantity(BigDecimal quantity)
    {
        this.quantity = quantity;
    }

    public BigDecimal getTotalCalculatedAmount()
    {
        return totalCalculatedAmount;
    }

    public void setTotalCalculatedAmount(
            BigDecimal totalCalculatedAmount)
    {
        this.totalCalculatedAmount = totalCalculatedAmount;
    }

    public int getPort() { return port; }

    public void setPort(int port) { this.port = port; }
}
