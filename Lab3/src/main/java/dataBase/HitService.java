package dataBase;


import java.util.List;


public class HitService{

    HitDao hitDao;

    public HitService() {
        hitDao = new HitDao();
    }

    public HitStorageBD findHit(int id) {
        return hitDao.findById(id);
    }

    public void saveHit(HitStorageBD hit) {
        hitDao.save(hit);
    }

    public void deleteHit(HitStorageBD hit) {
        hitDao.delete(hit);
    }

    public void updateHit(HitStorageBD hit) {
        hitDao.update(hit);
    }

    public List<HitStorageBD> findAllHits() throws Exception {
        return hitDao.findAll();
    }

    public void deleteAllHits() throws Exception {
        hitDao.deleteAll();
    }

}
