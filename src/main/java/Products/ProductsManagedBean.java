package Products;

import entity.Products;
import facade.ProductsFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "productsManagedBean")
@SessionScoped
public class ProductsManagedBean implements Serializable {

    private String name;
    private int price;
    private int pquantity;
    private List<Products> _productsList;
    private Products prod;

    @Inject
    ProductsFacadeLocal productsFacadeLocal;

    @PostConstruct
    private void init() {
        _productsList = productsFacadeLocal.findAll();
    }

    public ProductsManagedBean() {

    }

    public Products getProd() {
        return prod;
    }

    public void setProd(Products prod) {
        this.prod = prod;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return pquantity;
    }

    public void setQuantity(int quantity) {
        this.pquantity = quantity;
    }


    public List<Products> getProductsList() {
        return _productsList;
    }

    public void setProductsList(List<Products> _productsList) {
        this._productsList = _productsList;
    }

    public String add(int id) {
        for (Products product : _productsList) {
            if (!product.getProductName().equals(name) && !(product.getProductId() == id)) {
                prod = new Products(name, price, pquantity);
                productsFacadeLocal.create(prod);
            }
        }
        return "user";
    }

    public String delete(int id) {

        System.out.println("....delete....");
        Products product = productsFacadeLocal.find(id);
        productsFacadeLocal.remove(product);
        return "user";

    }

    public String update(int quantity) {

        System.out.println("....update....");
        for (Products product : _productsList) {
            if (product.getProductName().equals(name) && !(product.getQuantity() == pquantity)) {
                Products produ = new Products(name, price, pquantity);
                productsFacadeLocal.edit(produ);

            }
        }
        return "user";
    }
}

