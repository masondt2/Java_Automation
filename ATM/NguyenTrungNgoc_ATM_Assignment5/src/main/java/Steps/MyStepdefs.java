package Steps;

import Pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;

public class MyStepdefs {
    HomePage homePage = new HomePage();
    DanhMucPage danhMucPage = new DanhMucPage();
    LaptopMayViTinhPage laptopMayViTinhPage = new LaptopMayViTinhPage();
    ProductDetailPage productDetailPage = new ProductDetailPage();
    DienThoaiMayTinhBangPage dienThoaiMayTinhBangPage = new DienThoaiMayTinhBangPage();
    LocSanPhamPage locSanPhamPage = new LocSanPhamPage();


    @Given("Open TIKI application successfully")
    public void openTIKIApplicationSuccessfully() {
        homePage.acceptAllowPopup();
    }

    @When("Click to Danh Muc San Pham")
    public void clickToDanhMucSanPham() {
        homePage.clickToDanhMucSanPham();
    }

    @And("Scroll to Laptop – May Vi Tinh at Right category")
    public void scrollToLaptopMayViTinh() {
        danhMucPage.scrolToLaptopMayViTinh();
    }

    @And("Click to Laptop – May Vi Tinh at Right category")
    public void clickToLaptopMayViTinh() {
        danhMucPage.clickToLaptopMayViTinh();
    }

    @And("Click to Hang moi")
    public void clickToHangMoi() {
        laptopMayViTinhPage.clickToHangMoi();
    }

    @And("Click to the first Laptop May Vi Tinh product")
    public void clickToFirstProduct() {
        laptopMayViTinhPage.clickToFirstProductImage();
    }

    @Then("Verify the product name, product price of first product should be displayed")
    public void verifyFirstProductDisplay() {
        Assert.assertTrue(productDetailPage.verifyFirstProductDisplay());
    }

    @And("Click to Điện thoại – Máy tính bảng at Right category")
    public void clickToDienThoaiMayTinhBang() {
        danhMucPage.clickToDienthoaimaytinhbang();
    }

    @And("Click to the Lọc button")
    public void clickToTheLocButton() {
        dienThoaiMayTinhBangPage.clickToTheLocButton();
    }


    @And("Scroll to Thương hiệu")
    public void scrollToThuongHieu() {
        locSanPhamPage.scrollToThuongHieu();
    }

    @And("Select Samsung")
    public void selectSamsung() {
        locSanPhamPage.selectSamsung();
    }

    @And("Click to Áp Dụng button")
    public void clickToApDungButton() {
        locSanPhamPage.clickToApDungButton();
    }

    @And("Click to the first Dien Thoai May Tinh Bang product")
    public void clickToTheFirstDienThoaiMayTinhBangProduct() {
        dienThoaiMayTinhBangPage.clickToTheFirstDienThoaiMayTinhBangProduct();
    }
}
