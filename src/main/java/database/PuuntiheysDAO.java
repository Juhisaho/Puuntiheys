package database;


import model.Puuntiheys;
import java.util.List;

public interface PuuntiheysDAO
{
    public List<Puuntiheys> getAll();
    
    public Puuntiheys getItem(int id);
    
    public boolean addItem(Puuntiheys levy);
    
    public boolean removeItem(Puuntiheys levy);
}