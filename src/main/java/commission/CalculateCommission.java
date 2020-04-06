package commission;

/**
 * @author PC
 */
public class CalculateCommission {
    /**
     *
     * @param numberOfMainUnit 主机销售数量
     * @param numberOfDisplay 显示器销售数量
     * @param numberOfDevice 外设销售数量
     * @return 应得佣金数 浮点型 一位小数
     */
    public float calculateCommission(int numberOfMainUnit, int numberOfDisplay, int numberOfDevice){
        //定义主机、显示器、外设的价格
        final int priceOfMainUnit=25;
        final int priceOfDisplay=30;
        final int priceOfDevice=45;
        //总销售额变量
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
                //计算总销售额
                totalSold+=priceOfMainUnit*numberOfMainUnit+priceOfDisplay*numberOfDisplay+numberOfDevice*priceOfDevice;
                //计算佣金数量
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

    /**
     *
     * @param numberOfMainUnit 主机销售数量
     * @param numberOfDisplay 显示器销售数量
     * @param numberOfDevice 外设销售数量
     * @return 是否售出至少一台整机即三个参数均大于0 是：true 否：false
     */
    public boolean areLegalNumbers(int numberOfMainUnit,int numberOfDisplay,int numberOfDevice){
        return numberOfMainUnit > 0 && numberOfDisplay > 0 && numberOfDevice >0;
    }

    /**
     *
     * @param numberOfMainUnit 主机销售数量
     * @return 主机销售数量是否超过阈值70，是：true 否：false
     */
    public boolean isMainUnitOver(int numberOfMainUnit){
        return numberOfMainUnit>70;
    }

    /**
     *
     * @param numberOfDisplay 显示器销售数量
     * @return 显示器销售数量是否超过阈值80， 是：true 否：false
     */
    public boolean isDisplayOver(int numberOfDisplay){
        return numberOfDisplay>80;
    }

    /**
     *
     * @param numberOfDevice 外设销售数量
     * @return 外设销售数量是否超过阈值90， 是：true 否：false
     */
    public boolean isDeviceOver(int numberOfDevice){
        return numberOfDevice>90;
    }

    /**
     * 根据总销售额返回响应的佣金占比
     * @param totalSold 总销售额
     * @return 佣金的百分比
     */
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
