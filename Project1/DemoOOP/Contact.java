public class Contact {
    private Department department;
    private String email;
    public boolean isValid(){  //complete this 
        if (this.email == null){
            return false;
        }
        if (this.email.contains("@rutgers.edu")){
            return true;
        }
        else {
            return false;
        }

    }

    Contact(Department department, String email){
        this.department=department;
        this.email=email;
    }

    public Department getDepartment(){
        return this.department;
    }
    public String getEmail(){
        return this.email;
    }


    }

