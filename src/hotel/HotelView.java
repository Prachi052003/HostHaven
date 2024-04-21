package hotel;

public class HotelView {

    public LoginPage loginPage;
    public CustomerAdminPage customerAdminPage;
    public SignupPage signupPage;

    public CustomerRestaurant customerRestaurant;
    public CustomerRoom customerRoom;

    public AdminForm adminForm;
    public AddDishes addDishes;
    public AddRooms addRooms;

    public HotelView() {
        loginPage = new LoginPage();
        signupPage = new SignupPage();
    }

    public void showLoginPage() {
        loginPage.show();
    }

    public void showSignupPage() {
        signupPage.show();
    }

    public void show() {
        loginPage.show();
        signupPage.show();
    }
    
  
}
