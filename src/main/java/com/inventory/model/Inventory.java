package com.inventory.model;

import com.inventory.dto.EditInventoryRequestDto;
import com.inventory.dto.InventoryParamsDto;
import com.inventory.exception.InvalidCategoryException;
import com.inventory.exception.InventoryManagementException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Inventory {
    private String id;
    private String name;
    //    private List<Catalogue> catalogues;
    // category to list of products
    private Map<String, List<Product>> catalogProducts;
    // product id to product
    private Map<String, Product> productMap;

    public Inventory(final String id, final String name) {
        this.id = id;
        this.name = name;
        this.catalogProducts = new HashMap<>();
        this.productMap = new HashMap<>();
    }

    private boolean validateModifyProductRequest(EditInventoryRequestDto dto) {
        // TODO : check category exists or not


        // TODO : product exists in diffeent category already

        String productName = dto.getProductName();

//        catalogProducts.keySet().stream().
//        final List<String> productList =
//catalogProducts.st
//                catalogProducts.entrySet().stream().filter(p->p.getValue().stream().filter(q->q.getName().compareTo(productName)!=0)).count();
//                v.getP.getName().compareTo(productName) > 0).collect(Collectors.toList());

        return true;
    }

    private boolean validateCategory(String categoryName){
        switch (Category.valueOf(name)){
            case ELECTRONICS:
                break;
            case APPAREL:
                break;
            default:
                throw new InvalidCategoryException();
        }
        return true;
    }
    private boolean validateAddProductRequest(InventoryParamsDto dto) {
        // TODO : check category exists or not

        String categoryName = dto.getCategory().name();
//        validateCategory(categoryName);
        String productName = dto.getProductName();


        // TODO : product exists in diffeent category already


        // TODO: if product already exists throw exception

        final List<Product> products = catalogProducts.get(categoryName);
        if(products!=null) {
            final List<Product> productList = products.stream().filter(p -> p.getName()==(productName)).collect(Collectors.toList());

            if (productList != null && productList.size()>0) {
                throw new InventoryManagementException("Product already exists in the inventory");
            }


        }
        return true;
    }

    public String addProduct(InventoryParamsDto inventoryParamsDto) {

        Category category = inventoryParamsDto.getCategory();
        String productId = inventoryParamsDto.getProductId();
        String productName = inventoryParamsDto.getProductName();
        int productCount = inventoryParamsDto.getProductCount();

        // TODO : validate product request

        validateAddProductRequest(inventoryParamsDto);
        final Product product = new Product(productId, productName, category, productCount);

        productMap.put(productName, product);
        final List<Product> productList = catalogProducts.getOrDefault(category.name(), new ArrayList<>());
        productList.add(product);

        catalogProducts.put(category.name(), productList);
        return productName;
    }

    public void modifyProduct(EditInventoryRequestDto dto) {

        String productName = dto.getProductName();
        int productCount = dto.getQuantity();

        validateModifyProductRequest(dto);

        final Product product = productMap.get(productName);
        if (product != null) {
            product.setInStockQuantity(productCount);
        }
    }

    public void deleteProduct(String productName) {

        final Product product = productMap.get(productName);
        if (product != null) {
            Category category = product.getCategory();
            final List<Product> list = catalogProducts.get(category.name());
            final List<Product> updatedList = new ArrayList<>();
            for (Product p : list) {
                if (p.getName().compareTo(productName) != 0) {
                    updatedList.add(p);
                }
            }
            catalogProducts.put(category.name(), updatedList);
            productMap.remove(productName);
        }
    }

    // checking with starts keyword
    public List<Product> searchByKeyword(String startKeyword) {
        List<Product> productList = new ArrayList<>();
        for (Map.Entry<String, Product> productEntry : productMap.entrySet()) {
            if (productEntry.getKey().contains(startKeyword)) {
                productList.add(productEntry.getValue());
            }
        }

        return productList;
    }
}
