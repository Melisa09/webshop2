
package Users;

import entity.Users;
import facade.UsersFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named(value = "usersManagedBean")
@SessionScoped
public class UsersManagedBean implements Serializable{
    
    private List<Users> _usersList;
    private String user;
    private String pass;
    private int id;
    
    
    @Inject
    UsersFacadeLocal usersfacadelocal;
    
    @PostConstruct
    private void init(){
        _usersList = usersfacadelocal.findAll();
    }
    
public UsersManagedBean(){
}


    public List<Users> getUsersList() {
        return _usersList;
    }

    public void setUsersList(List<Users> _usersList) {
        this._usersList = _usersList;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String login(){
    
        for(Users logg : _usersList){
            if (user !=null && user.equals(logg .getUsername())){
                if(pass!=null && pass.equals(logg.getPassword())){
                    id = logg.getIdPrivilege();
                }
            }
        }
        
          if (id==1){
              return "user";
              }else if(id==2){
             return "admin";
           }else{
            return "";
           }
    }
    
    public String register(){ 
    for(Users reg : _usersList){
            if (!reg.getUsername().equals(user) && pass!=null ){
                    pass = reg.getPassword();
                if(id==1 || id==2){
                 Users regu = new Users(user, pass, id);
                usersfacadelocal.create(regu);
            }
        }
        
    }
        return null;
}
}


                






   