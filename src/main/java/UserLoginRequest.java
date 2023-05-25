public class UserLoginRequest {
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    private String email;
    private  String password;


    public UserLoginRequest(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
