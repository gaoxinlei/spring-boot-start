package net.self.spring.boot.bean;

public class User {

    private Integer id;
    private String username;
    private String password;
    private Integer age;
    private String home;
    
    
    public User() {
        super();
    }

    public User(Integer id, String username, String password, Integer age, String home) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.home = home;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }
    
    public Integer getAge() {
        return age;
    }
    
    public void setAge(Integer age) {
        this.age = age;
    }
    
    public String getHome() {
        return home;
    }
    
    public void setHome(String home) {
        this.home = home;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age + ", home="
                + home + "]";
    }
    
}
