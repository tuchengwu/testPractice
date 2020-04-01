package commission;

/**
 * @author PC
 */
public class CaculateCommission {
    public float caculateCommission(int numberOfMainUnit,int numberOfDisplay,int numberOfDevice){
        final int priceOfMainUnit=25;
        final int priceOfDisplay=30;
        final int priceOfDevice=45;
        int totalSold=0;
        float result=0.0f;
        if(areLegalNumbers(numberOfMainUnit, numberOfDisplay, numberOfDevice)){
            if(isMainUnitOver(numberOfMainUnit)){
                System.out.println("主机销售量超过上限");
                return totalSold;
            }
            else if(isDisplayOver(numberOfDisplay)){
                System.out.println("显示器销售量超过上限");
                return totalSold;
            }
            else if(isDeviceOver(numberOfDevice)){
                System.out.println("外设销售量超过上限");
                return totalSold;
            }
            else
            {
                totalSold+=priceOfMainUnit*numberOfMainUnit+priceOfDisplay*numberOfDisplay+numberOfDevice*priceOfDevice;
                result=totalSold*getPercent(totalSold);
                return result;
            }
        }
        else {
            System.out.println("未完成销售至少一台主机");
            result=0;
            return result;
        }

    }
    public boolean areLegalNumbers(int numberOfMainUnit,int numberOfDisplay,int numberOfDevice){
        return numberOfMainUnit > 0 && numberOfDisplay > 0 && numberOfDevice >0;
    }
    public boolean isMainUnitOver(int numberOfMainUnit){
        return numberOfMainUnit>70;
    }
    public boolean isDisplayOver(int numberOfDisplay){
        return numberOfDisplay>80;
    }
    public boolean isDeviceOver(int numberOfDevice){
        return numberOfDevice>90;
    }
    public float getPercent(int totalSold){
        if(totalSold<=1000){
            return (float) 0.1;
        }
        else if(totalSold<=1800){
            return (float) 0.15;
        }
        else {
            return (float) 0.2;
        }
    }
}
