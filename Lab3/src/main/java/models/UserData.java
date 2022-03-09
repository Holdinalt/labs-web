package models;

import dataBase.HitService;
import dataBase.HitStorageBD;
import factories.HitResultFactory;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "userData", eager = true)
@ApplicationScoped
public class UserData {
    String xValue = "";
    String yValue = "";
    String rValue = "";

    private HitResultFactory hitResultFactory = new HitResultFactory();
    private HitService hitService = new HitService();

    public void submitHitResult() {
        try {
            System.out.println("Запуск сабмита");
            HitResult hitResult = hitResultFactory.createHitResult(xValue, yValue, rValue);
            System.out.println(hitResult);
            hitService.saveHit(new HitStorageBD(hitResult));
            System.out.println("Я закончил!");

        }catch (Exception e){
            System.out.println("submit result problem");
        }
    }

    public void setyValue(String yValue) {
        this.yValue = yValue;
    }

    public String getxValue() {
        return xValue;
    }

    public String getyValue() {
        return yValue;
    }

    public String getrValue() {
        return rValue;
    }

    public void setxValue(String xValue) {
        this.xValue = xValue;
    }

    public void setrValue(String rValue) {
        this.rValue = rValue;
    }
}
