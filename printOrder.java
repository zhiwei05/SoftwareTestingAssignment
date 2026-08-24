package application;

public class printOrder {
    private customer customer;
    private String printType;
    private String paperSize;
    private String printingSide;
    private int numberOfPages;
    private int numberOfCopies;
    private String bindingOption;
    private boolean lamination;
    private boolean expressPrinting;

    private double baseCharge;
    private double optionalServiceCharge;
    private double discountAmount;
    private double totalCharge;
    private String orderStatus;

    public printOrder(customer customer, String printType, String paperSize,
                      String printingSide, int numberOfPages, int numberOfCopies,
                      String bindingOption, boolean lamination, boolean expressPrinting) {
        
        if (numberOfPages < 1 || numberOfPages > 500) {
            throw new IllegalArgumentException("Pages must be between 1 and 500");
        }
        if (numberOfCopies < 1 || numberOfCopies > 1000) {
            throw new IllegalArgumentException("Copies must be between 1 and 1000");
        }

        this.customer = customer;
        this.printType = printType;
        this.paperSize = paperSize;
        this.printingSide = printingSide;
        this.numberOfPages = numberOfPages;
        this.numberOfCopies = numberOfCopies;
        this.bindingOption = bindingOption;
        this.lamination = lamination;
        this.expressPrinting = expressPrinting;
        this.orderStatus = "Pending";
    }

    public customer getCustomer() { 
        
        return customer; 
    }
    public String getPrintType() { 

        return printType; 
    }
    public String getPaperSize() { 
        
        return paperSize; 
    }
    public String getPrintingSide() { 
        
        return printingSide; 
    }
    public int getNumberOfPages() { 

        return numberOfPages; 
    }
    public int getNumberOfCopies() { 
        
        return numberOfCopies; 
    }
    public String getBindingOption() { 
        
        return bindingOption; 
    }
    public boolean isLamination() { 
        
        return lamination; 
    }
    public boolean isExpressPrinting() { 
        
        return expressPrinting; 
    }

    public void setBaseCharge(double v) { 
        
        this.baseCharge = v; 
    }
    public void setOptionalServiceCharge(double v) { 
        
        this.optionalServiceCharge = v; 
    }
    public void setDiscountAmount(double v) { 
        
        this.discountAmount = v; 
    }
    public void setTotalCharge(double v) { 
        
        this.totalCharge = v; 
    }
    
    public double getBaseCharge() { 
        
        return baseCharge; 
    }
    public double getOptionalServiceCharge() { 
        
        return optionalServiceCharge; 
    }
    public double getDiscountAmount() { 
        
        return discountAmount; 
    }
    public double getTotalCharge() { 
        
        return totalCharge; 
    }
}