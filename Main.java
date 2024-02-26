package btvn22;

import java.util.*;
import java.text.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ProductManager productManager = new ProductManager();

		Category electronicsCategory = new Category("Điện tử");
		Category clothingCategory = new Category("Thời trang");
		Category foodCategory = new Category("Thực phẩm");

		int choice;
		do {
			System.out.println("Menu:");
			System.out.println("1. Phương thức tạo mới 1 Product");
			System.out.println("2. Phương thức sửa thông tin 1 Product theo id");
			System.out.println("3. Phương thức xóa 1 Product theo id");
			System.out.println("4. Hiển thị 1 Product theo id");
			System.out.println("5. Hiển thị tất cả Product");
			System.out.println("6. Hiển thị tất cả Product theo 1 Category");
			System.out.println("7. Tính tổng tiền của các Product hiện có");
			System.out.println("8. Hiển thị các Product có giá tiền > 100000");
			System.out.println("9. Hiển thị các Product có giá tiền > 200000 và có Category là \"Điện tử\"");
			System.out.println("0. Thoát");

			System.out.print("Nhập lựa chọn của bạn: ");
			try {
				choice = sc.nextInt();
				sc.nextLine();

				switch (choice) {
				case 1:
					try {
						System.out.print("Nhập id sản phẩm mới: ");
						Long newId = sc.nextLong();
						sc.nextLine();
						System.out.print("Nhập tên sản phẩm mới: ");
						String newName = sc.nextLine();
						System.out.print("Nhập giá sản phẩm mới: ");
						Double newPrice = sc.nextDouble();
						System.out.print("Nhập số lượng sản phẩm mới: ");
						Integer newQuantity = sc.nextInt();
						System.out.print("Nhập tên danh mục sản phẩm mới: ");
						String newCategoryName = sc.next();
						Category newCategory = new Category(newCategoryName);

						productManager.addProduct(new Product(newName, newId, newPrice, newQuantity, newCategory));
						System.out.println("Thông tin sản phẩm đã được thêm thành công.");

					} catch (Exception e) {
						System.out.println("Dữ liệu nhập vào không hợp lệ.");
						sc.nextLine();
					}
					break;
				case 2:
					System.out.print("Nhập id sản phẩm cần sửa thông tin: ");
					Long idToUpdate = sc.nextLong();
					sc.nextLine();

					System.out.print("Nhập tên sản phẩm mới: ");
					String newName = sc.nextLine();
					System.out.print("Nhập giá sản phẩm mới: ");
					Double newPrice = sc.nextDouble();
					System.out.print("Nhập số lượng sản phẩm mới: ");
					Integer newQuantity = sc.nextInt();
					System.out.print("Nhập tên danh mục sản phẩm mới: ");
					String newCategoryName = sc.next();
					Category newCategory = new Category(newCategoryName);
					productManager.updateProduct(idToUpdate, newName, newPrice, newQuantity, newCategory);
					System.out.println("Thông tin sản phẩm đã được cập nhật thành công.");
					break;

				case 3:
					System.out.print("Nhập id sản phẩm cần xóa: ");
					Long idToDelete = sc.nextLong();
					sc.nextLine();
					productManager.deleteProduct(idToDelete);
					System.out.println("Sản phẩm đã được xóa thành công.");
					break;

				case 4:
					System.out.print("Nhập id sản phẩm cần hiển thị: ");
					Long idToDisplay = sc.nextLong();
					sc.nextLine();
					Product product = productManager.getProductById(idToDisplay);
					if (product != null) {
						System.out.println(product.id + " - " + product.name + " - " + product.price + " - "
								+ product.quantity + " - " + product.category.name);
					} else {
						System.out.println("Không tìm thấy sản phẩm với id đã nhập.");
					}
					break;

				case 5:
					productManager.displayAllProducts();
					break;

				case 6:
					System.out.print("Nhập tên danh mục sản phẩm cần hiển thị: ");
					String categoryName = sc.nextLine();
					productManager.displayProductsByCategory(categoryName);
					break;

				case 7:
					NumberFormat currencyFormatter = NumberFormat.getCurrencyInstance(Locale.forLanguageTag("vi-VN"));
					double totalPrice = productManager.calculateTotalPrice();
					String formattedTotalPrice = currencyFormatter.format(totalPrice);
					System.out.println("Tổng tiền của các sản phẩm hiện có là: " + formattedTotalPrice);
					break;
				case 8:
					productManager.displayProductsAbovePrice(100000.0);
					break;

				case 9:
					productManager.displayProductsAbovePriceAndCategory(200000.0, "Điện tử");
					break;
				}
			} catch (Exception e) {
				System.out.println("Lựa chọn phải là một số nguyên.");
				sc.nextLine();
				choice = -1;
			}
		} while (choice != 0);
		sc.close();
	}
}


