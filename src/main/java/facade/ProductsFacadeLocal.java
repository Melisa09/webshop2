
package facade;

import entity.Products;
import java.util.List;
import javax.ejb.Local;


@Local
public interface ProductsFacadeLocal {

    void create(Products products);

    void edit(Products products);

    void remove(Products products);

    Products find(Object id);

    List<Products> findAll();
    
    List<Products> findRange(int[] range);

    int count();
    
}
