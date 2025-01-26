package AssignmentFinal;

public class DiscountRate {
    //Service discount
    private static final double serviceDiscountPremium = 0.2;
    private static final double serviceDiscountGold = 0.15;
    private static final double serviceDiscountSilver = 0.1;

    //Product discount
    private static final double flatRate = 0.1;
    private static final double productDiscountPremium = flatRate;
    private static final double productDiscountGold = flatRate;
    private static final double productDiscountSilver = flatRate;

    public static double getServiceDiscountRate(String memberType){
        switch (memberType) {
            case "Premium":
                return serviceDiscountPremium;
            case "Gold":
                return serviceDiscountGold;
            case "Silver":
                return serviceDiscountSilver;
            default:
                return 0.0;
        }
    }

    public static double getProductDiscountRate(String memberType){
        switch (memberType) {
            case "Premium":
                return productDiscountPremium;
            case "Gold":
                return productDiscountGold;
            case "Silver":
                return productDiscountSilver;
            default:
                return 0.0;
        }
    }
}
