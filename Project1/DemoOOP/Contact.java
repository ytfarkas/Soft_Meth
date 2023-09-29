public class Contact {
    private Department department;
    private String email;
    public boolean isValid(){  //complete this 

        if (this.email == null){
            return false;
        }
        char at='@';
        int amountOfAts=0;
        for(int i=0;i<email.length();i++){
            if(email.charAt(i)==at){
                if(i==0 || i==email.length()-1){
                    return false;
                }
                amountOfAts++;
            }
        }
        if(amountOfAts>1 || amountOfAts==0) return false;
        else{
            String[] emailSplit= email.split("@");
            if(!emailSplit[1].equals("rutgers.edu")) return false;
        }
        return true;
    }
    //test

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

