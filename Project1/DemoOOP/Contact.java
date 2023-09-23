public class Contact {
    private Department department;
    private String email;
    public boolean isValid(){  //complete this 

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

