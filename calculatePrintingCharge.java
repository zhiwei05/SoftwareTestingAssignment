package application;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class calculatePrintingCharge {

    private printerAvailability printerService;
    private applyDiscount discountService;

    public calculatePrintingCharge(printerAvailability printerService, applyDiscount discountService) {
        this.printerService = printerService;
        this.discountService = discountService;
    }

    public double calculateBaseCharge(String paperSize, String printType, String side, int pages, int copies) {
        double rate = 0.0;
        
        if (paperSize.equalsIgnoreCase("A4")) {
            if (printType.equalsIgnoreCase("Black & White")) 
                rate = side.equalsIgnoreCase("Single-sided") ? 0.20 : 0.18;
            else 
                rate = side.equalsIgnoreCase("Single-sided") ? 0.80 : 0.75;
        } else if (paperSize.equalsIgnoreCase("A3")) {
            if (printType.equalsIgnoreCase("Black & White")) 
                rate = side.equalsIgnoreCase("Single-sided") ? 0.40 : 0.35;
            else 
                rate = side.equalsIgnoreCase("Single-sided") ? 1.50 : 1.40;
        } else if (paperSize.equalsIgnoreCase("A5")) {
            if (printType.equalsIgnoreCase("Black & White")) 
                rate = side.equalsIgnoreCase("Single-sided") ? 0.15 : 0.13;
            else 
                rate = side.equalsIgnoreCase("Single-sided") ? 0.60 : 0.55;
        } else {
            throw new IllegalArgumentException("Unknown paper size or print type");
        }
        return rate * pages * copies;
    }

    public double calculateOptionalServiceCharge(String binding, boolean lam, boolean express, int pages, int copies) {
        double cost = 0.0;
        
        if (binding.equalsIgnoreCase("Staple")) cost += 2.00;
        else if (binding.equalsIgnoreCase("Comb")) cost += 5.00;
        else if (binding.equalsIgnoreCase("Spiral")) cost += 8.00;
        else if (!binding.equalsIgnoreCase("None")) {
            throw new IllegalArgumentException("Invalid binding option provided");
        }

        if (lam) cost += (1.50 * pages * copies); 
        if (express) cost += 20.00;
        
        return cost;
    }

    public double calculateTotalCharge(printOrder order) {

        if (!printerService.isPrinterAvailable(order.getPaperSize(), order.getPrintType())) {
            System.out.println("Selected printer is currently unavailable.");
            return -1.0;
        }

        double base = calculateBaseCharge(order.getPaperSize(), order.getPrintType(), order.getPrintingSide(), order.getNumberOfPages(), order.getNumberOfCopies());
        double opt = calculateOptionalServiceCharge(order.getBindingOption(), order.isLamination(), order.isExpressPrinting(), order.getNumberOfPages(), order.getNumberOfCopies());
        
        double subtotal = base + opt;

        boolean over300 = subtotal > 300.0;
        boolean loyal = order.getCustomer().getPreviousOrders() > 20;
        double discountedTotal = discountService.applyDiscount(order.getCustomer().getCustomerType(), subtotal, over300, loyal);

        BigDecimal bd = new BigDecimal(discountedTotal).setScale(2, RoundingMode.HALF_UP);
        double finalRoundedTotal = bd.doubleValue();

        order.setBaseCharge(base);
        order.setOptionalServiceCharge(opt);
        order.setDiscountAmount(subtotal - finalRoundedTotal);
        order.setTotalCharge(finalRoundedTotal);

        return finalRoundedTotal;
    }
}