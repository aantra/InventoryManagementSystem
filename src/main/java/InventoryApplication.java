import com.inventory.dto.EditInventoryRequestDto;
import com.inventory.dto.InventoryParamsDto;
import com.inventory.model.Category;
import com.inventory.model.Product;
import com.inventory.service.InventoryManagementService;
import com.inventory.service.InventorySearchService;

import java.util.List;

public class InventoryApplication {
    public static void main(String[] args) {


        // Inventory Management Service
        InventoryManagementService service = new InventoryManagementService("BIGBAZAR", "BIGBAZAR");

        service.addInventory(InventoryParamsDto.builder()
                .category(Category.ELECTRONICS)
                .productName("Redmi 10")
                .productId("Redmi 10")
                .productCount(10)
                .build());

        service.addInventory(InventoryParamsDto.builder()
                .category(Category.ELECTRONICS)
                .productName("Redmi 11")
                .productId("Redmi 11")
                .productCount(2)
                .build());

        service.addInventory(InventoryParamsDto.builder()
                .category(Category.APPAREL)
                .productName("Levis regular jeans")
                .productId("Levis regular jeans")
                .productCount(5)
                .build());


        service.addInventory(InventoryParamsDto.builder()
                .category(Category.APPAREL)
                .productName("Lee Cooper jeans")
                .productId("Lee Cooper jeans")
                .productCount(15)
                .build());



        service.addInventory(InventoryParamsDto.builder()
                .category(Category.ELECTRONICS)
                .productName("iPhone 12")
                .productId("iPhone 12")
                .productCount(29)
                .build());


        // For Search Service
        InventorySearchService userSearchService = service.getUserSearchService();

        List<Product> productList;

        // Search Operation for Product with starting keyword
        productList = userSearchService.searchByKeyword("Redmi");
        System.out.println(productList);

        // Modifying Redmi 10 quantity
        service.modifyInventory(EditInventoryRequestDto.builder()
                .productName("Redmi 10")
                .quantity(177)
                .build());


        productList = userSearchService.searchByKeyword("Redmi 10");
        System.out.println(productList);

        // Search for products starting with Red
        productList = userSearchService.searchByKeyword("Red");
        System.out.println(productList);

        // Delete Redmi 11 from inventory
        service.deleteInventory("Redmi 11");
        // Confirming there is no product for Redmi 11
        productList = userSearchService.searchByKeyword("Redmi 11");
        System.out.println(productList);

        // Search for products starting with Lee
        productList = userSearchService.searchByKeyword("Lee");
        System.out.println(productList);

        // Search for products starting with Red
        productList = userSearchService.searchByKeyword("Cooper");
        System.out.println(productList);


    }
}
