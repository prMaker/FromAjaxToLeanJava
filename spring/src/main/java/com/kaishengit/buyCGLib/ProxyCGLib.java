package com.kaishengit.buyCGLib;

/**
 * Created by Administrator on 2016/7/1.
 */
public class ProxyCGLib extends BuyCGLib{

    @Override
    public String buy(Integer money) {
        String food = null;
        try{
            System.out.println("前置通知~~~~~~");
            super.buy(money);
            System.out.println("后置通知~~~~~");
        }catch (Exception e){
            System.out.println("异常通知~~~~~~");
        }finally {
            System.out.println("异常通知~~~~~~~~~");
        }
        return food;
    }
}
