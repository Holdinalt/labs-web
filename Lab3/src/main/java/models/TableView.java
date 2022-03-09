package models;

import dataBase.HitService;
import dataBase.HitStorageBD;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class TableView {

    private HitService hitService;

    public TableView(){
         hitService = new HitService();
    }

    public List<HitStorageBD> getHitResultList() throws Exception {
        List<HitStorageBD> hitList = null;

        hitList = hitService.findAllHits();
        return hitList;
    }

    public void clearTable() throws Exception {
        hitService.deleteAllHits();

    }
}

