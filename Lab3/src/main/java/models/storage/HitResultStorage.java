package models.storage;

import models.HitResult;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class HitResultStorage implements Storagable{

    private final List<HitResult> hitResultList;

    public HitResultStorage(){
        hitResultList = new CopyOnWriteArrayList<HitResult>();
    }

    public void clearHitResults() {
        hitResultList.clear();
    }

    @Override
    public void addHitResult(HitResult hitResult){
        hitResultList.add(hitResult);
    }

    @Override
    public List<HitResult> getHitResultList() {
        return new CopyOnWriteArrayList<HitResult>(hitResultList);
    }

}
