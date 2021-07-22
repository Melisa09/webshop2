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

    private Integer productId;
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

    public int getPquantity() {
        return pquantity;
    }

    public void setPquantity(int pquantity) {
        this.pquantity = pquantity;
    }

    public List<Products> getProductsList() {
        return _productsList;
    }

    public void setProductsList(List<Products> _productsList) {
        this._productsList = _productsList;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String add() {

        Products product = new Products(name, price, pquantity);
        productsFacadeLocal.create(product);
        init();
        return "admin";
    }

    public String delete(Integer productId) {

        Products product = productsFacadeLocal.find(productId);
        productsFacadeLocal.remove(product);
        init();
        return "admin";
    }
}
